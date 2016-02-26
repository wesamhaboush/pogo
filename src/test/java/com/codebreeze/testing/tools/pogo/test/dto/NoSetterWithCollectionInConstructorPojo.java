package com.codebreeze.testing.tools.pogo.test.dto;

import com.codebreeze.testing.tools.pogo.common.PogoConstructor;

import java.io.Serializable;
import java.util.List;

public class NoSetterWithCollectionInConstructorPojo implements Serializable
{


    private static final long serialVersionUID = 1L;


    private final List<String> strList;

    private final int intField;

    @PogoConstructor
    public NoSetterWithCollectionInConstructorPojo( List<String> strList,
            int intField )
    {
        super();
        this.strList = strList;
        this.intField = intField;
    }



    public List<String> getStrList()
    {
        return strList;
    }

    public int getIntField()
    {
        return intField;
    }



    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "NoSetterWithCollectionInConstructorPojo ( " +
                          "strList = " + strList + TAB +
                          "intField = " + intField + TAB +
                          " )";
        return retValue;
    }
}
