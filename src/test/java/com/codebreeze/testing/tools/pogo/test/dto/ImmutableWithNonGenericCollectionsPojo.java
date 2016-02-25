/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PodamCollection;
import com.codebreeze.testing.tools.pogo.common.PodamConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author mtedone
 *
 */
public class ImmutableWithNonGenericCollectionsPojo implements Serializable
{

    // ------------------->> Constants

    private static final long serialVersionUID = 1L;

    public static final int NBR_ELEMENTS = 5;

    // ------------------->> Instance / Static variables

    @SuppressWarnings( "rawtypes" )
    // This is actually intentional
    private final Collection nonGenerifiedCollection;

    @SuppressWarnings( "rawtypes" )
    // This is actually intentional
    private final Map nonGenerifiedMap;

    @SuppressWarnings( "rawtypes" )
    private final Set nonGenerifiedSet;

    // ------------------->> Constructors

    /**
     * @param nonGenerifiedCollection
     * @param nonGenerifiedMap
     */
    // This is actually intentional
    @SuppressWarnings( "rawtypes" )
    @PodamConstructor
    public ImmutableWithNonGenericCollectionsPojo(
        @PodamCollection( nbrElements = NBR_ELEMENTS ) Collection nonGenerifiedCollection,
        @PodamCollection( nbrElements = NBR_ELEMENTS ) Map nonGenerifiedMap,
        @PodamCollection( nbrElements = NBR_ELEMENTS ) Set nonGenerifiedSet )
    {
        super();
        this.nonGenerifiedCollection = nonGenerifiedCollection;
        this.nonGenerifiedMap = nonGenerifiedMap;
        this.nonGenerifiedSet = nonGenerifiedSet;
    }

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    /**
     * @return the nonGenerifiedCollection
     */
    // This is actually intentional
    @SuppressWarnings( "rawtypes" )
    public Collection getNonGenerifiedCollection()
    {
        return nonGenerifiedCollection;
    }

    /**
     * @return the nonGenerifiedMap
     */
    // This is actually intentional
    @SuppressWarnings( "rawtypes" )
    public Map getNonGenerifiedMap()
    {
        return nonGenerifiedMap;
    }

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    /**
     * @return the nonGenerifiedSet
     */
    @SuppressWarnings( "rawtypes" )
    public Set getNonGenerifiedSet()
    {
        return nonGenerifiedSet;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation
     * of this object.
     */
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

    // ------------------->> Inner classes

}
