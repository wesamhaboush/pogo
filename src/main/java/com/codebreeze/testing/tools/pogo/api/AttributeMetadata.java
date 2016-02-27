package com.codebreeze.testing.tools.pogo.api;

import java.io.Serializable;
import java.lang.reflect.Type;

public class AttributeMetadata implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final String attributeName;

    private final Class<?> attributeType;

    private final Type[] attrGenericArgs;

    private final Class<?> pojoClass;

    public AttributeMetadata( String attributeName, Class<?> attributeType,
                              Type[] attrGenericArgs,
                              Class<?> declaringClass )
    {
        this.attributeName = attributeName;
        this.attributeType = attributeType;
        this.attrGenericArgs = attrGenericArgs;
        this.pojoClass = declaringClass;
    }

    public AttributeMetadata( Class<?> attributeType, Type[] attrGenericArgs,
                              Class<?> declaringClass )
    {
        this( null,
              attributeType,
              attrGenericArgs,
              declaringClass );
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

    public Class<?> getPojoClass()
    {
        return pojoClass;
    }

    @Override
    public String toString()
    {
        return "AttributeMetadata [attributeName=" +
               attributeName +
               ", attributeType=" +
               attributeType +
               ", pojoClass=" +
               pojoClass +
               "]";
    }

}
