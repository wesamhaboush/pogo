package com.codebreeze.testing.tools.pogo.common;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Comparator;

public class MethodLightFirstComparator implements Comparator<Method>
{

    public static final MethodLightFirstComparator INSTANCE =
        new MethodLightFirstComparator();

    private MethodLightFirstComparator()
    {
    }

    @Override
    public int compare( Method method1, Method method2 )
    {
        /* Then constructors with less parameters */
        int result = method1.getParameterTypes().length
                     - method2.getParameterTypes().length;

        if ( result != 0 )
        {
            return result;
        }

        /* Then less complex method */
        return methodComplexity( method1 )
               - methodComplexity( method2 );
    }

    private int methodComplexity( Method method )
    {
        int complexity = 0;

        for ( Class<?> parameter : method.getParameterTypes() )
        {
            if ( parameter.isInterface()
                    || ( Modifier.isAbstract( parameter.getModifiers() ) && !parameter.isPrimitive() )
                    || parameter.isAssignableFrom( method.getDeclaringClass() ) )
            {
                complexity++;
            }
        }

        return complexity;
    }

}
