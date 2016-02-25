package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveMap;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.Child;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.Parent;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveList;
import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePogoEnum;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PogoFactoryBasicTypesTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldGenerateBasicTypes() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        OneDimensionalTestPojo oneDimensionalTestPojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass(
                    OneDimensionalTestPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( oneDimensionalTestPojo );
        PogoValidationSteps.thePojoShouldContainSomeData( oneDimensionalTestPojo );
        oneDimentionalPojoValidationSteps.validateDimensionalTestPojo( oneDimensionalTestPojo, PogoFactory.getStrategy() );
    }

    @Test
    public void PogoShouldFillPojosWithNonDefaultConstructor() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        NoDefaultConstructorPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( NoDefaultConstructorPojo.class,
                                        PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void invokingPogoOnAbstractClassShouldReturnANullPojo() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        AbstractTestPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( AbstractTestPojo.class, PogoFactory );
        PogoValidationSteps.thePojoShouldBeNull( pojo );
    }

    @Test
    public void invokingPogoOnAnInterfaceShouldReturnAnEmptyPojo() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        InterfacePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( InterfacePojo.class, PogoFactory );
        PogoValidationSteps.thePojoShouldBeNull( pojo );
    }


    @Test
    public void PogoShouldFillRecursivePojos() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        RecursivePojo recursivePojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( RecursivePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( recursivePojo );
        recursivePojoValidationSteps.allPojosInTheRecursiveStrategyShouldBeValid( recursivePojo );
    }

    @Test
    public void PogoShouldFillRecursivePojosWhenInvokingPopulationDirectly() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        RecursivePojo pojo = new RecursivePojo();
        PogoInvocationSteps.whenIInvokeThePojoPopulationDirectly( pojo, PogoFactory );
        recursivePojoValidationSteps.allPojosInTheRecursiveStrategyShouldBeValid( pojo );
    }

    @Test
    public void PogoShouldSupportCircularDependencies() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        Parent parent = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Parent.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( parent );
        Child child = parent.getChild();
        PogoValidationSteps.theChildPojoShouldNotBeNull( child );
    }

    @Test
    public void PogoShouldSupportRecursiveLists() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        RecursiveList recursiveListPojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( RecursiveList.class,
                                          PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( recursiveListPojo );
        recursivePojoValidationSteps.thePojoListShouldNotBeNull( recursiveListPojo.getList() );
        recursivePojoValidationSteps.thePojoListShouldNotBeEmpty( recursiveListPojo.getList() );
        PogoValidationSteps.eachListElementShouldNotBeNull( recursiveListPojo.getList() );
    }

    @Test
    public void PogoShouldSupportRecursiveMaps() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        RecursiveMap recursiveMap = PogoInvocationSteps.whenIInvokeTheFactoryForClass( RecursiveMap.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( recursiveMap );
        recursivePojoValidationSteps.thePojoMapShouldNotBeNull( recursiveMap.getMap() );
        recursivePojoValidationSteps.thePojoMapShouldNotBeEmpty( recursiveMap.getMap() );
        PogoValidationSteps.eachMapElementShouldNotBeNull( recursiveMap.getMap() );
    }

    @Test
    public void PogoShouldHandleImmutableNonAnnotatedPojos() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ImmutableNonAnnotatedPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableNonAnnotatedPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
        PogoValidationSteps.theCalendarFieldShouldNotBeNull( pojo.getDateCreated() );
        PogoValidationSteps.theDateObjectShouldNotBeNull( pojo.getDateCreated().getTime() );
        PogoValidationSteps.theLongArrayShouldNotBeNullOrEmpty( pojo.getLongArray() );
        PogoValidationSteps.theLongValueShouldNotBeZero( pojo.getLongArray()[0] );
    }


    @Test
    public void PogoShouldFillPojoWithEnums() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        EnumsPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( EnumsPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        ExternalRatePogoEnum ratePogoExternal = pojo.getRatePogoExternal();
        PogoValidationSteps.theObjectShouldNotBeNull( ratePogoExternal );
        EnumsPojo.RatePogoInternal ratePogoInternal = pojo.getRatePogoInternal();
        PogoValidationSteps.theObjectShouldNotBeNull( ratePogoInternal );
    }

    @Test
    public void PogoShouldFillJavaNativeTypes() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        String pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor( String.class, PogoFactory );
        PogoValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo );
        Integer integerPojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Integer.class, PogoFactory );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( integerPojo );
        Calendar calendarPojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( GregorianCalendar.class, PogoFactory );
        PogoValidationSteps.theCalendarFieldShouldNotBeNull( calendarPojo );
        Date datePojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Date.class, PogoFactory );
        PogoValidationSteps.theDateObjectShouldNotBeNull( datePojo );
        BigDecimal bigDecimalPojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( BigDecimal.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( bigDecimalPojo );
    }

    @Test
    public void PogoShouldFillArraysWithElements() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ArrayPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ArrayPojo.class, PogoFactory );
        PogoValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getMyStringArray(), String.class );
        PogoValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getMyObjectArray(), Object.class );
    }

}
