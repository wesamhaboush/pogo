package com.codebreeze.testing.tools.pogo.test.unit.features.externalFactory;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExternalFactoryUnitTest extends AbstractPogoSteps
{

    @Test
    public void
    should_not_create_interface_instances_given_an_external_factory_which_does_not_manufacture_the_concrete_type()
    throws Exception
    {
        //given
        TestExternalFactory externalFactory = new TestExternalFactory();
        PogoFactory pogoFactory = new PogoFactoryImpl( externalFactory );
        //when
        InterfacePojo pojo = pogoFactory.manufacturePojo( InterfacePojo.class );
        //then
        assertThat( pojo ).isNull();
        assertThat( externalFactory.getFailures() ).hasSize( 1 );
        assertThat( externalFactory.getFailures().get( 0 ) ).isSameAs( InterfacePojo.class );
        assertThat( externalFactory.getFullDataCalls() ).isEmpty();
    }

    @Test
    public void should_not_fill_interface_attributes_if_the_external_factory_does_not_manufacture_the_right_type() throws
        Exception
    {
        //given
        TestExternalFactory externalFactory = new TestExternalFactory();
        PogoFactory pogoFactory = new PogoFactoryImpl( externalFactory );
        //when
        PojoWithInterfaces pojo = pogoFactory.manufacturePojo( PojoWithInterfaces.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( externalFactory.getFailures() ).contains( ObjectExt.class, InterfacePojo.class );
        assertThat( externalFactory.getFullDataCalls() ).isEmpty();
    }

    @Test
    public void should_fill_pojo_interface_attribute_if_full_constructor_sets_its_value() throws Exception
    {
        //given
        TestExternalFactory externalFactory = new TestExternalFactory();
        PogoFactory pogoFactory = new PogoFactoryImpl( externalFactory );
        //when
        PojoWithInterfaces pojo = pogoFactory.manufacturePojoWithFullData( PojoWithInterfaces.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( externalFactory.getFailures() ).hasSize( 2 );
        assertThat( externalFactory.getFailures() ).contains( ObjectExt.class, InterfacePojo.class );
        assertThat( externalFactory.getFullDataCalls() ).hasSize( 2 );
    }

    @Test
    public void should_not_create_instances_of_abstract_classes_if_external_factory_does_not_define_them() throws Exception
    {
        //given
        TestExternalFactory externalFactory = new TestExternalFactory();
        PogoFactory pogoFactory = new PogoFactoryImpl( externalFactory );
        //when
        AbstractClass pojo = pogoFactory.manufacturePojo( AbstractClass.class );
        //then
        assertThat( pojo ).isNull();
        assertThat( externalFactory.getFailures() ).hasSize( 1 );
        assertThat( externalFactory.getFailures() ).contains( AbstractClass.class );
        assertThat( externalFactory.getFullDataCalls() ).isEmpty();
    }

    @Test
    public void should_not_create_instances_of_an_abstract_class_even_if_pojo_has_full_constructor() throws Exception
    {
        //given
        TestExternalFactory externalFactory = new TestExternalFactory();
        PogoFactory pogoFactory = new PogoFactoryImpl( externalFactory );
        //when
        AbstractClass pojo = pogoFactory.manufacturePojoWithFullData( AbstractClass.class );
        //then
        assertThat( pojo ).isNull();
        assertThat( externalFactory.getFailures() ).hasSize( 1 );
        assertThat( externalFactory.getFailures() ).contains( AbstractClass.class );
        assertThat( externalFactory.getFullDataCalls() ).hasSize( 1 );
    }

    @Test
    public void should_not_create_instances_of_non_instantiable_classes() throws Exception
    {
        //given
        TestExternalFactory externalFactory = new TestExternalFactory();
        PogoFactory pogoFactory = new PogoFactoryImpl( externalFactory );
        //when
        NonInstantiatableClass pojo = pogoFactory.manufacturePojo( NonInstantiatableClass.class );
        //then
        assertThat( pojo ).isNull();
        assertThat( externalFactory.getFailures() ).hasSize( 1 );
        assertThat( externalFactory.getFailures() ).contains( NonInstantiatableClass.class );
        assertThat( externalFactory.getFullDataCalls() ).isEmpty();
    }

    @Test
    public void should_manage_external_factories_correctly_and_allow_chainging() throws Exception
    {
        //WHEN
        TestExternalFactory externalFactory = new TestExternalFactory();
        //then
        assertThat( externalFactory.getClassStrategy() ).isNull();
        assertThat( externalFactory ).isSameAs( externalFactory.setClassStrategy( null ) );
        assertThat( externalFactory.getStrategy() ).isNull();
        assertThat( externalFactory ).isSameAs( externalFactory.setStrategy( null ) );
        assertThat( externalFactory.getExternalFactory() ).isNull();
        assertThat( externalFactory ).isSameAs( externalFactory.setExternalFactory( null ) );
    }
}
