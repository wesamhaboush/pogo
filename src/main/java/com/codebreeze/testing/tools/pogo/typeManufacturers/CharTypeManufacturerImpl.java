package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class CharTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Character getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Character retValue = null;

        if ( retValue == null )
        {
            retValue = strategy.getCharacter( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
