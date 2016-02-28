package com.codebreeze.testing.tools.pogo.test.integration;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.api.RandomDataProviderStrategyImpl;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PogoFactoryInjectionIntegrationTest
{
    private final PogoFactory factory = new PogoFactoryImpl( new RandomDataProviderStrategyImpl() );

    @Test
    public void testSimplePojo()
    {
        //when
        SimplePojoToTestSetters pojo = factory
                                       .manufacturePojo( SimplePojoToTestSetters.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getStringField() ).isNotNull();
    }
}
