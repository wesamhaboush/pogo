package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoUtils;
import com.codebreeze.testing.tools.pogo.api.TypeProcessor;
import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.common.PogoConstants;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

public final class TypeManufacturerUtil
{

    private TypeManufacturerUtil()
    {
        throw new AssertionError( "Non instantiable" );
    }

    public static Object getTypeValue( DataProviderStrategy strategy,
                                       TypeProcessor processor,
                                       AttributeMetadata attributeMetadata,
                                       String qualifier )
    {
        Object retValue;
        TypeManufacturerParamsWrapper wrapper =
            new TypeManufacturerParamsWrapper( strategy, attributeMetadata );
        retValue = processor.process( wrapper, qualifier );
        return retValue;
    }

    public static Object getTypeValueForGenericTypes( DataProviderStrategy strategy,
            TypeProcessor processor,
            AttributeMetadata attributeMetadata,
            Type genericAttributeType,
            Map<String, Type> genericTypesArgumentsMap,
            String qualifier )
    {
        Object retValue;
        TypeManufacturerParamsWrapperForGenericTypes wrapper =
            new TypeManufacturerParamsWrapperForGenericTypes( strategy, attributeMetadata, genericTypesArgumentsMap,
                    genericAttributeType );
        retValue = processor.process( wrapper, qualifier );
        return retValue;
    }

    public static Type[] fillTypeArgMap( final Map<String, Type> typeArgsMap,
                                         final Class<?> pojoClass, final Type[] genericTypeArgs )
    {
        TypeVariable<?>[] array = pojoClass.getTypeParameters();
        List<TypeVariable<?>> typeParameters = new ArrayList<>( Arrays.asList( array ) );
        Iterator<TypeVariable<?>> iterator = typeParameters.iterator();

        /* Removing types, which are already in typeArgsMap */
        while ( iterator.hasNext() )
        {
            if ( typeArgsMap.containsKey( iterator.next().getName() ) )
            {
                iterator.remove();
            }
        }

        List<Type> genericTypes = new ArrayList<>( Arrays.asList( genericTypeArgs ) );
        Iterator<Type> iterator2 = genericTypes.iterator();

        /* Removing types, which are type variables */
        while ( iterator2.hasNext() )
        {
            if ( iterator2.next() instanceof TypeVariable )
            {
                iterator2.remove();
            }
        }

        if ( typeParameters.size() > genericTypes.size() )
        {
            String msg = pojoClass.getCanonicalName()
                         + " is missing generic type arguments, expected "
                         + typeParameters + " found "
                         + Arrays.toString( genericTypeArgs );
            throw new IllegalStateException( msg );
        }

        int i;

        for ( i = 0; i < typeParameters.size(); i++ )
        {
            typeArgsMap.put( typeParameters.get( i ).getName(), genericTypes.get( 0 ) );
            genericTypes.remove( 0 );
        }

        Type[] genericTypeArgsExtra;

        if ( genericTypes.size() > 0 )
        {
            genericTypeArgsExtra = genericTypes.toArray( new Type[genericTypes.size()] );
        }
        else
        {
            genericTypeArgsExtra = PogoConstants.NO_TYPES;
        }

        /* Adding types, which were specified during inheritance */
        Class<?> clazz = pojoClass;

        while ( clazz != null )
        {
            Type superType = clazz.getGenericSuperclass();
            clazz = clazz.getSuperclass();

            if ( superType instanceof ParameterizedType )
            {
                ParameterizedType paramType = ( ParameterizedType ) superType;
                Type[] actualParamTypes = paramType.getActualTypeArguments();
                TypeVariable<?>[] paramTypes = clazz.getTypeParameters();

                for ( i = 0; i < actualParamTypes.length
                        && i < paramTypes.length; i++ )
                {
                    if ( actualParamTypes[i] instanceof Class )
                    {
                        typeArgsMap.put( paramTypes[i].getName(),
                                         actualParamTypes[i] );
                    }
                }
            }
        }

        return genericTypeArgsExtra;
    }

    public static Integer findCollectionSize( DataProviderStrategy strategy,
            Class<?> collectionElementType )
    {
        return strategy
               .getNumberOfCollectionElements( collectionElementType );
    }

    public static boolean isWrapper( Class<?> candidateWrapperClass )
    {
        return candidateWrapperClass.equals( Byte.class ) || ( candidateWrapperClass.equals( Boolean.class ) ||
                ( candidateWrapperClass.equals( Character.class ) || ( candidateWrapperClass.equals( Short.class ) ? true
                        : candidateWrapperClass
                        .equals( Integer.class ) ? true
                        : candidateWrapperClass
                        .equals( Long.class ) ? true
                        : candidateWrapperClass
                        .equals( Float.class ) || candidateWrapperClass
                        .equals( Double.class ) ) ) );
    }

    public static Type[] mergeActualAndSuppliedGenericTypes(
        Type[] actualTypes, Type[] suppliedTypes,
        Map<String, Type> typeArgsMap )
    {
        List<Type> resolvedTypes = new ArrayList<>();
        List<Type> substitutionTypes = new ArrayList<>( Arrays.asList( suppliedTypes ) );

        for ( Type actualType : actualTypes )
        {
            Type type = null;

            if ( actualType instanceof TypeVariable )
            {
                type = typeArgsMap.get( ( ( TypeVariable<?> ) actualType ).getName() );
            }
            else if ( actualType instanceof Class )
            {
                type = actualType;
            }
            else if ( actualType instanceof WildcardType )
            {
                AtomicReference<Type[]> methodGenericTypeArgs
                    = new AtomicReference<>( PogoConstants.NO_TYPES );
                type = TypeManufacturerUtil.resolveGenericParameter( actualType, typeArgsMap,
                        methodGenericTypeArgs );
            }

            if ( type != null )
            {
                resolvedTypes.add( type );

                if ( !substitutionTypes.isEmpty() && substitutionTypes.get( 0 ).equals( type ) )
                {
                    substitutionTypes.remove( 0 );
                }
            }
        }

        Type[] resolved = resolvedTypes.toArray( new Type[resolvedTypes.size()] );
        Type[] supplied = substitutionTypes.toArray( new Type[substitutionTypes.size()] );
        return mergeTypeArrays( resolved, supplied );
    }

    public static Type[] mergeTypeArrays( Type[] original, Type[] extra )
    {
        Type[] merged;

        if ( extra != null )
        {
            merged = new Type[original.length + extra.length];
            System.arraycopy( original, 0, merged, 0, original.length );
            System.arraycopy( extra, 0, merged, original.length, extra.length );
        }
        else
        {
            merged = original;
        }

        return merged;
    }

    public static Collection<? super Object> resolveCollectionType(
        Class<?> collectionType, Collection<? super Object> defaultValue )
    {
        Collection<? super Object> retValue = null;

        // Default list and set are ArrayList and HashSet. If users
        // wants a particular collection flavour they have to initialise
        // the collection
        if ( null != defaultValue &&
                ( defaultValue.getClass().getModifiers() & Modifier.PRIVATE ) == 0 )
        {
            /* Default collection, which is not immutable */
            retValue = defaultValue;
        }
        else
        {
            if ( Queue.class.isAssignableFrom( collectionType ) )
            {
                if ( collectionType.isAssignableFrom( LinkedList.class ) )
                {
                    retValue = new LinkedList<>();
                }
            }
            else if ( Set.class.isAssignableFrom( collectionType ) )
            {
                if ( collectionType.isAssignableFrom( HashSet.class ) )
                {
                    retValue = new HashSet<>();
                }
            }
            else
            {
                if ( collectionType.isAssignableFrom( ArrayList.class ) )
                {
                    retValue = new ArrayList<>();
                }
            }

            if ( null != retValue && null != defaultValue )
            {
                retValue.addAll( defaultValue );
            }
        }

        return retValue;
    }

    public static Class<?> resolveGenericParameter( Type paramType,
            Map<String, Type> typeArgsMap,
            AtomicReference<Type[]> methodGenericTypeArgs )
    {
        Class<?> parameterType = null;
        //Safe copy
        Map<String, Type> localMap = new HashMap<>( typeArgsMap );
        methodGenericTypeArgs.set( PogoConstants.NO_TYPES );

        if ( paramType instanceof TypeVariable<?> )
        {
            final TypeVariable<?> typeVariable = ( TypeVariable<?> ) paramType;
            final Type type = localMap.get( typeVariable.getName() );

            if ( type != null )
            {
                parameterType = resolveGenericParameter( type, localMap,
                                methodGenericTypeArgs );
            }
        }
        else if ( paramType instanceof ParameterizedType )
        {
            ParameterizedType pType = ( ParameterizedType ) paramType;
            parameterType = ( Class<?> ) pType.getRawType();
            methodGenericTypeArgs.set( pType.getActualTypeArguments() );
        }
        else if ( paramType instanceof WildcardType )
        {
            WildcardType wType = ( WildcardType ) paramType;
            Type[] bounds = wType.getLowerBounds();

            if ( bounds == null || bounds.length == 0 )
            {
                bounds = wType.getUpperBounds();
            }

            if ( bounds != null && bounds.length > 0 )
            {
                parameterType = resolveGenericParameter( bounds[0], localMap,
                                methodGenericTypeArgs );
            }
        }
        else if ( paramType instanceof Class )
        {
            parameterType = ( Class<?> ) paramType;
        }

        if ( parameterType == null )
        {
            parameterType = Object.class;
        }

        return parameterType;
    }


    public static Map<? super Object, ? super Object> resolveMapType(
        Class<?> mapType, Map<? super Object, ? super Object> defaultValue )
    {
        Map<? super Object, ? super Object> retValue = null;

        if ( null != defaultValue &&
                ( defaultValue.getClass().getModifiers() & Modifier.PRIVATE ) == 0 )
        {
            /* Default map, which is not immutable */
            retValue = defaultValue;
        }
        else
        {
            if ( SortedMap.class.isAssignableFrom( mapType ) )
            {
                if ( mapType.isAssignableFrom( TreeMap.class ) )
                {
                    retValue = new TreeMap<>();
                }
            }
            else if ( ConcurrentMap.class.isAssignableFrom( mapType ) )
            {
                if ( mapType.isAssignableFrom( ConcurrentHashMap.class ) )
                {
                    retValue = new ConcurrentHashMap<>();
                }
            }
            else
            {
                if ( mapType.isAssignableFrom( HashMap.class ) )
                {
                    retValue = new HashMap<>();
                }
            }
        }

        return retValue;
    }

    public static Object returnAttributeDataStrategyValue( Class<?> attributeType,
            AttributeStrategy<?> attributeStrategy )
    throws IllegalArgumentException
    {
        Object retValue = attributeStrategy.getValue();

        if ( retValue != null )
        {
            Class<?> desiredType = attributeType.isPrimitive() ?
                                   PogoUtils.primitiveToBoxedType( attributeType ) : attributeType;

            if ( !desiredType.isAssignableFrom( retValue.getClass() ) )
            {
                String errMsg = "The type of the Pogo Attribute Strategy is not "
                                + attributeType.getName() + " but "
                                + retValue.getClass().getName()
                                + ". An exception will be thrown.";
                throw new IllegalArgumentException( errMsg );
            }
        }

        return retValue;
    }

}
