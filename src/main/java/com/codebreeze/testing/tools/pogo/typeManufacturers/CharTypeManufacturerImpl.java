package com.codebreeze.testing.tools.pogo.typeManufacturers;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PogoCharValue;

import java.lang.annotation.Annotation;

public class CharTypeManufacturerImpl extends AbstractTypeManufacturer
{

    @Override
    public Character getType( TypeManufacturerParamsWrapper wrapper )
    {
        super.checkWrapperIsValid( wrapper );
        DataProviderStrategy strategy = wrapper.getDataProviderStrategy();
        Character retValue = null;

        for ( Annotation annotation : wrapper.getAttributeMetadata().getAttributeAnnotations() )
        {
            if ( PogoCharValue.class.isAssignableFrom( annotation.getClass() ) )
            {
                PogoCharValue annotationStrategy = ( PogoCharValue ) annotation;
                char charValue = annotationStrategy.charValue();

                if ( charValue != ' ' )
                {
                    retValue = charValue;
                }
                else
                {
                    char minValue = annotationStrategy.minValue();
                    char maxValue = annotationStrategy.maxValue();

                    // Sanity check
                    if ( minValue > maxValue )
                    {
                        maxValue = minValue;
                    }

                    retValue = strategy.getCharacterInRange( minValue, maxValue,
                               wrapper.getAttributeMetadata() );
                }

                break;
            }
        }

        if ( retValue == null )
        {
            retValue = strategy.getCharacter( wrapper.getAttributeMetadata() );
        }

        return retValue;
    }
}
