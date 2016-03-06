package com.codebreeze.testing.tools.pogo.test.unit.pdm5;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.pdm5.InvisibleConstructorAndNoSettersPojo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvisibleConstructorAndNoSettersTest
{

    @Test
    public void testInvisibleConstructorAndNoSetters()
    {
        PogoFactory factory = new PogoFactoryImpl();
        InvisibleConstructorAndNoSettersPojo pojo = factory.manufacturePojo(
                    InvisibleConstructorAndNoSettersPojo.class );
        assertThat( pojo ).isNotNull();
    }
}
