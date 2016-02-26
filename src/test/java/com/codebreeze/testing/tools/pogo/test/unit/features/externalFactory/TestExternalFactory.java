package com.codebreeze.testing.tools.pogo.test.unit.features.externalFactory;

import com.codebreeze.testing.tools.pogo.api.AbstractExternalFactory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestExternalFactory extends AbstractExternalFactory
{

    private final List<Class<?>> failures = new ArrayList<>();
    private final List<Class<?>> fullDataCalls = new ArrayList<>();


    @Override
    public <T> T manufacturePojo( Class<T> pojoClass, Type... genericTypeArgs )
    {
        failures.add( pojoClass );
        return null;
    }

    @Override
    public <T> T populatePojo( T pojo, Type... genericTypeArgs )
    {
        return pojo;
    }

    @Override
    public <T> T manufacturePojoWithFullData( Class<T> pojoClass, Type... genericTypeArgs )
    {
        fullDataCalls.add( pojoClass );
        return this.manufacturePojo( pojoClass, genericTypeArgs );
    }

    public List<Class<?>> getFullDataCalls()
    {
        return fullDataCalls;
    }

    public List<Class<?>> getFailures()
    {
        return failures;
    }
}
