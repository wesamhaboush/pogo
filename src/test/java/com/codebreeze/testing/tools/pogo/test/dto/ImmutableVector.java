package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Collection;
import java.util.Vector;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ImmutableVector<E> extends Vector<E>
{
    private static final long serialVersionUID = 1L;

    @Override
    public boolean add( E e )
    {
        throw new UnsupportedOperationException( "Immutable vector" );
    }

    @Override
    public boolean remove( Object o )
    {
        throw new UnsupportedOperationException( "Immutable vector" );
    }

    @Override
    public boolean addAll( Collection<? extends E> c )
    {
        throw new UnsupportedOperationException( "Immutable vector" );
    }

    @Override
    public boolean removeAll( Collection<?> c )
    {
        throw new UnsupportedOperationException( "Immutable vector" );
    }

    @Override
    public boolean retainAll( Collection<?> c )
    {
        throw new UnsupportedOperationException( "Immutable vector" );
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException( "Immutable vector" );
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
