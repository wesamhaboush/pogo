package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy.Order;
import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.common.ManufacturingContext;
import com.codebreeze.testing.tools.pogo.common.PogoConstants;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerUtil;

import javax.xml.ws.Holder;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;


public class PogoFactoryImpl implements PogoFactory
{

    private static final String RESOLVING_COLLECTION_EXCEPTION_STR = "An exception occurred while resolving the collection";

    private static final String MAP_CREATION_EXCEPTION_STR = "An exception occurred while creating a Map object";

    private static final String UNCHECKED_STR = "unchecked";

    private static final TypeProcessor TYPE_PROCESSOR = new TypeProcessor();


    private PogoFactory externalFactory
        = NullExternalFactory.getInstance();

    private DataProviderStrategy strategy
        = new RandomDataProviderStrategyImpl();

    private ClassInfoStrategy classInfoStrategy
        = DefaultClassInfoStrategy.getInstance();


    public PogoFactoryImpl()
    {
        this( NullExternalFactory.getInstance(),
              new RandomDataProviderStrategyImpl() );
    }

    public PogoFactoryImpl( DataProviderStrategy strategy )
    {
        this( NullExternalFactory.getInstance(), strategy );
    }

    public PogoFactoryImpl( PogoFactory externalFactory )
    {
        this( externalFactory, new RandomDataProviderStrategyImpl() );
    }

    public PogoFactoryImpl( PogoFactory externalFactory,
                            DataProviderStrategy strategy )
    {
        this.externalFactory = externalFactory;
        this.strategy = strategy;
    }

    @Override
    public <T> T manufacturePojoWithFullData( Class<T> pojoClass, Type... genericTypeArgs )
    {
        ManufacturingContext manufacturingCtx = new ManufacturingContext();
        manufacturingCtx.getPojos().put( pojoClass, 0 );
        manufacturingCtx.setConstructorOrdering( Order.HEAVY_FIRST );

        try
        {
            Class<?> declaringClass = null;
            AttributeMetadata pojoMetadata = new AttributeMetadata( pojoClass,
                    genericTypeArgs, null );
            return this.manufacturePojoInternal( pojoClass, pojoMetadata,
                                                 manufacturingCtx, genericTypeArgs );
        }
        catch ( InstantiationException | IllegalAccessException | ClassNotFoundException e )
        {
            throw new PogoMockeryException( e.getMessage(), e );
        }
        catch ( InvocationTargetException e )
        {
            throw new PogoMockeryException( e.getMessage(), e );
        }
    }

    @Override
    public <T> T manufacturePojo( Class<T> pojoClass, Type... genericTypeArgs )
    {
        ManufacturingContext manufacturingCtx = new ManufacturingContext();
        manufacturingCtx.getPojos().put( pojoClass, 0 );

        try
        {
            Class<?> declaringClass = null;
            AttributeMetadata pojoMetadata = new AttributeMetadata( pojoClass,
                    genericTypeArgs, null );
            return this.manufacturePojoInternal( pojoClass, pojoMetadata,
                                                 manufacturingCtx, genericTypeArgs );
        }
        catch ( InstantiationException | ClassNotFoundException | InvocationTargetException | IllegalAccessException e )
        {
            throw new PogoMockeryException( e.getMessage(), e );
        }
    }

    @Override
    public <T> T populatePojo( T pojo, Type... genericTypeArgs )
    {
        ManufacturingContext manufacturingCtx = new ManufacturingContext();
        manufacturingCtx.getPojos().put( pojo.getClass(), 0 );
        final Map<String, Type> typeArgsMap = new HashMap<>();
        Type[] genericTypeArgsExtra = TypeManufacturerUtil.fillTypeArgMap( typeArgsMap,
                                      pojo.getClass(), genericTypeArgs );

        try
        {
            return this.populatePojoInternal( pojo, manufacturingCtx, typeArgsMap,
                                              genericTypeArgsExtra );
        }
        catch ( InstantiationException | ClassNotFoundException | InvocationTargetException | IllegalAccessException e )
        {
            throw new PogoMockeryException( e.getMessage(), e );
        }
    }

    @Override
    public DataProviderStrategy getStrategy()
    {
        return strategy;
    }

    @Override
    public PogoFactory setStrategy( DataProviderStrategy strategy )
    {
        this.strategy = strategy;
        return this;
    }

    @Override
    public ClassInfoStrategy getClassStrategy()
    {
        return classInfoStrategy;
    }

    @Override
    public PogoFactory setClassStrategy( ClassInfoStrategy classInfoStrategy )
    {
        this.classInfoStrategy = classInfoStrategy;
        return this;
    }

    @Override
    public PogoFactory getExternalFactory()
    {
        return externalFactory;
    }

    @Override
    public PogoFactory setExternalFactory( PogoFactory externalFactory )
    {
        this.externalFactory = externalFactory;
        return this;
    }

    private Object instantiatePojoWithoutConstructors(
        Class<?> pojoClass, ManufacturingContext manufacturingCtx,
        Map<String, Type> typeArgsMap, Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
               InvocationTargetException, ClassNotFoundException
    {
        Object retValue = null;
        // If no publicly accessible constructors are available,
        // the best we can do is to find a constructor (e.g.
        // getInstance())
        Method[] declaredMethods = pojoClass.getDeclaredMethods();
        strategy.sort( declaredMethods, manufacturingCtx.getConstructorOrdering() );
        // A candidate factory method is a method which returns the
        // Class type
        // The parameters to pass to the method invocation
        Object[] parameterValues;

        for ( Method candidateConstructor : declaredMethods )
        {
            if ( !Modifier.isStatic( candidateConstructor.getModifiers() )
                    || !candidateConstructor.getReturnType().equals( pojoClass )
                    || retValue != null )
            {
                continue;
            }

            parameterValues = getParameterValuesForMethod( candidateConstructor,
                              pojoClass, manufacturingCtx, typeArgsMap, genericTypeArgs );

            try
            {
                retValue = candidateConstructor.invoke( pojoClass,
                                                        parameterValues );

                //If Pogo has created the POJO, we're done
                if ( retValue != null )
                {
                    break;
                }
            }
            catch ( Exception t )
            {
                System.out.println( t );
            }
        }

        return retValue;
    }

    @SuppressWarnings( { UNCHECKED_STR } )
    private <T> T instantiatePojo( Class<T> pojoClass,
                                   ManufacturingContext manufacturingCtx, Map<String, Type> typeArgsMap,
                                   Type... genericTypeArgs )
    throws SecurityException
    {
        T retValue = null;
        Constructor<?>[] constructors = pojoClass.getConstructors();

        if ( constructors.length == 0 || Modifier.isAbstract( pojoClass.getModifiers() ) )
        {
            /* No public constructors, we will try static factory methods */
            try
            {
                retValue = ( T ) instantiatePojoWithoutConstructors(
                               pojoClass, manufacturingCtx, typeArgsMap, genericTypeArgs );
            }
            catch ( Exception e )
            {
                System.out.println( e );
            }

            /* Then non-public constructors */
            if ( retValue == null )
            {
                constructors = pojoClass.getDeclaredConstructors();
            }
        }

        if ( retValue == null && constructors.length > 0 )
        {
            strategy.sort( constructors, manufacturingCtx.getConstructorOrdering() );

            for ( Constructor<?> constructor : constructors )
            {
                try
                {
                    Object[] parameterValues = getParameterValuesForConstructor(
                                                   constructor, pojoClass, manufacturingCtx, typeArgsMap,
                                                   genericTypeArgs );

                    // Security hack
                    if ( !constructor.isAccessible() )
                    {
                        constructor.setAccessible( true );
                    }

                    retValue = ( T ) constructor.newInstance( parameterValues );
                    break;
                }
                catch ( Exception e )
                {
                    System.out.println( e );
                }
            }
        }

        return retValue;
    }

    @SuppressWarnings( UNCHECKED_STR )
    private <T> T manufacturePojoInternal( Class<T> pojoClass,
                                           AttributeMetadata pojoMetadata, ManufacturingContext manufacturingCtx,
                                           Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        T retValue;
        // reuse object from memoization table
        T objectToReuse = ( T ) strategy.getMemoizedObject( pojoMetadata );

        if ( objectToReuse != null )
        {
            return objectToReuse;
        }

        if ( pojoClass.isEnum() )
        {
            return ( T ) TypeManufacturerUtil.getTypeValue( strategy, TYPE_PROCESSOR, pojoMetadata, PogoConstants
                    .ENUMERATION_QUALIFIER );
        }

        if ( pojoClass.isPrimitive() )
        {
            return ( T ) TypeManufacturerUtil.getTypeValue( strategy, TYPE_PROCESSOR, pojoMetadata, pojoClass.getName() );
        }

        if ( pojoClass.isInterface() )
        {
            return getValueForAbstractType( pojoClass, pojoMetadata, manufacturingCtx, genericTypeArgs );
        }

        final Map<String, Type> typeArgsMap = new HashMap<>();
        Type[] genericTypeArgsExtra = TypeManufacturerUtil.fillTypeArgMap( typeArgsMap,
                                      pojoClass, genericTypeArgs );

        try
        {
            retValue = instantiatePojo( pojoClass, manufacturingCtx, typeArgsMap,
                                        genericTypeArgsExtra );
        }
        catch ( SecurityException e )
        {
            throw new PogoMockeryException(
                "Security exception while applying introspection.", e );
        }

        if ( retValue == null )
        {
            return getValueForAbstractType( pojoClass, pojoMetadata, manufacturingCtx, genericTypeArgs );
        }

        // update memoization cache with new object
        // the reference is stored before properties are set so that recursive
        // properties can use it
        strategy.cacheMemoizedObject( pojoMetadata, retValue );
        populatePojoInternal( retValue, manufacturingCtx, typeArgsMap, genericTypeArgsExtra );
        return retValue;
    }



    @SuppressWarnings( UNCHECKED_STR )
    private <T> T populatePojoInternal( T pojo, ManufacturingContext manufacturingCtx,
                                        Map<String, Type> typeArgsMap,
                                        Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Class<?> pojoClass = pojo.getClass();

        if ( pojo instanceof Collection && ( ( Collection<?> )pojo ).size() == 0 )
        {
            fillCollection( ( Collection<? super Object> )pojo, manufacturingCtx, typeArgsMap, genericTypeArgs );
        }
        else if ( pojo instanceof Map && ( ( Map<?, ?> )pojo ).size() == 0 )
        {
            fillMap( ( Map<? super Object, ? super Object> )pojo, manufacturingCtx, typeArgsMap, genericTypeArgs );
        }

        Class<?>[] parameterTypes;
        Class<?> attributeType;
        ClassInfo classInfo = classInfoStrategy.getClassInfo( pojo.getClass() );
        Set<ClassAttribute> classAttributes = classInfo.getClassAttributes();
        // According to JavaBeans standards, setters should have only
        // one argument
        Object setterArg;
        Iterator<ClassAttribute> iter = classAttributes.iterator();

        while ( iter.hasNext() )
        {
            ClassAttribute attribute = iter.next();
            Set<Method> setters = attribute.getSetters();

            if ( setters.isEmpty() )
            {
                if ( attribute.getGetters().isEmpty() )
                {
                    iter.remove();
                }

                continue;
            }
            else
            {
                iter.remove();
            }

            /* We want to find setter defined the latest */
            Method setter = null;

            for ( Method current : setters )
            {
                if ( setter == null || setter.getDeclaringClass().isAssignableFrom( current.getDeclaringClass() ) )
                {
                    setter = current;
                }
            }

            parameterTypes = setter != null ? setter.getParameterTypes() : new Class<?>[0];

            if ( parameterTypes.length != 1 )
            {
                continue;
            }

            // A class which has got an attribute to itself (e.g.
            // recursive hierarchies)
            attributeType = parameterTypes[0];
            // If an attribute has been annotated with
            // PogoAttributeStrategy, it takes the precedence over any
            // other strategy. Additionally we don't pass the attribute
            // metadata for value customisation; if user went to the extent
            // of specifying a PogoAttributeStrategy annotation for an
            // attribute they are already customising the value assigned to
            // that attribute.
            String attributeName = PogoUtils
                                   .extractFieldNameFromSetterMethod( setter );
            List<Annotation> pojoAttributeAnnotations
                = PogoUtils.getAttributeAnnotations(
                      attribute.getAttribute(), setter );
            Type[] typeArguments = PogoConstants.NO_TYPES;
            // If the parameter is a generic parameterized type resolve
            // the actual type arguments
            Type genericType = setter.getGenericParameterTypes()[0];

            if ( genericType instanceof ParameterizedType )
            {
                final ParameterizedType attributeParameterizedType
                    = ( ParameterizedType ) genericType;
                typeArguments = attributeParameterizedType
                                .getActualTypeArguments();
            }
            else if ( genericType instanceof TypeVariable )
            {
                final TypeVariable<?> typeVariable = ( TypeVariable<?> ) genericType;
                Type type = typeArgsMap.get( typeVariable.getName() );

                if ( type instanceof ParameterizedType )
                {
                    final ParameterizedType attributeParameterizedType = ( ParameterizedType ) type;
                    typeArguments = attributeParameterizedType
                                    .getActualTypeArguments();
                    attributeType = ( Class<?> ) attributeParameterizedType
                                    .getRawType();
                }
                else
                {
                    attributeType = ( Class<?> ) type;
                }
            }

            AtomicReference<Type[]> typeGenericTypeArgs
                = new AtomicReference<>( PogoConstants.NO_TYPES );

            for ( int i = 0; i < typeArguments.length; i++ )
            {
                if ( typeArguments[i] instanceof TypeVariable )
                {
                    Class<?> resolvedType = TypeManufacturerUtil.resolveGenericParameter( typeArguments[i],
                                            typeArgsMap, typeGenericTypeArgs );

                    if ( !Collection.class.isAssignableFrom( resolvedType ) && !Map.class.isAssignableFrom( resolvedType ) )
                    {
                        typeArguments[i] = resolvedType;
                    }
                }
            }

            setterArg = manufactureAttributeValue( pojo, manufacturingCtx,
                                                   attributeType, genericType,
                                                   pojoAttributeAnnotations, attributeName,
                                                   typeArgsMap, typeArguments );

            try
            {
                setter.invoke( pojo, setterArg );
            }
            catch( IllegalAccessException e )
            {
                setter.setAccessible( true );
                setter.invoke( pojo, setterArg );
            }
        }

        for ( ClassAttribute readOnlyAttribute : classAttributes )
        {
            Method getter = readOnlyAttribute.getGetters().iterator().next();

            if ( getter != null && !getter.getReturnType().isPrimitive() )
            {
                if ( getter.getGenericParameterTypes().length == 0 )
                {
                    Object fieldValue = null;

                    try
                    {
                        fieldValue = getter.invoke( pojo, PogoConstants.NO_ARGS );
                    }
                    catch( Exception e )
                    {
                        System.out.println( e );
                    }

                    if ( fieldValue != null )
                    {
                        Type[] genericTypeArgsAll;
                        Map<String, Type> paramTypeArgsMap;

                        if ( getter.getGenericReturnType() instanceof ParameterizedType )
                        {
                            paramTypeArgsMap = new HashMap<>( typeArgsMap );
                            ParameterizedType paramType
                                = ( ParameterizedType ) getter.getGenericReturnType();
                            Type[] actualTypes = paramType.getActualTypeArguments();
                            TypeManufacturerUtil.fillTypeArgMap( paramTypeArgsMap,
                                                                 getter.getReturnType(), actualTypes );
                            genericTypeArgsAll = TypeManufacturerUtil.fillTypeArgMap( paramTypeArgsMap,
                                                 getter.getReturnType(), genericTypeArgs );
                        }
                        else
                        {
                            paramTypeArgsMap = typeArgsMap;
                            genericTypeArgsAll = genericTypeArgs;
                        }

                        Class<?> fieldClass = fieldValue.getClass();
                        Integer depth = manufacturingCtx.getPojos().get( fieldClass );

                        if ( depth == null )
                        {
                            depth = -1;
                        }

                        if ( depth <= strategy.getMaxDepth( fieldClass ) )
                        {
                            manufacturingCtx.getPojos().put( fieldClass, depth + 1 );
                            populatePojoInternal( fieldValue, manufacturingCtx, paramTypeArgsMap, genericTypeArgsAll );
                            manufacturingCtx.getPojos().put( fieldClass, depth );
                        }
                        else
                        {
                        }
                    }
                }
                else
                {
                }
            }
        }

        // It executes any extra methods
        Collection<Method> extraMethods = classInfoStrategy.getExtraMethods( pojoClass );

        if ( null != extraMethods )
        {
            for ( Method extraMethod : extraMethods )
            {
                Object[] args = getParameterValuesForMethod( extraMethod, pojoClass,
                                manufacturingCtx, typeArgsMap, genericTypeArgs );
                extraMethod.invoke( pojo, args );
            }
        }

        return pojo;
    }

    private Object manufactureAttributeValue( Object pojo,
            ManufacturingContext manufacturingCtx, Class<?> attributeType,
            Type genericAttributeType, List<Annotation> annotations,
            String attributeName, Map<String, Type> typeArgsMap,
            Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Object attributeValue = null;
        Class<?> pojoClass = ( pojo instanceof Class ? ( Class<?> ) pojo : pojo.getClass() );
        Class<?> realAttributeType;

        if ( Object.class.equals( attributeType ) && attributeType != genericAttributeType )
        {
            AtomicReference<Type[]> elementGenericTypeArgs
                = new AtomicReference<>( PogoConstants.NO_TYPES );
            realAttributeType = TypeManufacturerUtil.resolveGenericParameter( genericAttributeType,
                                typeArgsMap, elementGenericTypeArgs );
        }
        else
        {
            realAttributeType = attributeType;
        }

        AttributeMetadata attributeMetadata = new AttributeMetadata(
            attributeName, realAttributeType, genericTypeArgs, annotations,
            pojoClass );

        if ( realAttributeType.isPrimitive() || TypeManufacturerUtil.isWrapper( realAttributeType ) ||
                realAttributeType.equals( String.class ) )
        {
            attributeValue = TypeManufacturerUtil.getTypeValue( strategy, TYPE_PROCESSOR, attributeMetadata,
                             realAttributeType.getName() );
        }
        else if ( realAttributeType.isArray() )
        {
            // Array type
            attributeValue = resolveArrayElementValue( realAttributeType,
                             genericAttributeType, attributeName, manufacturingCtx, annotations, pojo,
                             typeArgsMap );
            // Collection
        }
        else if ( Collection.class.isAssignableFrom( realAttributeType ) )
        {
            attributeValue = resolveCollectionValueWhenCollectionIsPojoAttribute(
                                 pojo, manufacturingCtx, realAttributeType, attributeName,
                                 annotations, typeArgsMap, genericTypeArgs );
            // Map
        }
        else if ( Map.class.isAssignableFrom( realAttributeType ) )
        {
            attributeValue = resolveMapValueWhenMapIsPojoAttribute( pojo,
                             manufacturingCtx, realAttributeType, attributeName, annotations,
                             typeArgsMap, genericTypeArgs );
            //Enum
        }
        else if ( realAttributeType.isEnum() )
        {
            attributeValue = TypeManufacturerUtil.getTypeValue( strategy, TYPE_PROCESSOR, attributeMetadata,
                             PogoConstants.ENUMERATION_QUALIFIER );
            //Parametrized type
        }
        else if ( Type.class.isAssignableFrom( realAttributeType ) )
        {
            attributeValue = TypeManufacturerUtil.getTypeValueForGenericTypes( strategy, TYPE_PROCESSOR, attributeMetadata,
                             genericAttributeType, typeArgsMap, PogoConstants.GENERIC_TYPE_QUALIFIER );
        }

        // For any other type, we use the Pogo strategy
        if ( attributeValue == null )
        {
            TypeVariable<?>[] typeParams = attributeType.getTypeParameters();
            Type[] genericTypeArgsAll = TypeManufacturerUtil.mergeActualAndSuppliedGenericTypes(
                                            typeParams, genericTypeArgs, typeArgsMap );
            Integer depth = manufacturingCtx.getPojos().get( realAttributeType );

            if ( depth == null )
            {
                depth = -1;
            }

            if ( depth <= strategy.getMaxDepth( pojoClass ) )
            {
                manufacturingCtx.getPojos().put( realAttributeType, depth + 1 );
                attributeValue = this.manufacturePojoInternal(
                                     realAttributeType, attributeMetadata, manufacturingCtx, genericTypeArgsAll );
                manufacturingCtx.getPojos().put( realAttributeType, depth );
            }
            else
            {
                attributeValue = resortToExternalFactory( manufacturingCtx,
                                 "Loop in {} production detected. Resorting to {} external factory",
                                 realAttributeType, genericTypeArgsAll );
            }
        }

        return attributeValue;
    }

    private <T> T resortToExternalFactory( ManufacturingContext manufacturingCtx,
                                           String msg, Class<T> pojoClass,
                                           Type... genericTypeArgs )
    {
        if ( manufacturingCtx.getConstructorOrdering() == Order.HEAVY_FIRST )
        {
            return externalFactory.manufacturePojoWithFullData( pojoClass, genericTypeArgs );
        }
        else
        {
            return externalFactory.manufacturePojo( pojoClass, genericTypeArgs );
        }
    }

    private Collection<? super Object> resolveCollectionValueWhenCollectionIsPojoAttribute(
        Object pojo, ManufacturingContext manufacturingCtx,
        Class<?> collectionType, String attributeName,
        List<Annotation> annotations, Map<String, Type> typeArgsMap,
        Type... genericTypeArgs )
    {
        // This needs to be generic because collections can be of any type
        Collection<? super Object> retValue = null;

        if ( null != pojo && null != attributeName )
        {
            retValue = PogoUtils.getFieldValue( pojo, attributeName );
        }

        retValue = TypeManufacturerUtil.resolveCollectionType( collectionType, retValue );

        if ( null == retValue )
        {
            return null;
        }

        try
        {
            Class<?> typeClass;
            AtomicReference<Type[]> elementGenericTypeArgs = new AtomicReference<>(
                PogoConstants.NO_TYPES );

            if ( genericTypeArgs == null || genericTypeArgs.length == 0 )
            {
                // Support for non-generified collections
                typeClass = Object.class;
            }
            else
            {
                Type actualTypeArgument = genericTypeArgs[0];
                typeClass = TypeManufacturerUtil.resolveGenericParameter( actualTypeArgument,
                            typeArgsMap, elementGenericTypeArgs );
            }

            fillCollection( manufacturingCtx, annotations, attributeName, retValue, typeClass,
                            elementGenericTypeArgs.get() );
        }
        catch ( SecurityException | InvocationTargetException | ClassNotFoundException | IllegalAccessException |
                    InstantiationException | IllegalArgumentException e )
        {
            throw new PogoMockeryException( RESOLVING_COLLECTION_EXCEPTION_STR,
                                            e );
        }

        return retValue;
    }

    private void fillCollection( Collection<? super Object> collection,
                                 ManufacturingContext manufacturingCtx, Map<String, Type> typeArgsMap,
                                 Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Class<?> pojoClass = collection.getClass();
        Annotation[] annotations = collection.getClass().getAnnotations();
        AtomicReference<Type[]> elementGenericTypeArgs = new AtomicReference<>(
            PogoConstants.NO_TYPES );
        Class<?> collectionClass = pojoClass;
        Type[] typeParams = collectionClass.getTypeParameters();
        main :

        while ( typeParams.length < 1 )
        {
            for ( Type genericIface : collectionClass.getGenericInterfaces() )
            {
                Class<?> clazz = TypeManufacturerUtil.resolveGenericParameter( genericIface,
                                 typeArgsMap, elementGenericTypeArgs );

                if ( Collection.class.isAssignableFrom( clazz ) )
                {
                    collectionClass = clazz;
                    typeParams = elementGenericTypeArgs.get();
                    continue main;
                }
            }

            Type type = collectionClass.getGenericSuperclass();

            if ( type != null )
            {
                Class<?> clazz = TypeManufacturerUtil.resolveGenericParameter( type, typeArgsMap,
                                 elementGenericTypeArgs );

                if ( Collection.class.isAssignableFrom( clazz ) )
                {
                    collectionClass = clazz;
                    typeParams = elementGenericTypeArgs.get();
                    continue;
                }
            }

            if ( Collection.class.equals( collectionClass ) )
            {
                typeParams = new Type[] { Object.class };
            }
        }

        Class<?> elementTypeClass = TypeManufacturerUtil.resolveGenericParameter( typeParams[0],
                                    typeArgsMap, elementGenericTypeArgs );
        Type[] elementGenericArgs = TypeManufacturerUtil.mergeTypeArrays( elementGenericTypeArgs.get(),
                                    genericTypeArgs );
        fillCollection( manufacturingCtx, Arrays.asList( annotations ), null,
                        collection, elementTypeClass, elementGenericArgs );
    }

    private void fillCollection( ManufacturingContext manufacturingCtx,
                                 List<Annotation> annotations, String attributeName,
                                 Collection<? super Object> collection,
                                 Class<?> collectionElementType, Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        // If the user defined a strategy to fill the collection elements,
        // we use it
        Holder<AttributeStrategy<?>> elementStrategyHolder
            = new Holder<>();
        Integer nbrElements = TypeManufacturerUtil.findCollectionSize( strategy, annotations,
                              collectionElementType, elementStrategyHolder, null );
        AttributeStrategy<?> elementStrategy = elementStrategyHolder.value;

        try
        {
            if ( collection.size() > nbrElements )
            {
                collection.clear();
            }

            for ( int i = collection.size(); i < nbrElements; i++ )
            {
                // The default
                Object element;

                if ( null != elementStrategy
                        && ( elementStrategy instanceof ObjectStrategy )
                        && Object.class.equals( collectionElementType ) )
                {
                    element = elementStrategy.getValue();
                }
                else if ( null != elementStrategy
                          && !( elementStrategy instanceof ObjectStrategy ) )
                {
                    element = TypeManufacturerUtil.returnAttributeDataStrategyValue(
                                  collectionElementType, elementStrategy );
                }
                else
                {
                    Map<String, Type> nullTypeArgsMap = new HashMap<>();
                    element = manufactureAttributeValue( collection, manufacturingCtx,
                                                         collectionElementType, collectionElementType,
                                                         annotations, attributeName, nullTypeArgsMap, genericTypeArgs );
                }

                collection.add( element );
            }
        }
        catch ( UnsupportedOperationException e )
        {
            System.out.println( e );
        }
    }

    private Map<? super Object, ? super Object> resolveMapValueWhenMapIsPojoAttribute(
        Object pojo, ManufacturingContext manufacturingCtx,
        Class<?> attributeType, String attributeName,
        List<Annotation> annotations, Map<String, Type> typeArgsMap,
        Type... genericTypeArgs )
    {
        Map<? super Object, ? super Object> retValue = null;

        if ( null != pojo && null != attributeName )
        {
            retValue = PogoUtils.getFieldValue( pojo, attributeName );
        }

        retValue = TypeManufacturerUtil.resolveMapType( attributeType, retValue );

        if ( null == retValue )
        {
            return null;
        }

        try
        {
            Class<?> keyClass;
            Class<?> elementClass;
            AtomicReference<Type[]> keyGenericTypeArgs = new AtomicReference<>(
                PogoConstants.NO_TYPES );
            AtomicReference<Type[]> elementGenericTypeArgs = new AtomicReference<>(
                PogoConstants.NO_TYPES );

            if ( genericTypeArgs == null || genericTypeArgs.length == 0 )
            {
                keyClass = Object.class;
                elementClass = Object.class;
            }
            else
            {
                // Expected only key, value type
                if ( genericTypeArgs.length != 2 )
                {
                    throw new IllegalStateException(
                        "In a Map only key value generic type are expected." );
                }

                keyClass = TypeManufacturerUtil.resolveGenericParameter( genericTypeArgs[0],
                           typeArgsMap, keyGenericTypeArgs );
                elementClass = TypeManufacturerUtil.resolveGenericParameter( genericTypeArgs[1],
                               typeArgsMap, elementGenericTypeArgs );
            }

            MapArguments mapArguments = new MapArguments();
            mapArguments.setAttributeName( attributeName );
            mapArguments.setAnnotations( annotations );
            mapArguments.setMapToBeFilled( retValue );
            mapArguments.setKeyClass( keyClass );
            mapArguments.setElementClass( elementClass );
            mapArguments.setKeyGenericTypeArgs( keyGenericTypeArgs.get() );
            mapArguments
            .setElementGenericTypeArgs( elementGenericTypeArgs.get() );
            fillMap( mapArguments, manufacturingCtx );
        }
        catch ( InstantiationException | InvocationTargetException | ClassNotFoundException | SecurityException |
                    IllegalAccessException e )
        {
            throw new PogoMockeryException( MAP_CREATION_EXCEPTION_STR, e );
        }

        return retValue;
    }

    private void fillMap( Map<? super Object, ? super Object> map,
                          ManufacturingContext manufacturingCtx, Map<String, Type> typeArgsMap,
                          Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Class<?> pojoClass = map.getClass();
        Class<?> mapClass = pojoClass;
        AtomicReference<Type[]> elementGenericTypeArgs = new AtomicReference<>(
            PogoConstants.NO_TYPES );
        Type[] typeParams = mapClass.getTypeParameters();
        main :

        while ( typeParams.length < 2 )
        {
            for ( Type genericIface : mapClass.getGenericInterfaces() )
            {
                Class<?> clazz = TypeManufacturerUtil.resolveGenericParameter( genericIface, typeArgsMap,
                                 elementGenericTypeArgs );

                if ( Map.class.isAssignableFrom( clazz ) )
                {
                    typeParams = elementGenericTypeArgs.get();
                    mapClass = clazz;
                    continue main;
                }
            }

            Type type = mapClass.getGenericSuperclass();

            if ( type != null )
            {
                Class<?> clazz = TypeManufacturerUtil.resolveGenericParameter( type, typeArgsMap,
                                 elementGenericTypeArgs );

                if ( Map.class.isAssignableFrom( clazz ) )
                {
                    typeParams = elementGenericTypeArgs.get();
                    mapClass = clazz;
                    continue;
                }
            }

            if ( Map.class.equals( mapClass ) )
            {
                typeParams = new Type[] { Object.class, Object.class };
            }
        }

        AtomicReference<Type[]> keyGenericTypeArgs = new AtomicReference<>(
            PogoConstants.NO_TYPES );
        Class<?> keyClass = TypeManufacturerUtil.resolveGenericParameter( typeParams[0],
                            typeArgsMap, keyGenericTypeArgs );
        Class<?> elementClass = TypeManufacturerUtil.resolveGenericParameter( typeParams[1],
                                typeArgsMap, elementGenericTypeArgs );
        Type[] keyGenericArgs = TypeManufacturerUtil.mergeTypeArrays( keyGenericTypeArgs.get(),
                                genericTypeArgs );
        Type[] elementGenericArgs = TypeManufacturerUtil.mergeTypeArrays( elementGenericTypeArgs.get(),
                                    genericTypeArgs );
        MapArguments mapArguments = new MapArguments();
        mapArguments.setAnnotations( Arrays.asList( pojoClass.getAnnotations() ) );
        mapArguments.setMapToBeFilled( map );
        mapArguments.setKeyClass( keyClass );
        mapArguments.setElementClass( elementClass );
        mapArguments.setKeyGenericTypeArgs( keyGenericArgs );
        mapArguments.setElementGenericTypeArgs( elementGenericArgs );
        fillMap( mapArguments, manufacturingCtx );
    }

    private void fillMap( MapArguments mapArguments, ManufacturingContext manufacturingCtx )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        // If the user defined a strategy to fill the collection elements,
        // we use it
        Holder<AttributeStrategy<?>> elementStrategyHolder
            = new Holder<>();
        Holder<AttributeStrategy<?>> keyStrategyHolder
            = new Holder<>();
        Integer nbrElements = TypeManufacturerUtil.findCollectionSize( strategy, mapArguments.getAnnotations(),
                              mapArguments.getElementClass(), elementStrategyHolder,
                              keyStrategyHolder );
        AttributeStrategy<?> keyStrategy = keyStrategyHolder.value;
        AttributeStrategy<?> elementStrategy = elementStrategyHolder.value;
        Map<? super Object, ? super Object> map = mapArguments.getMapToBeFilled();

        try
        {
            if ( map.size() > nbrElements )
            {
                map.clear();
            }

            for ( int i = map.size(); i < nbrElements; i++ )
            {
                Object keyValue;
                Object elementValue;
                MapKeyOrElementsArguments valueArguments = new MapKeyOrElementsArguments();
                valueArguments.setAttributeName( mapArguments.getAttributeName() );
                valueArguments.setMapToBeFilled( mapArguments.getMapToBeFilled() );
                valueArguments.setAnnotations( mapArguments.getAnnotations() );
                valueArguments.setKeyOrValueType( mapArguments.getKeyClass() );
                valueArguments.setElementStrategy( keyStrategy );
                valueArguments.setGenericTypeArgs( mapArguments
                                                   .getKeyGenericTypeArgs() );
                keyValue = getMapKeyOrElementValue( valueArguments, manufacturingCtx );
                valueArguments.setKeyOrValueType( mapArguments.getElementClass() );
                valueArguments.setElementStrategy( elementStrategy );
                valueArguments.setGenericTypeArgs( mapArguments
                                                   .getElementGenericTypeArgs() );
                elementValue = getMapKeyOrElementValue( valueArguments, manufacturingCtx );

                /* ConcurrentHashMap doesn't allow null values */
                if ( elementValue != null || !( map instanceof ConcurrentHashMap ) )
                {
                    map.put( keyValue, elementValue );
                }
            }
        }
        catch ( UnsupportedOperationException e )
        {
            System.out.println( e );
        }
    }

    private Object getMapKeyOrElementValue(
        MapKeyOrElementsArguments keyOrElementsArguments,
        ManufacturingContext manufacturingCtx )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Object retValue;

        if ( null != keyOrElementsArguments.getElementStrategy()
                && ObjectStrategy.class.isAssignableFrom( keyOrElementsArguments
                        .getElementStrategy().getClass() )
                && Object.class.equals( keyOrElementsArguments
                                        .getKeyOrValueType() ) )
        {
            retValue = keyOrElementsArguments.getElementStrategy().getValue();
        }
        else if ( null != keyOrElementsArguments.getElementStrategy()
                  && !ObjectStrategy.class
                  .isAssignableFrom( keyOrElementsArguments
                                     .getElementStrategy().getClass() ) )
        {
            retValue = TypeManufacturerUtil.returnAttributeDataStrategyValue(
                           keyOrElementsArguments.getKeyOrValueType(),
                           keyOrElementsArguments.getElementStrategy() );
        }
        else
        {
            Map<String, Type> nullTypeArgsMap = new HashMap<>();
            retValue = manufactureAttributeValue(
                           keyOrElementsArguments.getMapToBeFilled(),
                           manufacturingCtx,
                           keyOrElementsArguments.getKeyOrValueType(),
                           keyOrElementsArguments.getKeyOrValueType(),
                           keyOrElementsArguments.getAnnotations(),
                           keyOrElementsArguments.getAttributeName(),
                           nullTypeArgsMap,
                           keyOrElementsArguments.getGenericTypeArgs() );
        }

        return retValue;
    }

    private Object resolveArrayElementValue( Class<?> attributeType,
            Type genericType, String attributeName, ManufacturingContext manufacturingCtx,
            List<Annotation> annotations, Object pojo,
            Map<String, Type> typeArgsMap ) throws InstantiationException,
        IllegalAccessException, InvocationTargetException,
        ClassNotFoundException
    {
        Class<?> componentType = null;
        Type genericComponentType;
        AtomicReference<Type[]> genericTypeArgs = new AtomicReference<>(
            PogoConstants.NO_TYPES );

        if ( genericType instanceof GenericArrayType )
        {
            genericComponentType = ( ( GenericArrayType ) genericType ).getGenericComponentType();

            if ( genericComponentType instanceof TypeVariable )
            {
                TypeVariable<?> componentTypeVariable
                    = ( TypeVariable<?> ) genericComponentType;
                final Type resolvedType
                    = typeArgsMap.get( componentTypeVariable.getName() );
                componentType
                    = TypeManufacturerUtil.resolveGenericParameter( resolvedType, typeArgsMap,
                            genericTypeArgs );
            }
        }
        else if ( genericType instanceof Class )
        {
            Class<?> arrayClass = ( Class<?> ) genericType;
            genericComponentType = arrayClass.getComponentType();
        }
        else
        {
            genericComponentType = attributeType.getComponentType();
        }

        if ( componentType == null )
        {
            componentType = attributeType.getComponentType();
        }

        // If the user defined a strategy to fill the collection elements,
        // we use it
        Holder<AttributeStrategy<?>> elementStrategyHolder
            = new Holder<>();
        Integer nbrElements = TypeManufacturerUtil.findCollectionSize( strategy, annotations, attributeType,
                              elementStrategyHolder, null );
        AttributeStrategy<?> elementStrategy = elementStrategyHolder.value;
        Object arrayElement;
        Object array = Array.newInstance( componentType, nbrElements );

        for ( int i = 0; i < nbrElements; i++ )
        {
            // The default
            if ( null != elementStrategy
                    && ( elementStrategy instanceof ObjectStrategy )
                    && Object.class.equals( componentType ) )
            {
                arrayElement = elementStrategy.getValue();
            }
            else if ( null != elementStrategy
                      && !( elementStrategy instanceof ObjectStrategy ) )
            {
                arrayElement = TypeManufacturerUtil.returnAttributeDataStrategyValue( componentType,
                               elementStrategy );
            }
            else
            {
                arrayElement = manufactureAttributeValue( array, manufacturingCtx,
                               componentType, genericComponentType, annotations, attributeName,
                               typeArgsMap, genericTypeArgs.get() );
            }

            Array.set( array, i, arrayElement );
        }

        return array;
    }


    private Object[] getParameterValuesForConstructor(
        Constructor<?> constructor, Class<?> pojoClass,
        ManufacturingContext manufacturingCtx, Map<String, Type> typeArgsMap,
        Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Object[] parameterValues;
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        if ( parameterTypes.length == 0 )
        {
            parameterValues = PogoConstants.NO_ARGS;
        }
        else
        {
            parameterValues = new Object[parameterTypes.length];
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            Type[] genericTypes = constructor.getGenericParameterTypes();

            for ( int idx = 0; idx < parameterTypes.length; idx++ )
            {
                List<Annotation> annotations = Arrays
                                               .asList( parameterAnnotations[idx] );
                Type genericType = ( idx < genericTypes.length ) ?
                                   genericTypes[idx] : parameterTypes[idx];
                parameterValues[idx] = manufactureParameterValue( pojoClass,
                                       parameterTypes[idx], genericType, annotations,
                                       typeArgsMap, manufacturingCtx, genericTypeArgs );
            }
        }

        return parameterValues;
    }

    private Object[] getParameterValuesForMethod(
        Method method, Class<?> pojoClass,
        ManufacturingContext manufacturingCtx, Map<String, Type> typeArgsMap,
        Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Object[] parameterValues;
        Class<?>[] parameterTypes = method.getParameterTypes();

        if ( parameterTypes.length == 0 )
        {
            parameterValues = PogoConstants.NO_ARGS;
        }
        else
        {
            parameterValues = new Object[parameterTypes.length];
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            Type[] genericTypes = method.getGenericParameterTypes();

            for ( int idx = 0; idx < parameterTypes.length; idx++ )
            {
                List<Annotation> annotations = Arrays
                                               .asList( parameterAnnotations[idx] );
                Type genericType = ( idx < genericTypes.length ) ?
                                   genericTypes[idx] : parameterTypes[idx];
                parameterValues[idx] = manufactureParameterValue( pojoClass,
                                       parameterTypes[idx], genericType, annotations,
                                       typeArgsMap, manufacturingCtx, genericTypeArgs );
            }
        }

        return parameterValues;
    }

    private Object manufactureParameterValue( Class<?> pojoClass, Class<?> parameterType,
            Type genericType, List<Annotation> annotations,
            final Map<String, Type> typeArgsMap, ManufacturingContext manufacturingCtx,
            Type... genericTypeArgs )
    throws InstantiationException, IllegalAccessException,
        InvocationTargetException, ClassNotFoundException
    {
        Object parameterValue = null;

        if ( Collection.class.isAssignableFrom( parameterType ) )
        {
            Collection<? super Object> defaultValue = null;
            Collection<? super Object> collection = TypeManufacturerUtil.resolveCollectionType(
                    parameterType, null );

            if ( collection != null )
            {
                Class<?> collectionElementType;
                AtomicReference<Type[]> collectionGenericTypeArgs = new AtomicReference<>(
                    PogoConstants.NO_TYPES );

                if ( genericType instanceof ParameterizedType )
                {
                    ParameterizedType pType = ( ParameterizedType ) genericType;
                    Type actualTypeArgument = pType.getActualTypeArguments()[0];
                    collectionElementType = TypeManufacturerUtil.resolveGenericParameter(
                                                actualTypeArgument, typeArgsMap,
                                                collectionGenericTypeArgs );
                }
                else
                {
                    collectionElementType = Object.class;
                }

                Type[] genericTypeArgsAll = TypeManufacturerUtil.mergeTypeArrays(
                                                collectionGenericTypeArgs.get(), genericTypeArgs );
                fillCollection( manufacturingCtx, annotations, null,
                                collection, collectionElementType, genericTypeArgsAll );
                parameterValue = collection;
            }
        }
        else if ( Map.class.isAssignableFrom( parameterType ) )
        {
            Map<? super Object, ? super Object> map = TypeManufacturerUtil.resolveMapType( parameterType, null );

            if ( map != null )
            {
                Class<?> keyClass;
                Class<?> elementClass;
                AtomicReference<Type[]> keyGenericTypeArgs = new AtomicReference<>(
                    PogoConstants.NO_TYPES );
                AtomicReference<Type[]> elementGenericTypeArgs = new AtomicReference<>(
                    PogoConstants.NO_TYPES );

                if ( genericType instanceof ParameterizedType )
                {
                    ParameterizedType pType = ( ParameterizedType ) genericType;
                    Type[] actualTypeArguments = pType.getActualTypeArguments();
                    keyClass = TypeManufacturerUtil.resolveGenericParameter( actualTypeArguments[0],
                               typeArgsMap, keyGenericTypeArgs );
                    elementClass = TypeManufacturerUtil.resolveGenericParameter(
                                       actualTypeArguments[1], typeArgsMap,
                                       elementGenericTypeArgs );
                }
                else
                {
                    keyClass = Object.class;
                    elementClass = Object.class;
                }

                Type[] genericTypeArgsAll = TypeManufacturerUtil.mergeTypeArrays(
                                                elementGenericTypeArgs.get(), genericTypeArgs );
                MapArguments mapArguments = new MapArguments();
                mapArguments.setAnnotations( annotations );
                mapArguments.setMapToBeFilled( map );
                mapArguments.setKeyClass( keyClass );
                mapArguments.setElementClass( elementClass );
                mapArguments.setKeyGenericTypeArgs( keyGenericTypeArgs.get() );
                mapArguments.setElementGenericTypeArgs( genericTypeArgsAll );
                fillMap( mapArguments, manufacturingCtx );
                parameterValue = map;
            }
        }

        if ( parameterValue == null )
        {
            Map<String, Type> typeArgsMapForParam;

            if ( genericType instanceof ParameterizedType )
            {
                typeArgsMapForParam = new HashMap<>( typeArgsMap );
                ParameterizedType parametrizedType =
                    ( ParameterizedType ) genericType;
                TypeVariable<?>[] argumentTypes = parameterType.getTypeParameters();
                Type[] argumentGenericTypes = parametrizedType.getActualTypeArguments();

                for ( int k = 0; k < argumentTypes.length; k++ )
                {
                    if ( argumentGenericTypes[k] instanceof Class )
                    {
                        Class<?> genericParam = ( Class<?> ) argumentGenericTypes[k];
                        typeArgsMapForParam.put( argumentTypes[k].getName(), genericParam );
                    }
                }
            }
            else
            {
                typeArgsMapForParam = typeArgsMap;
            }

            parameterValue = manufactureAttributeValue( pojoClass, manufacturingCtx, parameterType,
                             genericType, annotations, null, typeArgsMapForParam,
                             genericTypeArgs );
        }

        return parameterValue;
    }

    private <T> T getValueForAbstractType( Class<T> pojoClass,
                                           AttributeMetadata pojoMetadata,
                                           ManufacturingContext manufacturingCtx,
                                           Type[] genericTypeArgs ) throws InstantiationException,
        IllegalAccessException, InvocationTargetException, ClassNotFoundException
    {
        Class<T> specificClass = ( Class<T> ) strategy.getSpecificClass( pojoClass );

        if ( !specificClass.equals( pojoClass ) )
        {
            return this.manufacturePojoInternal( specificClass, pojoMetadata,
                                                 manufacturingCtx, genericTypeArgs );
        }
        else
        {
            return resortToExternalFactory( manufacturingCtx,
                                            "{} is an abstract class or interface. Resorting to {} external factory",
                                            pojoClass, genericTypeArgs );
        }
    }


}
