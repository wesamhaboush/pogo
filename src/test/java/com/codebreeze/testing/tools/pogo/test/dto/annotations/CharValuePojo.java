package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class CharValuePojo
{
    private char charPrimitive;
    private Character charObject;

    public char getCharPrimitive()
    {
        return charPrimitive;
    }

    public void setCharPrimitive( char charPrimitive )
    {
        this.charPrimitive = charPrimitive;
    }

    public Character getCharObject()
    {
        return charObject;
    }

    public void setCharObject(
        Character charObject )
    {
        this.charObject = charObject;
    }

    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
