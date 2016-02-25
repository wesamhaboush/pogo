package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.ClassInheritedPojo;
import com.codebreeze.testing.tools.pogo.test.dto.OneDimensionalChildPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm42.B;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.pdm42.A;

public class InheritanceTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldHandleBasicInheritance() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        OneDimensionalChildPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( OneDimensionalChildPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        int maxValue = PogoTestConstants.NUMBER_INT_TEN;
        PogoValidationSteps.theIntFieldShouldHaveValueLessThen( pojo.getParentIntField(), maxValue );
        PogoValidationSteps.theCalendarFieldShouldBeValid( pojo.getParentCalendarField() );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
        PogoValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getStrField() );
    }

    @Test
    public void PogoShouldHandleTheManufacturingOfPojosWhichInheritFromOtherClasses() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ClassInheritedPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                      ClassInheritedPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getClazz() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getClazz() );
    }


    @Test
    public void PogoShouldManufactureAllPojosInATreeHierarchy() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        A pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( A.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        B b = pojo.getB();
        PogoValidationSteps.theObjectShouldNotBeNull( b );
        PogoValidationSteps.theObjectShouldNotBeNull( b.getCustomValue() );
    }
}
