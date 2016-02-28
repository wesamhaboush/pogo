package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class XMLDatatypePojo
{
    private XMLGregorianCalendar calendar;
    private Duration duration;

    public XMLDatatypePojo()
    {
    }

    public XMLGregorianCalendar getCalendar()
    {
        return calendar;
    }

    public void setCalendar( XMLGregorianCalendar calendar )
    {
        this.calendar = calendar;
    }

    public Duration getDuration()
    {
        return duration;
    }

    public void setDuration( Duration duration )
    {
        this.duration = duration;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
