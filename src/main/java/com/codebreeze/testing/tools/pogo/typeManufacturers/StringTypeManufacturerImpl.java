package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class StringTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public String getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        String retValue = null;
        AttributeMetadata attributeMetadata = wrapper.getAttributeMetadata();

        if ( retValue == null )
        {
            retValue = strategy.getStringValue( attributeMetadata );
        }

        return retValue;
    }
}
