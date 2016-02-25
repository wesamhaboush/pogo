package com.codebreeze.testing.tools.pogo.test.unit.features.edgeCases;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.exceptions.PodamMockeryException;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.NoDefaultPublicConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.PrivateOnlyConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.ProtectedNonDefaultConstructorPojo;
import org.junit.Assert;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import javax.activation.DataHandler;
import java.net.URL;

public class AbnormalPojosTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldGenerateANonNullPojoForAbstractTypesWithConcreteImplementation() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        podamStrategySteps.addOrReplaceSpecific( podamFactory, AbstractTestPojo.class, ConcreteTestPojo.class );
        AbstractTestPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( AbstractTestPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void podamShouldFillEmbeddedAbstractClassesIfAConcreteTypeHasBeenSpecified() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        podamStrategySteps.addOrReplaceSpecific( podamFactory, AbstractTestPojo.class, ConcreteTestPojo.class );
        EmbeddedAbstractFieldTestPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                EmbeddedAbstractFieldTestPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theInnerPojoInstanceShouldNotBeNull( pojo.getPojo() );
    }

    @Test
    public void invokingPodamOnaPojoWithPrivateNoArgumentsConstructorShouldReturnANonEmptyPojo() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        PrivateNoArgConstructorPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                               PrivateNoArgConstructorPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }

    @Test
    public void podamCannotHandleCircularConstructors() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        URL pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( URL.class, podamFactory );
        podamValidationSteps.thePojoShouldBeNull( pojo );
    }

    @Test
    public void podamShouldHandlePojosWithAMixOfCircularAndNonCircularConstructors() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        DataHandler pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( DataHandler.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void podamShouldHandlePojosWithSelfReferenceConstructorsButNotDefaultConstructors() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ConstructorWithSelfReferencesButNoDefaultConstructorPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( ConstructorWithSelfReferencesButNoDefaultConstructorPojo.class,
                    podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        constructorSelfReferenceValidationSteps.theFirstSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull( pojo );
        constructorSelfReferenceValidationSteps.theSecondSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull( pojo );
    }

    @Test
    public void podamShouldHandlePojosWithPrivateOnlyConstructors() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        PrivateOnlyConstructorPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( PrivateOnlyConstructorPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        podamValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }

    @Test
    public void podamShouldFillPojosWithPublicNonDefaultPublicConstructors() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        NoDefaultPublicConstructorPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                NoDefaultPublicConstructorPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        podamValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }


    @Test
    public void podamShouldFillPojosWithProtectedNonDefaultConstructors() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ProtectedNonDefaultConstructorPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( ProtectedNonDefaultConstructorPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        podamValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
    }


    @Test( expected = PodamMockeryException.class )
    public void podamShouldThrowAnExceptionIfAPojoContainsInvalidGettersOrSetters() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        BadlyTypedPojo pojo = podamFactory.manufacturePojo( BadlyTypedPojo.class );
        Assert.assertNotNull( "Manufacturing failed", pojo );
    }


    @Test
    public void podamShouldFillValuesInvokingChildrenSettersHavingDifferentTypesThanParent() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        BadlyTypedFixedPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( BadlyTypedFixedPojo.class,
                                   podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void podamShouldReturnANullValueForNonInstantiablePojos() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        NonInstantiatableClass innerClassPojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( NonInstantiatableClass.class, podamFactory );
        podamValidationSteps.theObjectShouldBeNull( innerClassPojo );
    }

}
