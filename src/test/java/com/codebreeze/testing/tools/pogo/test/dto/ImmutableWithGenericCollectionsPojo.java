package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PogoCollection;
import com.codebreeze.testing.tools.pogo.common.PogoConstructor;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ImmutableWithGenericCollectionsPojo implements Serializable
{


    private static final long serialVersionUID = 1L;

    public static final int NBR_ELEMENTS = 5;


    private final Collection<OneDimensionalTestPojo> generifiedCollection;

    private final Map<String, Calendar> generifiedMap;

    private final Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet;


    @PogoConstructor
    public ImmutableWithGenericCollectionsPojo(
        @PogoCollection( nbrElements = NBR_ELEMENTS ) Collection<OneDimensionalTestPojo> generifiedCollection,
        @PogoCollection( nbrElements = NBR_ELEMENTS ) Map<String, Calendar> generifiedMap,
        @PogoCollection( nbrElements = NBR_ELEMENTS ) Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet )
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
        final String TAB = "    ";
        String retValue = "ImmutableWithNonGenericCollectionsPojo ( " +
                          "nonGenerifiedCollection = " +
                          generifiedCollection + TAB +
                          "nonGenerifiedMap = " + generifiedMap +
                          TAB + "nonGenerifiedSet = " +
                          generifiedSet + TAB + " )";
        return retValue;
    }

}
