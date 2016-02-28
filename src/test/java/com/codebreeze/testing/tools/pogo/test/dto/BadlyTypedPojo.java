package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
