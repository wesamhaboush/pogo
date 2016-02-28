package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Map;
import java.util.TreeMap;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
