/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;
import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;
import com.codebreeze.testing.tools.pogo.test.utils.PogoTestConstants;

/**
 * A test strategy to manufacture UK-like post codes.
 *
 * @author mtedone
 *
 */
public class PostCodeStrategy implements AttributeStrategy<String>
{

    // ------------------->> Constants

    // ------------------->> Instance / Static variables

    /**
     * It returns an English post code.
     * <p>
     * This is just an example. More elaborated code could the implemented by
     * this method. This is just to proof the point.
     * </p>
     *
     * {@inheritDoc}
     */
    public String getValue() throws PogoMockeryException
    {
        return PogoTestConstants.POST_CODE;
    }

    // ------------------->> Constructors

    // ------------------->> Public methods

    // ------------------->> Getters / Setters

    // ------------------->> Private methods

    // ------------------->> equals() / hashcode() / toString()

    // ------------------->> Inner classes

}
