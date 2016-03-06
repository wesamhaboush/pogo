package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public abstract class AbstractRandomDataProviderStrategy implements RandomDataProviderStrategy
{

    private static final Random RANDOM = new Random( System.currentTimeMillis() );

    private static final int MAX_DEPTH = 1;

    private int nbrOfCollectionElements;

    private boolean isMemoizationEnabled =  true;

    private final ConcurrentMap<Class<?>, ConcurrentMap<Type[], Object>> memoizationTable = new ConcurrentHashMap<>();

    private final ConcurrentMap<Class<?>, Class<?>> specificTypes = new ConcurrentHashMap<>();

    private Comparator<Constructor<?>> constructorHeavyComparator =
        ConstructorHeavyFirstComparator.INSTANCE;

    private Comparator<Constructor<?>> constructorLightComparator =
        ConstructorLightFirstComparator.INSTANCE;

    private Comparator<Method> methodHeavyComparator
        = MethodHeavyFirstComparator.INSTANCE;

    private Comparator<Method> methodLightComparator
        = MethodLightFirstComparator.INSTANCE;

    public AbstractRandomDataProviderStrategy()
    {
        this( PogoConstants.DEFAULT_NBR_COLLECTION_ELEMENTS );
    }

    private AbstractRandomDataProviderStrategy( int nbrOfCollectionElements )
    {
        this.nbrOfCollectionElements = nbrOfCollectionElements;
    }

    @Override
    public Boolean getBoolean( AttributeMetadata attributeMetadata )
    {
        return RANDOM.nextBoolean();
    }

    @Override
    public Byte getByte( AttributeMetadata attributeMetadata )
    {
        final byte[] bytes = new byte[1];
        RANDOM.nextBytes( bytes );
        return bytes[0];
    }

    @Override
    public Character getCharacter( AttributeMetadata attributeMetadata )
    {
        return PogoUtils.getNiceCharacter();
    }

    @Override
    public Double getDouble( AttributeMetadata attributeMetadata )
    {
        return RANDOM.nextDouble();
    }


    @Override
    public Float getFloat( AttributeMetadata attributeMetadata )
    {
        return RANDOM.nextFloat();
    }

    @Override
    public Integer getInteger( AttributeMetadata attributeMetadata )
    {
        return RANDOM.nextInt();
    }

    @Override
    public Long getLong( AttributeMetadata attributeMetadata )
    {
        return RANDOM.nextLong();
    }


    @Override
    public Short getShort( AttributeMetadata attributeMetadata )
    {
        return ( short )RANDOM.nextInt( Short.MAX_VALUE + 1 );
    }

    @Override
    public String getStringValue( AttributeMetadata attributeMetadata )
    {
        return getStringOfLength( PogoConstants.STR_DEFAULT_LENGTH,
                                  attributeMetadata );
    }

    @Override
    public String getStringOfLength( int length,
                                     AttributeMetadata attributeMetadata )
    {
        StringBuilder buff = new StringBuilder();

        while ( buff.length() < length )
        {
            buff.append( getCharacter( attributeMetadata ) );
        }

        return buff.toString();
    }

    @Override
    public int getNumberOfCollectionElements( Class<?> type )
    {
        return nbrOfCollectionElements;
    }

    void setDefaultNumberOfCollectionElements( int newNumberOfCollectionElements )
    {
        nbrOfCollectionElements = newNumberOfCollectionElements;
    }

    @Override
    public int getMaxDepth( Class<?> type )
    {
        /* The max stack trace depth. */
        return MAX_DEPTH;
    }

    void setMemoization( boolean isMemoizationEnabled )
    {
        this.isMemoizationEnabled = isMemoizationEnabled;
    }

    @Override
    public Object getMemoizedObject( AttributeMetadata attributeMetadata )
    {
        if ( isMemoizationEnabled )
        {
            /* No memoization for arrays, collections and maps */
            Class<?> pojoClass = attributeMetadata.getPojoClass();

            if ( pojoClass == null ||
                    ( !pojoClass.isArray() &&
                      !Collection.class.isAssignableFrom( pojoClass ) &&
                      !Map.class.isAssignableFrom( pojoClass ) ) )
            {
                ConcurrentMap<Type[], Object> map = memoizationTable.get( attributeMetadata.getAttributeType() );

                if ( map != null )
                {
                    for ( Entry<Type[], Object> entry : map.entrySet() )
                    {
                        if ( Arrays.equals( entry.getKey(), attributeMetadata.getAttrGenericArgs() ) )
                        {
                            return entry.getValue();
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public void cacheMemoizedObject( AttributeMetadata attributeMetadata,
                                     Object instance )
    {
        if ( isMemoizationEnabled )
        {
            ConcurrentMap<Type[], Object> map = memoizationTable.get( attributeMetadata.getAttributeType() );

            if ( map == null )
            {
                map = new ConcurrentHashMap<>();
                memoizationTable.putIfAbsent( attributeMetadata.getAttributeType(), map );
            }

            map.putIfAbsent( attributeMetadata.getAttrGenericArgs(), instance );
        }
    }

    @Override
    public void sort( Constructor<?>[] constructors, Order order )
    {
        Comparator<Constructor<?>> constructorComparator;

        switch( order )
        {
        case HEAVY_FIRST:
            constructorComparator = constructorHeavyComparator;
            break;

        default:
            constructorComparator = constructorLightComparator;
            break;
        }

        Arrays.sort( constructors, constructorComparator );
    }

    @Override
    public void sort( Method[] methods, Order order )
    {
        Comparator<Method> methodComparator;

        switch( order )
        {
        case HEAVY_FIRST:
            methodComparator = methodHeavyComparator;
            break;

        default:
            methodComparator = methodLightComparator;
            break;
        }

        Arrays.sort( methods, methodComparator );
    }

    @Override
    public <T> void addOrReplaceSpecific(
        final Class<T> abstractClass, final Class<? extends T> specificClass )
    {
        specificTypes.put( abstractClass, specificClass );
    }

    @Override
    public <T> Class<? extends T> getSpecificClass(
        Class<T> nonInstantiatableClass )
    {
        Class<? extends T> found = ( Class<? extends T> ) specificTypes
                                   .get( nonInstantiatableClass );

        if ( found == null )
        {
            found = nonInstantiatableClass;
        }

        return found;
    }

    @Override
    public Comparator<Constructor<?>> getConstructorLightComparator()
    {
        return constructorLightComparator;
    }

    @Override
    public void setConstructorLightComparator( Comparator<Constructor<?>> constructorLightComparator )
    {
        this.constructorLightComparator = constructorLightComparator;
    }

    @Override
    public Comparator<Constructor<?>> getConstructorHeavyComparator()
    {
        return constructorHeavyComparator;
    }

    @Override
    public void setConstructorHeavyComparator( Comparator<Constructor<?>> constructorHeavyComparator )
    {
        this.constructorHeavyComparator = constructorHeavyComparator;
    }

    @Override
    public Comparator<Method> getMethodLightComparator()
    {
        return methodLightComparator;
    }

    @Override
    public void setMethodLightComparator( Comparator<Method> methodLightComparator )
    {
        this.methodLightComparator = methodLightComparator;
    }

    @Override
    public Comparator<Method> getMethodHeavyComparator()
    {
        return methodHeavyComparator;
    }

    @Override
    public void setMethodHeavyComparator( Comparator<Method> methodHeavyComparator )
    {
        this.methodHeavyComparator = methodHeavyComparator;
    }
}
