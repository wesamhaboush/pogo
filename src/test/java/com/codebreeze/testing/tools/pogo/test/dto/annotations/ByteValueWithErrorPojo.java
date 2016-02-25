/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoByteValue;

/**
 * POJO to test error case when {@link PogoByteValue#numValue()} contains an
 * unformattable value.
 *
 * @author mtedone
 *
 */
public class ByteValueWithErrorPojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    @PogoByteValue( numValue = "afasdfafa", comment = "This should throw an exception" )
    private byte byteAttributeWithErrorAnnotation;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the byteAttributeWithErrorAnnotation
     */
    public byte getByteAttributeWithErrorAnnotation()
    {
        return byteAttributeWithErrorAnnotation;
    }

    /**
     * @param byteAttributeWithErrorAnnotation
     *            the byteAttributeWithErrorAnnotation to set
     */
    public void setByteAttributeWithErrorAnnotation(
        byte byteAttributeWithErrorAnnotation )
    {
        this.byteAttributeWithErrorAnnotation = byteAttributeWithErrorAnnotation;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
