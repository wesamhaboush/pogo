/**
 *
 */
package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.common.PodamCollection;

/**
 * A default Object strategy, just to provide a default to
 * {@link PodamCollection#collectionElementStrategy()}.
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
