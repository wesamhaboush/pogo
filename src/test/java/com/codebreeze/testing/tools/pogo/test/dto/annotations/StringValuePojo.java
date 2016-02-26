package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoStringValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;

public class StringValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoStringValue( length = PogoTestConstants.STR_ANNOTATION_TWENTY_LENGTH )
    private String twentyLengthString;

    @PogoStringValue( strValue = PogoTestConstants.STR_ANNOTATION_PRECISE_VALUE )
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
        String retValue = "StringValuesPojo ( " + "twentyLengthString = " +
                          twentyLengthString + TAB +
                          "preciseValueString = " + preciseValueString +
                          TAB + " )";
        return retValue;
    }
}
