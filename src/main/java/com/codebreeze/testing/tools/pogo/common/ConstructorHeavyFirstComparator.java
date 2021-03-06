package com.codebreeze.testing.tools.pogo.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;

public class ConstructorHeavyFirstComparator implements Comparator<Constructor<?>>
{

    public static final ConstructorHeavyFirstComparator INSTANCE =
        new ConstructorHeavyFirstComparator();

    private ConstructorHeavyFirstComparator()
    {
    }

    @Override
    public int compare( Constructor<?> constructor1, Constructor<?> constructor2 )
    {
        /* Then constructors with more parameters */
        int result = -constructor1.getParameterTypes().length
                     + constructor2.getParameterTypes().length;

        if ( result != 0 )
        {
            return result;
        }

        /* Then less complex constructor */
        return constructorComplexity( constructor1 )
               - constructorComplexity( constructor2 );
    }

    private int constructorComplexity( Constructor<?> constructor )
    {
        int complexity = 0;

        for ( Class<?> parameter : constructor.getParameterTypes() )
        {
            if ( parameter.isInterface()
                    || ( Modifier.isAbstract( parameter.getModifiers() ) && !parameter.isPrimitive() )
                    || parameter.isAssignableFrom( constructor.getDeclaringClass() ) )
            {
                complexity++;
            }
        }

        return complexity;
    }

}
