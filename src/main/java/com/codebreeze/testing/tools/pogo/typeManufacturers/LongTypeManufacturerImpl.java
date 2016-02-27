package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class LongTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Long getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        return strategy.getLong( wrapper.getAttributeMetadata() );
    }
}
