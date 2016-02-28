package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Hashtable;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ImmutableHashtable<K, V> extends Hashtable<K, V>
{
    private static final long serialVersionUID = -1L;

    @Override
    public V put( K key, V value )
    {
        throw new UnsupportedOperationException( "Immutable hashtable" );
    }

    @Override
    public V remove( Object key )
    {
        throw new UnsupportedOperationException( "Immutable hashtable" );
    }

    @Override
    public void putAll( Map<? extends K, ? extends V> m )
    {
        throw new UnsupportedOperationException( "Immutable hashtable" );
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException( "Immutable hashtable" );
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
