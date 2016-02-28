package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.JAXBElement;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class JAXBElementPojo<T>
{
    private JAXBElement<T> value;

    public JAXBElementPojo()
    {
    }

    public JAXBElement<T> getValue()
    {
        return value;
    }

    public void setValue( JAXBElement<T> value )
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
