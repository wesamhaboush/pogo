package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class RecursivePojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int intField;

    private RecursivePojo parent;

    public RecursivePojo()
    {
    }

    public int getIntField()
    {
        return intField;
    }

    public void setIntField( int intField )
    {
        this.intField = intField;
    }

    public RecursivePojo getParent()
    {
        return parent;
    }

    public void setParent( RecursivePojo parent )
    {
        this.parent = parent;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
