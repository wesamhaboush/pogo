package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class ShortTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Short getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        return strategy.getShort( wrapper.getAttributeMetadata() );
    }
}
