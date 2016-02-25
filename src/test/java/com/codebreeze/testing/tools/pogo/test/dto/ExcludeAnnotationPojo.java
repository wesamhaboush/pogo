/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoExclude;

/**
 * @author mtedone
 *
 */
public class ExcludeAnnotationPojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    /** an int field */
    private int intField;

    /** another object */
    @PogoExclude
    private SimplePojoToTestSetters somePojo;

    // ------------------->> Constructors

    /**
     * No-args constructor
     */
    public ExcludeAnnotationPojo()
    {
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
     * @param intField
     *            the intField to set
     */
    public void setIntField( int intField )
    {
        this.intField = intField;
    }

    /**
     * @return the somePojo
     */
    public SimplePojoToTestSetters getSomePojo()
    {
        return somePojo;
    }

    /**
     * @param somePojo
     *            the somePojo to set
     */
    public void setSomePojo( SimplePojoToTestSetters somePojo )
    {
        this.somePojo = somePojo;
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
        String retValue = "ExcludeAnnotationPojo ( " + "intField = " +
                          intField + TAB + "somePojo = " +
                          somePojo + TAB + " )";
        return retValue;
    }

    // ------------------->> Inner classes

}
