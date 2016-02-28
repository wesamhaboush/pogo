package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ShortValuePojo
{
    private short shortPrimitive;

    private Short shortObject;

    public short getShortPrimitive()
    {
        return shortPrimitive;
    }

    public void setShortPrimitive( short shortPrimitive )
    {
        this.shortPrimitive = shortPrimitive;
    }

    public Short getShortObject()
    {
        return shortObject;
    }

    public void setShortObject(
        Short shortObject )
    {
        this.shortObject = shortObject;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
