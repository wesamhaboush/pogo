package com.codebreeze.testing.tools.pogo.test.dto.pdm3;

/**
 * Pojo to test <a href="https://agileguru.atlassian.net/browse/PDM-3">PDM-3</a>
 *
 * @author daivanov
 *
 */
public class Pdm3PojoConstructor<T extends RuntimeException>
{

    private final T name;

    public Pdm3PojoConstructor( T name )
    {
        this.name = name;
    }

    public T getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return String.format( "{name: '%s'}", name );
    }
}
