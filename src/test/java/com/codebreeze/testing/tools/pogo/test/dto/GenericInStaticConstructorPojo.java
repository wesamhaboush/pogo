package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Vector;

public abstract class GenericInStaticConstructorPojo
{

    protected Vector<String> vector;

    public static GenericInStaticConstructorPojo getInstance( Vector<String> vector )
    {
        return new GenericInStaticConstructorPojoImpl( vector );
    }

    public Vector<String> getVector()
    {
        return vector;
    }
}
