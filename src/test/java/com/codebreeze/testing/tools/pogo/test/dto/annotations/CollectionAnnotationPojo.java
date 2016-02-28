package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class CollectionAnnotationPojo
{
    private List<String> strList = new ArrayList<>();

    private String[] strArray = new String[5];

    private Map<String, String> stringMap = new HashMap<>();

    public List<String> getStrList()
    {
        return strList;
    }

    public void setStrList( List<String> strList )
    {
        this.strList = strList;
    }

    public String[] getStrArray()
    {
        return strArray;
    }

    public void setStrArray( String[] strArray )
    {
        this.strArray = strArray;
    }

    public Map<String, String> getStringMap()
    {
        return stringMap;
    }

    public void setStringMap( Map<String, String> stringMap )
    {
        this.stringMap = stringMap;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
