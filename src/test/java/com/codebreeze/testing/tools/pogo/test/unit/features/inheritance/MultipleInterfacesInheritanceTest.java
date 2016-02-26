package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesListPojo;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesHolderPojo;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesMapPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import java.util.List;

public class MultipleInterfacesInheritanceTest extends AbstractPogoSteps
{


    private static final TrackingExternalFactory externalFactory
        = new TrackingExternalFactory();

    private static final CustomDataProviderStrategy strategy
        = new CustomDataProviderStrategy();

    private static final PogoFactory factory
        = new PogoFactoryImpl( externalFactory, strategy );





    @Test
    public void PogoCannotInstantiateInterfaces() throws Exception
    {
        PogoFactory PogoFactory = provideCustomisedPogoFactory();
        MultipleInterfacesListPojo<?> pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType( MultipleInterfacesListPojo.class,
                    PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldBeNull( pojo );
        List<Class<?>> accessed = ( ( CustomDataProviderStrategy )PogoFactory.getStrategy() ).getAccessed();
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( accessed, 1 );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( MultipleInterfacesListPojo.class, accessed.get( 0 ) );
    }

    @Test
    public void PogoCannotInstantiateInterfacesWhichExtendMap() throws Exception
    {
        PogoFactory PogoFactory = provideCustomisedPogoFactory();
        MultipleInterfacesMapPojo<?, ?> pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                MultipleInterfacesMapPojo.class, PogoFactory, String.class, Long.class );
        PogoValidationSteps.theObjectShouldBeNull( pojo );
        List<Class<?>> accessed = ( ( CustomDataProviderStrategy )PogoFactory.getStrategy() ).getAccessed();
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( accessed, 1 );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( MultipleInterfacesMapPojo.class, accessed.get( 0 ) );
    }

    @Test
    public void testHolderOfPojoWithMultiInterfaces() throws Exception
    {
        PogoFactory PogoFactory = provideCustomisedPogoFactory();
        MultipleInterfacesHolderPojo<?, ?> pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                MultipleInterfacesHolderPojo.class, PogoFactory, String.class, Long.class
            );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldBeNull( pojo.getList() );
        PogoValidationSteps.theObjectShouldBeNull( pojo.getMap() );
        List<Class<?>> accessed = ( ( CustomDataProviderStrategy )PogoFactory.getStrategy() ).getAccessed();
        PogoValidationSteps.theTwoObjectsShouldBeEqual( accessed.size(), 2 );
        PogoValidationSteps.theCollectionShouldContainAtLeastOneElementOfType(
            accessed, MultipleInterfacesListPojo.class );
        PogoValidationSteps.theCollectionShouldContainAtLeastOneElementOfType(
            accessed, MultipleInterfacesMapPojo.class );
    }



    private PogoFactory provideCustomisedPogoFactory()
    {
        TrackingExternalFactory externalFactory = PogoFactorySteps.givenATrackingExternalFactory();
        CustomDataProviderStrategy customDataProviderStrategy = PogoFactorySteps.givenACustomDataProviderStrategy();
        return PogoFactorySteps.givenAPogoFactoryWithExternalFactoryAndCustomStrategy(
                   externalFactory, customDataProviderStrategy );
    }


}
