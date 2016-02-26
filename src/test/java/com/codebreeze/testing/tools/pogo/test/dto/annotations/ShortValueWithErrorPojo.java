package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoShortValue;

import java.io.Serializable;

public class ShortValueWithErrorPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    @PogoShortValue( numValue = "fajkfhaf" )
    private short shortFieldWithErrorInAnnotation;

    public short getShortFieldWithErrorInAnnotation()
    {
        return shortFieldWithErrorInAnnotation;
    }

    public void setShortFieldWithErrorInAnnotation(
        short shortFieldWithErrorInAnnotation )
    {
        this.shortFieldWithErrorInAnnotation = shortFieldWithErrorInAnnotation;
    }
}
