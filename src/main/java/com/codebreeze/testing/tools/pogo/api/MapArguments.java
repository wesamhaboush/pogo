package com.codebreeze.testing.tools.pogo.api;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Arrays;

public class MapArguments extends AbstractMapArguments implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Class<?> keyClass;

    private Class<?> elementClass;

    private Type[] keyGenericTypeArgs;

    private Type[] elementGenericTypeArgs;

    public Class<?> getKeyClass()
    {
        return keyClass;
    }

    public void setKeyClass( Class<?> keyClass )
    {
        this.keyClass = keyClass;
    }

    public Class<?> getElementClass()
    {
        return elementClass;
    }

    public void setElementClass( Class<?> elementClass )
    {
        this.elementClass = elementClass;
    }

    public Type[] getKeyGenericTypeArgs()
    {
        return keyGenericTypeArgs;
    }

    public void setKeyGenericTypeArgs( Type[] keyGenericTypeArgs )
    {
        this.keyGenericTypeArgs = keyGenericTypeArgs.clone();
    }

    public Type[] getElementGenericTypeArgs()
    {
        return elementGenericTypeArgs;
    }

    public void setElementGenericTypeArgs( Type[] elementGenericTypeArgs )
    {
        this.elementGenericTypeArgs = elementGenericTypeArgs.clone();
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
