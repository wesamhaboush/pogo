package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoLongValue;

import java.io.Serializable;

public class LongValueWithErrorPojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoLongValue( numValue = "afhafhakflh" )
    private long longFieldWithErrorInAnnotation;

    public long getLongFieldWithErrorInAnnotation()
    {
        return longFieldWithErrorInAnnotation;
    }

    public void setLongFieldWithErrorInAnnotation(
        long longFieldWithErrorInAnnotation )
    {
        this.longFieldWithErrorInAnnotation = longFieldWithErrorInAnnotation;
    }
}
