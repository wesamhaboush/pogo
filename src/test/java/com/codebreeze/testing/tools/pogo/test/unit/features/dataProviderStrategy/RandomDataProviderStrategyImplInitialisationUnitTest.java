/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.features.dataProviderStrategy;

import com.codebreeze.testing.tools.pogo.api.AbstractRandomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.common.AbstractMethodComparator;
import com.codebreeze.testing.tools.pogo.common.PogoConstants;
import com.codebreeze.testing.tools.pogo.common.AbstractConstructorComparator;
import com.codebreeze.testing.tools.pogo.test.dto.PojoWithMapsAndCollections;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import java.util.HashMap;
import java.util.Map;

public class RandomDataProviderStrategyImplInitialisationUnitTest extends AbstractPogoSteps
{


    @Test
    public void randomDataProviderStrategyShouldBeInitialisedCorrectlyAndAllowForChangesInNbrOfCollectionElements()
    {
        DataProviderStrategy dataProviderStrategy =
            PogoFactorySteps.givenARandomDataProviderStrategy();
        PogoValidationSteps.theTwoObjectsShouldBeEqual( PogoConstants.DEFAULT_NBR_COLLECTION_ELEMENTS,
                dataProviderStrategy.getNumberOfCollectionElements( Object.class ) );
        int aNumberOfCollectionElements = 3;
        dataProviderStrategy.setDefaultNumberOfCollectionElements( aNumberOfCollectionElements );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( aNumberOfCollectionElements,
                dataProviderStrategy.getNumberOfCollectionElements( Object.class ) );
    }

    @Test
    public void PogoShouldCreatePojosInAccordanceWithCustomDataProviderStrategies() throws Exception
    {
        DataProviderStrategy strategy = PogoFactorySteps.givenACustomRandomDataProviderStrategy();
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithCustomDataProviderStrategy( strategy );
        PojoWithMapsAndCollections pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( PojoWithMapsAndCollections.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainExactlyTheGivenNumberOfElements(
            pojo.getArray(), 2 );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmpty( pojo.getList() );
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( pojo.getList(), 3 );
        PogoValidationSteps.theMapShouldNotBeNullOrEmpty( pojo.getMap() );
        PogoValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( pojo.getMap(), 4 );
    }

    @Test
    public void PogoShouldCorrectGenerateHashMapsWithLongAsKeyType() throws Exception
    {
        DataProviderStrategy strategy = PogoFactorySteps.givenACustomRandomDataProviderStrategy();
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithCustomDataProviderStrategy( strategy );
        Map<?, ?> pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                HashMap.class, PogoFactory, Long.class, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( strategy.getNumberOfCollectionElements(
                    String.class ), pojo.size() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAConstructorLightComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) PogoFactorySteps.givenARandomDataProviderStrategy();
        AbstractConstructorComparator comparator = randomStrategy.getConstructorLightComparator();
        PogoValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setConstructorLightComparator( null );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getConstructorLightComparator() );
        randomStrategy.setConstructorLightComparator( comparator );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getConstructorLightComparator() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAConstructorHeavyComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) PogoFactorySteps.givenARandomDataProviderStrategy();
        AbstractConstructorComparator comparator = randomStrategy.getConstructorHeavyComparator();
        PogoValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setConstructorHeavyComparator( null );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getConstructorHeavyComparator() );
        randomStrategy.setConstructorHeavyComparator( comparator );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getConstructorHeavyComparator() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAMethodLightComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) PogoFactorySteps.givenARandomDataProviderStrategy();
        AbstractMethodComparator comparator = randomStrategy.getMethodLightComparator();
        PogoValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setMethodLightComparator( null );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getMethodLightComparator() );
        randomStrategy.setMethodLightComparator( comparator );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getMethodLightComparator() );
    }

    @Test
    public void creatingARandomDataProviderStrategyShouldCreateAMethodHeavyComparator() throws Exception
    {
        AbstractRandomDataProviderStrategy randomStrategy =
            ( AbstractRandomDataProviderStrategy ) PogoFactorySteps.givenARandomDataProviderStrategy();
        AbstractMethodComparator comparator = randomStrategy.getMethodHeavyComparator();
        PogoValidationSteps.theObjectShouldNotBeNull( comparator );
        randomStrategy.setMethodHeavyComparator( null );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( null, randomStrategy.getMethodHeavyComparator() );
        randomStrategy.setMethodHeavyComparator( comparator );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( comparator, randomStrategy.getMethodHeavyComparator() );
    }

}
