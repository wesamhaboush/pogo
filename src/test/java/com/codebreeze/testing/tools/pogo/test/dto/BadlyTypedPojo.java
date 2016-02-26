package com.codebreeze.testing.tools.pogo.test.dto;

public class BadlyTypedPojo
{
    private Integer value;

    public Integer getValue()
    {
        return value;
    }

    public void setValue( String value )
    {
        this.value = Integer.valueOf( value );
    }

}
