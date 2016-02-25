package com.codebreeze.testing.tools.pogo.typeManufacturers;


import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PogoByteValue;

import java.lang.annotation.Annotation;

/**
 * Default byte type manufacturer.
 *
 * Created by tedonema on 17/05/2015.
 *
 * @since 6.0.0.RELEASE
 */
public class ByteTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Byte getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Byte retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PogoByteValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PogoByteValue intStrategy = ( PogoByteValue ) annotation;
                String numValueStr = intStrategy.numValue();

                if ( null != numValueStr && !"".equals( numValueStr ) )
                {
                    try
                    {
                        retValue = Byte.valueOf( numValueStr );
                    }
                    catch ( NumberFormatException nfe )
                    {
                        String errMsg = "The precise value: "
                                        + numValueStr
                                        + " cannot be converted to a byte type. An exception will be thrown.";
                        throw new IllegalArgumentException( errMsg, nfe );
                    }
                }
                else
                {
                    byte minValue = intStrategy.minValue();
                    byte maxValue = intStrategy.maxValue();

                    // Sanity check
                    if ( minValue > maxValue )
                    {
                        maxValue = minValue;
                    }

                    retValue = strategy.getByteInRange( minValue, maxValue,
                                                        wrapper.getAttributeMetadata() );
                }

                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getByte( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
