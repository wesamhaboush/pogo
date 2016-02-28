package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ImmutableDefaultFieldsPojo
{

    private List<String> list = Collections.singletonList( "key" );

    private Map<String, Integer> map = Collections.singletonMap( "key", 100 );

    public List<String> getList()
    {
        return list;
    }

    public void setList( List<String> list )
    {
        this.list = list;
    }

    public Map<String, Integer> getMap()
    {
        return map;
    }

    public void setMap( Map<String, Integer> map )
    {
        this.map = map;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
