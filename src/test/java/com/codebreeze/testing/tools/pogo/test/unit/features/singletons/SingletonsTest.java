package com.codebreeze.testing.tools.pogo.test.unit.features.singletons;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.OneDimensionalTestPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SingletonWithParametersInStaticFactoryPojo;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonsTest
{


    private Condition<? super Map<?, ?>> atLeastOneNonEmptyElement = new Condition<Map<?, ?>>()
    {
        @Override
        public boolean matches( Map<?, ?> map )
        {
            return map.entrySet().stream().anyMatch( e -> e.getKey() != null && e.getValue() != null );
        }
    };

    @Test
    public void should_handle_singletons_with_parameters_in_public_static_Method() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        SingletonWithParametersInStaticFactoryPojo pojo = pogoFactory.manufacturePojo(
                    SingletonWithParametersInStaticFactoryPojo.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getCreateDate() ).isNotNull();
        assertThat( pojo.getFirstName() ).isNotNull().isNotEmpty();
        assertThat( pojo.getPojoList() ).isNotNull().isNotEmpty().hasAtLeastOneElementOfType( OneDimensionalTestPojo.class );
        assertThat( pojo.getPojoMap() ).isNotNull().isNotEmpty().has( atLeastOneNonEmptyElement );
    }

}
