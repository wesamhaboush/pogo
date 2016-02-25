package com.codebreeze.testing.tools.pogo.test.unit.features.typeManufacturing;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PodamConstants;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapperForGenericTypes;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePodamEnum;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeManufacturingTest extends AbstractPodamSteps
{

    @Test
    public void podamMessagingSystemShouldReturnAnIntValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, int.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theIntFieldShouldNotBeZero( ( Integer ) value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAnIntegerValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Integer.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theIntFieldShouldNotBeZero( ( Integer ) value );
    }

    @Test
    public void podamMessagingSystemShouldReturnABooleanPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, boolean.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theBooleanValueIsTrue( ( Boolean ) value );
    }

    @Test
    public void podamMessagingSystemShouldReturnABooleanWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Boolean.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theBooleanValueIsTrue( ( Boolean ) value );
    }

    @Test
    public void podamMessagingSystemShouldReturnACharacterPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, char.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnACharacterWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Character.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAShortPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, short.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAShortWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Short.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnABytePrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, byte.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAByteWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Byte.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnALongPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, long.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnALongWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Long.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAFloatPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, float.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAFloatWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Float.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnADoublePrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, double.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnADoubleWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Double.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }


    @Test
    public void podamMessagingSystemShouldReturnAStringValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, String.class.getName() );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAnEnumValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnAttributeMetadataForEnums
                                              ( ExternalRatePodamEnum.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper,
                       PodamConstants.ENUMERATION_QUALIFIER );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void podamMessagingSystemShouldReturnAGenericTypeValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = podamFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = podamFactorySteps.givenAnAttributeMetadataForGenericTypes
                                              ( ClassGenericConstructorPojo.class );
        podamValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        Map<String, Type> genericTypeArgumentsMap = new HashMap<>();
        genericTypeArgumentsMap.put( "T", String.class );
        TypeManufacturerParamsWrapperForGenericTypes paramsWrapper =
            new TypeManufacturerParamsWrapperForGenericTypes( dataProviderStrategy, attributeMetadata,
                    genericTypeArgumentsMap, String.class );
        Object value = podamInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper,
                       PodamConstants.GENERIC_TYPE_QUALIFIER );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theObjectShouldNotBeNull( value );
        podamValidationSteps.theTwoObjectsShouldBeEqual( String.class, value );
    }
}
