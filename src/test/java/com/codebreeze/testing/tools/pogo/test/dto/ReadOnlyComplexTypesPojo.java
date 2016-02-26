package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadOnlyComplexTypesPojo
{

    public static class Value
    {
        private String value;

        public String getValue()
        {
            return value;
        }

        public void setValue( String value )
        {
            this.value = value;
        }
    }

    private final List<Integer> list = new ArrayList<>();

    private final Map<Long, String> map = new HashMap<>();

    private final Value value = new Value();

    public List<Integer> getList()
    {
        return list;
    }

    public Map<Long, String> getMap()
    {
        return map;
    }

    public Value getValue()
    {
        return value;
    }
}
