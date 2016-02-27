package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import java.io.Serializable;

public class OrderItem implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int id;

    private String note;

    private double lineAmount;

    private Article article;

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote( String note )
    {
        this.note = note;
    }

    public double getLineAmount()
    {
        return lineAmount;
    }

    public void setLineAmount( double lineAmount )
    {
        this.lineAmount = lineAmount;
    }

    public Article getArticle()
    {
        return article;
    }

    public void setArticle( Article article )
    {
        this.article = article;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        return "OrderItem ( " + "id = " + id + TAB +
               "note = " + note + TAB +
               "lineAmount = " + lineAmount + TAB +
               "article = " + article + TAB + " )";
    }

}
