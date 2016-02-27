package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class FloatTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Float getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        return strategy.getFloat( wrapper.getAttributeMetadata() );
    }
}
