package com.codebreeze.testing.tools.pogo.test.dto;

public class ArrayPojo
{

    private String[] myStringArray = new String[10];

    private Object[] myObjectArray;

    public ArrayPojo()
    {
    }

    public String[] getMyStringArray()
    {
        return myStringArray;
    }

    public void setMyStringArray( String[] myStringArray )
    {
        this.myStringArray = myStringArray;
    }

    public Object[] getMyObjectArray()
    {
        return myObjectArray;
    }

    public void setMyObjectArray( Object[] myObjectArray )
    {
        this.myObjectArray = myObjectArray;
    }
}
