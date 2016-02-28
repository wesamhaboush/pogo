package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class BooleanValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private boolean booleanPrimitive;

    private Boolean booleanObject;

    public boolean isBooleanPrimitive()
    {
        return booleanPrimitive;
    }

    public void setBooleanPrimitive( boolean booleanPrimitive )
    {
        this.booleanPrimitive = booleanPrimitive;
    }

    public Boolean getBooleanObject()
    {
        return booleanObject;
    }

    public void setBooleanObject( Boolean booleanObject )
    {
        this.booleanObject = booleanObject;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
