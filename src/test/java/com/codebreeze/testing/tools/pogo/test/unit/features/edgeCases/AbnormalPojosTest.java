package com.codebreeze.testing.tools.pogo.test.unit.features.edgeCases;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.NoDefaultPublicConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.PrivateOnlyConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm33.ProtectedNonDefaultConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;

import javax.activation.DataHandler;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AbnormalPojosTest extends AbstractPogoSteps
{

    @Test
    public void should_generate_non_null_pojo_for_abstract_types_with_concrete_implementation() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        DataProviderStrategy strategy = pogoFactory.getStrategy();
        strategy.addOrReplaceSpecific( AbstractTestPojo.class, ConcreteTestPojo.class );
        AbstractTestPojo pojo = pogoFactory.manufacturePojo( AbstractTestPojo.class );
        //then
        assertThat( pojo ).isNotNull();
    }

    @Test
    public void should_fill_embedded_abstract_classes_if_a_concrete_type_has_been_specified() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        DataProviderStrategy strategy = pogoFactory.getStrategy();
        strategy.addOrReplaceSpecific( AbstractTestPojo.class, ConcreteTestPojo.class );
        EmbeddedAbstractFieldTestPojo pojo = pogoFactory.manufacturePojo( EmbeddedAbstractFieldTestPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getPojo() ).isNotNull();
    }

    @Test
    public void should_return_a_non_empty_pojo_when_invoked_for_a_pojo_with_private_no_args_constructor() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        PrivateNoArgConstructorPojo pojo = pogoFactory.manufacturePojo( PrivateNoArgConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getIntField() ).isNotNull();
    }

    @Test
    public void should_not_handle_circular_constructors() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        URL pojo = pogoFactory.manufacturePojo( URL.class );
        //then
        assertThat( pojo ).isNull();
    }

    @Test
    public void should_handle_pojos_with_a_mix_of_circular_and_non_circular_constructors() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        DataHandler pojo = pogoFactory.manufacturePojo( DataHandler.class );
        //then
        assertThat( pojo ).isNotNull();
    }

    @Test
    public void should_handle_pojos_with_self_reference_constructors_but_not_default_constructors() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ConstructorWithSelfReferencesButNoDefaultConstructorPojo pojo =
            pogoFactory.manufacturePojo( ConstructorWithSelfReferencesButNoDefaultConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getParent() ).isNotNull();
        assertThat( pojo.getAnotherParent() ).isNotNull();
    }

    @Test
    public void should_handle_pojos_with_private_only_constructors() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        PrivateOnlyConstructorPojo pojo =
            pogoFactory.manufacturePojo( PrivateOnlyConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getFirstName() ).isNotEmpty();
        assertThat( pojo.getIntField() ).isNotNull();
    }

    @Test
    public void should_fill_pojos_with_public_non_default_public_constructors() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        NoDefaultPublicConstructorPojo pojo = pogoFactory.manufacturePojo( NoDefaultPublicConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getFirstName() ).isNotEmpty();
        assertThat( pojo.getIntField() ).isNotNull();
    }


    @Test
    public void should_fill_pojos_with_protected_non_default_constructors() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ProtectedNonDefaultConstructorPojo pojo =
            pogoFactory.manufacturePojo( ProtectedNonDefaultConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getFirstName() ).isNotEmpty();
        assertThat( pojo.getIntField() ).isNotNull();
    }


    @Test
    public void should_throw_an_exception_if_a_pojo_contains_invalid_getters_or_setters() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ThrowingCallable creatingPojoWithInvalidSettersOrGetters = () ->
        {
            BadlyTypedPojo pojo = pogoFactory.manufacturePojo( BadlyTypedPojo.class );
        };
        //then
        assertThatExceptionOfType( PogoMockeryException.class )
        .isThrownBy( creatingPojoWithInvalidSettersOrGetters );
    }


    @Test
    public void should_fill_values_invoking_children_setters_having_different_types_than_parent() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        BadlyTypedFixedPojo pojo = pogoFactory.manufacturePojo( BadlyTypedFixedPojo.class );
        //then
        assertThat( pojo ).isNotNull();
    }

    @Test
    public void should_return_a_null_value_for_non_instantiable_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        NonInstantiatableClass innerClassPojo = pogoFactory.manufacturePojo( NonInstantiatableClass.class );
        //then
        assertThat( innerClassPojo ).isNull();
    }
}
