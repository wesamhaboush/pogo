package com.codebreeze.testing.tools.pogo.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;

public abstract class AbstractConstructorComparator implements Comparator<Constructor<?>>
{

    public int constructorComplexity( Constructor<?> constructor )
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

    public int compareAnnotations( Constructor<?> constructor1, Constructor<?> constructor2 )
    {
        /* Constructors with Pogo annotation first */
        boolean choose1 = constructor1.getAnnotation( PogoConstructor.class ) != null;
        boolean choose2 = constructor2.getAnnotation( PogoConstructor.class ) != null;

        if ( choose1 && !choose2 )
        {
            return Integer.MIN_VALUE;
        }
        else if ( !choose1 && choose2 )
        {
            return Integer.MAX_VALUE;
        }

        return 0;
    }

}
