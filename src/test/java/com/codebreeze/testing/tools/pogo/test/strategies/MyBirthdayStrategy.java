package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestUtils;

import java.util.Calendar;

public class MyBirthdayStrategy implements AttributeStrategy<Calendar>
{

    public Calendar getValue() throws PogoMockeryException
    {
        return PogoTestUtils.getMyBirthday();
    }
}
