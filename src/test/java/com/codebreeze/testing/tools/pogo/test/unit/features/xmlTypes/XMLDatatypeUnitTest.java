package com.codebreeze.testing.tools.pogo.test.unit.features.xmlTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.XMLDatatypePojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLDatatypeUnitTest extends AbstractPogoSteps
{
    @Test
    public void testXMLGregorianCalendarManufacturing() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithXmlTypesExternalFactory();
        XMLGregorianCalendar pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                        XMLGregorianCalendar.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void testDurationManufacturing() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithXmlTypesExternalFactory();
        Duration pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Duration.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void testXMLDatatypesFieldSetting() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithXmlTypesExternalFactory();
        XMLDatatypePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( XMLDatatypePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getCalendar() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getDuration() );
    }

}
