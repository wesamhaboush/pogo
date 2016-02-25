package com.codebreeze.testing.tools.pogo.api;


import java.lang.reflect.Type;

public class NullExternalFactory extends AbstractExternalFactory
{

    private NullExternalFactory()
    {
    }

    public static NullExternalFactory getInstance()
    {
        return new NullExternalFactory();
    }

    @Override
    public <T> T manufacturePojo( Class<T> pojoClass, Type... genericTypeArgs )
    {
        return null;
    }

    @Override
    public <T> T populatePojo( T pojo, Type... genericTypeArgs )
    {
        return pojo;
    }
}
