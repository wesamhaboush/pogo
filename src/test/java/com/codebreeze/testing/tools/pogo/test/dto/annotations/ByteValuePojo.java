package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

public class ByteValuePojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private byte byteFieldWithMinValueOnly;

    private byte byteFieldWithMaxValueOnly;

    private byte byteFieldWithMinAndMaxValue;

    private Byte byteObjectFieldWithMinValueOnly;

    private Byte byteObjectFieldWithMaxValueOnly;

    private Byte byteObjectFieldWithMinAndMaxValue;

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
