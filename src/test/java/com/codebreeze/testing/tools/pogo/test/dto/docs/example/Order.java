package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int id;

    private Calendar createDate;

    private double totalAmount;

    private List<OrderItem> orderItems = new ArrayList<>();

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public Calendar getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate( Calendar createDate )
    {
        this.createDate = createDate;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount( double totalAmount )
    {
        this.totalAmount = totalAmount;
    }

    public List<OrderItem> getOrderItems()
    {
        return orderItems;
    }

    public void setOrderItems( List<OrderItem> orderItems )
    {
        this.orderItems = orderItems;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "Order ( " + "id = " + id + TAB +
                          "createDate = " + createDate.getTime() +
                          TAB + "totalAmount = " + totalAmount +
                          TAB + "orderItems = " + orderItems +
                          TAB + " )";
        return retValue;
    }

}
