package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public interface DataProviderStrategy
{

    <T> DataProviderStrategy addOrReplaceSpecific(
        Class<T> abstractClass, Class<? extends T> specificClass );

    <T> DataProviderStrategy removeSpecific(
        Class<T> abstractClass );

    enum Order
    {
        HEAVY_FIRST,
        LIGHT_FIRST
    }

    Boolean getBoolean( AttributeMetadata attributeMetadata );

    Byte getByte( AttributeMetadata attributeMetadata );

    Byte getByteInRange( byte minValue, byte maxValue,
                         AttributeMetadata attributeMetadata );

    Character getCharacter( AttributeMetadata attributeMetadata );

    Character getCharacterInRange( char minValue, char maxValue,
                                   AttributeMetadata attributeMetadata );

    Double getDouble( AttributeMetadata attributeMetadata );

    Double getDoubleInRange( double minValue, double maxValue,
                             AttributeMetadata attributeMetadata );

    Float getFloat( AttributeMetadata attributeMetadata );

    Float getFloatInRange( float minValue, float maxValue,
                           AttributeMetadata attributeMetadata );

    Integer getInteger( AttributeMetadata attributeMetadata );

    int getIntegerInRange( int minValue, int maxValue,
                           AttributeMetadata attributeMetadata );

    Long getLong( AttributeMetadata attributeMetadata );

    Long getLongInRange( long minValue, long maxValue,
                         AttributeMetadata attributeMetadata );

    Short getShort( AttributeMetadata attributeMetadata );

    Short getShortInRange( short minValue, short maxValue,
                           AttributeMetadata attributeMetadata );

    String getStringValue( AttributeMetadata attributeMetadata );

    String getStringOfLength( int length, AttributeMetadata attributeMetadata );

    int getNumberOfCollectionElements( Class<?> type );

    void setDefaultNumberOfCollectionElements( int newNumberOfCollectionElements );

    int getMaxDepth( Class<?> type );

    boolean isMemoizationEnabled();

    void setMemoization( boolean isMemoizationEnabled );

    Object getMemoizedObject( AttributeMetadata attributeMetadata );

    void cacheMemoizedObject( AttributeMetadata attributeMetadata, Object instance );

    void clearMemoizationCache();

    void sort( Constructor<?>[] constructors, Order order );

    void sort( Method[] methods, Order order );

    <T> Class<? extends T> getSpecificClass( Class<T> nonInstantiatableClass );

    Class<AttributeStrategy<?>> getStrategyForAnnotation( Class<? extends Annotation> annotationClass );

}
