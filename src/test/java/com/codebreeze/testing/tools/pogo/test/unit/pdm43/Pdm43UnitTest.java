/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.pdm43;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.pdm43.ConcreteBusinessObject;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Pdm43UnitTest
{

    @Test
    public void validateDtoInstantiation()
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        ConcreteBusinessObject pojo = pogoFactory
                                      .manufacturePojo( ConcreteBusinessObject.class );
        //then
        assertThat( pojo ).isNotNull();
    }
}
