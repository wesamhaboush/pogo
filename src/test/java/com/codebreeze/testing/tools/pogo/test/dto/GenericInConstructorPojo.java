package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Vector;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class GenericInConstructorPojo
{

    private final Vector<String> vector;

    public GenericInConstructorPojo( Vector<String> vector )
    {
        this.vector = vector;
    }

    public Vector<String> getVector()
    {
        return vector;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
