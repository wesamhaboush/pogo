package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class MultipleGenericInConstructorPojo<T, E, K, V>
{

    private final Class<T> type;

    private final List<E> list;

    private final Map<K, V> map;

    public MultipleGenericInConstructorPojo( Class<T> type, List<E> list, Map<K, V> map )
    {
        this.type = type;
        this.list = list;
        this.map = map;
    }

    public Class<T> getType()
    {
        return type;
    }

    public List<E> getList()
    {
        return list;
    }

    public Map<K, V> getMap()
    {
        return map;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
