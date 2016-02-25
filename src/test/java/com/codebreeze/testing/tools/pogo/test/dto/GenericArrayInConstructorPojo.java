package com.codebreeze.testing.tools.pogo.test.dto;

/**
 * Generic Pojo with generic array type in constructor
 *
 * @author daivanov
 */
public class GenericArrayInConstructorPojo<E>
{

    private final E[] array;

    public GenericArrayInConstructorPojo( E[] array )
    {
        this.array = array;
    }

    public E[] getArray()
    {
        return array;
    }
}
