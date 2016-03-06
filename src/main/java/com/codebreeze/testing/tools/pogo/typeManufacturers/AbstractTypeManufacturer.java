package com.codebreeze.testing.tools.pogo.typeManufacturers;


abstract class AbstractTypeManufacturer implements TypeManufacturer
{
    void checkWrapperIsValid( TypeManufacturerParamsWrapper wrapper )
    {
        String errMsg;

        if ( null == wrapper )
        {
            errMsg = "The wrapper cannot be null";
            throw new IllegalArgumentException( errMsg );
        }

        if ( null == wrapper.getAttributeMetadata() )
        {
            errMsg = "The attribute metadata inside the wrapper cannot be null";
            throw new IllegalArgumentException( errMsg );
        }
    }
}
