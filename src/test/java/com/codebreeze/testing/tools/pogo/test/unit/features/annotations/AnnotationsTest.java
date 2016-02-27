package com.codebreeze.testing.tools.pogo.test.unit.features.annotations;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.ConstructorWithSelfReferencesPojoAndDefaultConstructor;
import com.codebreeze.testing.tools.pogo.test.dto.ImmutableNoHierarchicalAnnotatedPojo;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AnnotationsTest extends AbstractPogoSteps
{


    @Test
    public void PogoShouldHandleImmutablePojosAnnotatedWithPogoConstructor() throws Exception
    {
        PogoFactory pogoFactory = new PogoFactoryImpl();
        ImmutableNoHierarchicalAnnotatedPojo pojo = pogoFactory.manufacturePojo( ImmutableNoHierarchicalAnnotatedPojo.class );
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getDateCreated() ).isNotNull();
        assertThat( pojo.getDateCreated().getTime() ).isNotNull();
        assertThat( pojo.getLongArray() ).isNotNull().isNotEmpty();
    }

    @Test
    public void PogoShouldHandleConstructorsWithOneOrMoreSelfReferences() throws Exception
    {
        //given
        PogoFactory PogoFactory = new PogoFactoryImpl();
        //when
        ConstructorWithSelfReferencesPojoAndDefaultConstructor pojo = PogoFactory.manufacturePojo(
                    ConstructorWithSelfReferencesPojoAndDefaultConstructor.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getParent() ).isNull();
        assertThat( pojo.getAnotherParent() ).isNull();
    }

    @Test
    public void PogoShouldHandleIntegerValues() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        IntegerValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( IntegerValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithMinValueOnly() );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithMaxValueOnly() );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithMinAndMaxValue() );
        PogoValidationSteps.theIntegerObjectFieldShouldNotBeNull( pojo.getIntegerObjectFieldWithPreciseValue() );
    }

    @Test
    public void PogoShouldHandleLongValues() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        LongValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( LongValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theLongFieldShouldBeGreaterOrEqualToZero( pojo.getLongFieldWithMinValueOnly() );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithMinValueOnly() );
        PogoValidationSteps.theLongFieldShouldBeGreaterOrEqualToZero( pojo.getLongObjectFieldWithMinValueOnly() );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithMaxValueOnly() );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithMinAndMaxValue() );
        PogoValidationSteps.theLongObjectFieldShouldNotBeNull( pojo.getLongObjectFieldWithPreciseValue() );
    }

    @Test
    public void PogoShouldHandleByteValuesWithThePogoByteValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ByteValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ByteValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        byte byteFieldWithMaxValueOnly = pojo.getByteFieldWithMaxValueOnly();
        Byte byteObjectFieldWithMinValueOnly = pojo
                                               .getByteObjectFieldWithMinValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( byteObjectFieldWithMinValueOnly );
        PogoValidationSteps.theObjectShouldNotBeNull( byteFieldWithMaxValueOnly );
        Byte byteObjectFieldWithMinAndMaxValue = pojo
                .getByteObjectFieldWithMinAndMaxValue();
        PogoValidationSteps.theObjectShouldNotBeNull( byteObjectFieldWithMinAndMaxValue );
    }

    @Test
    public void PogoShouldHandleShortValuesWithThePogoShortValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ShortValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( ShortValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        short shortFieldWithMinValueOnly = pojo.getShortFieldWithMinValueOnly();
        PogoValidationSteps.theShortValueShouldBeGreaterOrEqualThan(
            shortFieldWithMinValueOnly, PogoTestConstants.NUMBER_INT_MIN_VALUE );
        short shortFieldWithMaxValueOnly = pojo.getShortFieldWithMaxValueOnly();
        short shortFieldWithMinAndMaxValue = pojo
                                             .getShortFieldWithMinAndMaxValue();
        PogoValidationSteps.theShortValueShouldBeBetween( shortFieldWithMinAndMaxValue,
                PogoTestConstants.NUMBER_INT_MIN_VALUE, PogoTestConstants.NUMBER_INT_MAX_VALUE );
        Short shortObjectFieldWithMinValueOnly = pojo
                .getShortObjectFieldWithMinValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( shortFieldWithMinValueOnly );
        PogoValidationSteps.theShortValueShouldBeGreaterOrEqualThan( shortObjectFieldWithMinValueOnly,
                PogoTestConstants.NUMBER_INT_MIN_VALUE );
        PogoValidationSteps.theObjectShouldNotBeNull( shortFieldWithMaxValueOnly );
        Short shortObjectFieldWithMinAndMaxValue = pojo
                .getShortObjectFieldWithMinAndMaxValue();
        PogoValidationSteps.theObjectShouldNotBeNull( shortObjectFieldWithMinAndMaxValue );
    }

    @Test
    public void PogoShouldHandleCharValuesWithThePogoCharValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        CharValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( CharValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        char charFieldWithMinValueOnly = pojo.getCharFieldWithMinValueOnly();
        PogoValidationSteps.theCharValueShouldBeGreaterOrEqualThan(
            charFieldWithMinValueOnly, ( char ) PogoTestConstants.NUMBER_INT_MIN_VALUE );
        Character charObjectFieldWithMinValueOnly = pojo
                .getCharObjectFieldWithMinValueOnly();
        PogoValidationSteps.theObjectShouldNotBeNull( charObjectFieldWithMinValueOnly );
        PogoValidationSteps.theCharValueShouldBeGreaterOrEqualThan( charObjectFieldWithMinValueOnly,
                ( char ) PogoTestConstants.NUMBER_INT_MIN_VALUE );
        Character charObjectFieldWithMinAndMaxValue = pojo
                .getCharObjectFieldWithMinAndMaxValue();
        PogoValidationSteps.theObjectShouldNotBeNull( charObjectFieldWithMinAndMaxValue );
    }


    @Test
    public void PogoShouldHandleBooleanValuesWithThePogoBooleanValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        BooleanValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( BooleanValuePojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        Boolean boolObjectDefaultToTrue = pojo.getBoolObjectDefaultToTrue();
        PogoValidationSteps.theObjectShouldNotBeNull( boolObjectDefaultToTrue );
    }

    @Test
    public void PogoShouldHandleFloatValuesWithThePogoFloatValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        FloatValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( FloatValuePojo.class, PogoFactory );
        Assert.assertNotNull( "The pojo cannot be null!", pojo );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
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
    }


    @Test
    public void PogoShouldHandleDoubleValuesWithThePogoDoubleValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
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
        Double doubleObjectFieldWithPreciseValue = pojo
                .getDoubleObjectFieldWithPreciseValue();
        PogoValidationSteps.theObjectShouldNotBeNull( doubleObjectFieldWithPreciseValue );
    }

    @Test
    public void PogoShouldAssignPreciseValuesWithTheStringValueAnnotation() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        StringValuePojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( StringValuePojo.class, PogoFactory );
        String twentyLengthString = pojo.getTwentyLengthString();
        PogoValidationSteps.theObjectShouldNotBeNull( twentyLengthString );
        String preciseValueString = pojo.getPreciseValueString();
        PogoValidationSteps.theObjectShouldNotBeNull( preciseValueString );
    }


    @Test
    public void thePogoCollectionAnnotationShouldWorkOnAllCollections() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
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
        PogoFactory PogoFactory = new PogoFactoryImpl();
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
