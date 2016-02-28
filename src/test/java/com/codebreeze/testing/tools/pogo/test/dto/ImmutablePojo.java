package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ImmutablePojo
{
    private String value;
    private Integer value2;

    public ImmutablePojo( String value, Integer value2 )
    {
        this( value );
        this.value2 = value2;
    }

    public ImmutablePojo( String value )
    {
        this.value = value;
    }

    public ImmutablePojo()
    {
    }

    public String getValue()
    {
        return value;
    }

    public Integer getValue2()
    {
        return value2;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
