/**
 *
 */
package com.codebreeze.testing.tools.pogo.common;

import com.codebreeze.testing.tools.pogo.exceptions.PodamMockeryException;

/**
 * Generic contract for attribute-level data provider strategies.
 *
 * @author mtedone
 *
 */
public interface AttributeStrategy<T>
{

    /**
     * It returns a value of the given type
     *
     * @return A value of the given type
     *
     * @throws PodamMockeryException
     *             If an exception occurred while assigning the value specified
     *             by this strategy
     */
    T getValue();

}
