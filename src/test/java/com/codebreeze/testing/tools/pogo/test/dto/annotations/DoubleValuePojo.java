package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class DoubleValuePojo
{
    private double doublePrimitive;

    private Double doubleObject;

    public double getDoublePrimitive()
    {
        return doublePrimitive;
    }

    public void setDoublePrimitive(
        double doublePrimitive )
    {
        this.doublePrimitive = doublePrimitive;
    }

    public Double getDoubleObject()
    {
        return doubleObject;
    }

    public void setDoubleObject(
        Double doubleObject )
    {
        this.doubleObject = doubleObject;
    }


    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
