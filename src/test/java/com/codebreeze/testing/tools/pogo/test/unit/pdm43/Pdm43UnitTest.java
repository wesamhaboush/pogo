/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.pdm43;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.pdm43.ConcreteBusinessObject;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class Pdm43UnitTest
{

    @Test
    public void validateDtoInstantiation()
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        ConcreteBusinessObject pojo = PogoFactory
                                      .manufacturePojo( ConcreteBusinessObject.class );
        assertNotNull( "The created POJO cannot be null!", pojo );
    }

}
