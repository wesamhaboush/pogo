package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.List;
import java.util.Map;

public class PojoWithMapsAndCollections
{

    private String[] array;
    private List<Boolean> list;
    private Map<Integer, Long> map;

    public String[] getArray()
    {
        return array;
    }

    public void setArray( String[] array )
    {
        this.array = array;
    }

    public List<Boolean> getList()
    {
        return list;
    }

    public void setList( List<Boolean> list )
    {
        this.list = list;
    }

    public Map<Integer, Long> getMap()
    {
        return map;
    }

    public void setMap( Map<Integer, Long> map )
    {
        this.map = map;
    }
}
