package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoByteValue;

import java.io.Serializable;

public class ByteValueWithErrorPojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoByteValue( numValue = "afasdfafa", comment = "This should throw an exception" )
    private byte byteAttributeWithErrorAnnotation;
}
