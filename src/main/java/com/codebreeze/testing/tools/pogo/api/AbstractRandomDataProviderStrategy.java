/**
 *
 */
package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public abstract class AbstractRandomDataProviderStrategy implements RandomDataProviderStrategy
{

    private static final Random RANDOM = new Random( System.currentTimeMillis() );

    public static final int MAX_DEPTH = 1;

    private int nbrOfCollectionElements;

    private boolean isMemoizationEnabled =  true;

    private final ConcurrentMap<Class<?>, ConcurrentMap<Type[], Object>> memoizationTable = new ConcurrentHashMap<>();

    private final ConcurrentMap<Class<?>, Class<?>> specificTypes = new ConcurrentHashMap<>();

    private final ConcurrentMap<Class<? extends Annotation>, Class<AttributeStrategy<?>>> attributeStrategies
        = new ConcurrentHashMap<>();

    private AbstractConstructorComparator constructorHeavyComparator =
        ConstructorHeavyFirstComparator.INSTANCE;

    private AbstractConstructorComparator constructorLightComparator =
        ConstructorLightFirstComparator.INSTANCE;

    private AbstractMethodComparator methodHeavyComparator
        = MethodHeavyFirstComparator.INSTANCE;

    private AbstractMethodComparator methodLightComparator
        = MethodLightFirstComparator.INSTANCE;

    public AbstractRandomDataProviderStrategy()
    {
        this( PogoConstants.DEFAULT_NBR_COLLECTION_ELEMENTS );
    }

    public AbstractRandomDataProviderStrategy( int nbrOfCollectionElements )
    {
        this.nbrOfCollectionElements = nbrOfCollectionElements;
    }

    @Override
    public Boolean getBoolean( AttributeMetadata attributeMetadata )
    {
        return Boolean.TRUE;
    }

    @Override
    public Byte getByte( AttributeMetadata attributeMetadata )
    {
        byte nextByte;

        do
        {
            nextByte = ( byte ) RANDOM.nextInt( Byte.MAX_VALUE );
        }
        while ( nextByte == 0 );

        return nextByte;
    }

    @Override
    public Byte getByteInRange( byte minValue, byte maxValue,
                                AttributeMetadata attributeMetadata )
    {
        return ( byte ) ( minValue + Math.random() * ( maxValue - minValue ) + 0.5 );
    }

    @Override
    public Character getCharacter( AttributeMetadata attributeMetadata )
    {
        return PogoUtils.getNiceCharacter();
    }

    @Override
    public Character getCharacterInRange( char minValue, char maxValue,
                                          AttributeMetadata attributeMetadata )
    {
        return ( char ) ( minValue + Math.random() * ( maxValue - minValue ) + 0.5 );
    }

    @Override
    public Double getDouble( AttributeMetadata attributeMetadata )
    {
        double retValue;

        do
        {
            retValue = RANDOM.nextDouble();
        }
        while ( retValue == 0.0 );

        return retValue;
    }

    @Override
    public Double getDoubleInRange( double minValue, double maxValue,
                                    AttributeMetadata attributeMetadata )
    {
        // This can happen. It's a way to specify a precise value
        if ( minValue == maxValue )
        {
            return minValue;
        }

        double retValue;

        do
        {
            retValue = minValue + Math.random() * ( maxValue - minValue + 1 );
        }
        while ( retValue > maxValue );

        return retValue;
    }

    @Override
    public Float getFloat( AttributeMetadata attributeMetadata )
    {
        float retValue;

        do
        {
            retValue = RANDOM.nextFloat();
        }
        while ( retValue == 0.0f );

        return retValue;
    }

    @Override
    public Float getFloatInRange( float minValue, float maxValue,
                                  AttributeMetadata attributeMetadata )
    {
        // This can happen. It's a way to specify a precise value
        if ( minValue == maxValue )
        {
            return minValue;
        }

        float retValue;

        do
        {
            retValue = ( float ) ( minValue
                                   + Math.random() * ( maxValue - minValue + 1 ) );
        }
        while ( retValue > maxValue );

        return retValue;
    }

    @Override
    public Integer getInteger( AttributeMetadata attributeMetadata )
    {
        Integer retValue;

        do
        {
            retValue = RANDOM.nextInt();
        }
        while ( retValue == 0 );

        return retValue;
    }

    @Override
    public int getIntegerInRange( int minValue, int maxValue,
                                  AttributeMetadata attributeMetadata )
    {
        return ( int ) ( minValue + Math.random() * ( maxValue - minValue ) + 0.5 );
    }

    @Override
    public Long getLong( AttributeMetadata attributeMetadata )
    {
        return System.nanoTime();
    }

    @Override
    public Long getLongInRange( long minValue, long maxValue,
                                AttributeMetadata attributeMetadata )
    {
        return PogoUtils.getLongInRange( minValue, maxValue );
    }

    @Override
    public Short getShort( AttributeMetadata attributeMetadata )
    {
        short retValue;

        do
        {
            retValue = ( short ) RANDOM.nextInt( Byte.MAX_VALUE );
        }
        while ( retValue == 0 );

        return retValue;
    }

    @Override
    public Short getShortInRange( short minValue, short maxValue,
                                  AttributeMetadata attributeMetadata )
    {
        return ( short ) ( minValue + Math.random() * ( maxValue - minValue ) + 0.5 );
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

    @Override
    public void setDefaultNumberOfCollectionElements( int newNumberOfCollectionElements )
    {
        nbrOfCollectionElements = newNumberOfCollectionElements;
    }

    @Override
    public int getMaxDepth( Class<?> type )
    {
        /* The max stack trace depth. */
        int maxDepth = MAX_DEPTH;
        return maxDepth;
    }

    @Override
    public boolean isMemoizationEnabled()
    {
        return isMemoizationEnabled;
    }

    @Override
    public void setMemoization( boolean isMemoizationEnabled )
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
    public void clearMemoizationCache()
    {
        memoizationTable.clear();
    }

    @Override
    public void sort( Constructor<?>[] constructors, Order order )
    {
        AbstractConstructorComparator constructorComparator;

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
        AbstractMethodComparator methodComparator;

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
    public <T> DataProviderStrategy addOrReplaceSpecific(
        final Class<T> abstractClass, final Class<? extends T> specificClass )
    {
        specificTypes.put( abstractClass, specificClass );
        return this;
    }

    @Override
    public <T> DataProviderStrategy removeSpecific(
        final Class<T> abstractClass )
    {
        specificTypes.remove( abstractClass );
        return this;
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
    public RandomDataProviderStrategy addOrReplaceAttributeStrategy(
        final Class<? extends Annotation> annotationClass,
        final Class<AttributeStrategy<?>> strategyClass )
    {
        attributeStrategies.put( annotationClass, strategyClass );
        return this;
    }

    @Override
    public RandomDataProviderStrategy removeAttributeStrategy(
        final Class<? extends Annotation> annotationClass )
    {
        attributeStrategies.remove( annotationClass );
        return this;
    }

    @Override
    public Class<AttributeStrategy<?>> getStrategyForAnnotation(
        final Class<? extends Annotation> annotationClass )
    {
        return attributeStrategies.get( annotationClass );
    }

    @Override
    public AbstractConstructorComparator getConstructorLightComparator()
    {
        return constructorLightComparator;
    }

    @Override
    public void setConstructorLightComparator( AbstractConstructorComparator constructorLightComparator )
    {
        this.constructorLightComparator = constructorLightComparator;
    }

    @Override
    public AbstractConstructorComparator getConstructorHeavyComparator()
    {
        return constructorHeavyComparator;
    }

    @Override
    public void setConstructorHeavyComparator( AbstractConstructorComparator constructorHeavyComparator )
    {
        this.constructorHeavyComparator = constructorHeavyComparator;
    }

    @Override
    public AbstractMethodComparator getMethodLightComparator()
    {
        return methodLightComparator;
    }

    @Override
    public void setMethodLightComparator( AbstractMethodComparator methodLightComparator )
    {
        this.methodLightComparator = methodLightComparator;
    }

    @Override
    public AbstractMethodComparator getMethodHeavyComparator()
    {
        return methodHeavyComparator;
    }

    @Override
    public void setMethodHeavyComparator( AbstractMethodComparator methodHeavyComparator )
    {
        this.methodHeavyComparator = methodHeavyComparator;
    }
}
