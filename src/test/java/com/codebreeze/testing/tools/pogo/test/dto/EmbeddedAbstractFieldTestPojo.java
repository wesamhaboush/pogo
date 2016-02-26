package com.codebreeze.testing.tools.pogo.test.dto;

import org.junit.Assert;

public class EmbeddedAbstractFieldTestPojo
{

    private final AbstractTestPojo testPojo;

    public EmbeddedAbstractFieldTestPojo( final AbstractTestPojo pojo )
    {
        Assert.assertNotNull( pojo );
        testPojo = pojo;
    }

    public AbstractTestPojo getPojo()
    {
        return testPojo;
    }

}
