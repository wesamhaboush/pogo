package com.codebreeze.testing.tools.pogo.test.dto;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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

}
