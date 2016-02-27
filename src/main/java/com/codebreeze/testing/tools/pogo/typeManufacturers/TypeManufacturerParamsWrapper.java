package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

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
        return "TypeManufacturerParamsWrapper{" + "dataProviderStrategy=" + dataProviderStrategy +
               ", attributeMetadata=" + attributeMetadata +
               '}';
    }
}
