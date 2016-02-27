package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

public class StringValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String twentyLengthString;

    private String preciseValueString;

    public String getTwentyLengthString()
    {
        return twentyLengthString;
    }

    public void setTwentyLengthString( String twentyLengthString )
    {
        this.twentyLengthString = twentyLengthString;
    }

    public String getPreciseValueString()
    {
        return preciseValueString;
    }

    public void setPreciseValueString( String preciseValueString )
    {
        this.preciseValueString = preciseValueString;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        return "StringValuesPojo ( " + "twentyLengthString = " +
               twentyLengthString + TAB +
               "preciseValueString = " + preciseValueString +
               TAB + " )";
    }
}
