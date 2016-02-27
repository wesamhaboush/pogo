package com.codebreeze.testing.tools.pogo.test.unit.features.constructors;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import javax.xml.bind.JAXBElement;
import java.util.Date;
import java.util.Observable;
import java.util.TimeZone;

public class ConstructorsUnitTest extends AbstractPogoSteps
{
    @Test
    public void PogoShouldHandleGenericsInConstructor() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        GenericInConstructorPojo pojo
            = PogoInvocationSteps.whenIInvokeTheFactoryForClass( GenericInConstructorPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }
    @Test
    public void PogoShouldHandleGenericsInSettersDuringPojoInstantiation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        GenericInSetterPojo pojo
            = PogoInvocationSteps.whenIInvokeTheFactoryForClass( GenericInSetterPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }

    @Test
    public void PogoShouldHandleGenericsInStaticConstructorsDuringPojoInstantiation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        GenericInStaticConstructorPojo pojo
            = PogoInvocationSteps.whenIInvokeTheFactoryForClass( GenericInStaticConstructorPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }

    @Test
    public void PogoShouldHandleConstructorsWithGenericArraysDuringPojoInstantiation()
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        GenericArrayInConstructorPojo<?> pojo
            = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                  GenericArrayInConstructorPojo.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getArray(), String.class );
    }

    @Test
    public void PogoShouldHandleConstructorsWithMultipleGenericsDuringPojoInstantiation()
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        MultipleGenericInConstructorPojo<?, ?, ?, ?> pojo
            = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType( MultipleGenericInConstructorPojo.class,
                    PogoFactory, String.class, Character.class, Byte.class, Integer.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getType() );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getList(), Character.class );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), Byte.class, Integer.class );
    }

    @Test
    public void PogoShouldHandleClassesWithKeyValueGenericTypes() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        DefaultFieldPojo<?, ?> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                          DefaultFieldPojo.class, PogoFactory, String.class, Long.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getMap() );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getMap(), String.class, Long.class );
    }


    @Test
    public void PogoShouldBeAbleToManufactureInstancesOfTheObservableClass() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        Observable observable = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Observable.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( observable );
    }

    @Test
    public void PogoShouldBeAbleToManufacturePojosWhichContainImmutableCollections() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ImmutableDefaultFieldsPojo model =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableDefaultFieldsPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( model );
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( model.getList() );
        PogoValidationSteps.theListShouldHaveExactlyTheExpectedNumberOfElements( model.getList(),
                PogoFactory.getStrategy().getNumberOfCollectionElements( model.getList().getClass() ) );
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( model.getMap() );
        PogoValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( model.getMap(),
                PogoFactory.getStrategy().getNumberOfCollectionElements( model.getMap().getClass() ) );
    }

    @Test
    public void PogoShouldBeAbleToManufactureAnyTypeOfCollections() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        UnsupportedCollectionInConstructorPojo<?> pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                UnsupportedCollectionInConstructorPojo.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getVector(), String.class );
    }

    @Test
    public void PogoShouldBeAbleToManufactureAnyTypeOfMaps() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        UnsupportedMapInConstructorPojo<?, ?> pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                UnsupportedMapInConstructorPojo.class, PogoFactory, String.class, Integer.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theMapShouldNotBeNullOrEmptyAndContainElementsOfType(
            pojo.getHashTable(), String.class, Integer.class );
    }

    @Test
    public void PogoShouldBeAbleToInstantiatePojosWithImmutableCollections() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ImmutableVector<?> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                      ImmutableVector.class, PogoFactory, String.class );
        PogoValidationSteps.theCollectionShouldBeEmpty( pojo );
    }

    @Test
    public void PogoShouldBeAbleToInstantiatePojosWithImmutableMaps() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ImmutableHashtable<?, ?> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                            ImmutableHashtable.class, PogoFactory, String.class, Integer.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theMapShouldBeEmtpy( pojo );
    }

    @Test
    public void PogoShouldInstantiateAbstractClassesForWhichItKnowsConcreteTypes() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        TimeZone pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( TimeZone.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void PogoShouldCreateInstancesOfGenericPojosWithFactoryMethodsWhenTheConcreteTypeIsKnown() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        FactoryInstantiablePojo<?> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                              FactoryInstantiablePojo.class, PogoFactory, Date.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        Object value = pojo.getTypedValue();
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( Date.class, value.getClass() );
    }


    @Test
    public void PogoShouldChooseTheFullestConstructorWhenInvokedForFullData() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ImmutablePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor(
                                 ImmutablePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue2() );
    }

    @Test
    public void testImmutablePojoConstructionFailure() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ImmutablePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ImmutablePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldBeNull( pojo.getValue() );
        PogoValidationSteps.theObjectShouldBeNull( pojo.getValue2() );
    }

    @Test
    public void PogoShouldCreateInstancesOfInnerClasses() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        InnerClassPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( InnerClassPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getIp() );
    }


    @Test
    public void PogoShouldCreateInstancesOfJAXBElements() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        JAXBElement<String> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                       JAXBElement.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getValue().getClass() );
    }

    @Test
    public void PogoShouldCreateInstancesOfJAXBElementsDeclaredAsInstanceVariablesInAPojo() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        JAXBElementPojo<String> pojo = PogoInvocationSteps.whenIInvokeTheFactoryForGenericTypeWithSpecificType(
                                           JAXBElementPojo.class, PogoFactory, String.class );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue().getValue() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getValue().getValue().getClass() );
    }

    @Test
    public void PogoShouldManufacturePackagePrivatePojos() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        PackagePrivatePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                                      PackagePrivatePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue() );
    }


    @Test
    public void PogoShouldCreateInstancesOfPojosExtendingGenericClasses() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        TypedClassPojo2 pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( TypedClassPojo2.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getTypedValue() );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, pojo.getTypedValue().getClass() );
        PogoValidationSteps.theCollectionShouldNotBeNullOrEmptyAndContainElementsOfType( pojo.getTypedList(), String.class );
    }

}
