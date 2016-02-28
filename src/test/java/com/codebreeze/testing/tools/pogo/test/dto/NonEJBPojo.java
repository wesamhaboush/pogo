package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class NonEJBPojo
{
    private static class Holder
    {
        private String holdingString;
        private Long holdingLong;
    }

    private final Holder myHolder = new Holder();

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
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
