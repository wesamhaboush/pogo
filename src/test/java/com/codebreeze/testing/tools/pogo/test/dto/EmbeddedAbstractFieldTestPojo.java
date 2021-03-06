package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Assert;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;
import static org.assertj.core.api.Assertions.assertThat;

public class EmbeddedAbstractFieldTestPojo
{

    private final AbstractTestPojo testPojo;

    public EmbeddedAbstractFieldTestPojo( final AbstractTestPojo pojo )
    {
        assertThat( pojo ).isNotNull();
        testPojo = pojo;
    }

    public AbstractTestPojo getPojo()
    {
        return testPojo;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
