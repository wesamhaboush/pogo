package com.codebreeze.testing.tools.pogo.test.dto;

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
}
