package com.codebreeze.testing.tools.pogo.test.dto.pdm33;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class ProtectedNonDefaultConstructorPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String firstName;

    private int intField;

    protected ProtectedNonDefaultConstructorPojo( String firstName, int intField )
    {
        this.firstName = firstName;
        this.intField = intField;
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
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
