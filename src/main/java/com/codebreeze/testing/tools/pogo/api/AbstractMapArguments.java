package com.codebreeze.testing.tools.pogo.api;

import java.util.Map;

public abstract class AbstractMapArguments
{

    private String attributeName;
    private Map<? super Object, ? super Object> mapToBeFilled;

    public String getAttributeName()
    {
        return attributeName;
    }

    public void setAttributeName( String attributeName )
    {
        this.attributeName = attributeName;
    }

    public Map<? super Object, ? super Object> getMapToBeFilled()
    {
        return mapToBeFilled;
    }

    public void setMapToBeFilled(
        Map<? super Object, ? super Object> mapToBeFilled )
    {
        this.mapToBeFilled = mapToBeFilled;
    }

    @Override
    public String toString()
    {
        String builder = "AbstractMapArguments [mapToBeFilled=" +
                         mapToBeFilled.getClass() +
                         "]";
        return builder;
    }

}
