package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class InnerClassPojo
{

    private final InnerPojo ip;

    public InnerPojo getIp()
    {
        return ip;
    }

    public InnerClassPojo( InnerPojo ip )
    {
        this.ip = ip;
    }

    public class InnerPojo
    {
        private final String data;

        public InnerPojo( String data )
        {
            this.data = data;
        }

        public String getData()
        {
            return data;
        }
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
