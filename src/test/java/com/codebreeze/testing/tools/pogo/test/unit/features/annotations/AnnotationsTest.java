package com.codebreeze.testing.tools.pogo.test.unit.features.annotations;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.ConstructorWithSelfReferencesPojoAndDefaultConstructor;
import com.codebreeze.testing.tools.pogo.test.dto.ExcludeAnnotationPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ImmutableNoHierarchicalAnnotatedPojo;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class AnnotationsTest extends AbstractPogoSteps
{


    @Test
    public void PogoShouldHandleImmutablePojosAnnotatedWithPogoConstructor() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ImmutableNoHierarchicalAnnotatedPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ImmutableNoHierarchicalAnnotatedPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
        PogoValidationSteps.theCalendarFieldShouldNotBeNull( pojo.getDateCreated() );
        PogoValidationSteps.theDateObjectShouldNotBeNull( pojo.getDateCreated().getTime() );
        PogoValidationSteps.theLongArrayShouldNotBeNullOrEmpty( pojo.getLongArray() );
        PogoValidationSteps.theLongValueShouldNotBeZero( pojo.getLongArray()[0] );
    }

    @Test
    public void PogoShouldHandleConstructorsWithOneOrMoreSelfReferences() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ConstructorWithSelfReferencesPojoAndDefaultConstructor pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( ConstructorWithSelfReferencesPojoAndDefaultConstructor.class,
                    PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        constructorSelfReferenceValidationSteps.theFirstSelfReferenceForPojoWithDefaultConstructorShouldNotBeNull( pojo );
        constructorSelfReferenceValidationSteps.theSecondSelfReferenceForPojoWithDefaultConstructorShouldNotBeNull( pojo );
    }

    @Test
    public void PogoShouldNotFillFieldsAnnotatedWithExcludeAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ExcludeAnnotationPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ExcludeAnnotationPojo.class,
                                     PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theIntFieldShouldNotBeZero( pojo.getIntField() );
        PogoValidationSteps.anyFieldWithPogoExcludeAnnotationShouldBeNull( pojo.getSomePojo() );
    }

    @Test
    public void PogoShouldHandleIntegerValues() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        IntegerValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( IntegerValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theIntFieldShouldBeGreaterOrEqualToZero( pojo.getIntFieldWithMinValueOnly() );
        int maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED;
        PogoValidationSteps.theIntFieldShouldHaveValueNotGreaterThan( pojo.getIntFieldWithMaxValueOnly(), maxValue );
        int minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE;
        maxValue = PogoTestConstants.NUMBER_INT_MAX_VALUE;
        PogoValidationSteps.theIntFieldShouldHaveValueBetween( minValue, maxValue, pojo.getIntFieldWithMinAndMaxValue() );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithMinValueOnly() );
        PogoValidationSteps.theIntFieldShouldBeGreaterOrEqualToZero( pojo.getIntegerObjectFieldWithMinValueOnly() );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithMaxValueOnly() );
        maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED;
        PogoValidationSteps.theIntFieldShouldHaveValueNotGreaterThan( pojo.getIntegerObjectFieldWithMaxValueOnly(), maxValue );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithMinAndMaxValue() );
        maxValue = PogoTestConstants.NUMBER_INT_MAX_VALUE;
        PogoValidationSteps.theIntFieldShouldHaveValueBetween( minValue, maxValue,
                pojo.getIntegerObjectFieldWithMinAndMaxValue() );
        int preciseValue = Integer.valueOf( PogoTestConstants.INTEGER_PRECISE_VALUE );
        PogoValidationSteps.theIntFieldShouldHaveThePreciseValueOf( pojo.getIntFieldWithPreciseValue(), preciseValue );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithPreciseValue() );
        PogoValidationSteps.theIntFieldShouldHaveThePreciseValueOf( pojo.getIntegerObjectFieldWithPreciseValue(),
                preciseValue );
    }

    @Test
    public void PogoShouldHandleLongValues() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        LongValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( LongValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theLongFieldShouldBeGreaterOrEqualToZero( pojo.getLongFieldWithMinValueOnly() );
        int maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED;
        PogoValidationSteps.theLongFieldShouldHaveValueNotGreaterThan( pojo.getLongFieldWithMaxValueOnly(), maxValue );
        int minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE;
        maxValue = PogoTestConstants.NUMBER_INT_MAX_VALUE;
        PogoValidationSteps.theLongFieldShouldHaveValueBetween( minValue, maxValue, pojo.getLongFieldWithMinAndMaxValue() );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithMinValueOnly() );
        PogoValidationSteps.theLongFieldShouldBeGreaterOrEqualToZero( pojo.getLongObjectFieldWithMinValueOnly() );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithMaxValueOnly() );
        maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED;
        PogoValidationSteps.theLongFieldShouldHaveValueNotGreaterThan( pojo.getLongObjectFieldWithMinValueOnly(), maxValue );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithMinAndMaxValue() );
        maxValue = PogoTestConstants.NUMBER_INT_MAX_VALUE;
        PogoValidationSteps.theLongFieldShouldHaveValueBetween( minValue, maxValue,
                pojo.getLongObjectFieldWithMinAndMaxValue() );
        long preciseValue = Long.valueOf( PogoTestConstants.LONG_PRECISE_VALUE );
        PogoValidationSteps.theLongFieldShouldHaveThePreciseValueOf( pojo.getLongFieldWithPreciseValue(), preciseValue );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithPreciseValue() );
        PogoValidationSteps.theLongFieldShouldHaveThePreciseValueOf( pojo.getLongObjectFieldWithPreciseValue(), preciseValue );
    }

    @Test
    public void PogoShouldHandleByteValuesWithThePogoByteValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ByteValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ByteValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        byte byteFieldWithMinValueOnly = pojo.getByteFieldWithMinValueOnly();
        PogoValidationSteps.theByteValueShouldBeGreaterOrEqualThan(
            byteFieldWithMinValueOnly, PogoTestConstants.NUMBER_INT_MIN_VALUE );
        byte byteFieldWithMaxValueOnly = pojo.getByteFieldWithMaxValueOnly();
        PogoValidationSteps.theByteValueShouldBeLowerOrEqualThan(
            byteFieldWithMaxValueOnly, PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        byte byteFieldWithMinAndMaxValue = pojo
                                           .getByteFieldWithMinAndMaxValue();
        PogoValidationSteps.theByteValueShouldBeBetween( byteFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_INT_MIN_VALUE, PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        Byte byteObjectFieldWithMinValueOnly = pojo
                                               .getByteObjectFieldWithMinValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( byteObjectFieldWithMinValueOnly );
        PogoValidationSteps.theByteValueShouldBeGreaterOrEqualThan(
            byteObjectFieldWithMinValueOnly, PogoTestConstants.NUMBER_INT_MIN_VALUE );
        Byte byteObjectFieldWithMaxValueOnly = pojo
                                               .getByteObjectFieldWithMaxValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( byteFieldWithMaxValueOnly );
        PogoValidationSteps.theByteValueShouldBeLowerOrEqualThan(
            byteObjectFieldWithMaxValueOnly, PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        Byte byteObjectFieldWithMinAndMaxValue = pojo
                .getByteObjectFieldWithMinAndMaxValue();
        PogoValidationSteps.theObjectShouldNotBeNull( byteObjectFieldWithMinAndMaxValue );
        PogoValidationSteps.theByteValueShouldBeBetween( byteObjectFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_INT_MIN_VALUE,
                PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        byte byteFieldWithPreciseValue = pojo.getByteFieldWithPreciseValue();
        PogoValidationSteps.theByteValueShouldHavePreciselyValueOf( byteFieldWithPreciseValue,
                Byte.valueOf( PogoTestConstants.BYTE_PRECISE_VALUE ) );
    }

    @Test
    public void PogoShouldHandleShortValuesWithThePogoShortValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        ShortValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ShortValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        short shortFieldWithMinValueOnly = pojo.getShortFieldWithMinValueOnly();
        PogoValidationSteps.theShortValueShouldBeGreaterOrEqualThan(
            shortFieldWithMinValueOnly, PogoTestConstants.NUMBER_INT_MIN_VALUE );
        short shortFieldWithMaxValueOnly = pojo.getShortFieldWithMaxValueOnly();
        PogoValidationSteps.theShortValueShouldBeLowerOrEqualThan(
            shortFieldWithMaxValueOnly, PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        short shortFieldWithMinAndMaxValue = pojo
                                             .getShortFieldWithMinAndMaxValue();
        PogoValidationSteps.theShortValueShouldBeBetween( shortFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_INT_MIN_VALUE, PogoTestConstants.NUMBER_INT_MAX_VALUE );
        Short shortObjectFieldWithMinValueOnly = pojo
                .getShortObjectFieldWithMinValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( shortFieldWithMinValueOnly );
        PogoValidationSteps.theShortValueShouldBeGreaterOrEqualThan( shortObjectFieldWithMinValueOnly,
                PogoTestConstants.NUMBER_INT_MIN_VALUE );
        Short shortObjectFieldWithMaxValueOnly = pojo
                .getShortObjectFieldWithMaxValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( shortFieldWithMaxValueOnly );
        PogoValidationSteps.theShortValueShouldBeLowerOrEqualThan( shortObjectFieldWithMaxValueOnly,
                PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        Short shortObjectFieldWithMinAndMaxValue = pojo
                .getShortObjectFieldWithMinAndMaxValue();
        PogoValidationSteps.theObjectShouldNotBeNull( shortObjectFieldWithMinAndMaxValue );
        PogoValidationSteps.theShortValueShouldBeBetween( shortObjectFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_INT_MIN_VALUE,
                PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        short shortFieldWithPreciseValue = pojo.getShortFieldWithPreciseValue();
        PogoValidationSteps.theShortPreciseValueShouldBe( shortFieldWithPreciseValue,
                Short.valueOf( PogoTestConstants.SHORT_PRECISE_VALUE ) );
    }

    @Test
    public void PogoShouldHandleCharValuesWithThePogoCharValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        CharValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( CharValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        char charFieldWithMinValueOnly = pojo.getCharFieldWithMinValueOnly();
        PogoValidationSteps.theCharValueShouldBeGreaterOrEqualThan(
            charFieldWithMinValueOnly, ( char ) PogoTestConstants.NUMBER_INT_MIN_VALUE );
        char charFieldWithMaxValueOnly = pojo.getCharFieldWithMaxValueOnly();
        PogoValidationSteps.theCharValueShouldBeLowerOrEqualThan( charFieldWithMaxValueOnly,
                PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        char charFieldWithMinAndMaxValue = pojo
                                           .getCharFieldWithMinAndMaxValue();
        PogoValidationSteps.theCharValueShouldBeBetween( charFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_INT_MIN_VALUE,
                PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        Character charObjectFieldWithMinValueOnly = pojo
                .getCharObjectFieldWithMinValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( charObjectFieldWithMinValueOnly );
        PogoValidationSteps.theCharValueShouldBeGreaterOrEqualThan( charObjectFieldWithMinValueOnly,
                ( char )PogoTestConstants.NUMBER_INT_MIN_VALUE );
        Character charObjectFieldWithMaxValueOnly = pojo
                .getCharObjectFieldWithMaxValueOnly();
        PogoValidationSteps.theCharValueShouldBeLowerOrEqualThan( charObjectFieldWithMaxValueOnly,
                PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        Character charObjectFieldWithMinAndMaxValue = pojo
                .getCharObjectFieldWithMinAndMaxValue();
        PogoValidationSteps.theObjectShouldNotBeNull( charObjectFieldWithMinAndMaxValue );
        PogoValidationSteps.theCharValueShouldBeBetween( charObjectFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_INT_MIN_VALUE,
                PogoTestConstants.NUMBER_INT_ONE_HUNDRED );
        char charFieldWithPreciseValue = pojo.getCharFieldWithPreciseValue();
        PogoValidationSteps.theCharValueShouldBeExactly( charFieldWithPreciseValue,
                PogoTestConstants.CHAR_PRECISE_VALUE );
        char charFieldWithBlankInPreciseValue = pojo
                                                .getCharFieldWithBlankInPreciseValue();
        PogoValidationSteps.theCharValueShouldBeExactly( charFieldWithBlankInPreciseValue, '\u0000' );
    }


    @Test
    public void PogoShouldHandleBooleanValuesWithThePogoBooleanValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        BooleanValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( BooleanValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        boolean boolDefaultToTrue = pojo.isBoolDefaultToTrue();
        PogoValidationSteps.theBooleanValueIsTrue( boolDefaultToTrue );
        boolean boolDefaultToFalse = pojo.isBoolDefaultToFalse();
        PogoValidationSteps.theBooleanValueShouldBeFalse( boolDefaultToFalse );
        Boolean boolObjectDefaultToFalse = pojo.getBoolObjectDefaultToFalse();
        PogoValidationSteps.theObjectShouldNotBeNull( boolObjectDefaultToFalse );
        PogoValidationSteps.theBooleanValueShouldBeFalse( boolObjectDefaultToFalse );
        Boolean boolObjectDefaultToTrue = pojo.getBoolObjectDefaultToTrue();
        PogoValidationSteps.theObjectShouldNotBeNull( boolObjectDefaultToTrue );
        PogoValidationSteps.theBooleanValueIsTrue( boolObjectDefaultToTrue );
    }

    @Test
    public void PogoShouldHandleFloatValuesWithThePogoFloatValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        FloatValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( FloatValuePojo.class, PogoFactory );
        Assert.assertNotNull( "The pojo cannot be null!", pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        float floatFieldWithMinValueOnly = pojo.getFloatFieldWithMinValueOnly();
        PogoValidationSteps.theFloatValueShouldBeGreaterOrEqualThan( floatFieldWithMinValueOnly,
                PogoTestConstants.NUMBER_FLOAT_MIN_VALUE );
        float floatFieldWithMaxValueOnly = pojo.getFloatFieldWithMaxValueOnly();
        PogoValidationSteps.theFloatValueShouldBeLowerOrEqualThan( floatFieldWithMaxValueOnly,
                PogoTestConstants.NUMBER_FLOAT_ONE_HUNDRED );
        float floatFieldWithMinAndMaxValue = pojo
                                             .getFloatFieldWithMinAndMaxValue();
        PogoValidationSteps.theFloatValueShouldBeBetween( floatFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_FLOAT_MIN_VALUE,
                PogoTestConstants.NUMBER_FLOAT_MAX_VALUE );
        Float floatObjectFieldWithMinValueOnly = pojo
                .getFloatObjectFieldWithMinValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( floatObjectFieldWithMinValueOnly );
        PogoValidationSteps.theFloatValueShouldBeGreaterOrEqualThan( floatObjectFieldWithMinValueOnly,
                PogoTestConstants.NUMBER_FLOAT_MIN_VALUE );
        Float floatObjectFieldWithMaxValueOnly = pojo
                .getFloatObjectFieldWithMaxValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( floatObjectFieldWithMaxValueOnly );
        PogoValidationSteps.theFloatValueShouldBeLowerOrEqualThan( floatObjectFieldWithMaxValueOnly,
                PogoTestConstants.NUMBER_FLOAT_ONE_HUNDRED );
        Float floatObjectFieldWithMinAndMaxValue = pojo
                .getFloatObjectFieldWithMinAndMaxValue();
        PogoValidationSteps.theObjectShouldNotBeNull( floatObjectFieldWithMinAndMaxValue );
        PogoValidationSteps.theFloatValueShouldBeBetween( floatObjectFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_FLOAT_MIN_VALUE,
                PogoTestConstants.NUMBER_FLOAT_MAX_VALUE );
        float floatFieldWithPreciseValue = pojo.getFloatFieldWithPreciseValue();
        PogoValidationSteps.theFloatValueShouldBePrecisely( floatFieldWithPreciseValue,
                Float.valueOf( PogoTestConstants.FLOAT_PRECISE_VALUE ) );
        Float floatObjectFieldWithPreciseValue = pojo
                .getFloatObjectFieldWithPreciseValue();
        PogoValidationSteps.theObjectShouldNotBeNull( floatObjectFieldWithPreciseValue );
        PogoValidationSteps.theFloatValueShouldBePrecisely( floatObjectFieldWithPreciseValue,
                Float.valueOf( PogoTestConstants.FLOAT_PRECISE_VALUE ) );
    }


    @Test
    public void PogoShouldHandleDoubleValuesWithThePogoDoubleValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        DoubleValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( DoubleValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        double doubleFieldWithMinValueOnly = pojo
                                             .getDoubleFieldWithMinValueOnly();
        PogoValidationSteps.theDoubleValueShouldBeGreaterOrEqualThan( doubleFieldWithMinValueOnly,
                PogoTestConstants.NUMBER_DOUBLE_MIN_VALUE );
        double doubleFieldWithMaxValueOnly = pojo
                                             .getDoubleFieldWithMaxValueOnly();
        PogoValidationSteps.theDoubleValueShouldBeLowerOrEqualThan( doubleFieldWithMaxValueOnly,
                PogoTestConstants.NUMBER_DOUBLE_ONE_HUNDRED );
        double doubleFieldWithMinAndMaxValue = pojo
                                               .getDoubleFieldWithMinAndMaxValue();
        PogoValidationSteps.theDoubleValueShouldBeBetween( doubleFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_DOUBLE_MIN_VALUE, PogoTestConstants.NUMBER_DOUBLE_MAX_VALUE );
        double doubleFieldWithPreciseValue = pojo
                                             .getDoubleFieldWithPreciseValue();
        PogoValidationSteps.theDoubleValueShouldBeExactly( doubleFieldWithPreciseValue,
                Double.valueOf( PogoTestConstants.DOUBLE_PRECISE_VALUE ) );
        Double doubleObjectFieldWithPreciseValue = pojo
                .getDoubleObjectFieldWithPreciseValue();
        PogoValidationSteps.theObjectShouldNotBeNull( doubleObjectFieldWithPreciseValue );
        Assert.assertTrue(
            "The double object field with precise value should have a value of: "
            + PogoTestConstants.DOUBLE_PRECISE_VALUE,
            doubleObjectFieldWithPreciseValue.doubleValue() == Double
            .valueOf( PogoTestConstants.DOUBLE_PRECISE_VALUE )
            .doubleValue() );
        PogoValidationSteps.theDoubleValueShouldBeExactly( doubleObjectFieldWithPreciseValue,
                Double.valueOf( PogoTestConstants.DOUBLE_PRECISE_VALUE ) );
    }

    @Test
    public void PogoShouldAssignPreciseValuesWithTheStringValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        StringValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( StringValuePojo.class, PogoFactory );
        String twentyLengthString = pojo.getTwentyLengthString();
        PogoValidationSteps.theObjectShouldNotBeNull( twentyLengthString );
        PogoValidationSteps.theStringValueShouldHaveTheExactLengthOf( twentyLengthString,
                PogoTestConstants.STR_ANNOTATION_TWENTY_LENGTH );
        String preciseValueString = pojo.getPreciseValueString();
        PogoValidationSteps.theObjectShouldNotBeNull( preciseValueString );
        PogoValidationSteps.theStringValueShouldBeExactly(
            preciseValueString, PogoTestConstants.STR_ANNOTATION_PRECISE_VALUE );
    }


    @Test
    public void thePogoCollectionAnnotationShouldWorkOnAllCollections() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        CollectionAnnotationPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( CollectionAnnotationPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        List<String> strList = pojo.getStrList();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( strList );
        PogoValidationSteps.theListShouldHaveExactlyTheExpectedNumberOfElements( strList,
                PogoTestConstants.ANNOTATION_COLLECTION_NBR_ELEMENTS );
        String[] strArray = pojo.getStrArray();
        PogoValidationSteps.theArrayOfStringsShouldNotBeNullOrEmpty( strArray );
        Map<String, String> stringMap = pojo.getStringMap();
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( stringMap );
        PogoValidationSteps.theMapShouldHaveExactlyTheExpectedNumberOfElements( stringMap,
                PogoTestConstants.ANNOTATION_COLLECTION_NBR_ELEMENTS );
    }


    @Test
    public void PogoShouldAssignExactValuesDefinedInPogoStrategyValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        PogoStrategyPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( PogoStrategyPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theArrayOfBytesShouldNotBeNullOrEmpty( pojo.getByteData() );
        List<Calendar> myBirthdays = pojo.getMyBirthdays();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( myBirthdays );
        List<Object> objectList = pojo.getObjectList();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( objectList );
        Object[] myObjectArray = pojo.getMyObjectArray();
        PogoValidationSteps.theArrayOfObjectsShouldNotBeNullOrEmpty( myObjectArray );
        List nonGenericObjectList = pojo.getNonGenericObjectList();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( nonGenericObjectList );
        Map<String, Calendar> myBirthdaysMap = pojo.getMyBirthdaysMap();
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( myBirthdaysMap );
    }



}
