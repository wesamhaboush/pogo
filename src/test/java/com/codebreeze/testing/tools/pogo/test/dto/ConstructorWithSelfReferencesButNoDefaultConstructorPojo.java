package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ConstructorWithSelfReferencesButNoDefaultConstructorPojo implements
    Serializable
{

    private static final long serialVersionUID = 1L;

    private final int intField;

    private final ConstructorWithSelfReferencesButNoDefaultConstructorPojo parent;

    private final ConstructorWithSelfReferencesButNoDefaultConstructorPojo anotherParent;

    public ConstructorWithSelfReferencesButNoDefaultConstructorPojo(
        int intField,
        ConstructorWithSelfReferencesButNoDefaultConstructorPojo parent,
        ConstructorWithSelfReferencesButNoDefaultConstructorPojo anotherParent )
    {
        super();
        this.intField = intField;
        this.parent = parent;
        this.anotherParent = anotherParent;
    }


    public int getIntField()
    {
        return intField;
    }

    public ConstructorWithSelfReferencesButNoDefaultConstructorPojo getParent()
    {
        return parent;
    }

    public ConstructorWithSelfReferencesButNoDefaultConstructorPojo getAnotherParent()
    {
        return anotherParent;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
