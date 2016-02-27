package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Calendar;

public abstract class AbstractOneDimensionalPojo
{
    private int parentIntField;

    private Calendar parentCalendarField;


    public int getParentIntField()
    {
        return parentIntField;
    }

    protected void setParentIntField( int parentIntField )
    {
        this.parentIntField = parentIntField;
    }

    public Calendar getParentCalendarField()
    {
        return parentCalendarField;
    }

    protected void setParentCalendarField( Calendar parentCalendarField )
    {
        this.parentCalendarField = parentCalendarField;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "AbstractOneDimensionalPojo ( " +
                          "parentIntField = " + parentIntField + TAB +
                          "parentCalendarField = " +
                          parentCalendarField.getTime() + TAB + " )";
        return retValue;
    }
}
