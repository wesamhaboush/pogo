package com.codebreeze.testing.tools.pogo.test.unit.issue86;

import com.codebreeze.testing.tools.pogo.api.*;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat( pojo ).as( "The pojo cannot be null" )
        .isNotNull();
        assertThat( pojo.getMyLong() ).as( "The long value cannot be zero" )
        .isNotNull();
        assertThat( pojo.getMyString() ).as( "The string value cannot be null" )
        .isNotNull();
        assertThat( pojo.getMyString().length() ).as( "The string value cannot be empty" )
        .isGreaterThan( 0 );
    }
}
