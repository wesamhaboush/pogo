package com.codebreeze.testing.tools.pogo.test.dto;

public abstract class ReadOnlyAbstract
{

    public static ReadOnlyAbstract getInstance()
    {
        return new ReadOnlyNonAccessible();
    }
}
