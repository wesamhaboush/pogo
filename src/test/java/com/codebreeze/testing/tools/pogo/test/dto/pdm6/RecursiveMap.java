package com.codebreeze.testing.tools.pogo.test.dto.pdm6;

import java.util.Map;

public class RecursiveMap
{

    private Map<String, RecursiveMap> map;

    public Map<String, RecursiveMap> getMap()
    {
        return this.map;
    }

    public void setMap( Map<String, RecursiveMap> map )
    {
        this.map = map;
    }
}
