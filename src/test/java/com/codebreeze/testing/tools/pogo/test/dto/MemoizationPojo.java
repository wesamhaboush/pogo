package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Currency;
import java.util.Map;
import java.util.Set;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class MemoizationPojo
{

    private Currency single;
    private final Currency singleReadOnly;
    private Currency[] array;
    private Set<Currency> collection;
    private Map<Currency, Currency> map;

    public MemoizationPojo( Currency singleReadOnly )
    {
        this.singleReadOnly = singleReadOnly;
    }

    public Currency getSingle()
    {
        return single;
    }

    public Currency getSingleReadOnly()
    {
        return singleReadOnly;
    }

    public void setSingle( Currency single )
    {
        this.single = single;
    }

    public Currency[] getArray()
    {
        return array;
    }

    public void setArray( Currency[] array )
    {
        this.array = array;
    }

    public Set<Currency> getCollection()
    {
        return collection;
    }

    public void setCollection( Set<Currency> collection )
    {
        this.collection = collection;
    }

    public Map<Currency, Currency> getMap()
    {
        return map;
    }

    public void setMap( Map<Currency, Currency> map )
    {
        this.map = map;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
