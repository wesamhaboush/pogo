package com.codebreeze.testing.tools.pogo.test.dto;

public class ValidationPojoForStringWithSizeAndNoMax
{

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        String sb = "ValidationPojoForStringWithSizeAndNoMax{" + "name='" + name + '\'' +
                    '}';
        return sb;
    }
}
