package com.codebreeze.testing.tools.pogo.test.unit.features.externalFactory;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;
import org.junit.Test;

/**
 * Test @uk.co.jemos.podam.test.dto.JAXBElementPojo@ construction
 *
 * @author daivanov
 *
 */
public class ExternalFactoryUnitTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldNotBeAbleToCreateInterfaceInstancesGivenAnExternalFactoryWhichDoesNotManufactureTheConcreteType()
    throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) podamFactorySteps.givenAnExternalFactory();
        PodamFactory podamFactory = podamFactorySteps.givenAdPodamFactoryWithExternalFactory( externalFactory );
        InterfacePojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( InterfacePojo.class, podamFactory );
        podamValidationSteps.theObjectShouldBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( InterfacePojo.class, externalFactory.getFailures().get( 0 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void podamCannotFillInterfaceAttributesIfTheExternalFactoryDoesNotManufactureTheRightType() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) podamFactorySteps.givenAnExternalFactory();
        PodamFactory podamFactory = podamFactorySteps.givenAdPodamFactoryWithExternalFactory( externalFactory );
        PojoWithInterfaces pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( PojoWithInterfaces.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( ObjectExt.class, externalFactory.getFailures().get( 0 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( InterfacePojo.class, externalFactory.getFailures().get( 1 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void podamShouldFillPojoInterfaceAttributeIfFullConstructorSetsItsValue() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) podamFactorySteps.givenAnExternalFactory();
        PodamFactory podamFactory = podamFactorySteps.givenAdPodamFactoryWithExternalFactory( externalFactory );
        PojoWithInterfaces pojo = podamInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor(
                                      PojoWithInterfaces.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 2, externalFactory.getFailures().size() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( ObjectExt.class, externalFactory.getFailures().get( 0 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( InterfacePojo.class, externalFactory.getFailures().get( 1 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 2, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void podamDoesNotCreateInstancesOfAbstractClassesIfExternalFactoryDoesNotDefineThem() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) podamFactorySteps.givenAnExternalFactory();
        PodamFactory podamFactory = podamFactorySteps.givenAdPodamFactoryWithExternalFactory( externalFactory );
        AbstractClass pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( AbstractClass.class, podamFactory );
        podamValidationSteps.theObjectShouldBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( AbstractClass.class, externalFactory.getFailures().get( 0 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void podamShouldNotCreateInstancesOfAnAbstractClassEvenIfPojoHasFullConstructor() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) podamFactorySteps.givenAnExternalFactory();
        PodamFactory podamFactory = podamFactorySteps.givenAdPodamFactoryWithExternalFactory( externalFactory );
        AbstractClass pojo = podamInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor(
                                 AbstractClass.class, podamFactory );
        podamValidationSteps.theObjectShouldBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( AbstractClass.class, externalFactory.getFailures().get( 0 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void podamShouldNotcreateInstancesOfNonInstantiableClasses() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) podamFactorySteps.givenAnExternalFactory();
        PodamFactory podamFactory = podamFactorySteps.givenAdPodamFactoryWithExternalFactory( externalFactory );
        NonInstantiatableClass pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                          NonInstantiatableClass.class, podamFactory );
        podamValidationSteps.theObjectShouldBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( NonInstantiatableClass.class, externalFactory.getFailures().get( 0 ) );
        podamValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void theManagementOfExternalFactoriesShouldBeCorrectAndChainingShouldWord() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) podamFactorySteps.givenAnExternalFactory();
        podamValidationSteps.theObjectShouldBeNull( externalFactory.getClassStrategy() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( externalFactory, externalFactory.setClassStrategy( null ) );
        podamValidationSteps.theObjectShouldBeNull( externalFactory.getStrategy() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( externalFactory, externalFactory.setStrategy( null ) );
        podamValidationSteps.theObjectShouldBeNull( externalFactory.getExternalFactory() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( externalFactory, externalFactory.setExternalFactory( null ) );
    }
}
