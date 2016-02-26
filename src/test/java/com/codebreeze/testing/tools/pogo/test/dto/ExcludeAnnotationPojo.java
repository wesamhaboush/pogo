package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PogoExclude;

import java.io.Serializable;

public class ExcludeAnnotationPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int intField;

    @PogoExclude
    private SimplePojoToTestSetters somePojo;


    public ExcludeAnnotationPojo()
    {
    }


    public int getIntField()
    {
        return intField;
    }

    public void setIntField( int intField )
    {
        this.intField = intField;
    }

    public SimplePojoToTestSetters getSomePojo()
    {
        return somePojo;
    }

    public void setSomePojo( SimplePojoToTestSetters somePojo )
    {
        this.somePojo = somePojo;
    }


    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "ExcludeAnnotationPojo ( " + "intField = " +
                          intField + TAB + "somePojo = " +
                          somePojo + TAB + " )";
        return retValue;
    }


}
