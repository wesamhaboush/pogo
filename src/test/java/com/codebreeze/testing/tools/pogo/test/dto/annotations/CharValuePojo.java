package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoCharValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;

public class CharValuePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoCharValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private char charFieldWithMinValueOnly;

    @PogoCharValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private char charFieldWithMaxValueOnly;

    @PogoCharValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE,
                    maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private char charFieldWithMinAndMaxValue;

    @PogoCharValue( charValue = ' ' )
    private char charFieldWithBlankInPreciseValue;

    @PogoCharValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE )
    private Character charObjectFieldWithMinValueOnly;

    @PogoCharValue( maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private Character charObjectFieldWithMaxValueOnly;

    @PogoCharValue( minValue = PogoTestConstants.NUMBER_INT_MIN_VALUE,
                    maxValue = PogoTestConstants.NUMBER_INT_ONE_HUNDRED )
    private Character charObjectFieldWithMinAndMaxValue;

    @PogoCharValue( charValue = PogoTestConstants.CHAR_PRECISE_VALUE )
    private char charFieldWithPreciseValue;

    public char getCharFieldWithMinValueOnly()
    {
        return charFieldWithMinValueOnly;
    }

    public void setCharFieldWithMinValueOnly( char charFieldWithMinValueOnly )
    {
        this.charFieldWithMinValueOnly = charFieldWithMinValueOnly;
    }

    public char getCharFieldWithMaxValueOnly()
    {
        return charFieldWithMaxValueOnly;
    }

    public void setCharFieldWithMaxValueOnly( char charFieldWithMaxValueOnly )
    {
        this.charFieldWithMaxValueOnly = charFieldWithMaxValueOnly;
    }

    public char getCharFieldWithMinAndMaxValue()
    {
        return charFieldWithMinAndMaxValue;
    }

    public void setCharFieldWithMinAndMaxValue( char charFieldWithMinAndMaxValue )
    {
        this.charFieldWithMinAndMaxValue = charFieldWithMinAndMaxValue;
    }

    public Character getCharObjectFieldWithMinValueOnly()
    {
        return charObjectFieldWithMinValueOnly;
    }

    public void setCharObjectFieldWithMinValueOnly(
        Character charObjectFieldWithMinValueOnly )
    {
        this.charObjectFieldWithMinValueOnly = charObjectFieldWithMinValueOnly;
    }

    public Character getCharObjectFieldWithMaxValueOnly()
    {
        return charObjectFieldWithMaxValueOnly;
    }

    public void setCharObjectFieldWithMaxValueOnly(
        Character charObjectFieldWithMaxValueOnly )
    {
        this.charObjectFieldWithMaxValueOnly = charObjectFieldWithMaxValueOnly;
    }

    public Character getCharObjectFieldWithMinAndMaxValue()
    {
        return charObjectFieldWithMinAndMaxValue;
    }

    public void setCharObjectFieldWithMinAndMaxValue(
        Character charObjectFieldWithMinAndMaxValue )
    {
        this.charObjectFieldWithMinAndMaxValue = charObjectFieldWithMinAndMaxValue;
    }

    public char getCharFieldWithPreciseValue()
    {
        return charFieldWithPreciseValue;
    }

    public void setCharFieldWithPreciseValue( char charFieldWithPreciseValue )
    {
        this.charFieldWithPreciseValue = charFieldWithPreciseValue;
    }

    public char getCharFieldWithBlankInPreciseValue()
    {
        return charFieldWithBlankInPreciseValue;
    }

    public void setCharFieldWithBlankInPreciseValue(
        char charFieldWithBlankInPreciseValue )
    {
        this.charFieldWithBlankInPreciseValue = charFieldWithBlankInPreciseValue;
    }

    public String toString()
    {
        final String TAB = "    ";
        String retValue = "CharValuePojo ( " +
                          "charFieldWithMinValueOnly = " + this.charFieldWithMinValueOnly + TAB +
                          "charFieldWithMaxValueOnly = " + this.charFieldWithMaxValueOnly + TAB +
                          "charFieldWithMinAndMaxValue = " + this.charFieldWithMinAndMaxValue + TAB +
                          "charFieldWithBlankInPreciseValue = " + this.charFieldWithBlankInPreciseValue + TAB +
                          "charObjectFieldWithMinValueOnly = " + this.charObjectFieldWithMinValueOnly + TAB +
                          "charObjectFieldWithMaxValueOnly = " + this.charObjectFieldWithMaxValueOnly + TAB +
                          "charObjectFieldWithMinAndMaxValue = " + this.charObjectFieldWithMinAndMaxValue + TAB +
                          "charFieldWithPreciseValue = " + this.charFieldWithPreciseValue + TAB +
                          " )";
        return retValue;
    }
}
