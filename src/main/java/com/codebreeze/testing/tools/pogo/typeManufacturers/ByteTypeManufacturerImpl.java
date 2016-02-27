package com.codebreeze.testing.tools.pogo.typeManufacturers;


import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

public class ByteTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Byte getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Byte retValue = null;

        if ( retValue == null )
        {
            retValue = strategy.getByte( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
