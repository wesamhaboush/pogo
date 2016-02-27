package com.codebreeze.testing.tools.pogo.test.dto;

import java.io.Serializable;

public class NoDefaultConstructorPojo implements Serializable
{


    private static final long serialVersionUID = 1L;


    private int intField;


    public NoDefaultConstructorPojo( int intField )
    {
        super();
        this.intField = intField;
    }


    public int getIntField()
    {
        return intField;
    }

    public void setIntField( int intField )
    {
        this.intField = intField;
    }



    @Override
    public String toString()
    {
        final String TAB = "    ";
        return "NoDefaultConstructorPojo ( " + "intField = " +
               intField + TAB + " )";
    }

}
