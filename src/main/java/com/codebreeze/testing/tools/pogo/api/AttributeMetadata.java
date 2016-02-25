package com.codebreeze.testing.tools.pogo.api;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class AttributeMetadata implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final String attributeName;

    private final Class<?> attributeType;

    private final Type[] attrGenericArgs;

    private final List<Annotation> attributeAnnotations;

    private final Class<?> pojoClass;

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

    public AttributeMetadata( Class<?> attributeType, Type[] attrGenericArgs,
                              Class<?> declaringClass )
    {
        this( null, attributeType, attrGenericArgs,
              Collections.<Annotation>emptyList(), declaringClass );
    }

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

}
