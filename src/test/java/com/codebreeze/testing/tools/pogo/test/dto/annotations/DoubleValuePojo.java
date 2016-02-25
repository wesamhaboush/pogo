/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoDoubleValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

/**
 * POJO to test the {@link PogoDoubleValue} annotation
 *
 * @author mtedone
 *
 */
public class DoubleValuePojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    @PogoDoubleValue( minValue = PogoTestConstants.NUMBER_DOUBLE_MIN_VALUE )
    private double doubleFieldWithMinValueOnly;

    @PogoDoubleValue( maxValue = PogoTestConstants.NUMBER_DOUBLE_ONE_HUNDRED )
    private double doubleFieldWithMaxValueOnly;

    @PogoDoubleValue( minValue = PogoTestConstants.NUMBER_DOUBLE_MIN_VALUE,
                      maxValue = PogoTestConstants.NUMBER_DOUBLE_MAX_VALUE )
    private double doubleFieldWithMinAndMaxValue;

    @PogoDoubleValue( numValue = PogoTestConstants.DOUBLE_PRECISE_VALUE )
    private double doubleFieldWithPreciseValue;

    @PogoDoubleValue( minValue = PogoTestConstants.NUMBER_DOUBLE_MIN_VALUE )
    private Double doubleObjectFieldWithMinValueOnly;

    @PogoDoubleValue( maxValue = PogoTestConstants.NUMBER_DOUBLE_ONE_HUNDRED )
    private Double doubleObjectFieldWithMaxValueOnly;

    @PogoDoubleValue( minValue = PogoTestConstants.NUMBER_DOUBLE_MIN_VALUE,
                      maxValue = PogoTestConstants.NUMBER_DOUBLE_MAX_VALUE )
    private Double doubleObjectFieldWithMinAndMaxValue;

    @PogoDoubleValue( numValue = PogoTestConstants.DOUBLE_PRECISE_VALUE )
    private Double doubleObjectFieldWithPreciseValue;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the doubleFieldWithMinValueOnly
     */
    public double getDoubleFieldWithMinValueOnly()
    {
        return doubleFieldWithMinValueOnly;
    }

    /**
     * @param doubleFieldWithMinValueOnly
     *            the doubleFieldWithMinValueOnly to set
     */
    public void setDoubleFieldWithMinValueOnly(
        double doubleFieldWithMinValueOnly )
    {
        this.doubleFieldWithMinValueOnly = doubleFieldWithMinValueOnly;
    }

    /**
     * @return the doubleFieldWithMaxValueOnly
     */
    public double getDoubleFieldWithMaxValueOnly()
    {
        return doubleFieldWithMaxValueOnly;
    }

    /**
     * @param doubleFieldWithMaxValueOnly
     *            the doubleFieldWithMaxValueOnly to set
     */
    public void setDoubleFieldWithMaxValueOnly(
        double doubleFieldWithMaxValueOnly )
    {
        this.doubleFieldWithMaxValueOnly = doubleFieldWithMaxValueOnly;
    }

    /**
     * @return the doubleFieldWithMinAndMaxValue
     */
    public double getDoubleFieldWithMinAndMaxValue()
    {
        return doubleFieldWithMinAndMaxValue;
    }

    /**
     * @param doubleFieldWithMinAndMaxValue
     *            the doubleFieldWithMinAndMaxValue to set
     */
    public void setDoubleFieldWithMinAndMaxValue(
        double doubleFieldWithMinAndMaxValue )
    {
        this.doubleFieldWithMinAndMaxValue = doubleFieldWithMinAndMaxValue;
    }

    /**
     * @return the doubleObjectFieldWithMinValueOnly
     */
    public Double getDoubleObjectFieldWithMinValueOnly()
    {
        return doubleObjectFieldWithMinValueOnly;
    }

    /**
     * @param doubleObjectFieldWithMinValueOnly
     *            the doubleObjectFieldWithMinValueOnly to set
     */
    public void setDoubleObjectFieldWithMinValueOnly(
        Double doubleObjectFieldWithMinValueOnly )
    {
        this.doubleObjectFieldWithMinValueOnly = doubleObjectFieldWithMinValueOnly;
    }

    /**
     * @return the doubleObjectFieldWithMaxValueOnly
     */
    public Double getDoubleObjectFieldWithMaxValueOnly()
    {
        return doubleObjectFieldWithMaxValueOnly;
    }

    /**
     * @param doubleObjectFieldWithMaxValueOnly
     *            the doubleObjectFieldWithMaxValueOnly to set
     */
    public void setDoubleObjectFieldWithMaxValueOnly(
        Double doubleObjectFieldWithMaxValueOnly )
    {
        this.doubleObjectFieldWithMaxValueOnly = doubleObjectFieldWithMaxValueOnly;
    }

    /**
     * @return the doubleObjectFieldWithMinAndMaxValue
     */
    public Double getDoubleObjectFieldWithMinAndMaxValue()
    {
        return doubleObjectFieldWithMinAndMaxValue;
    }

    /**
     * @param doubleObjectFieldWithMinAndMaxValue
     *            the doubleObjectFieldWithMinAndMaxValue to set
     */
    public void setDoubleObjectFieldWithMinAndMaxValue(
        Double doubleObjectFieldWithMinAndMaxValue )
    {
        this.doubleObjectFieldWithMinAndMaxValue = doubleObjectFieldWithMinAndMaxValue;
    }

    /**
     * @return the doubleFieldWithPreciseValue
     */
    public double getDoubleFieldWithPreciseValue()
    {
        return doubleFieldWithPreciseValue;
    }

    /**
     * @param doubleFieldWithPreciseValue
     *            the doubleFieldWithPreciseValue to set
     */
    public void setDoubleFieldWithPreciseValue(
        double doubleFieldWithPreciseValue )
    {
        this.doubleFieldWithPreciseValue = doubleFieldWithPreciseValue;
    }

    /**
     * @return the doubleObjectFieldWithPreciseValue
     */
    public Double getDoubleObjectFieldWithPreciseValue()
    {
        return doubleObjectFieldWithPreciseValue;
    }

    /**
     * @param doubleObjectFieldWithPreciseValue
     *            the doubleObjectFieldWithPreciseValue to set
     */
    public void setDoubleObjectFieldWithPreciseValue(
        Double doubleObjectFieldWithPreciseValue )
    {
        this.doubleObjectFieldWithPreciseValue = doubleObjectFieldWithPreciseValue;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation
     * of this object.
     */
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

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
