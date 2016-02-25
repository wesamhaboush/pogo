/**
 * Test multiple constructors with setters
 */
package com.codebreeze.testing.tools.pogo.test.unit.pdm5;

import static org.junit.Assert.assertNotNull;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.PodamFactoryImpl;
import org.junit.Test;

import com.codebreeze.testing.tools.pogo.test.dto.pdm5.InvisibleConstructorAndNoSettersPojo;

/**
 * @author divanov
 *
 */
public class InvisibleConstructorAndNoSettersTest
{

    @Test
    public void testInvisibleConstructorAndNoSetters()
    {
        PodamFactory factory = new PodamFactoryImpl();
        InvisibleConstructorAndNoSettersPojo pojo = factory.manufacturePojo(
                    InvisibleConstructorAndNoSettersPojo.class );
        assertNotNull( pojo );
    }
}
