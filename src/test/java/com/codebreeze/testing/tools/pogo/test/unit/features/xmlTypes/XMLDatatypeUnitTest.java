package com.codebreeze.testing.tools.pogo.test.unit.features.xmlTypes;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.XMLDatatypePojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;
import org.junit.Test;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

public class XMLDatatypeUnitTest extends AbstractPodamSteps
{
    @Test
    public void testXMLGregorianCalendarManufacturing() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithXmlTypesExternalFactory();
        XMLGregorianCalendar pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                        XMLGregorianCalendar.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void testDurationManufacturing() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithXmlTypesExternalFactory();
        Duration pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( Duration.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void testXMLDatatypesFieldSetting() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithXmlTypesExternalFactory();
        XMLDatatypePojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( XMLDatatypePojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getCalendar() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getDuration() );
    }

}
