package com.codebreeze.testing.tools.pogo.test.unit.features.typeManufacturing;

import com.codebreeze.testing.tools.pogo.api.AttributeMetadata;
import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.RandomDataProviderStrategyImpl;
import com.codebreeze.testing.tools.pogo.api.TypeProcessor;
import com.codebreeze.testing.tools.pogo.common.PogoConstants;
import com.codebreeze.testing.tools.pogo.test.dto.ClassGenericConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePogoEnum;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapper;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapperForGenericTypes;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TypeManufacturingTest
{

    @Test
    public void should_return_int_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper = new TypeManufacturerParamsWrapper( dataProviderStrategy,
                attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, int.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_integer_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Integer.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_boolean_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, boolean.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_boolean_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Boolean.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_char_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, char.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_character_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Character.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_short_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, short.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_short_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Short.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_byte_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, byte.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_byte_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Byte.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_long_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, long.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_long_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Long.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_float_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, float.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_float_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Float.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_double_primitive_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, double.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_a_double_wrapped_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, Double.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }


    @Test
    public void should_return_a_string_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata =  new AttributeMetadata( null, null, new Type[0], SimplePojoToTestSetters.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, String.class.getName() );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
    }

    @Test
    public void should_return_an_enum_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata = new AttributeMetadata(
            null, ExternalRatePogoEnum.class, new Type[0], ExternalRatePogoEnum.class );
        TypeManufacturerParamsWrapper paramsWrapper =
            new TypeManufacturerParamsWrapper( dataProviderStrategy, attributeMetadata );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, PogoConstants.ENUMERATION_QUALIFIER );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
        assertThat( value ).isInstanceOf( ExternalRatePogoEnum.class );
    }

    @Test
    public void should_return_a_generic_type_value() throws Exception
    {
        //given
        DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();
        AttributeMetadata attributeMetadata = new AttributeMetadata(
            null, ClassGenericConstructorPojo.class, ClassGenericConstructorPojo.class.getTypeParameters(),
            ClassGenericConstructorPojo.class );
        Map<String, Type> genericTypeArgumentsMap = new HashMap<>();
        genericTypeArgumentsMap.put( "T", String.class );
        TypeManufacturerParamsWrapperForGenericTypes paramsWrapper =
            new TypeManufacturerParamsWrapperForGenericTypes( dataProviderStrategy, attributeMetadata,
                    genericTypeArgumentsMap, String.class );
        //when
        Object value = new TypeProcessor().process( paramsWrapper, PogoConstants.GENERIC_TYPE_QUALIFIER );
        //then
        assertThat( attributeMetadata ).isNotNull();
        assertThat( value ).isNotNull();
        assertThat( value ).isInstanceOf( String.class.getClass() );
    }
}
