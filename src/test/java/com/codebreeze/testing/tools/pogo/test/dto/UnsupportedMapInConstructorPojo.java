/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Hashtable;

/**
 * @author daivanov
 *
 */
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
}
