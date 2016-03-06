package com.codebreeze.testing.tools.pogo.test.dto.pdm5;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
