package com.codebreeze.testing.tools.pogo.test.unit.features.extensions;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoClassic;
import com.codebreeze.testing.tools.pogo.test.strategies.CustomRandomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoSpecific;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.PojoWithMapsAndCollections;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

public class ExtensionsTest extends AbstractPogoSteps
{


    @Test
    public void PogoShouldFillTheAttributeMetadataWithTheAttributeNames() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoExternalFactorytoTestAttributeMetadata();
        PojoClassic pojoClassic =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( PojoClassic.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojoClassic );
        PojoSpecific pojoSpecific =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( PojoSpecific.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojoSpecific );
        PogoValidationSteps.theStringValueShouldBeExactly( pojoClassic.getAtt(), "classic" );
        PogoValidationSteps.theStringValueShouldBeExactly( pojoSpecific.getAtt(), "specific" );
    }

    @Test
    public void PogoShouldCreatePojosInAccordanceWithCustomDataProviderStrategies() throws Exception
    {
        CustomRandomDataProviderStrategy strategy = PogoFactorySteps.givenACustomRandomDataProviderStrategy();
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithCustomDataProviderStrategy( strategy );
        PojoWithMapsAndCollections pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( PojoWithMapsAndCollections.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainExactlyTheGivenNumberOfElements(
            pojo.getArray(), 2 );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmpty( pojo.getList() );
        PogoValidationSteps.theListShouldHaveExactlyTheExpectedNumberOfElements( pojo.getList(), 3 );
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( pojo.getMap() );
        PogoValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( pojo.getMap(), 4 );
    }


}
