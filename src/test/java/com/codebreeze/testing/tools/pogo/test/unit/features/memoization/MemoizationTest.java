package com.codebreeze.testing.tools.pogo.test.unit.features.memoization;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.dto.MemoizationPojo;
import com.codebreeze.testing.tools.pogo.test.dto.RecursivePojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import javax.xml.ws.Holder;
import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

public class MemoizationTest extends AbstractPodamSteps
{

    @Test
    public void whenMemoizationIsTruePodamShouldReturnTheSameInstanceForDifferentInvocations() throws Exception
    {
        DataProviderStrategy strategy = podamFactorySteps.givenADataProviderStrategyWithMemoizationSetToTrue();
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomDataProviderStrategy( strategy );
        SimplePojoToTestSetters pojo1 = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo1 );
        SimplePojoToTestSetters pojo2 = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo1 );
        podamValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo1, pojo2 );
    }


    @Test
    public void whenMemoizationIsFalsePodamShouldReturnDifferentInstancesForDifferentInvocations() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        podamFactory.getStrategy().setMemoization( false );
        SimplePojoToTestSetters pojo1 = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo1 );
        SimplePojoToTestSetters pojo2 = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo1 );
        podamValidationSteps.theTwoObjectsShouldBeDifferent( pojo1, pojo2 );
    }

    @Test
    public void memoizationShouldWorkForRecursivePojos() throws Exception
    {
        DataProviderStrategy strategy = podamFactorySteps.givenADataProviderStrategyWithMemoizationSetToTrue();
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomDataProviderStrategy( strategy );
        RecursivePojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( RecursivePojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo, pojo.getParent() );
    }

    @Test
    public void memoizationShouldWorkWithGenerics() throws Exception
    {
        DataProviderStrategy strategy = podamFactorySteps.givenADataProviderStrategyWithMemoizationSetToTrue();
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomDataProviderStrategy( strategy );
        Holder<String> pojo1 = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                   Holder.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo1 );
        Holder<String> pojo2 = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                   Holder.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo2 );
        podamValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo1, pojo2 );
        podamValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo1.value, pojo2.value );
    }

    @Test
    public void evenWhenMemoizationIsTrueIfGenericPojosHaveDifferentTypesObjectsShouldNotBeEqual() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        Holder<String> pojo1 = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                   Holder.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo1 );
        Holder<Integer> pojo2 = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                    Holder.class, podamFactory, Integer.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo2 );
        podamValidationSteps.theTwoObjectsShouldBeDifferent( pojo1, pojo2 );
    }

    @Test
    public void memoizationShouldWorkCorrectlyForCollectionsAndArrays() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        MemoizationPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( MemoizationPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getArray(), Currency.class );
        Set<Currency> countingSet = new HashSet<>();
        Collections.addAll( countingSet, pojo.getArray() );
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements(
            countingSet, podamFactory.getStrategy().getNumberOfCollectionElements( Currency.class )
        );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getCollection(), Currency.class );
        podamValidationSteps.theTwoObjectsShouldBeEqual(
            podamFactory.getStrategy().getNumberOfCollectionElements( Currency.class ), pojo.getCollection().size() );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Currency.class, Currency.class );
        podamValidationSteps.theTwoObjectsShouldBeEqual( podamFactory.getStrategy().getNumberOfCollectionElements(
                    Currency.class ), pojo.getMap().size() );
    }


}
