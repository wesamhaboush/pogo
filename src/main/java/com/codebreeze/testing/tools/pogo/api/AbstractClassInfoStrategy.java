package com.codebreeze.testing.tools.pogo.api;

import java.lang.reflect.Method;
import java.util.*;

public abstract class AbstractClassInfoStrategy implements ClassInfoStrategy,
    ClassAttributeApprover
{

    private final Map<Class<?>, List<Method>> extraMethods = new HashMap<>();


    public void addExtraMethod(
        Class<?> pojoClass, String methodName, Class<?> ... methodArgs )
    throws NoSuchMethodException, SecurityException
    {
        Method method = pojoClass.getMethod( methodName, methodArgs );
        List<Method> methods = extraMethods.get( pojoClass );

        if ( methods == null )
        {
            methods = new ArrayList<>();
            extraMethods.put( pojoClass, methods );
        }

        methods.add( method );
    }

    @Override
    public boolean approve( ClassAttribute attribute )
    {
        return ( attribute.getAttribute() != null );
    }

    @Override
    public ClassInfo getClassInfo( Class<?> pojoClass )
    {
        return PogoUtils.getClassInfo( pojoClass, this );
    }

    @Override
    public ClassAttributeApprover getClassAttributeApprover( Class<?> pojoClass )
    {
        return this;
    }

    @Override
    public Collection<Method> getExtraMethods( Class<?> pojoClass )
    {
        return extraMethods.get( pojoClass );
    }
}
