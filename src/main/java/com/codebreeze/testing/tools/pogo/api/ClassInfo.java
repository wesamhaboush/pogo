package com.codebreeze.testing.tools.pogo.api;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

public class ClassInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final Class<?> className;

    private final Set<ClassAttribute> classAttributes = new HashSet<>();

    public ClassInfo( Class<?> className, Collection<ClassAttribute> classAttributes )
    {
        this( className, classAttributes, Collections.<Method>emptyList() );
    }

    public ClassInfo( Class<?> className, Collection<ClassAttribute> classAttributes, Collection<Method> extraMethods )
    {
        this.className = className;
        this.classAttributes.addAll( classAttributes );
        List<Method> extraMethods1 = new ArrayList<Method>();
        extraMethods1.addAll( extraMethods );
    }

    public Set<ClassAttribute> getClassAttributes()
    {
        return new HashSet<>( classAttributes );
    }

    public Class<?> getClassName()
    {
        return className;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                 + ( classAttributes == null ? 0 : classAttributes.hashCode() );
        result = prime * result
                 + ( className == null ? 0 : className.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }

        if ( obj == null )
        {
            return false;
        }

        if ( this.getClass() != obj.getClass() )
        {
            return false;
        }

        ClassInfo other = ( ClassInfo ) obj;

        if ( classAttributes == null )
        {
            if ( other.classAttributes != null )
            {
                return false;
            }
        }
        else if ( !classAttributes.equals( other.classAttributes ) )
        {
            return false;
        }

        if ( className == null )
        {
            if ( other.className != null )
            {
                return false;
            }
        }
        else if ( !className.getName().equals( other.className.getName() ) )
        {
            return false;
        }

        return true;
    }
}
