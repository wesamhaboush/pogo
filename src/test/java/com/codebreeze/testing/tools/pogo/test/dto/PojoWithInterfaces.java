package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class PojoWithInterfaces
{

    private InterfacePojo value;

    public PojoWithInterfaces( ObjectExt<?> value )
    {
    }

    public InterfacePojo getValue()
    {
        return value;
    }

    public void setValue( InterfacePojo value )
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
