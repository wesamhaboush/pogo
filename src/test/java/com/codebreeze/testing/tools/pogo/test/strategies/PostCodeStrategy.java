package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

public class PostCodeStrategy implements AttributeStrategy<String>
{


    public String getValue() throws PogoMockeryException
    {
        return PogoTestConstants.POST_CODE;
    }
}
