package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class NoSetterWithCollectionInConstructorPojo
{
    private final List<String> strList;

    private final int intField;

    public NoSetterWithCollectionInConstructorPojo( List<String> strList,
            int intField )
    {
        super();
        this.strList = strList;
        this.intField = intField;
    }

    public List<String> getStrList()
    {
        return strList;
    }

    public int getIntField()
    {
        return intField;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
