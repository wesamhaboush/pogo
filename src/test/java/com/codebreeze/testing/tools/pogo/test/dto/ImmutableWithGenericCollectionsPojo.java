package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PodamCollection;
import com.codebreeze.testing.tools.pogo.common.PodamConstructor;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ImmutableWithGenericCollectionsPojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    public static final int NBR_ELEMENTS = 5;

    // ------------------->> Instance / Static variables

    private final Collection<OneDimensionalTestPojo> generifiedCollection;

    private final Map<String, Calendar> generifiedMap;

    private final Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet;

    // ------------------->> Constructors

    @PodamConstructor
    public ImmutableWithGenericCollectionsPojo(
        @PodamCollection( nbrElements = NBR_ELEMENTS ) Collection<OneDimensionalTestPojo> generifiedCollection,
        @PodamCollection( nbrElements = NBR_ELEMENTS ) Map<String, Calendar> generifiedMap,
        @PodamCollection( nbrElements = NBR_ELEMENTS ) Set<ImmutableWithNonGenericCollectionsPojo> generifiedSet )
    {
        super();
        this.generifiedCollection = generifiedCollection;
        this.generifiedMap = generifiedMap;
        this.generifiedSet = generifiedSet;
    }

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    /**
     * @return the generifiedCollection
     */
    public Collection<OneDimensionalTestPojo> getGenerifiedCollection()
    {
        return generifiedCollection;
    }

    /**
     * @return the generifiedMap
     */
    public Map<String, Calendar> getGenerifiedMap()
    {
        return generifiedMap;
    }

    /**
     * @return the generifiedSet
     */
    public Set<ImmutableWithNonGenericCollectionsPojo> getGenerifiedSet()
    {
        return generifiedSet;
    }

    /**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     *
     * @return a <code>String</code> representation of this object.
     */
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

    // ------------------->> Inner classes

}
