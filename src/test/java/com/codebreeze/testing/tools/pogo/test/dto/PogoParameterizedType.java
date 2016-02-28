package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class PogoParameterizedType implements ParameterizedType
{

    private final Class<?> rawType;
    private final Type[] actualTypeArguments;

    public PogoParameterizedType( final Class<?> rawType,
                                  final Type... actualTypeArguments )
    {
        super();
        this.rawType = rawType;
        this.actualTypeArguments = actualTypeArguments;
    }

    @Override
    public Type[] getActualTypeArguments()
    {
        return actualTypeArguments;
    }

    @Override
    public Class<?> getRawType()
    {
        return rawType;
    }

    @Override
    public Type getOwnerType()
    {
        return null;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }

}
