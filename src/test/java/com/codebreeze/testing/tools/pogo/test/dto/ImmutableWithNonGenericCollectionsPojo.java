package com.codebreeze.testing.tools.pogo.test.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ImmutableWithNonGenericCollectionsPojo implements Serializable
{


    private static final long serialVersionUID = 1L;

    public static final int NBR_ELEMENTS = 5;


    @SuppressWarnings( "rawtypes" )
    private final Collection nonGenerifiedCollection;

    @SuppressWarnings( "rawtypes" )
    private final Map nonGenerifiedMap;

    @SuppressWarnings( "rawtypes" )
    private final Set nonGenerifiedSet;


    // This is actually intentional
    @SuppressWarnings( "rawtypes" )
    public ImmutableWithNonGenericCollectionsPojo(
        Collection nonGenerifiedCollection,
        Map nonGenerifiedMap,
        Set nonGenerifiedSet )
    {
        super();
        this.nonGenerifiedCollection = nonGenerifiedCollection;
        this.nonGenerifiedMap = nonGenerifiedMap;
        this.nonGenerifiedSet = nonGenerifiedSet;
    }


    // This is actually intentional
    @SuppressWarnings( "rawtypes" )
    public Collection getNonGenerifiedCollection()
    {
        return nonGenerifiedCollection;
    }

    // This is actually intentional
    @SuppressWarnings( "rawtypes" )
    public Map getNonGenerifiedMap()
    {
        return nonGenerifiedMap;
    }



    @SuppressWarnings( "rawtypes" )
    public Set getNonGenerifiedSet()
    {
        return nonGenerifiedSet;
    }

    public String toString()
    {
        final String TAB = "    ";
        String retValue = "ImmutableWithNonGenericCollectionsPojo ( " +
                          "nonGenerifiedCollection = " + this.nonGenerifiedCollection + TAB +
                          "nonGenerifiedMap = " + this.nonGenerifiedMap + TAB +
                          "nonGenerifiedSet = " + this.nonGenerifiedSet + TAB +
                          " )";
        return retValue;
    }

}
