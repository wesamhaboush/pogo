/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import java.io.Serializable;

/**
 * @author mtedone
 *
 */
public class Address implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String address1;

    private String address2;

    private String city;

    private String zipCode;

    private Country country;

    /**
     * @return the address1
     */
    public String getAddress1()
    {
        return address1;
    }

    /**
     * @param address1
     *            the address1 to set
     */
    public void setAddress1( String address1 )
    {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2()
    {
        return address2;
    }

    /**
     * @param address2
     *            the address2 to set
     */
    public void setAddress2( String address2 )
    {
        this.address2 = address2;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity( String city )
    {
        this.city = city;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode()
    {
        return zipCode;
    }

    /**
     * @param zipCode
     *            the zipCode to set
     */
    public void setZipCode( String zipCode )
    {
        this.zipCode = zipCode;
    }

    /**
     * @return the country
     */
    public Country getCountry()
    {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry( Country country )
    {
        this.country = country;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation
     * of this object.
     */
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "Address ( " +
                          "address1 = " + this.address1 + TAB +
                          "address2 = " + this.address2 + TAB +
                          "city = " + this.city + TAB +
                          "zipCode = " + this.zipCode + TAB +
                          "country = " + this.country + TAB +
                          " )";
        return retValue;
    }




}
