/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.features.dataProviderStrategy;

import com.codebreeze.testing.tools.pogo.api.AbstractRandomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.common.AbstractMethodComparator;
import com.codebreeze.testing.tools.pogo.common.PodamConstants;
import com.codebreeze.testing.tools.pogo.common.AbstractConstructorComparator;
import com.codebreeze.testing.tools.pogo.test.dto.PojoWithMapsAndCollections;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import java.util.HashMap;
import java.util.Map;

public class RandomDataProviderStrategyImplInitialisationUnitTest extends AbstractPodamSteps
{


    @Test
    public void randomDataProviderStrategyShouldBeInitialisedCorrectlyAndAllowForChangesInNbrOfCollectionElements()
    {
        DataProviderStrategy dataProviderStrategy =
            podamFactorySteps.givenARandomDataProviderStrategy();
        podamValidationSteps.theTwoObjectsShouldBeEqual( PodamConstants.DEFAULT_NBR_COLLECTION_ELEMENTS,
                dataProviderStrategy.getNumberOfCollectionElements( Object.class ) );
        int aNumberOfCollectionElements = 3;
        dataProviderStrategy.setDefaultNumberOfCollectionElements( aNumberOfCollectionElements );
        podamValidationSteps.theTwoObjectsShouldBeEqual( aNumberOfCollectionElements,
                dataProviderStrategy.getNumberOfCollectionElements( Object.class ) );
    }

    @Test
    public void podamShouldCreatePojosInAccordanceWithCustomDataProviderStrategies() throws Exception
    {
        DataProviderStrategy strategy = podamFactorySteps.givenACustomRandomDataProviderStrategy();
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomDataProviderStrategy( strategy );
        PojoWithMapsAndCollections pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( PojoWithMapsAndCollections.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainExactlyTheGivenNumberOfElements(
            pojo.getArray(), 2 );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmpty( pojo.getList() );
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( pojo.getList(), 3 );
        podamValidationSteps.theMapShouldNotBeNullOrEmpty( pojo.getMap() );
        podamValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( pojo.getMap(), 4 );
    }

    @Test
    public void podamShouldCorrectGenerateHashMapsWithLongAsKeyType() throws Exception
    {
        DataProviderStrategy strategy = podamFactorySteps.givenACustomRandomDataProviderStrategy();
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomDataProviderStrategy( strategy );
        Map<?, ?> pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                HashMap.class, podamFactory, Long.class, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( strategy.getNumberOfCollectionElements(
                    String.class ), pojo.size() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAConstructorLightComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) podamFactorySteps.givenARandomDataProviderStrategy();
        AbstractConstructorComparator comparator = randomStrategy.getConstructorLightComparator();
        podamValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setConstructorLightComparator( null );
        podamValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getConstructorLightComparator() );
        randomStrategy.setConstructorLightComparator( comparator );
        podamValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getConstructorLightComparator() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAConstructorHeavyComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) podamFactorySteps.givenARandomDataProviderStrategy();
        AbstractConstructorComparator comparator = randomStrategy.getConstructorHeavyComparator();
        podamValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setConstructorHeavyComparator( null );
        podamValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getConstructorHeavyComparator() );
        randomStrategy.setConstructorHeavyComparator( comparator );
        podamValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getConstructorHeavyComparator() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAMethodLightComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) podamFactorySteps.givenARandomDataProviderStrategy();
        AbstractMethodComparator comparator = randomStrategy.getMethodLightComparator();
        podamValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setMethodLightComparator( null );
        podamValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getMethodLightComparator() );
        randomStrategy.setMethodLightComparator( comparator );
        podamValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getMethodLightComparator() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAMethodHeavyComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) podamFactorySteps.givenARandomDataProviderStrategy();
        AbstractMethodComparator comparator = randomStrategy.getMethodHeavyComparator();
        podamValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setMethodHeavyComparator( null );
        podamValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getMethodHeavyComparator() );
        randomStrategy.setMethodHeavyComparator( comparator );
        podamValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getMethodHeavyComparator() );
    }

}
