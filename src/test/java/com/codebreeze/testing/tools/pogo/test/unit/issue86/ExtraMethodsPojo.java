package com.codebreeze.testing.tools.pogo.test.unit.issue86;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class ExtraMethodsPojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private static class Holder
    {
        private String holdingString = null;
        private Long holdingLong = null;
    }

    private final Holder myHolder;

    public ExtraMethodsPojo()
    {
        myHolder = new Holder();
    }

    public String getMyString()
    {
        return myHolder.holdingString;
    }

    public void setMyString( String myString )
    {
        myHolder.holdingString = myString;
    }

    public Long getMyLong()
    {
        return myHolder.holdingLong;
    }

    public void setMyLong( Long myLong )
    {
        myHolder.holdingLong = myLong;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }

        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        ExtraMethodsPojo that = ( ExtraMethodsPojo ) o;
        return myHolder.equals( that.myHolder );
    }

    @Override
    public int hashCode()
    {
        return myHolder.hashCode();
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
