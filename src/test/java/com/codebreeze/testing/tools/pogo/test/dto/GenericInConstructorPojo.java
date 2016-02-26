package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Vector;

public class GenericInConstructorPojo
{

    private final Vector<String> vector;

    public GenericInConstructorPojo( Vector<String> vector )
    {
        this.vector = vector;
    }

    public Vector<String> getVector()
    {
        return vector;
    }
}
