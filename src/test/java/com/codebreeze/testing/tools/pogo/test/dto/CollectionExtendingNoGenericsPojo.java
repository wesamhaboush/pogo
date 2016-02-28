package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.LinkedList;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

@SuppressWarnings( "rawtypes" )
public class CollectionExtendingNoGenericsPojo extends LinkedList
{
    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
