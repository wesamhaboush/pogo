package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoByteValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;

public class ByteValuePojo implements Serializable
{

    private static final long serialVersionUID = 1L;

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

    public byte getByteFieldWithMinValueOnly()
    {
        return byteFieldWithMinValueOnly;
    }

    public void setByteFieldWithMinValueOnly( byte byteFieldWithMinValueOnly )
    {
        this.byteFieldWithMinValueOnly = byteFieldWithMinValueOnly;
    }

    public byte getByteFieldWithMaxValueOnly()
    {
        return byteFieldWithMaxValueOnly;
    }

    public void setByteFieldWithMaxValueOnly( byte byteFieldWithMaxValueOnly )
    {
        this.byteFieldWithMaxValueOnly = byteFieldWithMaxValueOnly;
    }

    public byte getByteFieldWithMinAndMaxValue()
    {
        return byteFieldWithMinAndMaxValue;
    }

    public void setByteFieldWithMinAndMaxValue( byte byteFieldWithMinAndMaxValue )
    {
        this.byteFieldWithMinAndMaxValue = byteFieldWithMinAndMaxValue;
    }

    public Byte getByteObjectFieldWithMinValueOnly()
    {
        return byteObjectFieldWithMinValueOnly;
    }

    public void setByteObjectFieldWithMinValueOnly(
        Byte byteObjectFieldWithMinValueOnly )
    {
        this.byteObjectFieldWithMinValueOnly = byteObjectFieldWithMinValueOnly;
    }

    public Byte getByteObjectFieldWithMaxValueOnly()
    {
        return byteObjectFieldWithMaxValueOnly;
    }

    public void setByteObjectFieldWithMaxValueOnly(
        Byte byteObjectFieldWithMaxValueOnly )
    {
        this.byteObjectFieldWithMaxValueOnly = byteObjectFieldWithMaxValueOnly;
    }

    public Byte getByteObjectFieldWithMinAndMaxValue()
    {
        return byteObjectFieldWithMinAndMaxValue;
    }

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
}
