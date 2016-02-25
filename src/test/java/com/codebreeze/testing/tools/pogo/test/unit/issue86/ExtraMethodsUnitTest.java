package com.codebreeze.testing.tools.pogo.test.unit.issue86;

import com.codebreeze.testing.tools.pogo.api.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExtraMethodsUnitTest
{


    private final DataProviderStrategy dataProviderStrategy = new RandomDataProviderStrategyImpl();

    private final AbstractClassInfoStrategy classInfoStrategy = DefaultClassInfoStrategy.getInstance();

    private final PogoFactory Pogo = new PogoFactoryImpl( dataProviderStrategy );

    @Before
    public void setup() throws Exception
    {
        classInfoStrategy.addExtraMethod( ExtraMethodsPojo.class, "setMyString", String.class );
        classInfoStrategy.addExtraMethod( ExtraMethodsPojo.class, "setMyLong", Long.class );
    }

    @Test
    public void testExtraMethods() throws Exception
    {
        ExtraMethodsPojo pojo = Pogo.manufacturePojo( ExtraMethodsPojo.class );
        assertNotNull( "The pojo cannot be null", pojo );
        assertNotNull( "The long value cannot be zero", pojo.getMyLong() );
        assertNotNull( "The string value cannot be null", pojo.getMyString() );
        assertTrue( "The string value cannot be empty", pojo.getMyString().length() > 0 );
    }
}
