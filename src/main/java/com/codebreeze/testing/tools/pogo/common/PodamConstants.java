/**
 *
 */
package com.codebreeze.testing.tools.pogo.common;


import java.lang.reflect.Type;

/**
 * PODAM constants.
 *
 * @author mtedone
 *
 * @since 1.0.0
 *
 */
public final class PodamConstants
{

    /**
     * The default string length that Podam will assign to an annotated
     * attribute
     */
    public static final int STR_DEFAULT_LENGTH = 10;

    /** The default number of elements for a collection-type element. */
    public static final int DEFAULT_NBR_COLLECTION_ELEMENTS = 5;

    /** A String used for messages. */
    public static final String THE_ANNOTATION_VALUE_STR = "The annotation value: ";

    /** An empty array of Types. */
    public static final Type[] NO_TYPES = new Type[0];

    /** An empty object array. */
    public static final Object[] NO_ARGS = new Object[0];

    /** The Enumeration qualifier for the Message Channel. */
    public static final String ENUMERATION_QUALIFIER = "Enumeration";

    /** The Generic Type qualifier for the Message Channel. */
    public static final String GENERIC_TYPE_QUALIFIER = "GenericType";

    /** Non-instantiable constructor */
    private PodamConstants()
    {
        throw new AssertionError( "Non instantiable" );
    }


}
