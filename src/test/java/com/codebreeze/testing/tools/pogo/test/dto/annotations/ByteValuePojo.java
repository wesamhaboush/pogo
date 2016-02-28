package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class ByteValuePojo
{
    private byte bytePrimitive;
    private Byte byteObject;

    public Byte getByteObject()
    {
        return byteObject;
    }

    public void setByteObject( Byte byteObject )
    {
        this.byteObject = byteObject;
    }

    public byte getBytePrimitive()
    {
        return bytePrimitive;
    }

    public void setBytePrimitive( byte bytePrimitive )
    {
        this.bytePrimitive = bytePrimitive;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
