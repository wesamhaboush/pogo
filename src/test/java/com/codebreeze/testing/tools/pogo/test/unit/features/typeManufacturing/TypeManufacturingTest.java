package com.codebreeze.testing.tools.pogo.test.unit.features.typeManufacturing;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.common.PogoConstants;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapperForGenericTypes;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePogoEnum;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeManufacturingTest extends AbstractPogoSteps
{

    @Test
    public void PogoMessagingSystemShouldReturnAnIntValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, int.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theIntFieldShouldNotBeZero( ( Integer ) value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAnIntegerValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Integer.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theIntFieldShouldNotBeZero( ( Integer ) value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnABooleanPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, boolean.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theBooleanValueIsTrue( ( Boolean ) value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnABooleanWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Boolean.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theBooleanValueIsTrue( ( Boolean ) value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnACharacterPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, char.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnACharacterWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Character.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAShortPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, short.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAShortWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Short.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnABytePrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, byte.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAByteWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Byte.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnALongPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, long.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnALongWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Long.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAFloatPrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, float.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAFloatWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Float.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnADoublePrimitiveValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, double.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnADoubleWrappedValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, Double.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }


    @Test
    public void PogoMessagingSystemShouldReturnAStringValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnEmptyAttributeMetadata
                                              ( SimplePojoToTestSetters.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper, String.class.getName() );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAnEnumValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnAttributeMetadataForEnums
                                              ( ExternalRatePogoEnum.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper,
                       PogoConstants.ENUMERATION_QUALIFIER );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
    }

    @Test
    public void PogoMessagingSystemShouldReturnAGenericTypeValue() throws Exception
    {
        DataProviderStrategy dataProviderStrategy = PogoFactorySteps.givenARandomDataProviderStrategy();
        AttributeMetadata attributeMetadata = PogoFactorySteps.givenAnAttributeMetadataForGenericTypes
                                              ( ClassGenericConstructorPojo.class );
        PogoValidationSteps.theObjectShouldNotBeNull( attributeMetadata );
        Map<String, Type> genericTypeArgumentsMap = new HashMap<>();
        genericTypeArgumentsMap.put( "T", String.class );
        TypeManufacturerParamsWrapperForGenericTypes paramsWrapper =
            new TypeManufacturerParamsWrapperForGenericTypes( dataProviderStrategy, attributeMetadata,
                    genericTypeArgumentsMap, String.class );
        Object value = PogoInvocationSteps.whenISendAMessageToTheChannel( paramsWrapper,
                       PogoConstants.GENERIC_TYPE_QUALIFIER );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theObjectShouldNotBeNull( value );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( String.class, value );
    }
}
