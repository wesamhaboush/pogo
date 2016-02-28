package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class MapExtendingImplementingPojo extends TreeMap<Integer, String>
    implements Observer
{
    @Override
    public void update( Observable o, Object arg )
    {
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
