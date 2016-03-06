package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TypeManufacturerParamsWrapper
{
    private final DataProviderStrategy dataProviderStrategy;

    private final AttributeMetadata attributeMetadata;

    public TypeManufacturerParamsWrapper( DataProviderStrategy dataProviderStrategy,
                                          AttributeMetadata attributeMetadata )
    {
        this.dataProviderStrategy = dataProviderStrategy;
        this.attributeMetadata = attributeMetadata;
    }

    public DataProviderStrategy getDataProviderStrategy()
    {
        return dataProviderStrategy;
    }

    public AttributeMetadata getAttributeMetadata()
    {
        return attributeMetadata;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
