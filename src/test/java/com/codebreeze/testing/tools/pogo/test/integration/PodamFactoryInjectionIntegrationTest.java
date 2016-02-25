/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.integration;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.api.PodamFactoryImpl;
import com.codebreeze.testing.tools.pogo.api.RandomDataProviderStrategyImpl;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author mtedone
 *
 */
public class PodamFactoryInjectionIntegrationTest
{

    // ------------------->> Constants

    // ------------------->> Instance / Static variables

    /** The Podam Factory */
    private final PodamFactory factory = new PodamFactoryImpl( new RandomDataProviderStrategyImpl() );

    // ------------------->> Constructors

    // ------------------->> Public methods

    @Before
    public void init()
    {
        assertNotNull( "The PODAM factory cannot be null!", factory );
        assertNotNull( "The factory strategy cannot be null!",
                       factory.getStrategy() );
    }

    @Test
    public void testSimplePojo()
    {
        SimplePojoToTestSetters pojo = factory
                                       .manufacturePojo( SimplePojoToTestSetters.class );
        assertNotNull( "The pojo cannot be null!", pojo );
        int intField = pojo.getIntField();
        assertTrue( "The int field cannot be zero!", intField != 0 );
        String stringField = pojo.getStringField();
        assertNotNull( "The string field cannot be null!", stringField );
    }
}
