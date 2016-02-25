package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PodamConstants;
import com.codebreeze.testing.tools.pogo.common.PodamLongValue;

import java.lang.annotation.Annotation;

public class LongTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Long getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Long retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PodamLongValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PodamLongValue longStrategy = ( PodamLongValue ) annotation;
                String numValueStr = longStrategy.numValue();

                if ( null != numValueStr && !"".equals( numValueStr ) )
                {
                    try
                    {
                        retValue = Long.valueOf( numValueStr );
                    }
                    catch ( NumberFormatException nfe )
                    {
                        String errMsg = PodamConstants.THE_ANNOTATION_VALUE_STR
                                        + numValueStr
                                        + " could not be converted to a Long. An exception will be thrown.";
                        throw new IllegalArgumentException( errMsg, nfe );
                    }
                }
                else
                {
                    long minValue = longStrategy.minValue();
                    long maxValue = longStrategy.maxValue();

                    // Sanity check
                    if ( minValue > maxValue )
                    {
                        maxValue = minValue;
                    }

                    retValue = strategy.getLongInRange( minValue, maxValue,
                                                        wrapper.getAttributeMetadata() );
                }

                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getLong( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
