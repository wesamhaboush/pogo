package com.codebreeze.testing.tools.pogo.test.dto;

/**
 * POJO to test Issue 110
 * <p>
 *     When a String is annotated with @Size and only min value is defined,
 *     Podam should allow for sensible, max defaults
 * </p>
 * Created by tedonema on 26/06/2015.
 */
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
