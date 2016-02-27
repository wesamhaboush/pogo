package com.codebreeze.testing.tools.pogo.test.dto.pdm33;

import java.io.Serializable;

public class NoDefaultPublicConstructorPojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String firstName;

    private int intField;

    public NoDefaultPublicConstructorPojo( String firstName )
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public int getIntField()
    {
        return intField;
    }

    public void setIntField( int intField )
    {
        this.intField = intField;
    }

    @Override
    public String toString()
    {
        final String TAB = "    ";
        return "NoDefaultPublicConstructorPojo ( " + "firstName = " +
               firstName + TAB + "intField = " + intField + TAB +
               " )";
    }
}
