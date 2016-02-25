/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.exceptions.PodamMockeryException;
import com.codebreeze.testing.tools.pogo.test.utils.PodamTestUtils;

import java.util.Calendar;

/**
 * @author mtedone
 *
 */
public class MyBirthdayStrategy implements AttributeStrategy<Calendar>
{

    /**
     * It returns a {@link Calendar} object set with the exact date of my
     * birthday.
     *
     * {@inheritDoc}
     */
    public Calendar getValue() throws PodamMockeryException
    {
        return PodamTestUtils.getMyBirthday();
    }

    // ------------------->> Constants

    // ------------------->> Instance / Static variables

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
