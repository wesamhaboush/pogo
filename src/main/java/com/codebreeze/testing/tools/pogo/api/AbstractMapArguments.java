package com.codebreeze.testing.tools.pogo.api;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapArguments
{

    private String attributeName;
    private Map<? super Object, ? super Object> mapToBeFilled;
    private List<Annotation> annotations;

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

    public List<Annotation> getAnnotations()
    {
        return annotations;
    }

    public void setAnnotations( List<Annotation> annotations )
    {
        this.annotations = annotations;
    }

    @Override
    public String toString()
    {
        String builder = "AbstractMapArguments [mapToBeFilled=" +
                         mapToBeFilled.getClass() +
                         ", annotations=" +
                         annotations +
                         "]";
        return builder;
    }

}
