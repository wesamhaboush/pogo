/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PodamConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A Pojo to test constructors with collections as arguments
 *
 * @author mtedone
 *
 */
public class NoSetterWithCollectionInConstructorPojo implements Serializable
{

    // ------------------->> Constants
    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    /** A list of strings */
    private final List<String> strList;

    /** An int field */
    private final int intField;

    // ------------------->> Constructors
    /**
     * Full constructor
     *
     * @param strList
     *            A list of Strings
     * @param intField
     *            An int field
     */
    @PodamConstructor
    public NoSetterWithCollectionInConstructorPojo( List<String> strList,
            int intField )
    {
        super();
        this.strList = strList;
        this.intField = intField;
    }

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the strList
     */
    public List<String> getStrList()
    {
        return strList;
    }

    /**
     * @return the intField
     */
    public int getIntField()
    {
        return intField;
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
        String retValue = "NoSetterWithCollectionInConstructorPojo ( " +
                          "strList = " + strList + TAB +
                          "intField = " + intField + TAB +
                          " )";
        return retValue;
    }

    // ------------------->> Inner classes

}
