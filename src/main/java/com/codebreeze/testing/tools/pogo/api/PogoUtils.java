package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.PogoExclude;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public final class PogoUtils
{

    private static final int SETTER_IDENTIFIER_LENGTH = 3;

    private static final String GETTER_PREFIX = "get";
    private static final String GETTER_PREFIX2 = "is";

    public static final char[] NICE_ASCII_CHARACTERS = new char[] { 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
            'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1',
            '2', '3', '4', '5', '6', '7', '8', '9', '_'
                                                                  };


    private PogoUtils()
    {
        throw new AssertionError();
    }

    public static ClassInfo getClassInfo( Class<?> clazz,
                                          ClassAttributeApprover attributeApprover )
    {
        return getClassInfo( clazz,
                             new HashSet<>(),
                             Collections.<String>emptySet(),
                             attributeApprover );
    }

    public static ClassInfo getClassInfo( Class<?> clazz,
                                          Set<Class<? extends Annotation>> excludeFieldAnnotations,
                                          Set<String> excludedFields,
                                          ClassAttributeApprover attributeApprover )
    {
        return getClassInfo( clazz, excludeFieldAnnotations, excludedFields, attributeApprover,
                             Collections.<Method>emptySet() );
    }


    public static ClassInfo getClassInfo( Class<?> clazz,
                                          Set<Class<? extends Annotation>> excludeFieldAnnotations,
                                          Set<String> excludedFields,
                                          ClassAttributeApprover attributeApprover,
                                          Collection<Method> extraMethods )
    {
        if ( null == attributeApprover )
        {
            attributeApprover = DefaultClassInfoStrategy.getInstance().getClassAttributeApprover( clazz );
        }

        Set<Field> classFields = new HashSet<>();
        Set<Method> classGetters = new HashSet<>();
        Set<Method> classSetters = new HashSet<>();
        fillPojoSets( clazz, classFields, classGetters, classSetters, excludeFieldAnnotations, excludedFields );
        Map<String, ClassAttribute> map = new TreeMap<>();

        for ( Field classField : classFields )
        {
            ClassAttribute attribute = new ClassAttribute( classField,
                    Collections.<Method>emptySet(), Collections.<Method>emptySet() );
            map.put( classField.getName(), attribute );
        }

        for ( Method classGetter : classGetters )
        {
            String attributeName = extractFieldNameFromGetterMethod( classGetter );
            ClassAttribute attribute = map.get( attributeName );

            if ( attribute != null )
            {
                attribute.getRawGetters().add( classGetter );
            }
            else
            {
                attribute = new ClassAttribute( null,
                                                Collections.singleton( classGetter ),
                                                Collections.<Method>emptySet() );
                map.put( attributeName, attribute );
            }
        }

        for ( Method classSetter : classSetters )
        {
            String attributeName = extractFieldNameFromSetterMethod( classSetter );
            ClassAttribute attribute = map.get( attributeName );

            if ( attribute != null )
            {
                attribute.getRawSetters().add( classSetter );
            }
            else
            {
                attribute = new ClassAttribute( null,
                                                Collections.<Method>emptySet(),
                                                Collections.singleton( classSetter ) );
                map.put( attributeName, attribute );
            }
        }

        /* Approve all found attributes */
        Collection<ClassAttribute> attributes = new ArrayList<>( map.values() );
        Iterator<ClassAttribute> iter = attributes.iterator();
        main :

        while( iter.hasNext() )
        {
            ClassAttribute attribute = iter.next();

            for ( Method classGetter : attribute.getRawGetters() )
            {
                if ( containsAnyAnnotation( classGetter, excludeFieldAnnotations ) )
                {
                    iter.remove();
                    continue main;
                }
            }

            for ( Method classSetter : attribute.getRawSetters() )
            {
                if ( containsAnyAnnotation( classSetter, excludeFieldAnnotations ) )
                {
                    iter.remove();
                    continue main;
                }
            }

            Field field = attribute.getAttribute();

            if ( field != null && (
                        excludedFields.contains( field.getName() )
                        || containsAnyAnnotation( field, excludeFieldAnnotations ) ) )
            {
                iter.remove();
                continue;
            }

            if ( !attributeApprover.approve( attribute ) )
            {
                iter.remove();
            }
        }

        return new ClassInfo( clazz, attributes, extraMethods );
    }


    public static boolean containsAnyAnnotation( Field field,
            Set<Class<? extends Annotation>> annotations )
    {
        for ( Class<? extends Annotation> annotation : annotations )
        {
            if ( field.getAnnotation( annotation ) != null )
            {
                return true;
            }
        }

        return false;
    }

    private static boolean containsAnyAnnotation( Method method,
            Set<Class<? extends Annotation>> annotations )
    {
        for ( Class<? extends Annotation> annotation : annotations )
        {
            if ( method.getAnnotation( annotation ) != null )
            {
                return true;
            }
        }

        return false;
    }

    public static void fillPojoSets( Class<?> clazz, Set<Field> classFields,
                                     Set<Method> classGetters, Set<Method> classSetters,
                                     Set<Class<? extends Annotation>> excludeAnnotations,
                                     Set<String> excludedFields )
    {
        if ( excludeAnnotations == null )
        {
            excludeAnnotations = new HashSet<>();
        }

        excludeAnnotations.add( PogoExclude.class );
        Class<?> workClass = clazz;

        while ( workClass != null )
        {
            Method[] declaredMethods = workClass.getDeclaredMethods();

            for ( Method method : declaredMethods )
            {
                /*
                 * Bridge methods are automatically generated by compiler to
                 * deal with type erasure and they are not type safe. That why
                 * they should be ignored
                 */
                if ( !method.isBridge() && !Modifier.isNative( method.getModifiers() ) )
                {
                    if ( method.getName().startsWith( "set" )
                            && method.getReturnType().equals( void.class ) )
                    {
                        classSetters.add( method );
                    }
                    else if ( ( method.getName().startsWith( GETTER_PREFIX ) || method.getName().startsWith( GETTER_PREFIX2 ) ) &&
                              method.getParameterTypes().length == 0 && !method.getReturnType().equals( void.class ) )
                    {
                        classGetters.add( method );
                    }
                }
            }

            Field[] declaredFields = workClass.getDeclaredFields();

            for ( Field field : declaredFields )
            {
                int modifiers = field.getModifiers();

                if ( !Modifier.isStatic( modifiers ) )
                {
                    classFields.add( field );
                }
            }

            workClass = workClass.getSuperclass();
        }
    }

    public static String extractFieldNameFromSetterMethod( Method method )
    {
        String candidateField = method.getName().substring( SETTER_IDENTIFIER_LENGTH );

        if ( !"".equals( candidateField ) )
        {
            candidateField = Character.toLowerCase( candidateField.charAt( 0 ) )
                             + candidateField.substring( 1 );
        }
        else
        {
        }

        return candidateField;
    }

    public static String extractFieldNameFromGetterMethod( Method method )
    {
        String candidateField = method.getName();

        if ( candidateField.startsWith( GETTER_PREFIX ) )
        {
            candidateField = candidateField.substring( GETTER_PREFIX.length() );
        }
        else if ( candidateField.startsWith( GETTER_PREFIX2 ) )
        {
            candidateField = candidateField.substring( GETTER_PREFIX2.length() );
        }

        if ( !"".equals( candidateField ) )
        {
            candidateField = Character.toLowerCase( candidateField.charAt( 0 ) )
                             + candidateField.substring( 1 );
        }
        else
        {
        }

        return candidateField;
    }

    public static Field getField( Class<?> pojoClass, String attributeName )
    {
        Field field = null;
        Class<?> clazz = pojoClass;

        while ( clazz != null )
        {
            try
            {
                field = clazz.getDeclaredField( attributeName );
                break;
            }
            catch ( NoSuchFieldException e )
            {
                clazz = clazz.getSuperclass();
            }
        }

        return field;
    }

    public static <T> T getFieldValue( Object pojo, String attributeName )
    {
        T retValue = null;

        try
        {
            Field field = PogoUtils.getField( pojo.getClass(), attributeName );

            if ( field != null )
            {
                // It allows to invoke Field.get on private fields
                field.setAccessible( true );
                @SuppressWarnings( "unchecked" )
                T t = ( T ) field.get( pojo );
                retValue = t;
            }
            else
            {
            }
        }
        catch ( Exception e )
        {
            System.out.println( e );
        }

        return retValue;
    }

    public static List<Annotation> getAttributeAnnotations( final Field attribute,
            final Method setter )
    {
        Annotation[] annotations = ( attribute != null ? attribute.getAnnotations() : null );
        List<Annotation> retValue;

        if ( annotations != null && annotations.length != 0 )
        {
            retValue = new ArrayList<>( Arrays.asList( annotations ) );
        }
        else
        {
            retValue = new ArrayList<>();
        }

        Collections.addAll( retValue, setter.getParameterAnnotations()[0] );
        return retValue;
    }

    public static Character getNiceCharacter()
    {
        int randomCharIdx =
            ( int ) ( Math.random() * ( NICE_ASCII_CHARACTERS.length - 1 ) + 0.5 );
        return NICE_ASCII_CHARACTERS[randomCharIdx];
    }

    public static long getLongInRange( long minValue, long maxValue )
    {
        return ( long ) ( minValue + Math.random() * ( maxValue - minValue ) + 0.5 );
    }

    public static Class<?> primitiveToBoxedType( Class<?> primitiveType )
    {
        if ( int.class.equals( primitiveType ) )
        {
            return Integer.class;
        }
        else if ( double.class.equals( primitiveType ) )
        {
            return Double.class;
        }
        else if ( long.class.equals( primitiveType ) )
        {
            return Long.class;
        }
        else if ( byte.class.equals( primitiveType ) )
        {
            return Byte.class;
        }
        else if ( float.class.equals( primitiveType ) )
        {
            return Float.class;
        }
        else if ( char.class.equals( primitiveType ) )
        {
            return Character.class;
        }
        else if ( short.class.equals( primitiveType ) )
        {
            return Short.class;
        }
        else
        {
            return primitiveType;
        }
    }
}
