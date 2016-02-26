package com.codebreeze.testing.tools.pogo.test.utils;

import org.junit.Assert;

import java.util.Calendar;
import java.util.Date;

public class TypesUtils
{

    private TypesUtils()
    {
        throw new AssertionError( "Non instantiable" );
    }

    public static void checkCalendarIsValid( Calendar calendarField )
    {
        Assert.assertNotNull( "The Calendar field cannot be null", calendarField );
        Date calendarDate = calendarField.getTime();
        Assert.assertNotNull( "It appears the Calendar field is not valid",
                              calendarDate );
    }
}
