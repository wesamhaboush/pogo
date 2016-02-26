package com.codebreeze.testing.tools.pogo.test.dto.pdm45;

import com.codebreeze.testing.tools.pogo.common.PogoCollection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GenericPojo<F, S>
{

    private F firstValue;
    private S secondValue;
    @PogoCollection( nbrElements = 2 )
    private List<F> firstList;
    @PogoCollection( nbrElements = 2 )
    private S[] secondArray;
    @PogoCollection( nbrElements = 2 )
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
        return "GenericPojo [firstValue=" + firstValue + ", secondValue="
               + secondValue + ", firstList=" + firstList + ", secondArray="
               + Arrays.toString( secondArray ) + ", firstSecondMap="
               + firstSecondMap + "]";
    }
}
