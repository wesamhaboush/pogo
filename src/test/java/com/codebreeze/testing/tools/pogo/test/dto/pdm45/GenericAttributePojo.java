package com.codebreeze.testing.tools.pogo.test.dto.pdm45;

public class GenericAttributePojo
{

    private GenericPojo<String, Long> genericPojo;

    public GenericPojo<String, Long> getGenericPojo()
    {
        return genericPojo;
    }

    public void setGenericPojo( GenericPojo<String, Long> genericPojo )
    {
        this.genericPojo = genericPojo;
    }

    @Override
    public String toString()
    {
        return "GenericAttributePojo [genericPojo=" + genericPojo + "]";
    }
}
