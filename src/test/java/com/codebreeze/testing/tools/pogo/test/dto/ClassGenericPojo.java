package com.codebreeze.testing.tools.pogo.test.dto;

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
}
