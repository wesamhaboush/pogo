package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.AbstractMethodComparator;
import com.codebreeze.testing.tools.pogo.common.*;

import java.lang.annotation.Annotation;

public interface RandomDataProviderStrategy extends DataProviderStrategy
{


    RandomDataProviderStrategy addOrReplaceAttributeStrategy(
        Class<? extends Annotation> annotationClass,
        Class<AttributeStrategy<?>> strategyClass );

    RandomDataProviderStrategy removeAttributeStrategy(
        Class<? extends Annotation> annotationClass );

    AbstractConstructorComparator getConstructorLightComparator();

    void setConstructorLightComparator( AbstractConstructorComparator constructorLightComparator );

    AbstractConstructorComparator getConstructorHeavyComparator();

    void setConstructorHeavyComparator( AbstractConstructorComparator constructorHeavyComparator );

    AbstractMethodComparator getMethodLightComparator();

    void setMethodLightComparator( AbstractMethodComparator methodLightComparator );

    AbstractMethodComparator getMethodHeavyComparator();

    void setMethodHeavyComparator( AbstractMethodComparator methodHeavyComparator );
}
