package com.codebreeze.testing.tools.pogo.test.dto;

public class BadlyTypedFixedPojo extends BadlyTypedPojo
{

    public void setValue( Integer value )
    {
        setValue( value.toString() );
    }

}
