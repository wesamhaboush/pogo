package com.codebreeze.testing.tools.pogo.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;

public interface ClassInfoStrategy
{

    Set<Class<? extends Annotation>> getExcludedAnnotations();

    Set<String> getExcludedFields( Class<?> pojoClass );

    ClassInfo getClassInfo( Class<?> pojoClass );


    ClassAttributeApprover getClassAttributeApprover( Class<?> pojoClass );

    Collection<Method> getExtraMethods( Class<?> pojoClass );
}
