/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PogoConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;

/**
 * This is an immutable POJO to test Pogo's ability to create an instance which
 * hasn't got setters
 *
 * @author mtedone
 *
 */
public class ImmutableNoHierarchicalAnnotatedPojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;
    // ------------------->> Instance / Static variables

    /** An int field */
    private final int intField;

    /** A Calendar field */
    private final Calendar dateCreated;

    /** An array of longs */
    private final long[] longArray;

    // ------------------->> Constructors

    /**
     * Full constructor
     *
     * @param intField
     * @param dateCreated
     * @param longArray
     */
    @PogoConstructor
    public ImmutableNoHierarchicalAnnotatedPojo( int intField, Calendar dateCreated,
            long[] longArray )
    {
        super();
        this.intField = intField;
        this.dateCreated = dateCreated;
        this.longArray = longArray;
    }

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the intField
     */
    public int getIntField()
    {
        return intField;
    }

    /**
     * @return the dateCreated
     */
    public Calendar getDateCreated()
    {
        return dateCreated;
    }

    /**
     * @return the longArray
     */
    public long[] getLongArray()
    {
        return longArray;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ImmutableNoHierarchicalPojo [intField=" + intField
               + ", dateCreated=" + dateCreated + ", longArray="
               + Arrays.toString( longArray ) + "]";
    }

    // ------------------->> Inner classes

}
