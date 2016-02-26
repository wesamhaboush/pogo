package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoLongValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;

public class LongValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoLongValue( minValue = 0 )
    private long longFieldWithMinValueOnly;

    @PogoLongValue( maxValue = 100 )
    private long longFieldWithMaxValueOnly;

    @PogoLongValue( minValue = 0, maxValue = 1000 )
    private long longFieldWithMinAndMaxValue;

    @PogoLongValue( numValue = PogoTestConstants.LONG_PRECISE_VALUE )
    private long longFieldWithPreciseValue;

    @PogoLongValue( minValue = 0 )
    private Long longObjectFieldWithMinValueOnly;

    @PogoLongValue( maxValue = 100 )
    private Long longObjectFieldWithMaxValueOnly;

    @PogoLongValue( minValue = 0, maxValue = 1000 )
    private Long longObjectFieldWithMinAndMaxValue;

    @PogoLongValue( numValue = PogoTestConstants.LONG_PRECISE_VALUE )
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
