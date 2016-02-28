package com.codebreeze.testing.tools.pogo.test.unit.features.constructors;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.assertj.core.api.Condition;
import org.junit.Test;

import javax.xml.bind.JAXBElement;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructorsUnitTest extends AbstractPogoSteps
{
    private Condition<? super Map<?, ?>> nonEmptyElements = new Condition<Map<?, ?>>()
    {
        @Override
        public boolean matches( Map<?, ?> map )
        {
            return map.entrySet().stream().anyMatch(
                       e -> e.getKey() != null && e.getValue() != null
                   );
        }
    };

    private Condition<List<? extends String>> noNullElements = new Condition<List<? extends String>>()
    {
        @Override
        public boolean matches( List<? extends String> list )
        {
            return list.stream().allMatch( e -> e != null );
        }
    };

    @Test
    public void should_handle_generics_in_constructor() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        GenericInConstructorPojo pojo = pogoFactory.manufacturePojo( GenericInConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getVector() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
    }

    @Test
    public void should_handle_generics_in_setters_during_pojo_instantiation() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        GenericInSetterPojo pojo = pogoFactory.manufacturePojo( GenericInSetterPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getVector() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
    }

    @Test
    public void should_handle_generics_in_static_constructors_during_pojo_instantiation() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        GenericInStaticConstructorPojo pojo = pogoFactory.manufacturePojo( GenericInStaticConstructorPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getVector() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
    }

    @Test
    public void should_handle_constructors_with_generic_arrays_during_pojo_instantiation()
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        GenericArrayInConstructorPojo<?> pojo = pogoFactory.manufacturePojo( GenericArrayInConstructorPojo.class,
                                                String.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getArray() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
    }

    @Test
    public void should_handle_constructors_with_multiple_generics_during_pojo_instantiation()
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        MultipleGenericInConstructorPojo<?, ?, ?, ?> pojo = pogoFactory.manufacturePojo(
                    MultipleGenericInConstructorPojo.class,
                    String.class,
                    Character.class,
                    Byte.class,
                    Integer.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getType() ).isEqualTo( String.class );
        assertThat( pojo.getList() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( Character.class );
        assertThat( pojo.getMap() )
        .isNotNull()
        .isNotEmpty()
        .has( onlyEntriesWithKeyValueTypes( Byte.class, Integer.class ) );
    }

    private Condition<? super Map<?, ?>> onlyEntriesWithKeyValueTypes( Class<?> keyClass, Class<?> valueClass )
    {
        return new Condition<Map<?, ?>>()
        {
            @Override
            public boolean matches( Map<?, ?> map )
            {
                return map.entrySet().stream().allMatch( e -> e.getKey().getClass() == keyClass
                        && e.getValue().getClass() == valueClass );
            }
        };
    }

    @Test
    public void should_handle_classes_with_key_value_generic_types() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        DefaultFieldPojo<?, ?> pojo = pogoFactory.manufacturePojo( DefaultFieldPojo.class, String.class, Long.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getMap() )
        .isNotNull()
        .isNotEmpty()
        .has( onlyEntriesWithKeyValueTypes( String.class, Long.class ) );
    }


    @Test
    public void should_support_instances_observable_class() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        Observable observable = pogoFactory.manufacturePojo( Observable.class );
        //then
        assertThat( observable ).isNotNull();
    }

    @Test
    public void should_support_manufacturing_pojos_with_immutable_collections() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutableDefaultFieldsPojo model = pogoFactory.manufacturePojo( ImmutableDefaultFieldsPojo.class );
        //then
        assertThat( model ).isNotNull();
        assertThat( model.getList() )
        .isNotNull()
        .isNotEmpty()
        .hasSize( pogoFactory.getStrategy().getNumberOfCollectionElements( model.getList().getClass() ) )
        .has( noNullElements );
        assertThat( model.getMap() )
        .isNotNull()
        .isNotEmpty()
        .has( nonEmptyElements )
        .hasSize( pogoFactory.getStrategy().getNumberOfCollectionElements( model.getMap().getClass() ) );
    }

    @Test
    public void should_support_manufacturing_any_collection_type() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        UnsupportedCollectionInConstructorPojo<?> pojo = pogoFactory.manufacturePojo(
                    UnsupportedCollectionInConstructorPojo.class, String.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getVector() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
    }

    @Test
    public void should_manufacture_any_map_type() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        UnsupportedMapInConstructorPojo<?, ?> pojo = pogoFactory.manufacturePojo( UnsupportedMapInConstructorPojo.class,
                String.class, Integer.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getHashTable() )
        .isNotNull()
        .isNotEmpty()
        .has( onlyEntriesWithKeyValueTypes( String.class, Integer.class ) );
    }

    @Test
    public void should_support_pojos_with_immutable_collections() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutableVector<?> pojo = pogoFactory.manufacturePojo( ImmutableVector.class, String.class );
        //then
        assertThat( pojo ).isNotNull().isEmpty();
    }

    @Test
    public void should_instantiate_pojos_with_immutable_maps() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutableHashtable<?, ?> pojo = pogoFactory.manufacturePojo( ImmutableHashtable.class, String.class, Integer.class );
        //then
        assertThat( pojo ).isNotNull().isEmpty();
    }

    @Test
    public void should_instantiate_abstract_classes_for_which_it_knows_concrete_types()
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        TimeZone pojo = pogoFactory.manufacturePojo( TimeZone.class );
        //then
        assertThat( pojo ).isNotNull();
    }

    @Test
    public void should_create_instances_of_generic_pojos_with_factory_methods_when_the_concrete_type_is_known() throws
        Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        FactoryInstantiablePojo<?> pojo = pogoFactory.manufacturePojo( FactoryInstantiablePojo.class, Date.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getTypedValue() )
        .isNotNull()
        .isInstanceOf( Date.class );
    }

    @Test
    public void should_choose_the_fullest_constructor_when_invoked_for_full_data() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutablePojo pojo = pogoFactory.manufacturePojoWithFullData( ImmutablePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getValue() ).isNotNull();
        assertThat( pojo.getValue2() ).isNotNull();
    }

    @Test
    public void should_fail_with_immutable_pojo() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ImmutablePojo pojo = pogoFactory.manufacturePojo( ImmutablePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getValue() ).isNull();
        assertThat( pojo.getValue2() ).isNull();
    }

    @Test
    public void should_create_instances_of_inner_classes() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        InnerClassPojo pojo = pogoFactory.manufacturePojo( InnerClassPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getIp() ).isNotNull();
    }


    @Test
    public void should_create_instances_of_jaxb_elements() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        JAXBElement<String> pojo = pogoFactory.manufacturePojo( JAXBElement.class, String.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getName() ).isNotNull();
        assertThat( pojo.getValue() )
        .isNotNull()
        .isInstanceOf( String.class );
    }

    @Test
    public void should_create_instances_of_jaxb_element_declared_as_instance_variables_in_a_pojo() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        JAXBElementPojo<String> pojo = pogoFactory.manufacturePojo( JAXBElementPojo.class, String.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getValue() ).isNotNull();
        assertThat( pojo.getValue().getName() ).isNotNull();
        assertThat( pojo.getValue().getValue() ).isNotNull().isInstanceOf( String.class );
    }

    @Test
    public void should_manufacture_package_private_pojos() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        PackagePrivatePojo pojo = pogoFactory.manufacturePojo( PackagePrivatePojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getValue() ).isNotNull();
    }


    @Test
    public void should_create_instances_of_pojos_extending_generic_classes() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        TypedClassPojo2 pojo = pogoFactory.manufacturePojo( TypedClassPojo2.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getTypedValue() ).isNotNull().isInstanceOf( String.class );
        assertThat( pojo.getTypedList() )
        .isNotNull()
        .isNotEmpty()
        .hasOnlyElementsOfType( String.class );
    }
}
