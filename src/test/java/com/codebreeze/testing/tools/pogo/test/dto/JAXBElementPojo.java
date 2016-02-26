package com.codebreeze.testing.tools.pogo.test.dto;

import javax.xml.bind.JAXBElement;

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
}
