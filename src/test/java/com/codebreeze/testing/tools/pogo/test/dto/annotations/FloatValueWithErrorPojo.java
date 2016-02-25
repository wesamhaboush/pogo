/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.io.Serializable;

import com.codebreeze.testing.tools.pogo.common.PogoFloatValue;

/**
 * POJO to test that a {@link PogoFloatValue#numValue()} is non parseable.
 *
 * @author mtedone
 *
 */
public class FloatValueWithErrorPojo implements Serializable
{

    // ------------------->> Constants
    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    @PogoFloatValue( numValue = "fafhakljhf" )
    private float floatFieldWithErrorInAnnotation;

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the floatFieldWithErrorInAnnotation
     */
    public float getFloatFieldWithErrorInAnnotation()
    {
        return floatFieldWithErrorInAnnotation;
    }

    /**
     * @param floatFieldWithErrorInAnnotation
     *            the floatFieldWithErrorInAnnotation to set
     */
    public void setFloatFieldWithErrorInAnnotation(
        float floatFieldWithErrorInAnnotation )
    {
        this.floatFieldWithErrorInAnnotation = floatFieldWithErrorInAnnotation;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
