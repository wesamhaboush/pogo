/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoStringValue;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

/**
 * POJO to test the {@link PogoStringValue}
 *
 * @author mtedone
 *
 */
public class StringValuePojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    @PogoStringValue( length = PogoTestConstants.STR_ANNOTATION_TWENTY_LENGTH )
    /** A String attribute with length 20 */
    private String twentyLengthString;

    @PogoStringValue( strValue = PogoTestConstants.STR_ANNOTATION_PRECISE_VALUE )
    private String preciseValueString;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the twentyLengthString
     */
    public String getTwentyLengthString()
    {
        return twentyLengthString;
    }

    /**
     * @param twentyLengthString
     *            the twentyLengthString to set
     */
    public void setTwentyLengthString( String twentyLengthString )
    {
        this.twentyLengthString = twentyLengthString;
    }

    /**
     * @return the preciseValueString
     */
    public String getPreciseValueString()
    {
        return preciseValueString;
    }

    /**
     * @param preciseValueString
     *            the preciseValueString to set
     */
    public void setPreciseValueString( String preciseValueString )
    {
        this.preciseValueString = preciseValueString;
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
        String retValue = "StringValuesPojo ( " + "twentyLengthString = " +
                          twentyLengthString + TAB +
                          "preciseValueString = " + preciseValueString +
                          TAB + " )";
        return retValue;
    }

    // ------------------->> Inner classes

}
