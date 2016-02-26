
package com.codebreeze.testing.tools.pogo.test.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;

public class ImmutableNonAnnotatedPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final int intField;

    private final Calendar dateCreated;

    private final long[] longArray;


    public ImmutableNonAnnotatedPojo( int intField, Calendar dateCreated,
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
        return "ImmutableNoHierarchicalPojo [intField=" + intField
               + ", dateCreated=" + dateCreated.getTime() + ", longArray="
               + Arrays.toString( longArray ) + "]";
    }
}
