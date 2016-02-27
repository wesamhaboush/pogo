package com.codebreeze.testing.tools.pogo.typeManufacturers;


import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class DoubleTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Double getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        return strategy.getDouble( wrapper.getAttributeMetadata() );
    }
}
