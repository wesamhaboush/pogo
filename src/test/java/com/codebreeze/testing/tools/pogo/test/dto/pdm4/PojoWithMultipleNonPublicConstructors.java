package com.codebreeze.testing.tools.pogo.test.dto.pdm4;

import com.codebreeze.testing.tools.pogo.common.PodamConstructor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo to test to test multiple non-public constructors and setters
 *
 * @author divanov
 *
 */
public class PojoWithMultipleNonPublicConstructors
{

    public static final List<String> invocationOrder = new ArrayList<>();

    private String value;

    protected PojoWithMultipleNonPublicConstructors( InputStream inputStream )
    {
        invocationOrder.add( "InputStream" );
        throw new IllegalStateException( "Cannot use me also" );
    }

    protected PojoWithMultipleNonPublicConstructors( int num, int num2 )
    {
        invocationOrder.add( "int,int" );
        throw new IllegalStateException( "Cannot use me neither" );
    }

    protected PojoWithMultipleNonPublicConstructors( InputStream inputStream, int num )
    {
        invocationOrder.add( "abstract,int" );
        throw new IllegalStateException( "Cannot use me also" );
    }

    @PodamConstructor( comment = "choose this one" )
    private PojoWithMultipleNonPublicConstructors( String value )
    {
        invocationOrder.add( "PodamConstructor" );
        throw new IllegalStateException( "Cannot use me" );
    }

    protected PojoWithMultipleNonPublicConstructors()
    {
        invocationOrder.add( "no-op" );
        throw new IllegalStateException( "Cannot use me too" );
    }

    public void setValue( String value )
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return String.format( "{value: '%s'}", value );
    }
}
