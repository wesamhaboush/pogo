package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class EnumTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Object getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        AttributeMetadata attributeMetadata = wrapper.getAttributeMetadata();
        Class<?> realAttributeType = attributeMetadata.getAttributeType();
        Object retValue = null;
        // Enum type
        int enumConstantsLength = realAttributeType.getEnumConstants().length;

        if ( enumConstantsLength > 0 )
        {
            int enumIndex = Math.abs( strategy.getInteger( attributeMetadata ) % enumConstantsLength );
            retValue = realAttributeType.getEnumConstants()[enumIndex];
        }

        return retValue;
    }
}
