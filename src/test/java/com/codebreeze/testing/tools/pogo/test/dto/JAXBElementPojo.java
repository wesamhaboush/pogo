/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.dto;

import javax.xml.bind.JAXBElement;

/**
 * POJO to test when Pogo sets a boolean.
 *
 * @author daivanov
 *
 */
public class JAXBElementPojo<T>
{
    private JAXBElement<T> value;

    public JAXBElementPojo()
    {
    }

    public JAXBElement<T> getValue()
    {
        return value;
    }

    public void setValue( JAXBElement<T> value )
    {
        this.value = value;
    }
}
