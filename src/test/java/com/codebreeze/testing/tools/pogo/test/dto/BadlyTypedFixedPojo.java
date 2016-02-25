/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

/**
 * POJO to test class with setters for strings, which are being
 * then parsed to some other types. This creates problems for Pogo
 *
 * @author daivanov
 *
 */
public class BadlyTypedFixedPojo extends BadlyTypedPojo
{

    /**
     * We created guide for Pogo what is real type of field to set
     * @param value integer value to set
     */
    public void setValue( Integer value )
    {
        setValue( value.toString() );
    }

}
