package com.codebreeze.testing.tools.pogo.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public interface DataProviderStrategy
{

    <T> void addOrReplaceSpecific(
        Class<T> abstractClass, Class<? extends T> specificClass );

    enum Order
    {
        HEAVY_FIRST,
        LIGHT_FIRST
    }

    Boolean getBoolean( AttributeMetadata attributeMetadata );

    Byte getByte( AttributeMetadata attributeMetadata );

    Character getCharacter( AttributeMetadata attributeMetadata );

    Double getDouble( AttributeMetadata attributeMetadata );

    Float getFloat( AttributeMetadata attributeMetadata );

    Integer getInteger( AttributeMetadata attributeMetadata );

    Long getLong( AttributeMetadata attributeMetadata );

    Short getShort( AttributeMetadata attributeMetadata );

    String getStringValue( AttributeMetadata attributeMetadata );

    String getStringOfLength( int length, AttributeMetadata attributeMetadata );

    int getNumberOfCollectionElements( Class<?> type );

    void setDefaultNumberOfCollectionElements( int newNumberOfCollectionElements );

    int getMaxDepth( Class<?> type );

    void setMemoization( boolean isMemoizationEnabled );

    Object getMemoizedObject( AttributeMetadata attributeMetadata );

    void cacheMemoizedObject( AttributeMetadata attributeMetadata, Object instance );

    void sort( Constructor<?>[] constructors, Order order );

    void sort( Method[] methods, Order order );

    <T> Class<? extends T> getSpecificClass( Class<T> nonInstantiatableClass );
}
