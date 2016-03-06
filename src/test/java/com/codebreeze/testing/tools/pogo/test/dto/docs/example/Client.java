package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Client
{
    private String firstName;

    private String lastName;

    private Calendar dateCreated;

    private List<Order> orders = new ArrayList<>();

    private List<Address> addresses = new ArrayList<>();

    // Default is one bank account
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public Calendar getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated( Calendar dateCreated )
    {
        this.dateCreated = dateCreated;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders( List<Order> orders )
    {
        this.orders = orders;
    }

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses( List<Address> addresses )
    {
        this.addresses = addresses;
    }

    public List<BankAccount> getBankAccounts()
    {
        return bankAccounts;
    }

    public void setBankAccounts( List<BankAccount> bankAccounts )
    {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }

}
