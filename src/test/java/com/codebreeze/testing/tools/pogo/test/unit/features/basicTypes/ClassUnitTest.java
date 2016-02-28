package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ClassPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassUnitTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldHandleTheManufacturingOfBasicTypes() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ClassPojo pojo = pogoFactory.manufacturePojo( ClassPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getClazz() ).isNotNull().isEqualTo( String.class );
    }

    @Test
    public void PogoShouldHandleTheManufacturingOfGenericPojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ClassGenericPojo<?> pojo  = pogoFactory.manufacturePojo( ClassGenericPojo.class, String.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getClazz() ).isNotNull().isEqualTo( String.class );
    }

    @Test
    public void PogoShouldHandleTheManufacturingOfPojosWithGenericTypesInTheConstructor() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ClassGenericConstructorPojo<?> pojo  = pogoFactory.manufacturePojo( ClassGenericConstructorPojo.class, String.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getClazz() ).isNotNull().isEqualTo( String.class );
    }


}
