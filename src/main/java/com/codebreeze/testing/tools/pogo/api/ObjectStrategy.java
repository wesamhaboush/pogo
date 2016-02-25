package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;

public class ObjectStrategy implements AttributeStrategy<Object>
{

    @Override
    public Object getValue()
    {
        return new Object();
    }

}
