package com.codebreeze.testing.tools.pogo.test.dto;

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
}
