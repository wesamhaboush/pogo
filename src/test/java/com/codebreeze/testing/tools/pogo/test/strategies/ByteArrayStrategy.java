package com.codebreeze.testing.tools.pogo.test.strategies;

import java.security.SecureRandom;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;

public class ByteArrayStrategy implements AttributeStrategy<byte[]>
{

    public static final int LENGTH = 20;
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public byte[] getValue()
    {
        byte[] b = new byte[LENGTH];
        RANDOM.nextBytes( b );
        return b;
    }
}
