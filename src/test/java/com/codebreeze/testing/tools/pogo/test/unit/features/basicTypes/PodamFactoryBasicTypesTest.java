package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveMap;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.Child;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.Parent;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveList;
import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePodamEnum;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PodamFactoryBasicTypesTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldGenerateBasicTypes() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        OneDimensionalTestPojo oneDimensionalTestPojo = podamInvocationSteps.whenIInvokeTheFactoryForClass(
                    OneDimensionalTestPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( oneDimensionalTestPojo );
        podamValidationSteps.thePojoShouldContainSomeData( oneDimensionalTestPojo );
        oneDimentionalPojoValidationSteps.validateDimensionalTestPojo( oneDimensionalTestPojo, podamFactory.getStrategy() );
    }

    @Test
    public void podamShouldFillPojosWithNonDefaultConstructor() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        NoDefaultConstructorPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( NoDefaultConstructorPojo.class,
                                        podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
    }

    @Test
    public void invokingPodamOnAbstractClassShouldReturnANullPojo() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        AbstractTestPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( AbstractTestPojo.class, podamFactory );
        podamValidationSteps.thePojoShouldBeNull( pojo );
    }

    @Test
    public void invokingPodamOnAnInterfaceShouldReturnAnEmptyPojo() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        InterfacePojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( InterfacePojo.class, podamFactory );
        podamValidationSteps.thePojoShouldBeNull( pojo );
    }


    @Test
    public void podamShouldFillRecursivePojos() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        RecursivePojo recursivePojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( RecursivePojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( recursivePojo );
        recursivePojoValidationSteps.allPojosInTheRecursiveStrategyShouldBeValid( recursivePojo );
    }

    @Test
    public void podamShouldFillRecursivePojosWhenInvokingPopulationDirectly() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        RecursivePojo pojo = new RecursivePojo();
        podamInvocationSteps.whenIInvokeThePojoPopulationDirectly( pojo, podamFactory );
        recursivePojoValidationSteps.allPojosInTheRecursiveStrategyShouldBeValid( pojo );
    }

    @Test
    public void podamShouldSupportCircularDependencies() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        Parent parent = podamInvocationSteps.whenIInvokeTheFactoryForClass( Parent.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( parent );
        Child child = parent.getChild();
        podamValidationSteps.theChildPojoShouldNotBeNull( child );
    }

    @Test
    public void podamShouldSupportRecursiveLists() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        RecursiveList recursiveListPojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( RecursiveList.class,
                                          podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( recursiveListPojo );
        recursivePojoValidationSteps.thePojoListShouldNotBeNull( recursiveListPojo.getList() );
        recursivePojoValidationSteps.thePojoListShouldNotBeEmpty( recursiveListPojo.getList() );
        podamValidationSteps.eachListElementShouldNotBeNull( recursiveListPojo.getList() );
    }

    @Test
    public void podamShouldSupportRecursiveMaps() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        RecursiveMap recursiveMap = podamInvocationSteps.whenIInvokeTheFactoryForClass( RecursiveMap.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( recursiveMap );
        recursivePojoValidationSteps.thePojoMapShouldNotBeNull( recursiveMap.getMap() );
        recursivePojoValidationSteps.thePojoMapShouldNotBeEmpty( recursiveMap.getMap() );
        podamValidationSteps.eachMapElementShouldNotBeNull( recursiveMap.getMap() );
    }

    @Test
    public void podamShouldHandleImmutableNonAnnotatedPojos() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ImmutableNonAnnotatedPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableNonAnnotatedPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
        podamValidationSteps.theCalendarFieldShouldNotBeNull( pojo.getDateCreated() );
        podamValidationSteps.theDateObjectShouldNotBeNull( pojo.getDateCreated().getTime() );
        podamValidationSteps.theLongArrayShouldNotBeNullOrEmpty( pojo.getLongArray() );
        podamValidationSteps.theLongValueShouldNotBeZero( pojo.getLongArray()[0] );
    }


    @Test
    public void podamShouldFillPojoWithEnums() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        EnumsPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( EnumsPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        ExternalRatePodamEnum ratePodamExternal = pojo.getRatePodamExternal();
        podamValidationSteps.theObjectShouldNotBeNull( ratePodamExternal );
        EnumsPojo.RatePodamInternal ratePodamInternal = pojo.getRatePodamInternal();
        podamValidationSteps.theObjectShouldNotBeNull( ratePodamInternal );
    }

    @Test
    public void podamShouldFillJavaNativeTypes() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        String pojo = podamInvocationSteps.whenIInvokeTheFactoryForClassWithFullConstructor( String.class, podamFactory );
        podamValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo );
        Integer integerPojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( Integer.class, podamFactory );
        podamValidationSteps.theIntegerObjectFieldShouldNotBeNull( integerPojo );
        Calendar calendarPojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( GregorianCalendar.class, podamFactory );
        podamValidationSteps.theCalendarFieldShouldNotBeNull( calendarPojo );
        Date datePojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( Date.class, podamFactory );
        podamValidationSteps.theDateObjectShouldNotBeNull( datePojo );
        BigDecimal bigDecimalPojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( BigDecimal.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( bigDecimalPojo );
    }

    @Test
    public void podamShouldFillArraysWithElements() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        ArrayPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( ArrayPojo.class, podamFactory );
        podamValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getMyStringArray(), String.class );
        podamValidationSteps.theArrayOfTheGivenTypeShouldNotBeNullOrEmptyAndContainElementsOfTheRightType(
            pojo.getMyObjectArray(), Object.class );
    }

}
