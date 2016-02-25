/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoShortValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

/**
 * POJO to test {@link PogoShortValue} annotation
 *
 * @author mtedone
 *
 */
public class ShortValuePojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    @PogoShortValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private short shortFieldWithMinValueOnly;

    @PogoShortValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private short shortFieldWithMaxValueOnly;

    @PogoShortValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE,
                     maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private short shortFieldWithMinAndMaxValue;

    @PogoShortValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private Short shortObjectFieldWithMinValueOnly;

    @PogoShortValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private Short shortObjectFieldWithMaxValueOnly;

    @PogoShortValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE,
                     maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private Short shortObjectFieldWithMinAndMaxValue;

    @PogoShortValue( numValue = PogoTestConstants.SHORT_PRECISE_VALUE )
    private short shortFieldWithPreciseValue;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the shortFieldWithMinValueOnly
     */
    public short getShortFieldWithMinValueOnly()
    {
        return shortFieldWithMinValueOnly;
    }

    /**
     * @param shortFieldWithMinValueOnly
     *            the shortFieldWithMinValueOnly to set
     */
    public void setShortFieldWithMinValueOnly( short shortFieldWithMinValueOnly )
    {
        this.shortFieldWithMinValueOnly = shortFieldWithMinValueOnly;
    }

    /**
     * @return the shortFieldWithMaxValueOnly
     */
    public short getShortFieldWithMaxValueOnly()
    {
        return shortFieldWithMaxValueOnly;
    }

    /**
     * @param shortFieldWithMaxValueOnly
     *            the shortFieldWithMaxValueOnly to set
     */
    public void setShortFieldWithMaxValueOnly( short shortFieldWithMaxValueOnly )
    {
        this.shortFieldWithMaxValueOnly = shortFieldWithMaxValueOnly;
    }

    /**
     * @return the shortFieldWithMinAndMaxValue
     */
    public short getShortFieldWithMinAndMaxValue()
    {
        return shortFieldWithMinAndMaxValue;
    }

    /**
     * @param shortFieldWithMinAndMaxValue
     *            the shortFieldWithMinAndMaxValue to set
     */
    public void setShortFieldWithMinAndMaxValue(
        short shortFieldWithMinAndMaxValue )
    {
        this.shortFieldWithMinAndMaxValue = shortFieldWithMinAndMaxValue;
    }

    /**
     * @return the shortObjectFieldWithMinValueOnly
     */
    public Short getShortObjectFieldWithMinValueOnly()
    {
        return shortObjectFieldWithMinValueOnly;
    }

    /**
     * @param shortObjectFieldWithMinValueOnly
     *            the shortObjectFieldWithMinValueOnly to set
     */
    public void setShortObjectFieldWithMinValueOnly(
        Short shortObjectFieldWithMinValueOnly )
    {
        this.shortObjectFieldWithMinValueOnly = shortObjectFieldWithMinValueOnly;
    }

    /**
     * @return the shortObjectFieldWithMaxValueOnly
     */
    public Short getShortObjectFieldWithMaxValueOnly()
    {
        return shortObjectFieldWithMaxValueOnly;
    }

    /**
     * @param shortObjectFieldWithMaxValueOnly
     *            the shortObjectFieldWithMaxValueOnly to set
     */
    public void setShortObjectFieldWithMaxValueOnly(
        Short shortObjectFieldWithMaxValueOnly )
    {
        this.shortObjectFieldWithMaxValueOnly = shortObjectFieldWithMaxValueOnly;
    }

    /**
     * @return the shortObjectFieldWithMinAndMaxValue
     */
    public Short getShortObjectFieldWithMinAndMaxValue()
    {
        return shortObjectFieldWithMinAndMaxValue;
    }

    /**
     * @param shortObjectFieldWithMinAndMaxValue
     *            the shortObjectFieldWithMinAndMaxValue to set
     */
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

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    /**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     *
     * @return a <code>String</code> representation of this object.
     */
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

    // ------------------->> Inner classes

}
