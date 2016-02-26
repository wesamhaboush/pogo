package com.codebreeze.testing.tools.pogo.test.dto;

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
