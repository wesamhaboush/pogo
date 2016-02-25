package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.ClassInheritedPojo;
import com.codebreeze.testing.tools.pogo.test.dto.OneDimensionalChildPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm42.B;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;
import com.codebreeze.testing.tools.pogo.test.utils.PodamTestConstants;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.pdm42.A;

public class InheritanceTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldHandleBasicInheritance() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        OneDimensionalChildPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( OneDimensionalChildPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        int maxValue = PodamTestConstants.NUMBER_INT_TEN;
        podamValidationSteps.theIntFieldShouldHaveValueLessThen( pojo.getParentIntField(), maxValue );
        podamValidationSteps.theCalendarFieldShouldBeValid( pojo.getParentCalendarField() );
        podamValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
        podamValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getStrField() );
    }

    @Test
    public void podamShouldHandleTheManufacturingOfPojosWhichInheritFromOtherClasses() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ClassInheritedPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                      ClassInheritedPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }


    @Test
    public void podamShouldManufactureAllPojosInATreeHierarchy() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        A pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( A.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        B b = pojo.getB();
        podamValidationSteps.theObjectShouldNotBeNull( b );
        podamValidationSteps.theObjectShouldNotBeNull( b.getCustomValue() );
    }
}
