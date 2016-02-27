package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import java.io.Serializable;


public class Article implements Serializable
{

    private static final long serialVersionUID = 1L;

    private final int id;

    private final String description;

    private final Double itemCost;

    public Article( int id,
                    String description,
                    Double itemCost )
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
        return "Article ( " + "id = " + id + TAB +
               "description = " + description + TAB +
               "itemCost = " + itemCost + TAB +
               " )";
    }

}
