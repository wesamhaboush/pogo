package com.codebreeze.testing.tools.pogo.test.dto;

public class NonInstantiatableClass
{
    private String name;

    public NonInstantiatableClass() throws Exception
    {
        throw new Exception();
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
