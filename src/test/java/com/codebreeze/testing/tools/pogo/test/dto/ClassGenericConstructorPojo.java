/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

/**
 * POJO to test Class instantiation
 *
 * @author daivanov
 *
 */
public class ClassGenericConstructorPojo<T>
{
    private final Class<T> clazz;

    public ClassGenericConstructorPojo( Class<T> clazz )
    {
        this.clazz = clazz;
    }

    public Class<T> getClazz()
    {
        return clazz;
    }
}
