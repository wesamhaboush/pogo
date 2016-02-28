package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class IntegerValuePojo
{
    private int integerPrimitive;

    private Integer integerObject;

    public int getIntegerPrimitive()
    {
        return integerPrimitive;
    }

    public void setIntegerPrimitive( int integerPrimitive )
    {
        this.integerPrimitive = integerPrimitive;
    }

    public Integer getIntegerObject()
    {
        return integerObject;
    }

    public void setIntegerObject(
        Integer integerObject )
    {
        this.integerObject = integerObject;
    }

    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
