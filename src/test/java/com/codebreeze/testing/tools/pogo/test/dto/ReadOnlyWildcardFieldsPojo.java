package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ReadOnlyWildcardFieldsPojo
{

    private final Class<?> clazz = Object.class;

    private final List<?> list = new ArrayList<>();

    private final Map<?, ?> map = new HashMap<>();

    public Class<?> getClazz()
    {
        return clazz;
    }

    public List<?> getList()
    {
        return list;
    }

    public Map<?, ?> getMap()
    {
        return map;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
