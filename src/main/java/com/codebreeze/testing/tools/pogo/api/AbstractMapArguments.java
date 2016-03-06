package com.codebreeze.testing.tools.pogo.api;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

abstract class AbstractMapArguments
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
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }

}
