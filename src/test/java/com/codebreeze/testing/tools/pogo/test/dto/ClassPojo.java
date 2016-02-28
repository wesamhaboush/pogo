package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ClassPojo
{
    private Class<String> clazz;

    public ClassPojo()
    {
    }

    public Class<String> getClazz()
    {
        return clazz;
    }

    public void setClazz( Class<String> clazz )
    {
        this.clazz = clazz;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
