package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ReadOnlyNonAccessible extends ReadOnlyAbstract
{

    private final List<Integer> list = new ArrayList<>();

    private final Map<Long, String> map = new HashMap<>();

    public List<Integer> getList()
    {
        return list;
    }

    public Map<Long, String> getMap()
    {
        return map;
    }
}
