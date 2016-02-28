package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;

public class PostCodeStrategy implements AttributeStrategy<String>
{


    public String getValue() throws PogoMockeryException
    {
        return "W1E X9P";
    }
}
