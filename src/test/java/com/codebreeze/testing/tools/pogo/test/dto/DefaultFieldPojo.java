package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Map;
import java.util.TreeMap;

/**
 * Pojo with default field
 *
 * @author daivanov
 *
 */
public class DefaultFieldPojo<K, V>
{

    private Map<K, V> map = new TreeMap<>();

    public DefaultFieldPojo( K key )
    {
        map.remove( key );
    }

    public Map<K, V> getMap()
    {
        return map;
    }

    public void setMap( Map<K, V> map )
    {
        this.map = map;
    }
}
