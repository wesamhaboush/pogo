package com.codebreeze.testing.tools.pogo.test.unit.features.memoization;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.MemoizationPojo;
import com.codebreeze.testing.tools.pogo.test.dto.RecursivePojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import javax.xml.ws.Holder;
import java.util.Collections;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

public class MemoizationTest extends AbstractPogoSteps
{

    @Test
    public void whenMemoizationIsTruePogoShouldReturnTheSameInstanceForDifferentInvocations() throws Exception
    {
        DataProviderStrategy strategy = PogoFactorySteps.givenADataProviderStrategyWithMemoizationSetToTrue();
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithCustomDataProviderStrategy( strategy );
        SimplePojoToTestSetters pojo1 = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo1 );
        SimplePojoToTestSetters pojo2 = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo1 );
        PogoValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo1, pojo2 );
    }


    @Test
    public void whenMemoizationIsFalsePogoShouldReturnDifferentInstancesForDifferentInvocations() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        PogoFactory.getStrategy().setMemoization( false );
        SimplePojoToTestSetters pojo1 = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo1 );
        SimplePojoToTestSetters pojo2 = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                            SimplePojoToTestSetters.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo1 );
        PogoValidationSteps.theTwoObjectsShouldBeDifferent( pojo1, pojo2 );
    }

    @Test
    public void memoizationShouldWorkForRecursivePojos() throws Exception
    {
        DataProviderStrategy strategy = PogoFactorySteps.givenADataProviderStrategyWithMemoizationSetToTrue();
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithCustomDataProviderStrategy( strategy );
        RecursivePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( RecursivePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo, pojo.getParent() );
    }

    @Test
    public void memoizationShouldWorkWithGenerics() throws Exception
    {
        DataProviderStrategy strategy = PogoFactorySteps.givenADataProviderStrategyWithMemoizationSetToTrue();
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithCustomDataProviderStrategy( strategy );
        Holder<String> pojo1 = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                   Holder.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo1 );
        Holder<String> pojo2 = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                   Holder.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo2 );
        PogoValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo1, pojo2 );
        PogoValidationSteps.theTwoObjectsShouldBeStrictlyEqual( pojo1.value, pojo2.value );
    }

    @Test
    public void evenWhenMemoizationIsTrueIfGenericPojosHaveDifferentTypesObjectsShouldNotBeEqual() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        Holder<String> pojo1 = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                   Holder.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo1 );
        Holder<Integer> pojo2 = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                    Holder.class, PogoFactory, Integer.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo2 );
        PogoValidationSteps.theTwoObjectsShouldBeDifferent( pojo1, pojo2 );
    }

    @Test
    public void memoizationShouldWorkCorrectlyForCollectionsAndArrays() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        MemoizationPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( MemoizationPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getArray(), Currency.class );
        Set<Currency> countingSet = new HashSet<>();
        Collections.addAll( countingSet, pojo.getArray() );
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements(
            countingSet, PogoFactory.getStrategy().getNumberOfCollectionElements( Currency.class )
        );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getCollection(), Currency.class );
        PogoValidationSteps.theTwoObjectsShouldBeEqual(
            PogoFactory.getStrategy().getNumberOfCollectionElements( Currency.class ), pojo.getCollection().size() );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Currency.class, Currency.class );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( PogoFactory.getStrategy().getNumberOfCollectionElements(
                    Currency.class ), pojo.getMap().size() );
    }


}
