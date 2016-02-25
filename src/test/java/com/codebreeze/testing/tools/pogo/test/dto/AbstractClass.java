package com.codebreeze.testing.tools.pogo.test.dto;

/**
 * Class which doesn't have any specific implementation
 * @author daivanov
 */
public abstract class AbstractClass
{
    private final String name;

    public AbstractClass( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
