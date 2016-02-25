package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PodamConstants;
import com.codebreeze.testing.tools.pogo.common.PodamFloatValue;

import java.lang.annotation.Annotation;

/**
 * Default float type manufacturer.
 *
 * Created by tedonema on 17/05/2015.
 *
 * @since 6.0.0.RELEASE
 */
public class FloatTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Float getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Float retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PodamFloatValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PodamFloatValue floatStrategy = ( PodamFloatValue ) annotation;
                String numValueStr = floatStrategy.numValue();

                if ( null != numValueStr && !"".equals( numValueStr ) )
                {
                    try
                    {
                        retValue = Float.valueOf( numValueStr );
                    }
                    catch ( NumberFormatException nfe )
                    {
                        String errMsg = PodamConstants.THE_ANNOTATION_VALUE_STR
                                        + numValueStr
                                        + " could not be converted to a Float. An exception will be thrown.";
                        throw new IllegalArgumentException( errMsg, nfe );
                    }
                }
                else
                {
                    float minValue = floatStrategy.minValue();
                    float maxValue = floatStrategy.maxValue();

                    // Sanity check
                    if ( minValue > maxValue )
                    {
                        maxValue = minValue;
                    }

                    retValue = strategy.getFloatInRange( minValue, maxValue,
                                                         wrapper.getAttributeMetadata() );
                }

                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getFloat( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
