package com.codebreeze.testing.tools.pogo.test.unit.features.xmlTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.XMLDatatypePojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class XMLDatatypeUnitTest extends AbstractPogoSteps
{
    @Test
    public void testXMLGregorianCalendarManufacturing() throws Exception
    {
        //given
        PogoFactory pogoFactory = PogoFactorySteps.givenAPogoFactoryWithXmlTypesExternalFactory();
        //when
        XMLGregorianCalendar pojo = pogoFactory.manufacturePojo( XMLGregorianCalendar.class );
        //then
        assertThat( pojo ).isNotNull();
    }

    @Test
    public void testDurationManufacturing() throws Exception
    {
        //given
        PogoFactory pogoFactory = PogoFactorySteps.givenAPogoFactoryWithXmlTypesExternalFactory();
        //when
        Duration pojo = pogoFactory.manufacturePojo( Duration.class );
        //then
        assertThat( pojo ).isNotNull();
    }

    @Test
    public void testXMLDatatypesFieldSetting() throws Exception
    {
        //given
        PogoFactory pogoFactory = PogoFactorySteps.givenAPogoFactoryWithXmlTypesExternalFactory();
        //when
        XMLDatatypePojo pojo = pogoFactory.manufacturePojo( XMLDatatypePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getCalendar() ).isNotNull();
        assertThat( pojo.getDuration() ).isNotNull();
    }

}
