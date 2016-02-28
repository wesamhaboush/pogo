package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ConstructorWithSelfReferencesPojoAndDefaultConstructor implements Serializable
{

    private static final long serialVersionUID = 1L;


    private int intField;

    private ConstructorWithSelfReferencesPojoAndDefaultConstructor parent;

    private ConstructorWithSelfReferencesPojoAndDefaultConstructor anotherParent;


    public ConstructorWithSelfReferencesPojoAndDefaultConstructor()
    {
    }

    public ConstructorWithSelfReferencesPojoAndDefaultConstructor( int intField,
            ConstructorWithSelfReferencesPojoAndDefaultConstructor parent,
            ConstructorWithSelfReferencesPojoAndDefaultConstructor anotherParent )
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

    public ConstructorWithSelfReferencesPojoAndDefaultConstructor getParent()
    {
        return parent;
    }

    public ConstructorWithSelfReferencesPojoAndDefaultConstructor getAnotherParent()
    {
        return anotherParent;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
