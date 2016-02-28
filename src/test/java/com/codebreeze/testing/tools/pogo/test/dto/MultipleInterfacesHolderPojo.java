package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class MultipleInterfacesHolderPojo<K, V>
{
    private MultipleInterfacesListPojo<K> list;

    private MultipleInterfacesMapPojo<K, V> map;

    public MultipleInterfacesListPojo<K> getList()
    {
        return list;
    }

    public void setList( MultipleInterfacesListPojo<K> list )
    {
        this.list = list;
    }

    public MultipleInterfacesMapPojo<K, V> getMap()
    {
        return map;
    }

    public void setMap( MultipleInterfacesMapPojo<K, V> map )
    {
        this.map = map;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}

