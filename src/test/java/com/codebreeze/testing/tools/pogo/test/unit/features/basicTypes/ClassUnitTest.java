package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import com.codebreeze.testing.tools.pogo.test.dto.ClassPojo;
import org.junit.Test;

public class ClassUnitTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldHandleTheManufacturingOfBasicTypes() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ClassPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ClassPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }

    @Test
    public void PogoShouldHandleTheManufacturingOfGenericPojos() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ClassGenericPojo<?> pojo  = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                        ClassGenericPojo.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }

    @Test
    public void PogoShouldHandleTheManufacturingOfPojosWithGenericTypesInTheConstructor() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ClassGenericConstructorPojo<?> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                ClassGenericConstructorPojo.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }


}
