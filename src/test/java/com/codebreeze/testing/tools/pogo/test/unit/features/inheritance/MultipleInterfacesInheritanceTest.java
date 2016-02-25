package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.PodamFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesListPojo;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesHolderPojo;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesMapPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import java.util.List;

public class MultipleInterfacesInheritanceTest extends AbstractPodamSteps
{


    private static final TrackingExternalFactory externalFactory
        = new TrackingExternalFactory();

    private static final CustomDataProviderStrategy strategy
        = new CustomDataProviderStrategy();

    private static final PodamFactory factory
        = new PodamFactoryImpl( externalFactory, strategy );





    @Test
    public void podamCannotInstantiateInterfaces() throws Exception
    {
        PodamFactory podamFactory = provideCustomisedPodamFactory();
        MultipleInterfacesListPojo<?> pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType( MultipleInterfacesListPojo.class,
                    podamFactory, String.class );
        podamValidationSteps.theObjectShouldBeNull( pojo );
        List<Class<?>> accessed = ( ( CustomDataProviderStrategy )podamFactory.getStrategy() ).getAccessed();
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( accessed, 1 );
        podamValidationSteps.theTwoObjectsShouldBeEqual( MultipleInterfacesListPojo.class, accessed.get( 0 ) );
    }

    @Test
    public void podamCannotInstantiateInterfacesWhichExtendMap() throws Exception
    {
        PodamFactory podamFactory = provideCustomisedPodamFactory();
        MultipleInterfacesMapPojo<?, ?> pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                MultipleInterfacesMapPojo.class, podamFactory, String.class, Long.class );
        podamValidationSteps.theObjectShouldBeNull( pojo );
        List<Class<?>> accessed = ( ( CustomDataProviderStrategy )podamFactory.getStrategy() ).getAccessed();
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( accessed, 1 );
        podamValidationSteps.theTwoObjectsShouldBeEqual( MultipleInterfacesMapPojo.class, accessed.get( 0 ) );
    }

    @Test
    public void testHolderOfPojoWithMultiInterfaces() throws Exception
    {
        PodamFactory podamFactory = provideCustomisedPodamFactory();
        MultipleInterfacesHolderPojo<?, ?> pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                MultipleInterfacesHolderPojo.class, podamFactory, String.class, Long.class
            );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldBeNull( pojo.getList() );
        podamValidationSteps.theObjectShouldBeNull( pojo.getMap() );
        List<Class<?>> accessed = ( ( CustomDataProviderStrategy )podamFactory.getStrategy() ).getAccessed();
        podamValidationSteps.theTwoObjectsShouldBeEqual( accessed.size(), 2 );
        podamValidationSteps.theCollectionShouldContainAtLeastOneElementOfType(
            accessed, MultipleInterfacesListPojo.class );
        podamValidationSteps.theCollectionShouldContainAtLeastOneElementOfType(
            accessed, MultipleInterfacesMapPojo.class );
    }


    //-------------> Private methods

    private PodamFactory provideCustomisedPodamFactory()
    {
        TrackingExternalFactory externalFactory = podamFactorySteps.givenATrackingExternalFactory();
        CustomDataProviderStrategy customDataProviderStrategy = podamFactorySteps.givenACustomDataProviderStrategy();
        return podamFactorySteps.givenAPodamFactoryWithExternalFactoryAndCustomStrategy(
                   externalFactory, customDataProviderStrategy );
    }


}
