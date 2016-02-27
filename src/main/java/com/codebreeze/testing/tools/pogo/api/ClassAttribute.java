package com.codebreeze.testing.tools.pogo.api;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class ClassAttribute implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final Field attribute;

    private final Set<Method> getters = new HashSet<>();

    private final Set<Method> setters = new HashSet<>();

    public ClassAttribute( Field attribute, Set<Method> getters, Set<Method> setters )
    {
        this.attribute = attribute;
        this.getters.addAll( getters );
        this.setters.addAll( setters );
    }

    public Field getAttribute()
    {
        return attribute;
    }

    public Set<Method> getGetters()
    {
        return new HashSet<>( getters );
    }

    Set<Method> getRawGetters()
    {
        return getters;
    }

    public Set<Method> getSetters()
    {
        return new HashSet<>( setters );
    }

    Set<Method> getRawSetters()
    {
        return setters;
    }

    @Override
    public int hashCode()
    {
        int hashCode = getters.hashCode() ^ setters.hashCode();

        if ( attribute != null )
        {
            hashCode ^= attribute.hashCode();
        }

        return hashCode;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
        {
            return true;
        }

        if ( !( obj instanceof ClassAttribute ) )
        {
            return false;
        }

        ClassAttribute other = ( ClassAttribute ) obj;

        if ( attribute != null && !attribute.equals( other.getAttribute() ) )
        {
            return false;
        }

        return setters.equals( other.getSetters() ) && getters.equals( other.getGetters() );
    }

    @Override
    public String toString()
    {
        return String.valueOf( attribute ) +
               "={ getters: {" +
               getters +
               "}, { setters: {" +
               setters +
               "}}";
    }

}
