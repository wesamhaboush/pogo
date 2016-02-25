/**
 *
 */
package com.codebreeze.testing.tools.pogo.api;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Contains metadata about the attribute for which a value is being assigned.
 * <p>
 * This class is available to all strategies and it allows users to customise
 * behaviour of a strategy depending on the metadata of the attribute to which a
 * value is being assigned. For instance, clients might assign different values
 * based on the attribute name.
 * </p>
 *
 * @author mtedone
 *
 */
public class AttributeMetadata implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    // ------------------->> Instance / Static variables

    /** The attribute name */
    private final String attributeName;

    /** The attribute type */
    private final Class<?> attributeType;

    /** The attribute type generic arguments */
    private final Type[] attrGenericArgs;

    /** The attribute annotations */
    private final List<Annotation> attributeAnnotations;

    /** Type of class that owns the attribute */
    private final Class<?> pojoClass;

    // ------------------->> Constructors

    /**
     * Full constructor.
     *
     * @param attributeName
     *            The attribute name
     * @param attributeType
     *            The attribute type
     * @param attrGenericArgs
     *            The attribute type generic arguments
     * @param attributeAnnotations
     *            The attribute annotations
     * @param declaringClass
     *            The type of class that owns the attribute
     */
    public AttributeMetadata( String attributeName, Class<?> attributeType,
                              Type[] attrGenericArgs, List<Annotation> attributeAnnotations,
                              Class<?> declaringClass )
    {
        this.attributeName = attributeName;
        this.attributeType = attributeType;
        this.attrGenericArgs = attrGenericArgs;
        this.attributeAnnotations = attributeAnnotations;
        this.pojoClass = declaringClass;
    }

    /**
     * Constructor for method parameters metadata
     *
     * @param attributeType
     *            The attribute type
     * @param attrGenericArgs
     *            The attribute type generic arguments
     * @param declaringClass
     *            The type of class that owns the attribute
     */
    public AttributeMetadata( Class<?> attributeType, Type[] attrGenericArgs,
                              Class<?> declaringClass )
    {
        this( null, attributeType, attrGenericArgs,
              Collections.<Annotation>emptyList(), declaringClass );
    }

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    public String getAttributeName()
    {
        return attributeName;
    }

    public Class<?> getAttributeType()
    {
        return attributeType;
    }

    public Type[] getAttrGenericArgs()
    {
        return attrGenericArgs;
    }

    public List<Annotation> getAttributeAnnotations()
    {
        return attributeAnnotations;
    }

    public Class<?> getPojoClass()
    {
        return pojoClass;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        String builder = "AttributeMetadata [attributeName=" +
                         attributeName +
                         ", attributeType=" +
                         attributeType +
                         ", pojoClass=" +
                         pojoClass +
                         ", attributeAnnotations=" +
                         attributeAnnotations +
                         "]";
        return builder;
    }

    // ------------------->> Inner classes

}
