/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoIntValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

/**
 * POJO to test the {@link PogoIntValue} annotation
 *
 * @author mtedone
 *
 */
public class IntegerValuePojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

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

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the intFieldWithMinValueOnly
     */
    public int getIntFieldWithMinValueOnly()
    {
        return intFieldWithMinValueOnly;
    }

    /**
     * @param intFieldWithMinValueOnly
     *            the intFieldWithMinValueOnly to set
     */
    public void setIntFieldWithMinValueOnly( int intFieldWithMinValueOnly )
    {
        this.intFieldWithMinValueOnly = intFieldWithMinValueOnly;
    }

    /**
     * @return the intFieldWithMaxValueOnly
     */
    public int getIntFieldWithMaxValueOnly()
    {
        return intFieldWithMaxValueOnly;
    }

    /**
     * @param intFieldWithMaxValueOnly
     *            the intFieldWithMaxValueOnly to set
     */
    public void setIntFieldWithMaxValueOnly( int intFieldWithMaxValueOnly )
    {
        this.intFieldWithMaxValueOnly = intFieldWithMaxValueOnly;
    }

    /**
     * @return the intFieldWithMinAndMaxValue
     */
    public int getIntFieldWithMinAndMaxValue()
    {
        return intFieldWithMinAndMaxValue;
    }

    /**
     * @param intFieldWithMinAndMaxValue
     *            the intFieldWithMinAndMaxValue to set
     */
    public void setIntFieldWithMinAndMaxValue( int intFieldWithMinAndMaxValue )
    {
        this.intFieldWithMinAndMaxValue = intFieldWithMinAndMaxValue;
    }

    /**
     * @return the integerObjectFieldWithMinValueOnly
     */
    public Integer getIntegerObjectFieldWithMinValueOnly()
    {
        return integerObjectFieldWithMinValueOnly;
    }

    /**
     * @param integerObjectFieldWithMinValueOnly
     *            the integerObjectFieldWithMinValueOnly to set
     */
    public void setIntegerObjectFieldWithMinValueOnly(
        Integer integerObjectFieldWithMinValueOnly )
    {
        this.integerObjectFieldWithMinValueOnly = integerObjectFieldWithMinValueOnly;
    }

    /**
     * @return the integerObjectFieldWithMaxValueOnly
     */
    public Integer getIntegerObjectFieldWithMaxValueOnly()
    {
        return integerObjectFieldWithMaxValueOnly;
    }

    /**
     * @param integerObjectFieldWithMaxValueOnly
     *            the integerObjectFieldWithMaxValueOnly to set
     */
    public void setIntegerObjectFieldWithMaxValueOnly(
        Integer integerObjectFieldWithMaxValueOnly )
    {
        this.integerObjectFieldWithMaxValueOnly = integerObjectFieldWithMaxValueOnly;
    }

    /**
     * @return the integerObjectFieldWithMinAndMaxValue
     */
    public Integer getIntegerObjectFieldWithMinAndMaxValue()
    {
        return integerObjectFieldWithMinAndMaxValue;
    }

    /**
     * @param integerObjectFieldWithMinAndMaxValue
     *            the integerObjectFieldWithMinAndMaxValue to set
     */
    public void setIntegerObjectFieldWithMinAndMaxValue(
        Integer integerObjectFieldWithMinAndMaxValue )
    {
        this.integerObjectFieldWithMinAndMaxValue = integerObjectFieldWithMinAndMaxValue;
    }

    /**
     * @return the intFieldWithPreciseValue
     */
    public int getIntFieldWithPreciseValue()
    {
        return intFieldWithPreciseValue;
    }

    /**
     * @param intFieldWithPreciseValue
     *            the intFieldWithPreciseValue to set
     */
    public void setIntFieldWithPreciseValue( int intFieldWithPreciseValue )
    {
        this.intFieldWithPreciseValue = intFieldWithPreciseValue;
    }

    /**
     * @return the integerObjectFieldWithPreciseValue
     */
    public Integer getIntegerObjectFieldWithPreciseValue()
    {
        return integerObjectFieldWithPreciseValue;
    }

    /**
     * @param integerObjectFieldWithPreciseValue
     *            the integerObjectFieldWithPreciseValue to set
     */
    public void setIntegerObjectFieldWithPreciseValue(
        Integer integerObjectFieldWithPreciseValue )
    {
        this.integerObjectFieldWithPreciseValue = integerObjectFieldWithPreciseValue;
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

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
