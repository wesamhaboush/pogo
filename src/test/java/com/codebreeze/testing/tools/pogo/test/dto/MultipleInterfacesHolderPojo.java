package com.codebreeze.testing.tools.pogo.test.dto;

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
}

