package com.codebreeze.testing.tools.pogo.test.dto.pdm3;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
