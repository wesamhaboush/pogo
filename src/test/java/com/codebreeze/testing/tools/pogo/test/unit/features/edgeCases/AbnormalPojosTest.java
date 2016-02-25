package com.codebreeze.testing.tools.pogo.test.unit.features.edgeCases;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.NoDefaultPublicConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.PrivateOnlyConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.ProtectedNonDefaultConstructorPojo;
import org.junit.Assert;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import javax.activation.DataHandler;
import java.net.URL;

public class AbnormalPojosTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldGenerateANonNullPojoForAbstractTypesWithConcreteImplementation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        PogoStrategySteps.addOrReplaceSpecific( PogoFactory, AbstractTestPojo.class, ConcreteTestPojo.class );
        AbstractTestPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( AbstractTestPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void PogoShouldFillEmbeddedAbstractClassesIfAConcreteTypeHasBeenSpecified() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        PogoStrategySteps.addOrReplaceSpecific( PogoFactory, AbstractTestPojo.class, ConcreteTestPojo.class );
        EmbeddedAbstractFieldTestPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                EmbeddedAbstractFieldTestPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theInnerPojoInstanceShouldNotBeNull( pojo.getPojo() );
    }

    @Test
    public void invokingPogoOnaPojoWithPrivateNoArgumentsConstructorShouldReturnANonEmptyPojo() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        PrivateNoArgConstructorPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                               PrivateNoArgConstructorPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }

    @Test
    public void PogoCannotHandleCircularConstructors() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        URL pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( URL.class, PogoFactory );
        PogoValidationSteps.thePojoShouldBeNull( pojo );
    }

    @Test
    public void PogoShouldHandlePojosWithAMixOfCircularAndNonCircularConstructors() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        DataHandler pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( DataHandler.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void PogoShouldHandlePojosWithSelfReferenceConstructorsButNotDefaultConstructors() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ConstructorWithSelfReferencesButNoDefaultConstructorPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ConstructorWithSelfReferencesButNoDefaultConstructorPojo.class,
                    PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        constructorSelfReferenceValidationSteps.theFirstSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull( pojo );
        constructorSelfReferenceValidationSteps.theSecondSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull( pojo );
    }

    @Test
    public void PogoShouldHandlePojosWithPrivateOnlyConstructors() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        PrivateOnlyConstructorPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( PrivateOnlyConstructorPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }

    @Test
    public void PogoShouldFillPojosWithPublicNonDefaultPublicConstructors() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        NoDefaultPublicConstructorPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                NoDefaultPublicConstructorPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }


    @Test
    public void PogoShouldFillPojosWithProtectedNonDefaultConstructors() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ProtectedNonDefaultConstructorPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ProtectedNonDefaultConstructorPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }


    @Test( expected = PogoMockeryException.class )
    public void PogoShouldThrowAnExceptionIfAPojoContainsInvalidGettersOrSetters() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        BadlyTypedPojo pojo = PogoFactory.manufacturePojo( BadlyTypedPojo.class );
        Assert.assertNotNull( "Manufacturing failed", pojo );
    }


    @Test
    public void PogoShouldFillValuesInvokingChildrenSettersHavingDifferentTypesThanParent() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        BadlyTypedFixedPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( BadlyTypedFixedPojo.class,
                                   PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void PogoShouldReturnANullValueForNonInstantiablePojos() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        NonInstantiatableClass innerClassPojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( NonInstantiatableClass.class, PogoFactory );
        PogoValidationSteps.theObjectShouldBeNull( innerClassPojo );
    }

}
