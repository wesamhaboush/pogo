/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoByteValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;

/**
 * @author mtedone
 *
 */
public class ByteValuePojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    @PogoByteValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private byte byteFieldWithMinValueOnly;

    @PogoByteValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private byte byteFieldWithMaxValueOnly;

    @PogoByteValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE,
                    maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private byte byteFieldWithMinAndMaxValue;

    @PogoByteValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private Byte byteObjectFieldWithMinValueOnly;

    @PogoByteValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private Byte byteObjectFieldWithMaxValueOnly;

    @PogoByteValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE,
                    maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private Byte byteObjectFieldWithMinAndMaxValue;

    @PogoByteValue( numValue = PogoTestConstants.BYTE_PRECISE_VALUE )
    private byte byteFieldWithPreciseValue;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the byteFieldWithMinValueOnly
     */
    public byte getByteFieldWithMinValueOnly()
    {
        return byteFieldWithMinValueOnly;
    }

    /**
     * @param byteFieldWithMinValueOnly
     *            the byteFieldWithMinValueOnly to set
     */
    public void setByteFieldWithMinValueOnly( byte byteFieldWithMinValueOnly )
    {
        this.byteFieldWithMinValueOnly = byteFieldWithMinValueOnly;
    }

    /**
     * @return the byteFieldWithMaxValueOnly
     */
    public byte getByteFieldWithMaxValueOnly()
    {
        return byteFieldWithMaxValueOnly;
    }

    /**
     * @param byteFieldWithMaxValueOnly
     *            the byteFieldWithMaxValueOnly to set
     */
    public void setByteFieldWithMaxValueOnly( byte byteFieldWithMaxValueOnly )
    {
        this.byteFieldWithMaxValueOnly = byteFieldWithMaxValueOnly;
    }

    /**
     * @return the byteFieldWithMinAndMaxValue
     */
    public byte getByteFieldWithMinAndMaxValue()
    {
        return byteFieldWithMinAndMaxValue;
    }

    /**
     * @param byteFieldWithMinAndMaxValue
     *            the byteFieldWithMinAndMaxValue to set
     */
    public void setByteFieldWithMinAndMaxValue( byte byteFieldWithMinAndMaxValue )
    {
        this.byteFieldWithMinAndMaxValue = byteFieldWithMinAndMaxValue;
    }

    /**
     * @return the byteObjectFieldWithMinValueOnly
     */
    public Byte getByteObjectFieldWithMinValueOnly()
    {
        return byteObjectFieldWithMinValueOnly;
    }

    /**
     * @param byteObjectFieldWithMinValueOnly
     *            the byteObjectFieldWithMinValueOnly to set
     */
    public void setByteObjectFieldWithMinValueOnly(
        Byte byteObjectFieldWithMinValueOnly )
    {
        this.byteObjectFieldWithMinValueOnly = byteObjectFieldWithMinValueOnly;
    }

    /**
     * @return the byteObjectFieldWithMaxValueOnly
     */
    public Byte getByteObjectFieldWithMaxValueOnly()
    {
        return byteObjectFieldWithMaxValueOnly;
    }

    /**
     * @param byteObjectFieldWithMaxValueOnly
     *            the byteObjectFieldWithMaxValueOnly to set
     */
    public void setByteObjectFieldWithMaxValueOnly(
        Byte byteObjectFieldWithMaxValueOnly )
    {
        this.byteObjectFieldWithMaxValueOnly = byteObjectFieldWithMaxValueOnly;
    }

    /**
     * @return the byteObjectFieldWithMinAndMaxValue
     */
    public Byte getByteObjectFieldWithMinAndMaxValue()
    {
        return byteObjectFieldWithMinAndMaxValue;
    }

    /**
     * @param byteObjectFieldWithMinAndMaxValue
     *            the byteObjectFieldWithMinAndMaxValue to set
     */
    public void setByteObjectFieldWithMinAndMaxValue(
        Byte byteObjectFieldWithMinAndMaxValue )
    {
        this.byteObjectFieldWithMinAndMaxValue = byteObjectFieldWithMinAndMaxValue;
    }

    public byte getByteFieldWithPreciseValue()
    {
        return byteFieldWithPreciseValue;
    }

    public void setByteFieldWithPreciseValue( byte byteFieldWithPreciseValue )
    {
        this.byteFieldWithPreciseValue = byteFieldWithPreciseValue;
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
        String retValue = "ByteRangeValuesPojo ( " +
                          "byteFieldWithMinValueOnly = " +
                          byteFieldWithMinValueOnly + TAB +
                          "byteFieldWithMaxValueOnly = " +
                          byteFieldWithMaxValueOnly + TAB +
                          "byteFieldWithMinAndMaxValue = " +
                          byteFieldWithMinAndMaxValue + TAB +
                          "byteObjectFieldWithMinValueOnly = " +
                          byteObjectFieldWithMinValueOnly + TAB +
                          "byteObjectFieldWithMaxValueOnly = " +
                          byteObjectFieldWithMaxValueOnly + TAB +
                          "byteObjectFieldWithMinAndMaxValue = " +
                          byteObjectFieldWithMinAndMaxValue + TAB +
                          "byteFieldWithPreciseValue = " +
                          byteFieldWithPreciseValue + TAB + " )";
        return retValue;
    }

    // ------------------->> Inner classes

}
