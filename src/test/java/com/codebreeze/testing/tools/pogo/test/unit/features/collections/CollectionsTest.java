package com.codebreeze.testing.tools.pogo.test.unit.features.collections;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CollectionsTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldHandleStandardCollections() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        CollectionsPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( CollectionsPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        List<String> strList = pojo.getStrList();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( strList );
        ArrayList<String> arrayListStr = pojo.getArrayListStr();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( arrayListStr );
        List<String> copyOnWriteList = pojo.getCopyOnWriteList();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( copyOnWriteList );
        HashSet<String> hashSetStr = pojo.getHashSetStr();
        PogoValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( hashSetStr );
        List<String> listStrCollection = new ArrayList<>(
            pojo.getStrCollection() );
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( listStrCollection );
        Set<String> setStrCollection = new HashSet<>(
            pojo.getStrCollection() );
        PogoValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( setStrCollection );
        Set<String> strSet = pojo.getStrSet();
        PogoValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( strSet );
        Map<String, OneDimensionalTestPojo> map = pojo.getMap();
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( map );
        HashMap<String, OneDimensionalTestPojo> hashMap = pojo.getHashMap();
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( hashMap );
        ConcurrentMap<String, OneDimensionalTestPojo> concurrentHashMap = pojo
                .getConcurrentHashMap();
        PogoValidationSteps.theConcurrentHashMapOfStringsObjectsShouldContainAtLeastOneNonEmptyElement( concurrentHashMap );
        ConcurrentHashMap<String, OneDimensionalTestPojo> concurrentHashMapImpl = pojo
                .getConcurrentHashMapImpl();
        PogoValidationSteps.theConcurrentHashMapOfStringsObjectsShouldContainAtLeastOneNonEmptyElement(
            concurrentHashMapImpl );
        Queue<SimplePojoToTestSetters> queue = pojo.getQueue();
        PogoValidationSteps.theQueueCannotBeNull( queue );
        PogoValidationSteps.theQueueMustBeAnInstanceOf( queue, LinkedList.class );
        SimplePojoToTestSetters pojoQueueElement = queue.poll();
        PogoValidationSteps.theObjectShouldNotBeNull( pojoQueueElement );
        List nonGenerifiedList = pojo.getNonGenerifiedList();
        PogoValidationSteps.theNonGenerifiedListShouldNotBeNullOrEmpty( nonGenerifiedList );
        Map<?, ?> nonGenerifiedMap = pojo.getNonGenerifiedMap();
        PogoValidationSteps.theNonGenerifiedMapShouldNotBeNullOrEmpty( nonGenerifiedMap );
        Object object = nonGenerifiedMap.get( nonGenerifiedMap.keySet()
                                              .iterator().next() );
        PogoValidationSteps.theObjectShouldNotBeNull( object );
    }

    @Test
    public void PogoShouldHandlePojosWithNoSettersAndCollectionsInTheConstructor() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        NoSetterWithCollectionInConstructorPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( NoSetterWithCollectionInConstructorPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        List<String> strList = pojo.getStrList();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( strList );
        int intField = pojo.getIntField();
        PogoValidationSteps.theIntFieldShouldNotBeZero( intField );
    }

    @Test
    public void PogoShouldHandleImmutablePojosWithNonGenericCollections() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ImmutableWithNonGenericCollectionsPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableWithNonGenericCollectionsPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        Collection<Object> nonGenerifiedCollection = pojo
                .getNonGenerifiedCollection();
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmpty( pojo.getNonGenerifiedCollection() );
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( nonGenerifiedCollection,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Set<Object> nonGenerifiedSet = pojo.getNonGenerifiedSet();
        PogoValidationSteps.theSetShouldContainAtleastOneNonEmptyElement( nonGenerifiedSet );
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements(
            nonGenerifiedSet, ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Map<Object, Object> nonGenerifiedMap = pojo.getNonGenerifiedMap();
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( nonGenerifiedMap );
        PogoValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( nonGenerifiedMap,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
    }

    @Test
    public void PogoShouldHandleImmutablePojoWithGenerifiedCollectionsInConstructor() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ImmutableWithGenericCollectionsPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableWithGenericCollectionsPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        Collection<OneDimensionalTestPojo> generifiedCollection = pojo
                .getGenerifiedCollection();
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmpty( generifiedCollection );
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( generifiedCollection,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Map<String, Calendar> generifiedMap = pojo.getGenerifiedMap();
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( generifiedMap );
        PogoValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( generifiedMap,
                ImmutableWithNonGenericCollectionsPojo.NBR_ELEMENTS );
        Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet = pojo
                .getGenerifiedSet();
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmpty( generifiedSet );
        PogoValidationSteps.theCollectionShouldHaveExactlyTheExpectedNumberOfElements( generifiedSet,
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
    public void PogoShouldFillInPojosWithAttributesContainingWildcards() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ReadOnlyWildcardFieldsPojo pojo	= PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                              ReadOnlyWildcardFieldsPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Object.class );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Object.class, Object.class );
    }

    @Test
    public void PogoShouldBeAbleToFillInPojosWithRawTypeCollectionAttributesAndDefaultValueToObject() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ReadOnlyRawFieldsPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                         ReadOnlyRawFieldsPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Object.class );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Object.class, Object.class );
    }


    //------------------> Private methods

    private void testMap( Class<? extends Map> mapType )
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        DataProviderStrategy strategy = PogoFactory.getStrategy();
        int mapSize = strategy.getNumberOfCollectionElements( PogoTestInterface.class );

        if ( mapType.isAssignableFrom( ConcurrentHashMap.class ) )
        {
            mapSize = 0;
        }

        Map<?, ?> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                             mapType, PogoFactory, String.class, PogoTestInterface.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( mapSize, pojo.keySet().size() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( mapSize, pojo.values().size() );
    }


}
