/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoFloatValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

/**
 * POJO to test the {@link PogoFloatValue} annotation
 *
 * @author mtedone
 *
 */
public class FloatValuePojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

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

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the floatFieldWithMinValueOnly
     */
    public float getFloatFieldWithMinValueOnly()
    {
        return floatFieldWithMinValueOnly;
    }

    /**
     * @param floatFieldWithMinValueOnly
     *            the floatFieldWithMinValueOnly to set
     */
    public void setFloatFieldWithMinValueOnly( float floatFieldWithMinValueOnly )
    {
        this.floatFieldWithMinValueOnly = floatFieldWithMinValueOnly;
    }

    /**
     * @return the floatFieldWithMaxValueOnly
     */
    public float getFloatFieldWithMaxValueOnly()
    {
        return floatFieldWithMaxValueOnly;
    }

    /**
     * @param floatFieldWithMaxValueOnly
     *            the floatFieldWithMaxValueOnly to set
     */
    public void setFloatFieldWithMaxValueOnly( float floatFieldWithMaxValueOnly )
    {
        this.floatFieldWithMaxValueOnly = floatFieldWithMaxValueOnly;
    }

    /**
     * @return the floatFieldWithMinAndMaxValue
     */
    public float getFloatFieldWithMinAndMaxValue()
    {
        return floatFieldWithMinAndMaxValue;
    }

    /**
     * @param floatFieldWithMinAndMaxValue
     *            the floatFieldWithMinAndMaxValue to set
     */
    public void setFloatFieldWithMinAndMaxValue(
        float floatFieldWithMinAndMaxValue )
    {
        this.floatFieldWithMinAndMaxValue = floatFieldWithMinAndMaxValue;
    }

    /**
     * @return the floatObjectFieldWithMinValueOnly
     */
    public Float getFloatObjectFieldWithMinValueOnly()
    {
        return floatObjectFieldWithMinValueOnly;
    }

    /**
     * @param floatObjectFieldWithMinValueOnly
     *            the floatObjectFieldWithMinValueOnly to set
     */
    public void setFloatObjectFieldWithMinValueOnly(
        Float floatObjectFieldWithMinValueOnly )
    {
        this.floatObjectFieldWithMinValueOnly = floatObjectFieldWithMinValueOnly;
    }

    /**
     * @return the floatObjectFieldWithMaxValueOnly
     */
    public Float getFloatObjectFieldWithMaxValueOnly()
    {
        return floatObjectFieldWithMaxValueOnly;
    }

    /**
     * @param floatObjectFieldWithMaxValueOnly
     *            the floatObjectFieldWithMaxValueOnly to set
     */
    public void setFloatObjectFieldWithMaxValueOnly(
        Float floatObjectFieldWithMaxValueOnly )
    {
        this.floatObjectFieldWithMaxValueOnly = floatObjectFieldWithMaxValueOnly;
    }

    /**
     * @return the floatObjectFieldWithMinAndMaxValue
     */
    public Float getFloatObjectFieldWithMinAndMaxValue()
    {
        return floatObjectFieldWithMinAndMaxValue;
    }

    /**
     * @param floatObjectFieldWithMinAndMaxValue
     *            the floatObjectFieldWithMinAndMaxValue to set
     */
    public void setFloatObjectFieldWithMinAndMaxValue(
        Float floatObjectFieldWithMinAndMaxValue )
    {
        this.floatObjectFieldWithMinAndMaxValue = floatObjectFieldWithMinAndMaxValue;
    }

    /**
     * @return the floatFieldWithPreciseValue
     */
    public float getFloatFieldWithPreciseValue()
    {
        return floatFieldWithPreciseValue;
    }

    /**
     * @param floatFieldWithPreciseValue
     *            the floatFieldWithPreciseValue to set
     */
    public void setFloatFieldWithPreciseValue( float floatFieldWithPreciseValue )
    {
        this.floatFieldWithPreciseValue = floatFieldWithPreciseValue;
    }

    /**
     * @return the floatObjectFieldWithPreciseValue
     */
    public Float getFloatObjectFieldWithPreciseValue()
    {
        return floatObjectFieldWithPreciseValue;
    }

    /**
     * @param floatObjectFieldWithPreciseValue
     *            the floatObjectFieldWithPreciseValue to set
     */
    public void setFloatObjectFieldWithPreciseValue(
        Float floatObjectFieldWithPreciseValue )
    {
        this.floatObjectFieldWithPreciseValue = floatObjectFieldWithPreciseValue;
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

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
