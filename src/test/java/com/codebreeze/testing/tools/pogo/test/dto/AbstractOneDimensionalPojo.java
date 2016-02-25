/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Calendar;

import com.codebreeze.testing.tools.pogo.common.PogoIntValue;

/**
 * Abstract POJO to test inheritance.
 *
 * @author mtedone
 *
 */
public abstract class AbstractOneDimensionalPojo
{

    // ------------------->> Constants

    // ------------------->> Instance / Static variables

    /** An int field */
    @PogoIntValue( maxValue = 10 )
    private int parentIntField;

    /** An object field */
    private Calendar parentCalendarField;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the parentIntField
     */
    public int getParentIntField()
    {
        return parentIntField;
    }

    /**
     * @param parentIntField
     *            the parentIntField to set
     */
    protected void setParentIntField( int parentIntField )
    {
        this.parentIntField = parentIntField;
    }

    /**
     * @return the parentCalendarField
     */
    public Calendar getParentCalendarField()
    {
        return parentCalendarField;
    }

    /**
     * @param parentCalendarField
     *            the parentCalendarField to set
     */
    protected void setParentCalendarField( Calendar parentCalendarField )
    {
        this.parentCalendarField = parentCalendarField;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    /**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     *
     * @return a <code>String</code> representation of this object.
     */
    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "AbstractOneDimensionalPojo ( " +
                          "parentIntField = " + parentIntField + TAB +
                          "parentCalendarField = " +
                          parentCalendarField.getTime() + TAB + " )";
        return retValue;
    }

    // ------------------->> Inner classes

}
