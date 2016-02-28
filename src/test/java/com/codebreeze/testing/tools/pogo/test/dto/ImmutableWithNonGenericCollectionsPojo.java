package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ImmutableWithNonGenericCollectionsPojo
{
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

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
