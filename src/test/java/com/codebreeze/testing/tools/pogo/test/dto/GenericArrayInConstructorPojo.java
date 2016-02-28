package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class GenericArrayInConstructorPojo<E>
{

    private final E[] array;

    public GenericArrayInConstructorPojo( E[] array )
    {
        this.array = array;
    }

    public E[] getArray()
    {
        return array;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
