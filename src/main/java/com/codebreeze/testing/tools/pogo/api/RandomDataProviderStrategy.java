package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;

public interface RandomDataProviderStrategy extends DataProviderStrategy
{


    RandomDataProviderStrategy addOrReplaceAttributeStrategy(
        Class<? extends Annotation> annotationClass,
        Class<AttributeStrategy<?>> strategyClass );

    RandomDataProviderStrategy removeAttributeStrategy(
        Class<? extends Annotation> annotationClass );

    Comparator<Constructor<?>> getConstructorLightComparator();

    void setConstructorLightComparator( Comparator<Constructor<?>> constructorLightComparator );

    Comparator<Constructor<?>> getConstructorHeavyComparator();

    void setConstructorHeavyComparator( Comparator<Constructor<?>> constructorHeavyComparator );

    Comparator<Method> getMethodLightComparator();

    void setMethodLightComparator( Comparator<Method> methodLightComparator );

    Comparator<Method> getMethodHeavyComparator();

    void setMethodHeavyComparator( Comparator<Method> methodHeavyComparator );
}
