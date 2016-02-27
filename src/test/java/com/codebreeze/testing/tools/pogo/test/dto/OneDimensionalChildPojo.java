package com.codebreeze.testing.tools.pogo.test.dto;

public class OneDimensionalChildPojo extends AbstractOneDimensionalPojo
{
    private int intField;

    private String strField;

    public OneDimensionalChildPojo()
    {
        super();
    }

    public int getIntField()
    {
        return intField;
    }

    public void setIntField( int intField )
    {
        this.intField = intField;
    }

    public String getStrField()
    {
        return strField;
    }

    public void setStrField( String strField )
    {
        this.strField = strField;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        return super.toString() + TAB +
               "OneDimensionalChildPojo ( " + "intField = " +
               intField + TAB + "strField = " +
               strField + TAB + " )";
    }
}
