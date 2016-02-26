package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import com.codebreeze.testing.tools.pogo.common.PogoConstructor;
import com.codebreeze.testing.tools.pogo.common.PogoDoubleValue;
import com.codebreeze.testing.tools.pogo.common.PogoIntValue;

import java.io.Serializable;


public class Article implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final int id;

    private final String description;

    private final Double itemCost;

    @PogoConstructor( comment = "Immutable-like POJOs must be annotated with @PogoConstructor" )
    public Article( @PogoIntValue( maxValue = 100000 ) int id,
                    String description,
                    @PogoDoubleValue( minValue = 50.0 ) Double itemCost )
    {
        super();
        this.id = id;
        this.description = description;
        this.itemCost = itemCost;
    }

    public int getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public Double getItemCost()
    {
        return itemCost;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "Article ( " + "id = " + id + TAB +
                          "description = " + description + TAB +
                          "itemCost = " + itemCost + TAB +
                          " )";
        return retValue;
    }

}
