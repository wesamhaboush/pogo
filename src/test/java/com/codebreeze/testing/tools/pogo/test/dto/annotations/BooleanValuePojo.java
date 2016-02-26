package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoBooleanValue;

import java.io.Serializable;

public class BooleanValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoBooleanValue( boolValue = true )
    private boolean boolDefaultToTrue;

    @PogoBooleanValue( boolValue = false )
    private boolean boolDefaultToFalse = true;

    @PogoBooleanValue( boolValue = true )
    private Boolean boolObjectDefaultToTrue;

    @PogoBooleanValue( boolValue = false )
    private Boolean boolObjectDefaultToFalse = true;

    public boolean isBoolDefaultToTrue()
    {
        return boolDefaultToTrue;
    }

    public void setBoolDefaultToTrue( boolean boolDefaultToTrue )
    {
        this.boolDefaultToTrue = boolDefaultToTrue;
    }

    public boolean isBoolDefaultToFalse()
    {
        return boolDefaultToFalse;
    }

    public void setBoolDefaultToFalse( boolean boolDefaultToFalse )
    {
        this.boolDefaultToFalse = boolDefaultToFalse;
    }

    public Boolean getBoolObjectDefaultToTrue()
    {
        return boolObjectDefaultToTrue;
    }

    public void setBoolObjectDefaultToTrue( Boolean boolObjectDefaultToTrue )
    {
        this.boolObjectDefaultToTrue = boolObjectDefaultToTrue;
    }

    public Boolean getBoolObjectDefaultToFalse()
    {
        return boolObjectDefaultToFalse;
    }

    public void setBoolObjectDefaultToFalse( Boolean boolObjectDefaultToFalse )
    {
        this.boolObjectDefaultToFalse = boolObjectDefaultToFalse;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "BooleanValuePojo ( " + "boolDefaultToTrue = " +
                          boolDefaultToTrue + TAB +
                          "boolDefaultToFalse = " + boolDefaultToFalse +
                          TAB + "boolObjectDefaultToTrue = " +
                          boolObjectDefaultToTrue + TAB +
                          "boolObjectDefaultToFalse = " +
                          boolObjectDefaultToFalse + TAB + " )";
        return retValue;
    }
}
