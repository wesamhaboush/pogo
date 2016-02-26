package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.List;

public class TypedClassPojo<T>
{

    private T typedValue;

    private List<T> typedList;

    public T getTypedValue()
    {
        return typedValue;
    }

    public void setTypedValue( T typedValue )
    {
        this.typedValue = typedValue;
    }

    public List<T> getTypedList()
    {
        return typedList;
    }

    public void setTypedList( List<T> typedList )
    {
        this.typedList = typedList;
    }
}
