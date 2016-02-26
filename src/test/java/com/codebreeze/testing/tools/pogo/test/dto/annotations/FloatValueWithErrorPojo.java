package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoFloatValue;

import java.io.Serializable;

public class FloatValueWithErrorPojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @PogoFloatValue( numValue = "fafhakljhf" )
    private float floatFieldWithErrorInAnnotation;

    public float getFloatFieldWithErrorInAnnotation()
    {
        return floatFieldWithErrorInAnnotation;
    }

    public void setFloatFieldWithErrorInAnnotation(
        float floatFieldWithErrorInAnnotation )
    {
        this.floatFieldWithErrorInAnnotation = floatFieldWithErrorInAnnotation;
    }
}
