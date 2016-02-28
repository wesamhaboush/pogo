package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
