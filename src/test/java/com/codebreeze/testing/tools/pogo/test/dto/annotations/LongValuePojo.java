package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

public class LongValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private long longFieldWithMinValueOnly;

    private long longFieldWithMaxValueOnly;

    private long longFieldWithMinAndMaxValue;

    private long longFieldWithPreciseValue;

    private Long longObjectFieldWithMinValueOnly;

    private Long longObjectFieldWithMaxValueOnly;

    private Long longObjectFieldWithMinAndMaxValue;

    private Long longObjectFieldWithPreciseValue;

    public long getLongFieldWithMinValueOnly()
    {
        return longFieldWithMinValueOnly;
    }

    public void setLongFieldWithMinValueOnly( long longFieldWithMinValueOnly )
    {
        this.longFieldWithMinValueOnly = longFieldWithMinValueOnly;
    }

    public long getLongFieldWithMaxValueOnly()
    {
        return longFieldWithMaxValueOnly;
    }

    public void setLongFieldWithMaxValueOnly( long longFieldWithMaxValueOnly )
    {
        this.longFieldWithMaxValueOnly = longFieldWithMaxValueOnly;
    }

    public long getLongFieldWithMinAndMaxValue()
    {
        return longFieldWithMinAndMaxValue;
    }

    public void setLongFieldWithMinAndMaxValue( long longFieldWithMinAndMaxValue )
    {
        this.longFieldWithMinAndMaxValue = longFieldWithMinAndMaxValue;
    }

    public Long getLongObjectFieldWithMinValueOnly()
    {
        return longObjectFieldWithMinValueOnly;
    }

    public void setLongObjectFieldWithMinValueOnly(
        Long longObjectFieldWithMinValueOnly )
    {
        this.longObjectFieldWithMinValueOnly = longObjectFieldWithMinValueOnly;
    }

    public Long getLongObjectFieldWithMaxValueOnly()
    {
        return longObjectFieldWithMaxValueOnly;
    }

    public void setLongObjectFieldWithMaxValueOnly(
        Long longObjectFieldWithMaxValueOnly )
    {
        this.longObjectFieldWithMaxValueOnly = longObjectFieldWithMaxValueOnly;
    }

    public Long getLongObjectFieldWithMinAndMaxValue()
    {
        return longObjectFieldWithMinAndMaxValue;
    }

    public void setLongObjectFieldWithMinAndMaxValue(
        Long longObjectFieldWithMinAndMaxValue )
    {
        this.longObjectFieldWithMinAndMaxValue = longObjectFieldWithMinAndMaxValue;
    }

    public long getLongFieldWithPreciseValue()
    {
        return longFieldWithPreciseValue;
    }

    public void setLongFieldWithPreciseValue( long longFieldWithPreciseValue )
    {
        this.longFieldWithPreciseValue = longFieldWithPreciseValue;
    }

    public Long getLongObjectFieldWithPreciseValue()
    {
        return longObjectFieldWithPreciseValue;
    }

    public void setLongObjectFieldWithPreciseValue(
        Long longObjectFieldWithPreciseValue )
    {
        this.longObjectFieldWithPreciseValue = longObjectFieldWithPreciseValue;
    }

    public String toString()
    {
        final String TAB = "    ";
        String retValue = "LongRangeValuesPojo ( " +
                          "longFieldWithMinValueOnly = " + this.longFieldWithMinValueOnly + TAB +
                          "longFieldWithMaxValueOnly = " + this.longFieldWithMaxValueOnly + TAB +
                          "longFieldWithMinAndMaxValue = " + this.longFieldWithMinAndMaxValue + TAB +
                          "longFieldWithPreciseValue = " + this.longFieldWithPreciseValue + TAB +
                          "longObjectFieldWithMinValueOnly = " + this.longObjectFieldWithMinValueOnly + TAB +
                          "longObjectFieldWithMaxValueOnly = " + this.longObjectFieldWithMaxValueOnly + TAB +
                          "longObjectFieldWithMinAndMaxValue = " + this.longObjectFieldWithMinAndMaxValue + TAB +
                          "longObjectFieldWithPreciseValue = " + this.longObjectFieldWithPreciseValue + TAB +
                          " )";
        return retValue;
    }
}
