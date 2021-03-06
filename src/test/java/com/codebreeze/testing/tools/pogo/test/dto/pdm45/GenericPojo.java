package com.codebreeze.testing.tools.pogo.test.dto.pdm45;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GenericPojo<F, S>
{

    private F firstValue;
    private S secondValue;
    private List<F> firstList;
    private S[] secondArray;
    private Map<F, S> firstSecondMap;

    public F getFirstValue()
    {
        return firstValue;
    }

    public void setFirstValue( F firstValue )
    {
        this.firstValue = firstValue;
    }

    public S getSecondValue()
    {
        return secondValue;
    }

    public void setSecondValue( S secondValue )
    {
        this.secondValue = secondValue;
    }

    public List<F> getFirstList()
    {
        return firstList;
    }

    public void setFirstList( List<F> firstList )
    {
        this.firstList = firstList;
    }

    public S[] getSecondArray()
    {
        return secondArray;
    }

    public void setSecondArray( S[] secondArray )
    {
        this.secondArray = secondArray;
    }

    public Map<F, S> getFirstSecondMap()
    {
        return firstSecondMap;
    }

    public void setFirstSecondMap( Map<F, S> firstSecondMap )
    {
        this.firstSecondMap = firstSecondMap;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
