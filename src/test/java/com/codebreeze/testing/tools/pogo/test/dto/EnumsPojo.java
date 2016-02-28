package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePogoEnum;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }

    public enum RatePogoInternal
    {
        COOL, ROCKS, SUPERCOOL
    }

}
