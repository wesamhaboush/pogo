package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Calendar;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public abstract class AbstractOneDimensionalPojo
{
    private int parentIntField;

    private Calendar parentCalendarField;


    public int getParentIntField()
    {
        return parentIntField;
    }

    protected void setParentIntField( int parentIntField )
    {
        this.parentIntField = parentIntField;
    }

    public Calendar getParentCalendarField()
    {
        return parentCalendarField;
    }

    protected void setParentCalendarField( Calendar parentCalendarField )
    {
        this.parentCalendarField = parentCalendarField;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
