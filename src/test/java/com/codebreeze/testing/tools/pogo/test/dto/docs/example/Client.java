/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.codebreeze.testing.tools.pogo.common.PodamCollection;
import com.codebreeze.testing.tools.pogo.common.PodamStringValue;

/**
 * @author mtedone
 *
 */
public class Client implements Serializable
{

    private static final long serialVersionUID = 1L;

    @PodamStringValue( strValue = "Michael" )
    private String firstName;

    private String lastName;

    private Calendar dateCreated;

    // Let's make some orders
    @PodamCollection( nbrElements = 3 )
    private List<Order> orders = new ArrayList<>();

    // Let's have few addresses
    @PodamCollection( nbrElements = 2 )
    private List<Address> addresses = new ArrayList<>();

    // Default is one bank account
    private List<BankAccount> bankAccounts = new ArrayList<>();

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    /**
     * @return the dateCreated
     */
    public Calendar getDateCreated()
    {
        return dateCreated;
    }

    /**
     * @param dateCreated
     *            the dateCreated to set
     */
    public void setDateCreated( Calendar dateCreated )
    {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the orders
     */
    public List<Order> getOrders()
    {
        return orders;
    }

    /**
     * @param orders
     *            the orders to set
     */
    public void setOrders( List<Order> orders )
    {
        this.orders = orders;
    }

    /**
     * @return the addresses
     */
    public List<Address> getAddresses()
    {
        return addresses;
    }

    /**
     * @param addresses
     *            the addresses to set
     */
    public void setAddresses( List<Address> addresses )
    {
        this.addresses = addresses;
    }

    /**
     * @return the bankAccounts
     */
    public List<BankAccount> getBankAccounts()
    {
        return bankAccounts;
    }

    /**
     * @param bankAccounts
     *            the bankAccounts to set
     */
    public void setBankAccounts( List<BankAccount> bankAccounts )
    {
        this.bankAccounts = bankAccounts;
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
        String retValue = "Client ( " + "firstName = " + firstName +
                          TAB + "lastName = " + lastName + TAB +
                          "dateCreated = " + dateCreated.getTime() +
                          TAB + "orders = " + orders + TAB +
                          "addresses = " + addresses + TAB +
                          "bankAccounts = " + bankAccounts + TAB +
                          " )";
        return retValue;
    }

}
