package com.codebreeze.testing.tools.pogo.test.unit.features.constructors;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyAbstract;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyComplexTypesPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ReadOnlyGenericComplexTypesPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.beans.beancontext.BeanContextServicesSupport;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadOnlyComplexTypesTest extends AbstractPogoSteps
{

    @Test
    public void should_fill_read_only_types() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ReadOnlyComplexTypesPojo pojo = pogoFactory.manufacturePojo( ReadOnlyComplexTypesPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getValue() ).isNotNull();
        assertThat( pojo.getValue().getValue() ).isNotNull();
        assertThat( pojo.getList() ).isNotNull().isNotEmpty().hasOnlyElementsOfType( Integer.class );
        assertThat( pojo.getMap() ).isNotNull().isNotEmpty().has( onlyEntriesWithKeyValueTypes( Long.class, String.class ) );
    }

    private Condition<? super Map<?, ?>> onlyEntriesWithKeyValueTypes( Class<?> keyClass, Class<?> valueClass )
    {
        return new Condition<Map<?, ?>>()
        {
            @Override
            public boolean matches( Map<?, ?> map )
            {
                return map.entrySet().stream().allMatch( e -> e.getKey().getClass() == keyClass &&
                        e.getValue().getClass() == valueClass );
            }
        };
    }

    @Test
    public void should_fill_read_only_complex_types() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ReadOnlyGenericComplexTypesPojo<?, ?, ?> pojo = pogoFactory.manufacturePojo( ReadOnlyGenericComplexTypesPojo.class,
                Character.class, Long.class, Integer.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getList() ).isNotNull().isNotEmpty().hasOnlyElementsOfType( Long.class );
        assertThat( pojo.getMap() ).isNotNull().isNotEmpty().has( onlyEntriesWithKeyValueTypes( Integer.class, String.class ) );
        assertThat( pojo.getValue() ).isNotNull();
        assertThat( pojo.getValue().getValue() ).isNotNull().isInstanceOf( Character.class );
    }

    @Test
    public void should_fill_in_pojos_which_contain_internal_loops() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        BeanContextServicesSupport pojo = pogoFactory.manufacturePojo( BeanContextServicesSupport.class );
        //then
        assertThat( pojo ).isNotNull();
    }


    @Test
    public void should_create_an_instance_of_an_abstract_class_with_a_factory_method_which_returns_a_concrete_type()
    throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ReadOnlyAbstract pojo = pogoFactory.manufacturePojo( ReadOnlyAbstract.class );
        //
        assertThat( pojo ).isNotNull();
    }
}
