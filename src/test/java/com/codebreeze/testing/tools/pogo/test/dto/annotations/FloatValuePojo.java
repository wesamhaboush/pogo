package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class FloatValuePojo
{
    private float floatPrimitive;

    private Float floatObject;

    public float getFloatPrimitive()
    {
        return floatPrimitive;
    }

    public void setFloatPrimitive( float floatPrimitive )
    {
        this.floatPrimitive = floatPrimitive;
    }

    public Float getFloatObject()
    {
        return floatObject;
    }

    public void setFloatObject(
        Float floatObject )
    {
        this.floatObject = floatObject;
    }

    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
