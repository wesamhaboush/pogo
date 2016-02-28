package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Vector;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class GenericInSetterPojo
{

    private Vector<String> vector;

    public Vector<String> getVector()
    {
        return vector;
    }

    public void setVector( Vector<String> vector )
    {
        this.vector = vector;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
