package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ClassPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

public class ClassUnitTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldHandleTheManufacturingOfBasicTypes() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ClassPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ClassPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }

    @Test
    public void PogoShouldHandleTheManufacturingOfGenericPojos() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ClassGenericPojo<?> pojo  = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                        ClassGenericPojo.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }

    @Test
    public void PogoShouldHandleTheManufacturingOfPojosWithGenericTypesInTheConstructor() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ClassGenericConstructorPojo<?> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                ClassGenericConstructorPojo.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }


}
