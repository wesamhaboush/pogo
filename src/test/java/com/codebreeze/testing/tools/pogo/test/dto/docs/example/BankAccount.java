package com.codebreeze.testing.tools.pogo.test.dto.docs.example;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;


public class BankAccount implements Serializable
{

    private static final long serialVersionUID = 1L;

    private int account;

    private String bank;

    private String sortCode;

    private double balance;

    public int getAccount()
    {
        return account;
    }

    public void setAccount( int account )
    {
        this.account = account;
    }

    public String getBank()
    {
        return bank;
    }

    public void setBank( String bank )
    {
        this.bank = bank;
    }

    public String getSortCode()
    {
        return sortCode;
    }

    public void setSortCode( String sortCode )
    {
        this.sortCode = sortCode;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance( double balance )
    {
        this.balance = balance;
    }

    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }

}
