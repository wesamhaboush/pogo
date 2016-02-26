package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Vector;

public class GenericInStaticConstructorPojoImpl
    extends GenericInStaticConstructorPojo
{

    protected GenericInStaticConstructorPojoImpl( Vector<String> vector )
    {
        this.vector = vector;
    }
}
