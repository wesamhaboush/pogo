package com.codebreeze.testing.tools.pogo.test.unit.features.inheritance;

import com.codebreeze.testing.tools.pogo.api.AbstractRandomDataProviderStrategy;

import java.util.ArrayList;
import java.util.List;

public class CustomDataProviderStrategy extends AbstractRandomDataProviderStrategy
{
    private final List<Class<?>> accessed = new ArrayList<>();

    @Override
    public <T> Class<? extends T> getSpecificClass(
        Class<T> nonInstantiatableClass )
    {
        accessed.add( nonInstantiatableClass );
        return nonInstantiatableClass;
    }

    public List<Class<?>> getAccessed()
    {
        return accessed;
    }

}
