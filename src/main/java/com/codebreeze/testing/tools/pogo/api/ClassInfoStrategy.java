package com.codebreeze.testing.tools.pogo.api;

import java.lang.reflect.Method;
import java.util.Collection;

public interface ClassInfoStrategy
{

    ClassInfo getClassInfo( Class<?> pojoClass );


    ClassAttributeApprover getClassAttributeApprover( Class<?> pojoClass );

    Collection<Method> getExtraMethods( Class<?> pojoClass );
}
