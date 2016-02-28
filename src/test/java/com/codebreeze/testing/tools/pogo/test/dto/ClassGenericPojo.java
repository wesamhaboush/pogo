package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ClassGenericPojo<T>
{
    private Class<T> clazz;

    public ClassGenericPojo()
    {
    }

    public Class<T> getClazz()
    {
        return clazz;
    }

    public void setClazz( Class<T> clazz )
    {
        this.clazz = clazz;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
