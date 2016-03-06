package com.codebreeze.testing.tools.pogo.test.dto.pdm45;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
        return ReflectionToStringBuilder.toString( this, ToStringStyle.JSON_STYLE );
    }
}
