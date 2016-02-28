package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.Parent;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveList;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveMap;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class PogoFactoryBasicTypesTest
{

    @Test
    public void should_generate_basic_types() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        OneDimensionalTestPojo oneDimensionalTestPojo = pogoFactory.manufacturePojo( OneDimensionalTestPojo.class );
        //then
        assertThat( oneDimensionalTestPojo ).isNotNull();
        assertThat( oneDimensionalTestPojo.getClass().getDeclaredFields()[0] ).isNotNull();
        assertThat( oneDimensionalTestPojo.getBooleanObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getByteObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getShortObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getCharObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getIntObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getLongObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getFloatObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getDoubleObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getStringField() ).isNotEmpty();
        assertThat( oneDimensionalTestPojo.getObjectField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getCalendarField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getCalendarField().getTime() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getDateField() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getRandomArray() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getRandomArray()[0] ).isNotNull();
        assertThat( oneDimensionalTestPojo.getIntArray() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getIntArray()[0] ).isNotNull();
        assertThat( oneDimensionalTestPojo.getBooleanArray() ).isNotNull();
        assertThat( oneDimensionalTestPojo.getBooleanArray()[0] ).isNotNull();
        assertThat( oneDimensionalTestPojo.getBigDecimalField() ).isNotNull();
    }

    @Test
    public void should_fill_pojos_with_non_default_constructor() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        NoDefaultConstructorPojo pojo = pogoFactory.manufacturePojo( NoDefaultConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
    }

    @Test
    public void should_return_null_pojo_when_pojo_class_is_abstract() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        AbstractTestPojo pojo = pogoFactory.manufacturePojo( AbstractTestPojo.class );
        //then
        assertThat( pojo ).isNull();
    }

    @Test
    public void should_return_empty_pojo_with_interfaces() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        InterfacePojo pojo = pogoFactory.manufacturePojo( InterfacePojo.class );
        //then
        assertThat( pojo ).isNull();
    }


    @Test
    public void should_fill_recusive_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        RecursivePojo recursivePojo = pogoFactory.manufacturePojo( RecursivePojo.class );
        //then
        assertThat( recursivePojo ).isNotNull();
        assertThat( recursivePojo.getParent() ).isNotNull();
        assertThat( recursivePojo.getParent().getParent() ).isNotNull();
    }

    @Test
    public void should_fill_recursive_pojo_when_population_is_required() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        RecursivePojo pojo = new RecursivePojo();
        //when
        pogoFactory.populatePojo( pojo );
        //then
        assertThat( pojo.getParent() ).isNotNull();
        assertThat( pojo.getParent().getParent() ).isNotNull();
    }

    @Test
    public void should_support_circular_dependencies() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        Parent parent = pogoFactory.manufacturePojo( Parent.class );
        //then
        assertThat( parent ).isNotNull();
        assertThat( parent.getChild() ).isNotNull();
    }

    @Test
    public void should_support_recursive_lists() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        RecursiveList recursiveListPojo = pogoFactory.manufacturePojo( RecursiveList.class );
        //then
        assertThat( recursiveListPojo ).isNotNull();
        assertThat( recursiveListPojo.getList() )
        .isNotNull()
        .isNotEmpty()
        .are( noNulls );
    }

    @Test
    public void should_support_recursive_maps() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        RecursiveMap recursiveMap = pogoFactory.manufacturePojo( RecursiveMap.class );
        //then
        assertThat( recursiveMap ).isNotNull();
        assertThat( recursiveMap.getMap() ).isNotNull().isNotEmpty();
        assertThat( recursiveMap.getMap() )
        .doesNotContainKey( null )
        .doesNotContainValue( null );
    }

    @Test
    public void should_support_immutable_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutableNonAnnotatedPojo pojo =
            pogoFactory.manufacturePojo( ImmutableNonAnnotatedPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getDateCreated() ).isNotNull();
        assertThat( pojo.getDateCreated().getTime() ).isNotNull();
        assertThat( pojo.getLongArray() ).isNotNull().isNotEmpty();
    }


    @Test
    public void should_support_pojos_with_enum_fileds() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        EnumsPojo pojo = pogoFactory.manufacturePojo( EnumsPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getRatePogoExternal() ).isNotNull();
        assertThat( pojo.getRatePogoInternal() ).isNotNull();
    }

    @Test
    public void should_fill_java_native_types() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        String stringPojo = pogoFactory.manufacturePojoWithFullData( String.class );
        //then
        assertThat( stringPojo ).isNotEmpty().isNotNull();
        //when
        Integer integerPojo = pogoFactory.manufacturePojo( Integer.class );
        //then
        assertThat( integerPojo ).isNotNull();
        //when
        Calendar calendarPojo = pogoFactory.manufacturePojo( GregorianCalendar.class );
        //then
        assertThat( calendarPojo ).isNotNull();
        assertThat( calendarPojo.getTime() ).isNotNull();
        //when
        Date datePojo = pogoFactory.manufacturePojo( Date.class );
        //then
        assertThat( datePojo ).isNotNull();
        //when
        BigDecimal bigDecimalPojo = pogoFactory.manufacturePojo( BigDecimal.class );
        //then
        assertThat( bigDecimalPojo ).isNotNull();
    }

    @Test
    public void should_fill_arrays_with_elements() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ArrayPojo pojo = pogoFactory.manufacturePojo( ArrayPojo.class );
        //then
        assertThat( pojo.getMyStringArray() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
        assertThat( pojo.getMyObjectArray() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( Object.class );
    }

    private static final Condition<RecursiveList> noNulls = new Condition<RecursiveList>()
    {
        @Override
        public boolean matches( RecursiveList recursiveList )
        {
            return recursiveList != null;
        }
    };

}
