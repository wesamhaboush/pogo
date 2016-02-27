package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.AbstractExternalFactory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TrackingExternalFactory extends AbstractExternalFactory
{

    private final List<Class<?>> failures = new ArrayList<>();

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

}
