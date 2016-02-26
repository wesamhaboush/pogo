package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoIntValue;

import java.io.Serializable;

public class IntegerValueWithErrorPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    @PogoIntValue( numValue = "hfajkfhalfh" )
    private int intFieldWithErrorInAnnotation;

    public int getIntFieldWithErrorInAnnotation()
    {
        return intFieldWithErrorInAnnotation;
    }

    public void setIntFieldWithErrorInAnnotation(
        int intFieldWithErrorInAnnotation )
    {
        this.intFieldWithErrorInAnnotation = intFieldWithErrorInAnnotation;
    }

}
