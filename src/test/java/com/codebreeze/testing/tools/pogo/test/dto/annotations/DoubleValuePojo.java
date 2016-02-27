package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

public class DoubleValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private double doubleFieldWithMinValueOnly;

    private double doubleFieldWithMaxValueOnly;

    private double doubleFieldWithMinAndMaxValue;

    private double doubleFieldWithPreciseValue;

    private Double doubleObjectFieldWithMinValueOnly;

    private Double doubleObjectFieldWithMaxValueOnly;

    private Double doubleObjectFieldWithMinAndMaxValue;

    private Double doubleObjectFieldWithPreciseValue;

    public double getDoubleFieldWithMinValueOnly()
    {
        return doubleFieldWithMinValueOnly;
    }

    public void setDoubleFieldWithMinValueOnly(
        double doubleFieldWithMinValueOnly )
    {
        this.doubleFieldWithMinValueOnly = doubleFieldWithMinValueOnly;
    }

    public double getDoubleFieldWithMaxValueOnly()
    {
        return doubleFieldWithMaxValueOnly;
    }

    public void setDoubleFieldWithMaxValueOnly(
        double doubleFieldWithMaxValueOnly )
    {
        this.doubleFieldWithMaxValueOnly = doubleFieldWithMaxValueOnly;
    }

    public double getDoubleFieldWithMinAndMaxValue()
    {
        return doubleFieldWithMinAndMaxValue;
    }

    public void setDoubleFieldWithMinAndMaxValue(
        double doubleFieldWithMinAndMaxValue )
    {
        this.doubleFieldWithMinAndMaxValue = doubleFieldWithMinAndMaxValue;
    }

    public Double getDoubleObjectFieldWithMinValueOnly()
    {
        return doubleObjectFieldWithMinValueOnly;
    }

    public void setDoubleObjectFieldWithMinValueOnly(
        Double doubleObjectFieldWithMinValueOnly )
    {
        this.doubleObjectFieldWithMinValueOnly = doubleObjectFieldWithMinValueOnly;
    }

    public Double getDoubleObjectFieldWithMaxValueOnly()
    {
        return doubleObjectFieldWithMaxValueOnly;
    }

    public void setDoubleObjectFieldWithMaxValueOnly(
        Double doubleObjectFieldWithMaxValueOnly )
    {
        this.doubleObjectFieldWithMaxValueOnly = doubleObjectFieldWithMaxValueOnly;
    }

    public Double getDoubleObjectFieldWithMinAndMaxValue()
    {
        return doubleObjectFieldWithMinAndMaxValue;
    }

    public void setDoubleObjectFieldWithMinAndMaxValue(
        Double doubleObjectFieldWithMinAndMaxValue )
    {
        this.doubleObjectFieldWithMinAndMaxValue = doubleObjectFieldWithMinAndMaxValue;
    }

    public double getDoubleFieldWithPreciseValue()
    {
        return doubleFieldWithPreciseValue;
    }

    public void setDoubleFieldWithPreciseValue(
        double doubleFieldWithPreciseValue )
    {
        this.doubleFieldWithPreciseValue = doubleFieldWithPreciseValue;
    }

    public Double getDoubleObjectFieldWithPreciseValue()
    {
        return doubleObjectFieldWithPreciseValue;
    }

    public void setDoubleObjectFieldWithPreciseValue(
        Double doubleObjectFieldWithPreciseValue )
    {
        this.doubleObjectFieldWithPreciseValue = doubleObjectFieldWithPreciseValue;
    }

    public String toString()
    {
        final String TAB = "    ";
        String retValue = "DoubleRangeValuesPojo ( " +
                          "doubleFieldWithMinValueOnly = " + this.doubleFieldWithMinValueOnly + TAB +
                          "doubleFieldWithMaxValueOnly = " + this.doubleFieldWithMaxValueOnly + TAB +
                          "doubleFieldWithMinAndMaxValue = " + this.doubleFieldWithMinAndMaxValue + TAB +
                          "doubleFieldWithPreciseValue = " + this.doubleFieldWithPreciseValue + TAB +
                          "doubleObjectFieldWithMinValueOnly = " + this.doubleObjectFieldWithMinValueOnly + TAB +
                          "doubleObjectFieldWithMaxValueOnly = " + this.doubleObjectFieldWithMaxValueOnly + TAB +
                          "doubleObjectFieldWithMinAndMaxValue = " + this.doubleObjectFieldWithMinAndMaxValue + TAB +
                          "doubleObjectFieldWithPreciseValue = " + this.doubleObjectFieldWithPreciseValue + TAB +
                          " )";
        return retValue;
    }
}
