package com.codebreeze.testing.tools.pogo.test.dto.pdm5;

/**
 * Pojo to test invisible constructor
 *
 * @author divanov
 *
 */
public class InvisibleConstructorAndNoSettersPojo
{

    private final String value;

    InvisibleConstructorAndNoSettersPojo( String value )
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return String.format( "{value: '%s'}", value );
    }
}
