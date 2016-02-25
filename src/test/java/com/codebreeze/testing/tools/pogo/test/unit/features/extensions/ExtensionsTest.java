package com.codebreeze.testing.tools.pogo.test.unit.features.extensions;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoClassic;
import com.codebreeze.testing.tools.pogo.test.strategies.CustomRandomDataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.PojoSpecific;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.PojoWithMapsAndCollections;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

public class ExtensionsTest extends AbstractPodamSteps
{


    @Test
    public void podamShouldFillTheAttributeMetadataWithTheAttributeNames() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAPodamExternalFactorytoTestAttributeMetadata();
        PojoClassic pojoClassic =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( PojoClassic.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojoClassic );
        PojoSpecific pojoSpecific =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( PojoSpecific.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojoSpecific );
        podamValidationSteps.theStringValueShouldBeExactly( pojoClassic.getAtt(), "classic" );
        podamValidationSteps.theStringValueShouldBeExactly( pojoSpecific.getAtt(), "specific" );
    }

    @Test
    public void podamShouldCreatePojosInAccordanceWithCustomDataProviderStrategies() throws Exception
    {
        CustomRandomDataProviderStrategy strategy = podamFactorySteps.givenACustomRandomDataProviderStrategy();
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomDataProviderStrategy( strategy );
        PojoWithMapsAndCollections pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( PojoWithMapsAndCollections.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainExactlyTheGivenNumberOfElements(
            pojo.getArray(), 2 );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmpty( pojo.getList() );
        podamValidationSteps.theListShouldHaveExactlyTheExpectedNumberOfElements( pojo.getList(), 3 );
        podamValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( pojo.getMap() );
        podamValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( pojo.getMap(), 4 );
    }


}
