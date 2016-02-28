
package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Calendar;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ImmutableNoHierarchicalAnnotatedPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final int intField;

    private final Calendar dateCreated;

    private final long[] longArray;


    public ImmutableNoHierarchicalAnnotatedPojo( int intField, Calendar dateCreated,
            long[] longArray )
    {
        super();
        this.intField = intField;
        this.dateCreated = dateCreated;
        this.longArray = longArray;
    }


    public int getIntField()
    {
        return intField;
    }

    public Calendar getDateCreated()
    {
        return dateCreated;
    }

    public long[] getLongArray()
    {
        return longArray;
    }


    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
