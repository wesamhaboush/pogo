package com.codebreeze.testing.tools.pogo.test.dto;

/**
 * POJO with read only fields which are not accessible
 *
 * @author daivanov
 */
public abstract class ReadOnlyAbstract
{

    public static ReadOnlyAbstract getInstance()
    {
        return new ReadOnlyNonAccessible();
    }
}
