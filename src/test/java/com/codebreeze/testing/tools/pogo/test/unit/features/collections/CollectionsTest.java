package com.codebreeze.testing.tools.pogo.test.unit.features.collections;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CollectionsTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldHandleStandardCollections() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        CollectionsPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( CollectionsPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        List<String> strList = pojo.getStrList();
        podamValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( strList );
        ArrayList<String> arrayListStr = pojo.getArrayListStr();
        podamValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( arrayListStr );
        List<String> copyOnWriteList = pojo.getCopyOnWriteList();
        podamValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( copyOnWriteList );
        HashSet<String> hashSetStr = pojo.getHashSetStr();
        podamValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( hashSetStr );
        List<String> listStrCollection = new ArrayList<>(
            pojo.getStrCollection() );
        podamValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( listStrCollection );
        Set<String> setStrCollection = new HashSet<>(
            pojo.getStrCollection() );
        podamValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( setStrCollection );
        Set<String> strSet = pojo.getStrSet();
        podamValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( strSet );
        Map<String, OneDimensionalTestPojo> map = pojo.getMap();
        podamValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( map );
        HashMap<String, OneDimensionalTestPojo> hashMap = pojo.getHashMap();
        podamValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( hashMap );
        ConcurrentMap<String, OneDimensionalTestPojo> concurrentHashMap = pojo
                .getConcurrentHashMap();
        podamValidationSteps.theConcurrentHashMapOfStringsObjectsShouldContainAtLeastOneNonEmptyElement( concurrentHashMap );
        ConcurrentHashMap<String, OneDimensionalTestPojo> concurrentHashMapImpl = pojo
                .getConcurrentHashMapImpl();
        podamValidationSteps.theConcurrentHashMapOfStringsObjectsShouldContainAtLeastOneNonEmptyElement(
            concurrentHashMapImpl );
        Queue<SimplePojoToTestSetters> queue = pojo.getQueue();
        podamValidationSteps.theQueueCannotBeNull( queue );
        podamValidationSteps.theQueueMustBeAnInstanceOf( queue, LinkedList.class );
        SimplePojoToTestSetters pojoQueueElement = queue.poll();
        podamValidationSteps.theObjectShouldNotBeNull( pojoQueueElement );
        List nonGenerifiedList = pojo.getNonGenerifiedList();
        podamValidationSteps.theNonGenerifiedListShouldNotBeNullOrEmpty( nonGenerifiedList );
        Map<?, ?> nonGenerifiedMap = pojo.getNonGenerifiedMap();
        podamValidationSteps.theNonGenerifiedMapShouldNotBeNullOrEmpty( nonGenerifiedMap );
        Object object = nonGenerifiedMap.get( nonGenerifiedMap.keySet()
                                              .iterator().next() );
        podamValidationSteps.theObjectShouldNotBeNull( object );
    }

    @Test
    public void podamShouldHandlePojosWithNoSettersAndCollectionsInTheConstructor() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        NoSetterWithCollectionInConstructorPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( NoSetterWithCollectionInConstructorPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        List<String> strList = pojo.getStrList();
        podamValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( strList );
        int intField = pojo.getIntField();
        podamValidationSteps.theIntFieldShouldNotBeZero( intField );
    }

    @Test
    public void podamShouldHandleImmutablePojosWithNonGenericCollections() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutableWithNonGenericCollectionsPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableWithNonGenericCollectionsPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        Collection<Object> nonGenerifiedCollection = pojo
                .getNonGenerifiedCollection();
        podamValidationSteps.theCollectionShouldNotBeNullOrEmpty( pojo.getNonGenerifiedCollection() );
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( nonGenerifiedCollection,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Set<Object> nonGenerifiedSet = pojo.getNonGenerifiedSet();
        podamValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( nonGenerifiedSet );
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements(
            nonGenerifiedSet, ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Map<Object, Object> nonGenerifiedMap = pojo.getNonGenerifiedMap();
        podamValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( nonGenerifiedMap );
        podamValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( nonGenerifiedMap,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
    }

    @Test
    public void podamShouldHandleImmutablePojoWithGenerifiedCollectionsInConstructor() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutableWithGenericCollectionsPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableWithGenericCollectionsPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        Collection<OneDimensionalTestPojo> generifiedCollection = pojo
                .getGenerifiedCollection();
        podamValidationSteps.theCollectionShouldNotBeNullOrEmpty( generifiedCollection );
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( generifiedCollection,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Map<String, Calendar> generifiedMap = pojo.getGenerifiedMap();
        podamValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( generifiedMap );
        podamValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( generifiedMap,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet = pojo
                .getGenerifiedSet();
        podamValidationSteps.theCollectionShouldNotBeNullOrEmpty( generifiedSet );
        podamValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( generifiedSet,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
    }


    @Test
    public void testSortedMapCreation()
    {
        testMap( TreeMap.class );
    }

    @Test
    public void testConcurrentMapCreation()
    {
        testMap( ConcurrentHashMap.class );
    }

    @Test
    public void testHashMapCreation()
    {
        testMap( HashMap.class );
    }


    @Test
    public void podamShouldFillInPojosWithAttributesContainingWildcards() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ReadOnlyWildcardFieldsPojo pojo	= podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                              ReadOnlyWildcardFieldsPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Object.class );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Object.class, Object.class );
    }

    @Test
    public void podamShouldBeAbleToFillInPojosWithRawTypeCollectionAttributesAndDefaultValueToObject() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ReadOnlyRawFieldsPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                         ReadOnlyRawFieldsPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Object.class );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Object.class, Object.class );
    }


    //------------------> Private methods

    private void testMap( Class<? extends Map> mapType )
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        DataProviderStrategy strategy = podamFactory.getStrategy();
        int mapSize = strategy.getNumberOfCollectionElements( PodamTestInterface.class );

        if ( mapType.isAssignableFrom( ConcurrentHashMap.class ) )
        {
            mapSize = 0;
        }

        Map<?, ?> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                             mapType, podamFactory, String.class, PodamTestInterface.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( mapSize, pojo.keySet().size() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( mapSize, pojo.values().size() );
    }


}
