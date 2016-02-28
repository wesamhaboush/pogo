package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ReadOnlyGenericComplexTypesPojo<T, E, K>
{

    public static class Value<T>
    {
        private T value;

        public T getValue()
        {
            return value;
        }

        public void setValue( T value )
        {
            this.value = value;
        }
    }

    private final List<E> list = new ArrayList<>();

    private final Map<K, String> map = new HashMap<>();

    private final Value<T> value = new Value<>();

    public List<E> getList()
    {
        return list;
    }

    public Map<K, String> getMap()
    {
        return map;
    }

    public Value<T> getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
