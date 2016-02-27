package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePogoEnum;

import java.io.Serializable;

public class EnumsPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private RatePogoInternal ratePogoInternal;

    private ExternalRatePogoEnum ratePogoExternal;

    public RatePogoInternal getRatePogoInternal()
    {
        return ratePogoInternal;
    }

    public void setRatePogoInternal( RatePogoInternal ratePogoInternal )
    {
        this.ratePogoInternal = ratePogoInternal;
    }

    public ExternalRatePogoEnum getRatePogoExternal()
    {
        return ratePogoExternal;
    }

    public void setRatePogoExternal( ExternalRatePogoEnum ratePogoExternal )
    {
        this.ratePogoExternal = ratePogoExternal;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        return "EnumsPojo ( " + "ratePogoInternal = " +
               ratePogoInternal + TAB +
               "ratePogoExternal = " + ratePogoExternal +
               TAB + " )";
    }

    public enum RatePogoInternal
    {
        COOL, ROCKS, SUPERCOOL
    }

}
