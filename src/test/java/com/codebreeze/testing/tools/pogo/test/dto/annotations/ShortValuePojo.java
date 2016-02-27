package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

public class ShortValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private short shortFieldWithMinValueOnly;

    private short shortFieldWithMaxValueOnly;

    private short shortFieldWithMinAndMaxValue;

    private Short shortObjectFieldWithMinValueOnly;

    private Short shortObjectFieldWithMaxValueOnly;

    private Short shortObjectFieldWithMinAndMaxValue;

    private short shortFieldWithPreciseValue;

    public short getShortFieldWithMinValueOnly()
    {
        return shortFieldWithMinValueOnly;
    }

    public void setShortFieldWithMinValueOnly( short shortFieldWithMinValueOnly )
    {
        this.shortFieldWithMinValueOnly = shortFieldWithMinValueOnly;
    }

    public short getShortFieldWithMaxValueOnly()
    {
        return shortFieldWithMaxValueOnly;
    }

    public void setShortFieldWithMaxValueOnly( short shortFieldWithMaxValueOnly )
    {
        this.shortFieldWithMaxValueOnly = shortFieldWithMaxValueOnly;
    }

    public short getShortFieldWithMinAndMaxValue()
    {
        return shortFieldWithMinAndMaxValue;
    }

    public void setShortFieldWithMinAndMaxValue(
        short shortFieldWithMinAndMaxValue )
    {
        this.shortFieldWithMinAndMaxValue = shortFieldWithMinAndMaxValue;
    }

    public Short getShortObjectFieldWithMinValueOnly()
    {
        return shortObjectFieldWithMinValueOnly;
    }

    public void setShortObjectFieldWithMinValueOnly(
        Short shortObjectFieldWithMinValueOnly )
    {
        this.shortObjectFieldWithMinValueOnly = shortObjectFieldWithMinValueOnly;
    }

    public Short getShortObjectFieldWithMaxValueOnly()
    {
        return shortObjectFieldWithMaxValueOnly;
    }

    public void setShortObjectFieldWithMaxValueOnly(
        Short shortObjectFieldWithMaxValueOnly )
    {
        this.shortObjectFieldWithMaxValueOnly = shortObjectFieldWithMaxValueOnly;
    }

    public Short getShortObjectFieldWithMinAndMaxValue()
    {
        return shortObjectFieldWithMinAndMaxValue;
    }

    public void setShortObjectFieldWithMinAndMaxValue(
        Short shortObjectFieldWithMinAndMaxValue )
    {
        this.shortObjectFieldWithMinAndMaxValue = shortObjectFieldWithMinAndMaxValue;
    }

    public short getShortFieldWithPreciseValue()
    {
        return shortFieldWithPreciseValue;
    }

    public void setShortFieldWithPreciseValue( short shortFieldWithPreciseValue )
    {
        this.shortFieldWithPreciseValue = shortFieldWithPreciseValue;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "ShortRangeValuesPojo ( " +
                          "shortFieldWithMinValueOnly = " +
                          shortFieldWithMinValueOnly + TAB +
                          "shortFieldWithMaxValueOnly = " +
                          shortFieldWithMaxValueOnly + TAB +
                          "shortFieldWithMinAndMaxValue = " +
                          shortFieldWithMinAndMaxValue + TAB +
                          "shortObjectFieldWithMinValueOnly = " +
                          shortObjectFieldWithMinValueOnly + TAB +
                          "shortObjectFieldWithMaxValueOnly = " +
                          shortObjectFieldWithMaxValueOnly + TAB +
                          "shortObjectFieldWithMinAndMaxValue = " +
                          shortObjectFieldWithMinAndMaxValue + TAB +
                          "shortFieldWithPreciseValue = " +
                          shortFieldWithPreciseValue + TAB + " )";
        return retValue;
    }
}
