package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class OneDimensionalChildPojo extends AbstractOneDimensionalPojo
{
    private int intField;

    private String strField;

    public OneDimensionalChildPojo()
    {
        super();
    }

    public int getIntField()
    {
        return intField;
    }

    public void setIntField( int intField )
    {
        this.intField = intField;
    }

    public String getStrField()
    {
        return strField;
    }

    public void setStrField( String strField )
    {
        this.strField = strField;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
