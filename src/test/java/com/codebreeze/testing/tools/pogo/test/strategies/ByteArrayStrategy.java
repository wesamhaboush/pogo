package com.codebreeze.testing.tools.pogo.test.strategies;

import com.codebreeze.testing.tools.pogo.common.AttributeStrategy;

import java.security.SecureRandom;

public class ByteArrayStrategy implements AttributeStrategy<byte[]>
{

    private static final int LENGTH = 20;
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public byte[] getValue()
    {
        byte[] b = new byte[LENGTH];
        RANDOM.nextBytes( b );
        return b;
    }
}
