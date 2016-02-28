package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Hashtable;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class UnsupportedMapInConstructorPojo<K, V>
{

    private final Hashtable<K, V> hashTable;

    public UnsupportedMapInConstructorPojo( Hashtable<K, V> hashTable )
    {
        this.hashTable = hashTable;
    }

    public Hashtable<K, V> getHashTable()
    {
        return hashTable;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
