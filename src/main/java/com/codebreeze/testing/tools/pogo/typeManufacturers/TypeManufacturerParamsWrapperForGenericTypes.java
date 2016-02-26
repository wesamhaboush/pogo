package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeManufacturerParamsWrapperForGenericTypes extends TypeManufacturerParamsWrapper
{
    private final Map<String, Type> typeArgumentsMap;

    private final Type attributeGenericType;

    public TypeManufacturerParamsWrapperForGenericTypes( DataProviderStrategy dataProviderStrategy,
            AttributeMetadata attributeMetadata,
            Map<String, Type> typeArgumentsMap,
            Type attributeGenericType )
    {
        super( dataProviderStrategy, attributeMetadata );
        //safe copy
        this.typeArgumentsMap = new HashMap<>( typeArgumentsMap );
        this.attributeGenericType = attributeGenericType;
    }

    public Map<String, Type> getTypeArgumentsMap()
    {
        return new HashMap<>( typeArgumentsMap );
    }

    public Type getAttributeGenericType()
    {
        return attributeGenericType;
    }

}
