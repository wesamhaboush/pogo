package com.codebreeze.testing.tools.pogo.test.dto.pdm4;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class PojoWithFactoryMethods
{

    public static final List<String> invocationOrder = new ArrayList<>();

    private String value;

    public static PojoWithFactoryMethods getInstance( String str, InputStream is )
    {
        invocationOrder.add( "PogoConstructor(str,abstract)" );
        throw new IllegalStateException( "Cannot use me" );
    }

    public static PojoWithFactoryMethods getInstance( InputStream inputStream )
    {
        invocationOrder.add( "InputStream" );
        throw new IllegalStateException( "Cannot use me also" );
    }

    public static PojoWithFactoryMethods getInstance( int num, int num2 )
    {
        invocationOrder.add( "int,int" );
        throw new IllegalStateException( "Cannot use me neither" );
    }

    public static PojoWithFactoryMethods getInstance( InputStream inputStream, int num )
    {
        invocationOrder.add( "abstract,int" );
        throw new IllegalStateException( "Cannot use me also" );
    }

    public static PojoWithFactoryMethods getInstance( String value )
    {
        invocationOrder.add( "PogoConstructor(str)" );
        throw new IllegalStateException( "Cannot use me" );
    }

    public static PojoWithFactoryMethods getInstance( String str, boolean bool )
    {
        invocationOrder.add( "PogoConstructor(str,bool)" );
        throw new IllegalStateException( "Cannot use me" );
    }

    public static PojoWithFactoryMethods getInstance()
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
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
