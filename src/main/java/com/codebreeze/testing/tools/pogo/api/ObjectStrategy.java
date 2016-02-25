/**
 *
 */
package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.common.PogoCollection;

/**
 * A default Object strategy, just to provide a default to
 * {@link PogoCollection#collectionElementStrategy()}.
 *
 * @author mtedone
 *
 */
public class ObjectStrategy implements AttributeStrategy<Object>
{

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getValue()
    {
        return new Object();
    }

}
