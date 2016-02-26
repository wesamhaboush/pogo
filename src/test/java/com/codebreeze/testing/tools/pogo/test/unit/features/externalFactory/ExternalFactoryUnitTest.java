package com.codebreeze.testing.tools.pogo.test.unit.features.externalFactory;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

public class ExternalFactoryUnitTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldNotBeAbleToCreateInterfaceInstancesGivenAnExternalFactoryWhichDoesNotManufactureTheConcreteType()
    throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) PogoFactorySteps.givenAnExternalFactory();
        PogoFactory PogoFactory = PogoFactorySteps.givenAdPogoFactoryWithExternalFactory( externalFactory );
        InterfacePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( InterfacePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( InterfacePojo.class, externalFactory.getFailures().get( 0 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void PogoCannotFillInterfaceAttributesIfTheExternalFactoryDoesNotManufactureTheRightType() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) PogoFactorySteps.givenAnExternalFactory();
        PogoFactory PogoFactory = PogoFactorySteps.givenAdPogoFactoryWithExternalFactory( externalFactory );
        PojoWithInterfaces pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( PojoWithInterfaces.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( ObjectExt.class, externalFactory.getFailures().get( 0 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( InterfacePojo.class, externalFactory.getFailures().get( 1 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void PogoShouldFillPojoInterfaceAttributeIfFullConstructorSetsItsValue() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) PogoFactorySteps.givenAnExternalFactory();
        PogoFactory PogoFactory = PogoFactorySteps.givenAdPogoFactoryWithExternalFactory( externalFactory );
        PojoWithInterfaces pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor(
                                      PojoWithInterfaces.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 2, externalFactory.getFailures().size() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( ObjectExt.class, externalFactory.getFailures().get( 0 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( InterfacePojo.class, externalFactory.getFailures().get( 1 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 2, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void PogoDoesNotCreateInstancesOfAbstractClassesIfExternalFactoryDoesNotDefineThem() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) PogoFactorySteps.givenAnExternalFactory();
        PogoFactory PogoFactory = PogoFactorySteps.givenAdPogoFactoryWithExternalFactory( externalFactory );
        AbstractClass pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( AbstractClass.class, PogoFactory );
        PogoValidationSteps.theObjectShouldBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( AbstractClass.class, externalFactory.getFailures().get( 0 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void PogoShouldNotCreateInstancesOfAnAbstractClassEvenIfPojoHasFullConstructor() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) PogoFactorySteps.givenAnExternalFactory();
        PogoFactory PogoFactory = PogoFactorySteps.givenAdPogoFactoryWithExternalFactory( externalFactory );
        AbstractClass pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor(
                                 AbstractClass.class, PogoFactory );
        PogoValidationSteps.theObjectShouldBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( AbstractClass.class, externalFactory.getFailures().get( 0 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void PogoShouldNotcreateInstancesOfNonInstantiableClasses() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) PogoFactorySteps.givenAnExternalFactory();
        PogoFactory PogoFactory = PogoFactorySteps.givenAdPogoFactoryWithExternalFactory( externalFactory );
        NonInstantiatableClass pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                          NonInstantiatableClass.class, PogoFactory );
        PogoValidationSteps.theObjectShouldBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 1, externalFactory.getFailures().size() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( NonInstantiatableClass.class, externalFactory.getFailures().get( 0 ) );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( 0, externalFactory.getFullDataCalls().size() );
    }

    @Test
    public void theManagementOfExternalFactoriesShouldBeCorrectAndChainingShouldWord() throws Exception
    {
        TestExternalFactory externalFactory = ( TestExternalFactory ) PogoFactorySteps.givenAnExternalFactory();
        PogoValidationSteps.theObjectShouldBeNull( externalFactory.getClassStrategy() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( externalFactory, externalFactory.setClassStrategy( null ) );
        PogoValidationSteps.theObjectShouldBeNull( externalFactory.getStrategy() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( externalFactory, externalFactory.setStrategy( null ) );
        PogoValidationSteps.theObjectShouldBeNull( externalFactory.getExternalFactory() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( externalFactory, externalFactory.setExternalFactory( null ) );
    }
}
