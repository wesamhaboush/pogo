package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoIntValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;

public class IntegerValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoIntValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private int intFieldWithMinValueOnly;

    @PogoIntValue( numValue = PogoTestConstants.INTEGER_PRECISE_VALUE )
    private int intFieldWithPreciseValue;

    @PogoIntValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private int intFieldWithMaxValueOnly;

    @PogoIntValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE, maxValue = PogoTestConstants.NUMBER_INT_MAX_VALUE )
    private int intFieldWithMinAndMaxValue;

    @PogoIntValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private Integer integerObjectFieldWithMinValueOnly;

    @PogoIntValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private Integer integerObjectFieldWithMaxValueOnly;

    @PogoIntValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE, maxValue = PogoTestConstants.NUMBER_INT_MAX_VALUE )
    private Integer integerObjectFieldWithMinAndMaxValue;

    @PogoIntValue( numValue = PogoTestConstants.INTEGER_PRECISE_VALUE )
    private Integer integerObjectFieldWithPreciseValue;

    public int getIntFieldWithMinValueOnly()
    {
        return intFieldWithMinValueOnly;
    }

    public void setIntFieldWithMinValueOnly( int intFieldWithMinValueOnly )
    {
        this.intFieldWithMinValueOnly = intFieldWithMinValueOnly;
    }

    public int getIntFieldWithMaxValueOnly()
    {
        return intFieldWithMaxValueOnly;
    }

    public void setIntFieldWithMaxValueOnly( int intFieldWithMaxValueOnly )
    {
        this.intFieldWithMaxValueOnly = intFieldWithMaxValueOnly;
    }

    public int getIntFieldWithMinAndMaxValue()
    {
        return intFieldWithMinAndMaxValue;
    }

    public void setIntFieldWithMinAndMaxValue( int intFieldWithMinAndMaxValue )
    {
        this.intFieldWithMinAndMaxValue = intFieldWithMinAndMaxValue;
    }

    public Integer getIntegerObjectFieldWithMinValueOnly()
    {
        return integerObjectFieldWithMinValueOnly;
    }

    public void setIntegerObjectFieldWithMinValueOnly(
        Integer integerObjectFieldWithMinValueOnly )
    {
        this.integerObjectFieldWithMinValueOnly = integerObjectFieldWithMinValueOnly;
    }

    public Integer getIntegerObjectFieldWithMaxValueOnly()
    {
        return integerObjectFieldWithMaxValueOnly;
    }

    public void setIntegerObjectFieldWithMaxValueOnly(
        Integer integerObjectFieldWithMaxValueOnly )
    {
        this.integerObjectFieldWithMaxValueOnly = integerObjectFieldWithMaxValueOnly;
    }

    public Integer getIntegerObjectFieldWithMinAndMaxValue()
    {
        return integerObjectFieldWithMinAndMaxValue;
    }

    public void setIntegerObjectFieldWithMinAndMaxValue(
        Integer integerObjectFieldWithMinAndMaxValue )
    {
        this.integerObjectFieldWithMinAndMaxValue = integerObjectFieldWithMinAndMaxValue;
    }

    public int getIntFieldWithPreciseValue()
    {
        return intFieldWithPreciseValue;
    }

    public void setIntFieldWithPreciseValue( int intFieldWithPreciseValue )
    {
        this.intFieldWithPreciseValue = intFieldWithPreciseValue;
    }

    public Integer getIntegerObjectFieldWithPreciseValue()
    {
        return integerObjectFieldWithPreciseValue;
    }

    public void setIntegerObjectFieldWithPreciseValue(
        Integer integerObjectFieldWithPreciseValue )
    {
        this.integerObjectFieldWithPreciseValue = integerObjectFieldWithPreciseValue;
    }

    public String toString()
    {
        final String TAB = "    ";
        String retValue = "IntegerRangeValuesPojo ( " +
                          "intFieldWithMinValueOnly = " + this.intFieldWithMinValueOnly + TAB +
                          "intFieldWithPreciseValue = " + this.intFieldWithPreciseValue + TAB +
                          "intFieldWithMaxValueOnly = " + this.intFieldWithMaxValueOnly + TAB +
                          "intFieldWithMinAndMaxValue = " + this.intFieldWithMinAndMaxValue + TAB +
                          "integerObjectFieldWithMinValueOnly = " + this.integerObjectFieldWithMinValueOnly + TAB +
                          "integerObjectFieldWithMaxValueOnly = " + this.integerObjectFieldWithMaxValueOnly + TAB +
                          "integerObjectFieldWithMinAndMaxValue = " + this.integerObjectFieldWithMinAndMaxValue + TAB +
                          "integerObjectFieldWithPreciseValue = " + this.integerObjectFieldWithPreciseValue + TAB +
                          " )";
        return retValue;
    }
}
