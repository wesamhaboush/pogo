package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PogoBooleanValue;

import java.lang.annotation.Annotation;

public class BooleanTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Boolean getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Boolean retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PogoBooleanValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PogoBooleanValue localStrategy = ( PogoBooleanValue ) annotation;
                retValue = localStrategy.boolValue();
                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getBoolean( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }

}
