package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class LongValuePojo
{
    private long longPrimitive;

    private Long longObject;

    public long getLongPrimitive()
    {
        return longPrimitive;
    }

    public void setLongPrimitive( long longPrimitive )
    {
        this.longPrimitive = longPrimitive;
    }

    public Long getLongObject()
    {
        return longObject;
    }

    public void setLongObject(
        Long longObject )
    {
        this.longObject = longObject;
    }

    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
