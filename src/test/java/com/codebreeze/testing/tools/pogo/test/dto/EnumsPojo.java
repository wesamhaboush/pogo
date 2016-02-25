/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.test.enums.ExternalRatePogoEnum;

/**
 * A Pojo using enums for instance attributes
 *
 * @author mtedone
 *
 */
public class EnumsPojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    private RatePogoInternal ratePogoInternal;

    private ExternalRatePogoEnum ratePogoExternal;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the ratePogoInternal
     */
    public RatePogoInternal getRatePogoInternal()
    {
        return ratePogoInternal;
    }

    /**
     * @param ratePogoInternal
     *            the ratePogoInternal to set
     */
    public void setRatePogoInternal( RatePogoInternal ratePogoInternal )
    {
        this.ratePogoInternal = ratePogoInternal;
    }

    /**
     * @return the ratePogoExternal
     */
    public ExternalRatePogoEnum getRatePogoExternal()
    {
        return ratePogoExternal;
    }

    /**
     * @param ratePogoExternal
     *            the ratePogoExternal to set
     */
    public void setRatePogoExternal( ExternalRatePogoEnum ratePogoExternal )
    {
        this.ratePogoExternal = ratePogoExternal;
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
        String retValue = "EnumsPojo ( " + "ratePogoInternal = " +
                          ratePogoInternal + TAB +
                          "ratePogoExternal = " + ratePogoExternal +
                          TAB + " )";
        return retValue;
    }

    // ------------------->> Inner classes

    /**
     * Some internal enum
     *
     * @author mtedone
     *
     */
    public enum RatePogoInternal
    {
        COOL, ROCKS, SUPERCOOL
    }

}
