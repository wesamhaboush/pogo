package com.codebreeze.testing.tools.pogo.test.unit.features.constructors;

import com.codebreeze.testing.tools.pogo.test.dto.*;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import javax.xml.bind.JAXBElement;
import java.util.Date;
import java.util.Observable;
import java.util.TimeZone;

public class ConstructorsUnitTest extends AbstractPodamSteps
{



    @Test
    public void podamShouldHandleGenericsInConstructor() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        GenericInConstructorPojo pojo
            = podamInvocationSteps.whenIInvokeTheFactoryForClass( GenericInConstructorPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }
    @Test
    public void podamShouldHandleGenericsInSettersDuringPojoInstantiation() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        GenericInSetterPojo pojo
            = podamInvocationSteps.whenIInvokeTheFactoryForClass( GenericInSetterPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }

    @Test
    public void podamShouldHandleGenericsInStaticConstructorsDuringPojoInstantiation() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        GenericInStaticConstructorPojo pojo
            = podamInvocationSteps.whenIInvokeTheFactoryForClass( GenericInStaticConstructorPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }

    @Test
    public void podamShouldHandleConstructorsWithGenericArraysDuringPojoInstantiation()
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        GenericArrayInConstructorPojo<?> pojo
            = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                  GenericArrayInConstructorPojo.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getArray(), String.class );
    }

    @Test
    public void podamShouldHandleConstructorsWithMultipleGenericsDuringPojoInstantiation()
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        MultipleGenericInConstructorPojo<?, ?, ?, ?> pojo
            = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType( MultipleGenericInConstructorPojo.class,
                    podamFactory, String.class, Character.class, Byte.class, Integer.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getType() );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Character.class );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Byte.class, Integer.class );
    }

    @Test
    public void podamShouldHandleClassesWithKeyValueGenericTypes() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        DefaultFieldPojo<?, ?> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                          DefaultFieldPojo.class, podamFactory, String.class, Long.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getMap() );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), String.class, Long.class );
    }


    @Test
    public void podamShouldBeAbleToManufactureInstancesOfTheObservableClass() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        Observable observable = podamInvocationSteps.whenIInvokeTheFactoryForClass( Observable.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( observable );
    }

    @Test
    public void podamShouldBeAbleToManufacturePojosWhichContainImmutableCollections() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutableDefaultFieldsPojo model =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableDefaultFieldsPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( model );
        podamValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( model.getList() );
        podamValidationSteps.theListShouldHaveExactlyTheExpectedNumberOfElements( model.getList(),
                podamFactory.getStrategy().getNumberOfCollectionElements( model.getList().getClass() ) );
        podamValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( model.getMap() );
        podamValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( model.getMap(),
                podamFactory.getStrategy().getNumberOfCollectionElements( model.getMap().getClass() ) );
    }

    @Test
    public void podamShouldBeAbleToManufactureAnyTypeOfCollections() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        UnsupportedCollectionInConstructorPojo<?> pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                UnsupportedCollectionInConstructorPojo.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }

    @Test
    public void podamShouldBeAbleToManufactureAnyTypeOfMaps() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        UnsupportedMapInConstructorPojo<?, ?> pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                UnsupportedMapInConstructorPojo.class, podamFactory, String.class, Integer.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getHashTable(), String.class, Integer.class );
    }

    @Test
    public void podamShouldBeAbleToInstantiatePojosWithImmutableCollections() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutableVector<?> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                      ImmutableVector.class, podamFactory, String.class );
        podamValidationSteps.theCollectionShouldBeEmpty( pojo );
    }

    @Test
    public void podamShouldBeAbleToInstantiatePojosWithImmutableMaps() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutableHashtable<?, ?> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                            ImmutableHashtable.class, podamFactory, String.class, Integer.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theMapShouldBeEmtpy( pojo );
    }

    @Test
    public void podamShouldInstantiateAbstractClassesForWhichItKnowsConcreteTypes() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        TimeZone pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( TimeZone.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void podamShouldCreateInstancesOfGenericPojosWithFactoryMethodsWhenTheConcreteTypeIsKnown() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        FactoryInstantiablePojo<?> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                              FactoryInstantiablePojo.class, podamFactory, Date.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        Object value = pojo.getTypedValue();
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theTwoObjectsShouldBeEqual( Date.class, value.getClass() );
    }


    @Test
    public void podamShouldChooseTheFullestConstructorWhenInvokedForFullData() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutablePojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor(
                                 ImmutablePojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue2() );
    }

    @Test
    public void testImmutablePojoConstructionFailure() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutablePojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( ImmutablePojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldBeNull( pojo.getValue() );
        podamValidationSteps.theObjectShouldBeNull( pojo.getValue2() );
    }

    @Test
    public void podamShouldCreateInstancesOfInnerClasses() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        InnerClassPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( InnerClassPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getIp() );
    }


    @Test
    public void podamShouldCreateInstancesOfJAXBElements() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        JAXBElement<String> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                       JAXBElement.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getValue().getClass() );
    }

    @Test
    public void podamShouldCreateInstancesOfJAXBElementsDeclaredAsInstanceVariablesInAPojo() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        JAXBElementPojo<String> pojo = podamInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                           JAXBElementPojo.class, podamFactory, String.class );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getName() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getValue() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getValue().getValue().getClass() );
    }

    @Test
    public void podamShouldManufacturePackagePrivatePojos() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        PackagePrivatePojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                                      PackagePrivatePojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
    }


    @Test
    public void podamShouldCreateInstancesOfPojosExtendingGenericClasses() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        TypedClassPojo2 pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( TypedClassPojo2.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getTypedValue() );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getTypedValue().getClass() );
        podamValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getTypedList(), String.class );
    }

}
