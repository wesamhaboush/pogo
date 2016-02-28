package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Vector;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public abstract class GenericInStaticConstructorPojo
{

    protected Vector<String> vector;

    public static GenericInStaticConstructorPojo getInstance( Vector<String> vector )
    {
        return new GenericInStaticConstructorPojoImpl( vector );
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
