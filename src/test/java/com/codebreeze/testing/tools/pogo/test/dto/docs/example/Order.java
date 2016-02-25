/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.codebreeze.testing.tools.pogo.common.PodamCollection;

/**
 * @author mtedone
 *
 */
public class Order implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int id;

    private Calendar createDate;

    private double totalAmount;

    @PodamCollection( nbrElements = 5 )
    private List<OrderItem> orderItems = new ArrayList<>();

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId( int id )
    {
        this.id = id;
    }

    /**
     * @return the createDate
     */
    public Calendar getCreateDate()
    {
        return createDate;
    }

    /**
     * @param createDate
     *            the createDate to set
     */
    public void setCreateDate( Calendar createDate )
    {
        this.createDate = createDate;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount()
    {
        return totalAmount;
    }

    /**
     * @param totalAmount
     *            the totalAmount to set
     */
    public void setTotalAmount( double totalAmount )
    {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the orderItems
     */
    public List<OrderItem> getOrderItems()
    {
        return orderItems;
    }

    /**
     * @param orderItems
     *            the orderItems to set
     */
    public void setOrderItems( List<OrderItem> orderItems )
    {
        this.orderItems = orderItems;
    }

    /**
     * Constructs a <code>String</code> with all attributes in name = value
     * format.
     *
     * @return a <code>String</code> representation of this object.
     */
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
