package com.codebreeze.testing.tools.pogo.typeManufacturers;


import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PodamConstants;
import com.codebreeze.testing.tools.pogo.common.PodamDoubleValue;

import java.lang.annotation.Annotation;

public class DoubleTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Double getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Double retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PodamDoubleValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PodamDoubleValue doubleStrategy = ( PodamDoubleValue ) annotation;
                String numValueStr = doubleStrategy.numValue();

                if ( null != numValueStr && !"".equals( numValueStr ) )
                {
                    try
                    {
                        retValue = Double.valueOf( numValueStr );
                    }
                    catch ( NumberFormatException nfe )
                    {
                        String errMsg = PodamConstants.THE_ANNOTATION_VALUE_STR
                                        + numValueStr
                                        + " could not be converted to a Double. An exception will be thrown.";
                        throw new IllegalArgumentException( errMsg, nfe );
                    }
                }
                else
                {
                    double minValue = doubleStrategy.minValue();
                    double maxValue = doubleStrategy.maxValue();

                    // Sanity check
                    if ( minValue > maxValue )
                    {
                        maxValue = minValue;
                    }

                    retValue = strategy.getDoubleInRange( minValue, maxValue,
                                                          wrapper.getAttributeMetadata() );
                }

                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getDouble( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
