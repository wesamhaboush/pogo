package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class CharTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Character getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        return strategy.getCharacter( wrapper.getAttributeMetadata() );
    }
}
