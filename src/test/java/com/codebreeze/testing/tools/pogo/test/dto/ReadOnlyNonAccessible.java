package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
