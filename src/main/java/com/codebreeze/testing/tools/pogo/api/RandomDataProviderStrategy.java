package com.codebreeze.testing.tools.pogo.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;

interface RandomDataProviderStrategy extends DataProviderStrategy
{
    Comparator<Constructor<?>> getConstructorLightComparator();

    void setConstructorLightComparator( Comparator<Constructor<?>> constructorLightComparator );

    Comparator<Constructor<?>> getConstructorHeavyComparator();

    void setConstructorHeavyComparator( Comparator<Constructor<?>> constructorHeavyComparator );

    Comparator<Method> getMethodLightComparator();

    void setMethodLightComparator( Comparator<Method> methodLightComparator );

    Comparator<Method> getMethodHeavyComparator();

    void setMethodHeavyComparator( Comparator<Method> methodHeavyComparator );
}
