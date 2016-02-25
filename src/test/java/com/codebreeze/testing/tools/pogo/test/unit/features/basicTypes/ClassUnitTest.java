package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;
import com.codebreeze.testing.tools.pogo.test.dto.ClassPojo;
import org.junit.Test;

public class ClassUnitTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldHandleTheManufacturingOfBasicTypes() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ClassPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( ClassPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }

    @Test
    public void podamShouldHandleTheManufacturingOfGenericPojos() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ClassGenericPojo<?> pojo  = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                        ClassGenericPojo.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }

    @Test
    public void podamShouldHandleTheManufacturingOfPojosWithGenericTypesInTheConstructor() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ClassGenericConstructorPojo<?> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                ClassGenericConstructorPojo.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }


}
