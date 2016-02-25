package com.codebreeze.testing.tools.pogo.test.dto.pdm4;

import com.codebreeze.testing.tools.pogo.common.PogoConstructor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo to test to test multiple constructors and setters
 *
 * @author divanov
 *
 */
public class Pdm4PojoWithSetters
{

    public static final List<String> invocationOrder = new ArrayList<>();

    private String value;

    public Pdm4PojoWithSetters( InputStream inputStream )
    {
        invocationOrder.add( "InputStream" );
        throw new IllegalStateException( "Cannot use me also" );
    }

    public Pdm4PojoWithSetters( int num, int num2 )
    {
        invocationOrder.add( "int,int" );
        throw new IllegalStateException( "Cannot use me neither" );
    }

    public Pdm4PojoWithSetters( InputStream inputStream, int num )
    {
        invocationOrder.add( "abstract,int" );
        throw new IllegalStateException( "Cannot use me also" );
    }

    @PogoConstructor( comment = "choose this one" )
    public Pdm4PojoWithSetters( String value )
    {
        invocationOrder.add( "PogoConstructor" );
        throw new IllegalStateException( "Cannot use me" );
    }

    public Pdm4PojoWithSetters()
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
