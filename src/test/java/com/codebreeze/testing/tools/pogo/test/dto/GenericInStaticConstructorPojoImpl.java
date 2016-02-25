package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Vector;

/**
 * Generic Pojo with generic type in constructor
 *
 * @author daivanov
 */
public class GenericInStaticConstructorPojoImpl
    extends GenericInStaticConstructorPojo
{

    protected GenericInStaticConstructorPojoImpl( Vector<String> vector )
    {
        this.vector = vector;
    }
}
