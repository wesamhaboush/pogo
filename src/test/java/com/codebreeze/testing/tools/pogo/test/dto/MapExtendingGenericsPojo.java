package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.TreeMap;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class MapExtendingGenericsPojo extends TreeMap<Integer, String>
{
    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
