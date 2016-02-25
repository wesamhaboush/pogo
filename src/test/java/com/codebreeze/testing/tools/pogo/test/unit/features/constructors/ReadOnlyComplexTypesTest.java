package com.codebreeze.testing.tools.pogo.test.unit.features.constructors;

import org.junit.Test;
import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyAbstract;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyComplexTypesPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyGenericComplexTypesPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import java.beans.beancontext.BeanContextServicesSupport;

public class ReadOnlyComplexTypesTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldFillReadOnlyTypes() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ReadOnlyComplexTypesPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                            ReadOnlyComplexTypesPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Integer.class );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Long.class, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getValue() );
    }

    @Test
    public void podamShouldFillReadOnlyComplexTypes() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ReadOnlyGenericComplexTypesPojo<?, ?, ?> pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                ReadOnlyGenericComplexTypesPojo.class, podamFactory, Character.class, Long.class, Integer.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Long.class );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Integer.class, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getValue() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( Character.class, pojo.getValue().getValue().getClass() );
    }

    @Test
    public void podamShouldFillInPojosWhichContainInternalLoops() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        BeanContextServicesSupport pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                              BeanContextServicesSupport.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }


    @Test
    public void podamShouldCreateAnInstanceOfAnAbstractClassWithAFactoryMethodWhichReturnsAConcreteType()
    throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ReadOnlyAbstract pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( ReadOnlyAbstract.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }
}
