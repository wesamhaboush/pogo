package com.codebreeze.testing.tools.pogo.test.unit.features.xmlTypes;

import com.codebreeze.testing.tools.pogo.api.AbstractExternalFactory;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.reflect.Type;
import java.util.GregorianCalendar;

public class XmlTypesExternalFactory extends AbstractExternalFactory
{


    @Override
    public <T> T manufacturePojo( Class<T> pojoClass, Type... genericTypeArgs )
    {
        try
        {
            if ( pojoClass.isAssignableFrom( XMLGregorianCalendar.class ) )
            {
                DatatypeFactory factory = DatatypeFactory.newInstance();
                return ( T ) factory.newXMLGregorianCalendar( new GregorianCalendar() );
            }
            else if ( pojoClass.isAssignableFrom( Duration.class ) )
            {
                DatatypeFactory factory = DatatypeFactory.newInstance();
                @SuppressWarnings( "unchecked" )
                T duration = ( T ) factory.newDuration( 0L );
                return duration;
            }
        }
        catch ( Exception e )
        {
            throw new IllegalStateException( "Manufacturing failed", e );
        }

        return null;
    }

    @Override
    public <T> T populatePojo( T pojo, Type... genericTypeArgs )
    {
        return pojo;
    }
}
