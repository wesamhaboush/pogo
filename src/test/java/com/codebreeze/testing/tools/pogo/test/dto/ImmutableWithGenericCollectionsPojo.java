package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ImmutableWithGenericCollectionsPojo implements Serializable
{


    private static final long serialVersionUID = 1L;

    private final Collection<OneDimensionalTestPojo> generifiedCollection;

    private final Map<String, Calendar> generifiedMap;

    private final Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet;


    public ImmutableWithGenericCollectionsPojo(
        Collection<OneDimensionalTestPojo> generifiedCollection,
        Map<String, Calendar> generifiedMap,
        Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet )
    {
        super();
        this.generifiedCollection = generifiedCollection;
        this.generifiedMap = generifiedMap;
        this.generifiedSet = generifiedSet;
    }


    public Collection<OneDimensionalTestPojo> getGenerifiedCollection()
    {
        return generifiedCollection;
    }

    public Map<String, Calendar> getGenerifiedMap()
    {
        return generifiedMap;
    }

    public Set<ImmutableWithNonGenericCollectionsPojo> getGenerifiedSet()
    {
        return generifiedSet;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
