package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

import java.io.Serializable;
import java.util.*;

public class CollectionAnnotationPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private List<String> strList = new ArrayList<>();

    private String[] strArray = new String[PogoTestConstants.ANNOTATION_COLLECTION_NBR_ELEMENTS];

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
        final String TAB = "    ";
        return "CollectionAnnotationPojo ( " + "strList = " +
               strList + TAB + "strArray = " +
               Arrays.toString( strArray ) + TAB +
               "stringMap = " + stringMap + TAB +
               " )";
    }
}
