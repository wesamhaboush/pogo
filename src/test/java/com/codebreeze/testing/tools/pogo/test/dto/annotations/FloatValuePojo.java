package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoFloatValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;

public class FloatValuePojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    @PogoFloatValue( minValue = PogoTestConstants.NUMBER_FLOAT_MIN_VALUE )
    private float floatFieldWithMinValueOnly;

    @PogoFloatValue( maxValue = PogoTestConstants.NUMBER_FLOAT_ONE_HUNDRED )
    private float floatFieldWithMaxValueOnly;

    @PogoFloatValue( minValue = PogoTestConstants.NUMBER_FLOAT_MIN_VALUE,
                     maxValue = PogoTestConstants.NUMBER_FLOAT_MAX_VALUE )
    private float floatFieldWithMinAndMaxValue;

    @PogoFloatValue( numValue = PogoTestConstants.FLOAT_PRECISE_VALUE )
    private float floatFieldWithPreciseValue;

    @PogoFloatValue( minValue = PogoTestConstants.NUMBER_FLOAT_MIN_VALUE )
    private Float floatObjectFieldWithMinValueOnly;

    @PogoFloatValue( maxValue = PogoTestConstants.NUMBER_FLOAT_ONE_HUNDRED )
    private Float floatObjectFieldWithMaxValueOnly;

    @PogoFloatValue( minValue = PogoTestConstants.NUMBER_FLOAT_MIN_VALUE,
                     maxValue = PogoTestConstants.NUMBER_FLOAT_MAX_VALUE )
    private Float floatObjectFieldWithMinAndMaxValue;

    @PogoFloatValue( numValue = PogoTestConstants.FLOAT_PRECISE_VALUE )
    private Float floatObjectFieldWithPreciseValue;

    public float getFloatFieldWithMinValueOnly()
    {
        return floatFieldWithMinValueOnly;
    }

    public void setFloatFieldWithMinValueOnly( float floatFieldWithMinValueOnly )
    {
        this.floatFieldWithMinValueOnly = floatFieldWithMinValueOnly;
    }

    public float getFloatFieldWithMaxValueOnly()
    {
        return floatFieldWithMaxValueOnly;
    }

    public void setFloatFieldWithMaxValueOnly( float floatFieldWithMaxValueOnly )
    {
        this.floatFieldWithMaxValueOnly = floatFieldWithMaxValueOnly;
    }

    public float getFloatFieldWithMinAndMaxValue()
    {
        return floatFieldWithMinAndMaxValue;
    }

    public void setFloatFieldWithMinAndMaxValue(
        float floatFieldWithMinAndMaxValue )
    {
        this.floatFieldWithMinAndMaxValue = floatFieldWithMinAndMaxValue;
    }

    public Float getFloatObjectFieldWithMinValueOnly()
    {
        return floatObjectFieldWithMinValueOnly;
    }

    public void setFloatObjectFieldWithMinValueOnly(
        Float floatObjectFieldWithMinValueOnly )
    {
        this.floatObjectFieldWithMinValueOnly = floatObjectFieldWithMinValueOnly;
    }

    public Float getFloatObjectFieldWithMaxValueOnly()
    {
        return floatObjectFieldWithMaxValueOnly;
    }

    public void setFloatObjectFieldWithMaxValueOnly(
        Float floatObjectFieldWithMaxValueOnly )
    {
        this.floatObjectFieldWithMaxValueOnly = floatObjectFieldWithMaxValueOnly;
    }

    public Float getFloatObjectFieldWithMinAndMaxValue()
    {
        return floatObjectFieldWithMinAndMaxValue;
    }

    public void setFloatObjectFieldWithMinAndMaxValue(
        Float floatObjectFieldWithMinAndMaxValue )
    {
        this.floatObjectFieldWithMinAndMaxValue = floatObjectFieldWithMinAndMaxValue;
    }

    public float getFloatFieldWithPreciseValue()
    {
        return floatFieldWithPreciseValue;
    }

    public void setFloatFieldWithPreciseValue( float floatFieldWithPreciseValue )
    {
        this.floatFieldWithPreciseValue = floatFieldWithPreciseValue;
    }

    public Float getFloatObjectFieldWithPreciseValue()
    {
        return floatObjectFieldWithPreciseValue;
    }

    public void setFloatObjectFieldWithPreciseValue(
        Float floatObjectFieldWithPreciseValue )
    {
        this.floatObjectFieldWithPreciseValue = floatObjectFieldWithPreciseValue;
    }

    public String toString()
    {
        final String TAB = "    ";
        String retValue = "FloatRangeValuesPojo ( " +
                          "floatFieldWithMinValueOnly = " + this.floatFieldWithMinValueOnly + TAB +
                          "floatFieldWithMaxValueOnly = " + this.floatFieldWithMaxValueOnly + TAB +
                          "floatFieldWithMinAndMaxValue = " + this.floatFieldWithMinAndMaxValue + TAB +
                          "floatFieldWithPreciseValue = " + this.floatFieldWithPreciseValue + TAB +
                          "floatObjectFieldWithMinValueOnly = " + this.floatObjectFieldWithMinValueOnly + TAB +
                          "floatObjectFieldWithMaxValueOnly = " + this.floatObjectFieldWithMaxValueOnly + TAB +
                          "floatObjectFieldWithMinAndMaxValue = " + this.floatObjectFieldWithMinAndMaxValue + TAB +
                          "floatObjectFieldWithPreciseValue = " + this.floatObjectFieldWithPreciseValue + TAB +
                          " )";
        return retValue;
    }
}
