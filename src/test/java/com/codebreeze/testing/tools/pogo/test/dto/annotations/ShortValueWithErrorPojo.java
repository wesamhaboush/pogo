/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoShortValue;

/**
 * POJO to test that {@link PogoShortValue#numValue()} with non parseable value
 * throws exception.
 *
 * @author mtedone
 *
 */
public class ShortValueWithErrorPojo implements Serializable
{

    // ------------------->> Constants
    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    @PogoShortValue( numValue = "fajkfhaf" )
    private short shortFieldWithErrorInAnnotation;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the shortFieldWithErrorInAnnotation
     */
    public short getShortFieldWithErrorInAnnotation()
    {
        return shortFieldWithErrorInAnnotation;
    }

    /**
     * @param shortFieldWithErrorInAnnotation
     *            the shortFieldWithErrorInAnnotation to set
     */
    public void setShortFieldWithErrorInAnnotation(
        short shortFieldWithErrorInAnnotation )
    {
        this.shortFieldWithErrorInAnnotation = shortFieldWithErrorInAnnotation;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
