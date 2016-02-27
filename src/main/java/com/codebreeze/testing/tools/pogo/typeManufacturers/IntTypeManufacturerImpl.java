package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class IntTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Integer getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        return strategy.getInteger( wrapper.getAttributeMetadata() );
    }
}
