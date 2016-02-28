package com.codebreeze.testing.tools.pogo.test.unit.features.annotations;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.ConstructorWithSelfReferencesPojoAndDefaultConstructor;
import com.codebreeze.testing.tools.pogo.test.dto.ImmutableNoHierarchicalAnnotatedPojo;
import com.codebreeze.testing.tools.pogo.test.dto.annotations.*;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.condition.Not.not;

public class AnnotationsTest
{


    @Test
    public void should_handle_immutable_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutableNoHierarchicalAnnotatedPojo pojo = pogoFactory.manufacturePojo( ImmutableNoHierarchicalAnnotatedPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getDateCreated() ).isNotNull();
        assertThat( pojo.getDateCreated().getTime() ).isNotNull();
        assertThat( pojo.getLongArray() ).isNotNull().isNotEmpty();
    }

    @Test
    public void should_handle_pojos_with_self_referencing_constructors_and_default_one_too() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ConstructorWithSelfReferencesPojoAndDefaultConstructor pojo = pogoFactory.manufacturePojo(
                    ConstructorWithSelfReferencesPojoAndDefaultConstructor.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getParent() ).isNull();
        assertThat( pojo.getAnotherParent() ).isNull();
    }

    @Test
    public void should_handle_integer_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        IntegerValuePojo pojo = pogoFactory.manufacturePojo( IntegerValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getIntegerObject() ).isNotNull();
    }

    @Test
    public void should_handle_long_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        LongValuePojo pojo = pogoFactory.manufacturePojo( LongValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getLongObject() ).isNotNull();
    }

    @Test
    public void should_handle_byte_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ByteValuePojo pojo = pogoFactory.manufacturePojo( ByteValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getByteObject() ).isNotNull();
    }

    @Test
    public void should_handle_short_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ShortValuePojo pojo = pogoFactory.manufacturePojo( ShortValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getShortObject() ).isNotNull();
    }

    @Test
    public void should_handle_char_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //
        CharValuePojo pojo = pogoFactory.manufacturePojo( CharValuePojo.class );
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getCharObject() ).isNotNull();
    }


    @Test
    public void PogoShouldHandleBooleanValuesWithThePogoBooleanValueAnnotation() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        BooleanValuePojo pojo = pogoFactory.manufacturePojo( BooleanValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getBooleanObject() ).isNotNull();
    }

    @Test
    public void should_handle_float_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        FloatValuePojo pojo = pogoFactory.manufacturePojo( FloatValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getFloatObject() ).isNotNull();
    }


    @Test
    public void should_handle_double_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        DoubleValuePojo pojo = pogoFactory.manufacturePojo( DoubleValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getDoubleObject() ).isNotNull();
    }

    @Test
    public void should_handle_string_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        StringValuePojo pojo = pogoFactory.manufacturePojo( StringValuePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getString() ).isNotNull();
    }


    @Test
    public void thePogoCollectionAnnotationShouldWorkOnAllCollections() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        CollectionAnnotationPojo pojo =
            pogoFactory.manufacturePojo( CollectionAnnotationPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getStrList() )
        .doNotHave( emptyStrings )
        .isNotNull()
        .isNotEmpty();
        assertThat( pojo.getStrArray() )
        .isNotNull()
        .isNotEmpty();
        assertThat( pojo.getStringMap() )
        .has( onlyNonEmptyEntries );
    }

    @Test
    public void PogoShouldAssignExactValuesDefinedInPogoStrategyValueAnnotation() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        PogoStrategyPojo pojo = pogoFactory.manufacturePojo( PogoStrategyPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getByteData() ).isNotNull().isNotEmpty();
        assertThat( pojo.getMyBirthdays() )
        .isNotNull()
        .isNotEmpty()
        .areAtLeastOne( not( nullValue ) );
        assertThat( pojo.getObjectList() )
        .isNotNull()
        .isNotEmpty()
        .areAtLeastOne( not( nullValue ) );
        assertThat( pojo.getMyObjectArray() )
        .isNotNull()
        .isNotEmpty()
        .areAtLeastOne( not( nullValue ) );
        assertThat( pojo.getNonGenericObjectList() )
        .areAtLeastOne( not( nullValue ) )
        .isNotNull();
        assertThat( pojo.getMyBirthdaysMap() )
        .isNotEmpty()
        .isNotNull()
        .has( atLeastOneNoneEmptyElement );
    }

    private final Condition<String> emptyStrings = new Condition<String>( "not empty" )
    {
        @Override
        public boolean matches( String actual )
        {
            return actual.length() == 0;
        }
    };

    private final Condition<Map<String, String>> onlyNonEmptyEntries = new Condition<Map<String, String>>( "not empty" )
    {
        @Override
        public boolean matches( Map<String, String> actual )
        {
            return actual.entrySet().stream().allMatch(
                       e -> e.getKey().length() > 0
                       && e.getValue().length() > 0
                   );
        }
    };

    private final Condition<Object> nullValue = new Condition<Object>()
    {
        @Override
        public boolean matches( Object actual )
        {
            return actual == null;
        }
    };

    private final Condition<Map<?, ?>> atLeastOneNoneEmptyElement =
        new Condition<Map<?, ?>>( "not empty" )
    {
        @Override
        public boolean matches( Map<?, ?> actual )
        {
            return actual.entrySet().stream().anyMatch(
                       e -> e.getKey() != null
                       && e.getValue() != null
                   );
        }
    };
}
