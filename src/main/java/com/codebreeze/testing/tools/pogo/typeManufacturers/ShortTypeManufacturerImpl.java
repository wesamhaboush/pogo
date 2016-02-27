package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class ShortTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Short getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Short retValue = null;

        if ( retValue == null )
        {
            retValue = strategy.getShort( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
