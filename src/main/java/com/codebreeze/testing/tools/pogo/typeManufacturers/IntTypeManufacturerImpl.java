package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.common.PodamConstants;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PodamIntValue;

import java.lang.annotation.Annotation;

/**
 * Default int type manufacturer.
 *
 * Created by tedonema on 17/05/2015.
 *
 * @since 6.0.0.RELEASE
 */
public class IntTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Integer getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Integer retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PodamIntValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PodamIntValue intStrategy = ( PodamIntValue ) annotation;
                String numValueStr = intStrategy.numValue();

                if ( null != numValueStr && !"".equals( numValueStr ) )
                {
                    try
                    {
                        retValue = Integer.valueOf( numValueStr );
                    }
                    catch ( NumberFormatException nfe )
                    {
                        String errMsg = PodamConstants.THE_ANNOTATION_VALUE_STR
                                        + numValueStr
                                        + " could not be converted to an Integer. An exception will be thrown.";
                        throw new IllegalArgumentException( errMsg, nfe );
                    }
                }
                else
                {
                    int minValue = intStrategy.minValue();
                    int maxValue = intStrategy.maxValue();

                    // Sanity check
                    if ( minValue > maxValue )
                    {
                        maxValue = minValue;
                    }

                    retValue = strategy.getIntegerInRange( minValue, maxValue,
                                                           wrapper.getAttributeMetadata() );
                }

                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getInteger( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
