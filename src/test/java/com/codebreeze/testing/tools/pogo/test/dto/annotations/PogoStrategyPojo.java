package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import java.util.*;

public class PogoStrategyPojo
{
    private String postCode;

    private String postCode2;

    private final String postCode3;

    private byte[] byteData;

    private Calendar myBirthday;

    private List<Calendar> myBirthdays = new ArrayList<>();

    private List<Object> objectList = new ArrayList<>();

    private Map<String, Calendar> myBirthdaysMap = new HashMap<>();

    @SuppressWarnings( "rawtypes" )
    private List nonGenericObjectList = new ArrayList();

    private Calendar[] myBirthdaysArray;

    private Object[] myObjectArray;

    public PogoStrategyPojo( String postCode3 )
    {
        this.postCode3 = postCode3;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode( String postCode )
    {
        this.postCode = postCode;
    }

    public String getPostCode2()
    {
        return postCode2;
    }

    public void setPostCode2( String postCode2 )
    {
        this.postCode2 = postCode2;
    }

    public String getPostCode3()
    {
        return postCode3;
    }

    public byte[] getByteData()
    {
        return byteData;
    }

    public void setByteData( byte[] byteData )
    {
        this.byteData = byteData;
    }

    public Calendar getMyBirthday()
    {
        return myBirthday;
    }

    public void setMyBirthday( Calendar myBirthday )
    {
        this.myBirthday = myBirthday;
    }

    public List<Calendar> getMyBirthdays()
    {
        return myBirthdays;
    }

    public void setMyBirthdays( List<Calendar> myBirthdays )
    {
        this.myBirthdays = myBirthdays;
    }

    public Calendar[] getMyBirthdaysArray()
    {
        return myBirthdaysArray;
    }

    public void setMyBirthdaysArray( Calendar[] myBirthdaysArray )
    {
        this.myBirthdaysArray = myBirthdaysArray;
    }

    public List<Object> getObjectList()
    {
        return objectList;
    }

    public void setObjectList( List<Object> objectList )
    {
        this.objectList = objectList;
    }

    public Object[] getMyObjectArray()
    {
        return myObjectArray;
    }

    public void setMyObjectArray( Object[] myObjectArray )
    {
        this.myObjectArray = myObjectArray;
    }

    @SuppressWarnings( "rawtypes" )
    public List getNonGenericObjectList()
    {
        return nonGenericObjectList;
    }

    public void setNonGenericObjectList(
        @SuppressWarnings( "rawtypes" ) List nonGenericObjectList )
    {
        this.nonGenericObjectList = nonGenericObjectList;
    }

    public Map<String, Calendar> getMyBirthdaysMap()
    {
        return myBirthdaysMap;
    }

    public void setMyBirthdaysMap( Map<String, Calendar> myBirthdaysMap )
    {
        this.myBirthdaysMap = myBirthdaysMap;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        return "PogoStrategyPojo ( " + "postCode = " +
               postCode + TAB + "postCode2 = " +
               postCode2 + TAB + "postCode3 = " +
               postCode3 + TAB + "myBirthday = " +
               myBirthday + TAB + "myBirthdays = " +
               myBirthdays + TAB + "objectList = " +
               objectList + TAB + "myBirthdaysMap = " +
               myBirthdaysMap + TAB +
               "nonGenericObjectList = " + nonGenericObjectList +
               TAB + "myBirthdaysArray = " +
               myBirthdaysArray + TAB +
               "myObjectArray = " + myObjectArray + TAB +
               " )";
    }
}
