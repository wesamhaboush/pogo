package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesHolderPojo;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesListPojo;
import com.codebreeze.testing.tools.pogo.test.dto.MultipleInterfacesMapPojo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleInterfacesInheritanceTest
{
    @Test
    public void cannot_instantiate_interfaces() throws Exception
    {
        //given
        PogoFactory pogoFactory = customPogoFactory();
        //when
        MultipleInterfacesListPojo<?> pojo = pogoFactory.manufacturePojo( MultipleInterfacesListPojo.class, String.class );
        //then
        assertThat( pojo ).isNull();
        assertThat( ( ( CustomDataProviderStrategy )pogoFactory.getStrategy() ).getAccessed() )
        .hasSize( 1 )
        .contains( MultipleInterfacesListPojo.class );
    }

    @Test
    public void cannot_instantiate_interfaces_which_extend_map() throws Exception
    {
        //given
        PogoFactory pogoFactory = customPogoFactory();
        //when
        MultipleInterfacesMapPojo<?, ?> pojo = pogoFactory.manufacturePojo( MultipleInterfacesMapPojo.class, String.class,
                                               Long.class );
        //then
        assertThat( pojo ).isNull();
        assertThat( ( ( CustomDataProviderStrategy )pogoFactory.getStrategy() ).getAccessed() )
        .hasSize( 1 )
        .contains( MultipleInterfacesMapPojo.class );
    }

    @Test
    public void test_holder_of_pojo_with_multi_interfaces() throws Exception
    {
        //given
        PogoFactory pogoFactory = customPogoFactory();
        //when
        MultipleInterfacesHolderPojo<?, ?> pojo = pogoFactory.manufacturePojo( MultipleInterfacesHolderPojo.class, String.class,
                Long.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getList() ).isNull();
        assertThat( pojo.getMap() ).isNull();
        assertThat( ( ( CustomDataProviderStrategy )pogoFactory.getStrategy() ).getAccessed() )
        .hasSize( 2 )
        .contains( MultipleInterfacesListPojo.class, MultipleInterfacesMapPojo.class );
    }

    private PogoFactory customPogoFactory()
    {
        TrackingExternalFactory externalFactory = new TrackingExternalFactory();
        CustomDataProviderStrategy customDataProviderStrategy = new CustomDataProviderStrategy();
        return new PogoFactoryImpl( externalFactory, customDataProviderStrategy );
    }
}
