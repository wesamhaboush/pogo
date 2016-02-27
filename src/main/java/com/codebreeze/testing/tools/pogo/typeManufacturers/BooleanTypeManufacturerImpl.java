package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class BooleanTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Boolean getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        return strategy.getBoolean( wrapper.getAttributeMetadata() );
    }

}
