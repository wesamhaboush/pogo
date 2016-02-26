package com.codebreeze.testing.tools.pogo.typeManufacturers;


public abstract class AbstractTypeManufacturer implements TypeManufacturer
{
    protected void checkWrapperIsValid( TypeManufacturerParamsWrapper wrapper )
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

        if ( null == wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            errMsg = "The annotations list within the attribute metadata cannot be null, although it can be empty";
            throw new IllegalArgumentException( errMsg );
        }
    }
}
