/**
 *
 */
package com.codebreeze.testing.tools.pogo.api;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * This class wraps fields, getters and setters information of the same attribute
 * <p>
 * The purpose of this class is to carry information about single attribute
 * of POJO class.
 * </p>
 *
 * @author daivanov
 *
 * @since 5.1.0
 *
 */
public class ClassAttribute implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** The Set of fields belonging to this class */
    private final Field attribute;

    /** The Set of getters for this attribute in the class */
    private final Set<Method> getters = new HashSet<>();

    /** The Set of setters for this attribute in the class */
    private final Set<Method> setters = new HashSet<>();

    /**
     * Full constructor
     *
     * @param attribute
     *            attribute, can be null
     * @param getters
     *            The set of getters for this attributes
     * @param setters
     *            The set of setters for this attributes
     */
    public ClassAttribute( Field attribute, Set<Method> getters, Set<Method> setters )
    {
        this.attribute = attribute;
        this.getters.addAll( getters );
        this.setters.addAll( setters );
    }

    /**
     * It returns the attribute
     *
     * @return the classFields
     */
    public Field getAttribute()
    {
        return attribute;
    }

    /**
     * It returns the attribute getters
     *
     * @return the getters
     */
    public Set<Method> getGetters()
    {
        return new HashSet<>( getters );
    }

    Set<Method> getRawGetters()
    {
        return getters;
    }

    /**
     * It returns the attribute setters
     *
     * @return the setters
     */
    public Set<Method> getSetters()
    {
        return new HashSet<>( setters );
    }

    Set<Method> getRawSetters()
    {
        return setters;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

        if ( !setters.equals( other.getSetters() ) )
        {
            return false;
        }

        return getters.equals( other.getGetters() );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        String builder = String.valueOf( attribute ) +
                         "={ getters: {" +
                         getters +
                         "}, { setters: {" +
                         setters +
                         "}}";
        return builder;
    }

}
