package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

public class BooleanValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private boolean boolDefaultToTrue;

    private boolean boolDefaultToFalse = true;

    private Boolean boolObjectDefaultToTrue;

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
        return "BooleanValuePojo ( " + "boolDefaultToTrue = " +
               boolDefaultToTrue + TAB +
               "boolDefaultToFalse = " + boolDefaultToFalse +
               TAB + "boolObjectDefaultToTrue = " +
               boolObjectDefaultToTrue + TAB +
               "boolObjectDefaultToFalse = " +
               boolObjectDefaultToFalse + TAB + " )";
    }
}
