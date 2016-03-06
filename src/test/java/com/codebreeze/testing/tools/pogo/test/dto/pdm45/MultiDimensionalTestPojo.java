package com.codebreeze.testing.tools.pogo.test.dto.pdm45;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.*;

public class MultiDimensionalTestPojo
{

    private List<List<List<String>>> threeDimensionalList;

    private Set<Set<Set<Double>>> threeDimensionalSet;

    private Collection<Collection<Collection<Long>>> threeDimensionalCollection;

    private Map<Boolean, Map<Float, Map<Integer, Calendar>>> threeDimensionalMap;

    private Queue<Queue<Queue<Date>>> threeDimensionalQueue;

    private String[][][] threeDimensionalArray;

    public List<List<List<String>>> getThreeDimensionalList()
    {
        return threeDimensionalList;
    }

    void setThreeDimensionalList(
        List<List<List<String>>> threeDimensionalList )
    {
        this.threeDimensionalList = threeDimensionalList;
    }

    public Set<Set<Set<Double>>> getThreeDimensionalSet()
    {
        return threeDimensionalSet;
    }

    void setThreeDimensionalSet( Set<Set<Set<Double>>> threeDimensionalSet )
    {
        this.threeDimensionalSet = threeDimensionalSet;
    }

    public Collection<Collection<Collection<Long>>> getThreeDimensionalCollection()
    {
        return threeDimensionalCollection;
    }

    void setThreeDimensionalCollection(
        Collection<Collection<Collection<Long>>> threeDimensionalCollection )
    {
        this.threeDimensionalCollection = threeDimensionalCollection;
    }

    public Map<Boolean, Map<Float, Map<Integer, Calendar>>> getThreeDimensionalMap()
    {
        return threeDimensionalMap;
    }

    void setThreeDimensionalMap(
        Map<Boolean, Map<Float, Map<Integer, Calendar>>> threeDimensionalMap )
    {
        this.threeDimensionalMap = threeDimensionalMap;
    }

    public Queue<Queue<Queue<Date>>> getThreeDimensionalQueue()
    {
        return threeDimensionalQueue;
    }

    void setThreeDimensionalQueue(
        Queue<Queue<Queue<Date>>> threeDimensionalQueue )
    {
        this.threeDimensionalQueue = threeDimensionalQueue;
    }

    public String[][][] getThreeDimensionalArray()
    {
        return threeDimensionalArray;
    }

    void setThreeDimensionalArray( String[][][] threeDimensionalArray )
    {
        this.threeDimensionalArray = threeDimensionalArray;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
