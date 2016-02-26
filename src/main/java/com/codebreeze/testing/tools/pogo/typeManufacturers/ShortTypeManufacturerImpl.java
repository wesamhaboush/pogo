package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PogoShortValue;

import java.lang.annotation.Annotation;

public class ShortTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Short getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Short retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PogoShortValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PogoShortValue shortStrategy = ( PogoShortValue ) annotation;
                String numValueStr = shortStrategy.numValue();

                if ( null != numValueStr && !"".equals( numValueStr ) )
                {
                    try
                    {
                        retValue = Short.valueOf( numValueStr );
                    }
                    catch ( NumberFormatException nfe )
                    {
                        String errMsg = "The precise value: "
                                        + numValueStr
                                        + " cannot be converted to a short type. An exception will be thrown.";
                        throw new IllegalArgumentException( errMsg, nfe );
                    }
                }
                else
                {
                    short minValue = shortStrategy.minValue();
                    short maxValue = shortStrategy.maxValue();

                    // Sanity check
                    if ( minValue > maxValue )
                    {
                        maxValue = minValue;
                    }

                    retValue = strategy.getShortInRange( minValue, maxValue,
                                                         wrapper.getAttributeMetadata() );
                }

                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getShort( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
