/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import java.util.Vector;

/**
 * @author daivanov
 *
 */
public class UnsupportedCollectionInConstructorPojo<E>
{

    private final Vector<E> vector;

    public UnsupportedCollectionInConstructorPojo( Vector<E> vector )
    {
        this.vector = vector;
    }

    public Vector<E> getVector()
    {
        return vector;
    }
}
