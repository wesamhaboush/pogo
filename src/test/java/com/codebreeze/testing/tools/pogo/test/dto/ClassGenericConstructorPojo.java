package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ClassGenericConstructorPojo<T>
{
    private final Class<T> clazz;

    public ClassGenericConstructorPojo( Class<T> clazz )
    {
        this.clazz = clazz;
    }

    public Class<T> getClazz()
    {
        return clazz;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
