/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.pdm43;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.PodamFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.pdm43.ConcreteBusinessObject;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for <a href="http://www.jemos.eu/jira/browse/PDM-43">PDM-43</a>.
 *
 * @author mtedone
 *
 */
public class Pdm43UnitTest
{

    @Test
    public void validateDtoInstantiation()
    {
        PodamFactory podamFactory = new PodamFactoryImpl();
        ConcreteBusinessObject pojo = podamFactory
                                      .manufacturePojo( ConcreteBusinessObject.class );
        assertNotNull( "The created POJO cannot be null!", pojo );
    }

}
