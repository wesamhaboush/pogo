package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Vector;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class UnsupportedCollectionInConstructorPojo<E>
{

    private final Vector<E> vector;

    public UnsupportedCollectionInConstructorPojo( Vector<E> vector )
    {
        this.vector = vector;
    }

    public Vector<E> getVector()
    {
        return vector;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
