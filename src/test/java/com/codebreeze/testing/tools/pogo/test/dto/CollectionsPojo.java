package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsPojo
{

    private List<String> strList = new ArrayList<>();

    private ArrayList<String> arrayListStr = new ArrayList<>();

    private List<String> copyOnWriteList = new CopyOnWriteArrayList<>();

    private Set<String> strSet = new HashSet<>();

    private HashSet<String> hashSetStr = new HashSet<>();

    private Collection<String> strCollection = new ArrayList<>();

    private Map<String, OneDimensionalTestPojo> map = new HashMap<>();

    private HashMap<String, OneDimensionalTestPojo> hashMap = new HashMap<>();

    private ConcurrentMap<String, OneDimensionalTestPojo> concurrentHashMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, OneDimensionalTestPojo> concurrentHashMapImpl = new ConcurrentHashMap<>();

    private Queue<SimplePojoToTestSetters> queue;

    @SuppressWarnings( "rawtypes" )
    private List nonGenerifiedList;

    @SuppressWarnings( "rawtypes" )
    private Map nonGenerifiedMap;


    public List<String> getStrList()
    {
        return strList;
    }

    public ArrayList<String> getArrayListStr()
    {
        return arrayListStr;
    }

    public Set<String> getStrSet()
    {
        return strSet;
    }

    public HashSet<String> getHashSetStr()
    {
        return hashSetStr;
    }

    public Collection<String> getStrCollection()
    {
        return strCollection;
    }

    public Map<String, OneDimensionalTestPojo> getMap()
    {
        return map;
    }


    public void setStrList( List<String> strList )
    {
        this.strList = strList;
    }

    public void setArrayListStr( ArrayList<String> arrayListStr )
    {
        this.arrayListStr = arrayListStr;
    }

    public void setStrSet( Set<String> strSet )
    {
        this.strSet = strSet;
    }

    public void setHashSetStr( HashSet<String> hashSetStr )
    {
        this.hashSetStr = hashSetStr;
    }

    public void setStrCollection( Collection<String> strCollection )
    {
        this.strCollection = strCollection;
    }

    public void setMap( Map<String, OneDimensionalTestPojo> map )
    {
        this.map = map;
    }

    public List<String> getCopyOnWriteList()
    {
        return copyOnWriteList;
    }

    public void setCopyOnWriteList( List<String> copyOnWriteList )
    {
        this.copyOnWriteList = copyOnWriteList;
    }

    public HashMap<String, OneDimensionalTestPojo> getHashMap()
    {
        return hashMap;
    }

    public void setHashMap( HashMap<String, OneDimensionalTestPojo> hashMap )
    {
        this.hashMap = hashMap;
    }

    public ConcurrentMap<String, OneDimensionalTestPojo> getConcurrentHashMap()
    {
        return concurrentHashMap;
    }

    public void setConcurrentHashMap(
        ConcurrentMap<String, OneDimensionalTestPojo> concurrentHashMap )
    {
        this.concurrentHashMap = concurrentHashMap;
    }

    public ConcurrentHashMap<String, OneDimensionalTestPojo> getConcurrentHashMapImpl()
    {
        return concurrentHashMapImpl;
    }

    public void setConcurrentHashMapImpl(
        ConcurrentHashMap<String, OneDimensionalTestPojo> concurrentHashMapImpl )
    {
        this.concurrentHashMapImpl = concurrentHashMapImpl;
    }

    public Queue<SimplePojoToTestSetters> getQueue()
    {
        return queue;
    }

    public void setQueue( Queue<SimplePojoToTestSetters> queue )
    {
        this.queue = queue;
    }

    @SuppressWarnings( "rawtypes" )
    public List getNonGenerifiedList()
    {
        return nonGenerifiedList;
    }

    @SuppressWarnings( "rawtypes" )
    public void setNonGenerifiedList( List nonGenerifiedList )
    {
        this.nonGenerifiedList = nonGenerifiedList;
    }

    @SuppressWarnings( "rawtypes" )
    public Map getNonGenerifiedMap()
    {
        return nonGenerifiedMap;
    }

    @SuppressWarnings( "rawtypes" )
    public void setNonGenerifiedMap( Map nonGenerifiedMap )
    {
        this.nonGenerifiedMap = nonGenerifiedMap;
    }


}
