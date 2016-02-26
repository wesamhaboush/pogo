package com.codebreeze.testing.tools.pogo.test.dto.annotations;

import com.codebreeze.testing.tools.pogo.common.PogoDoubleValue;

import java.io.Serializable;

public class DoubleValueWithErrorPojo implements Serializable
{

    private static final long serialVersionUID = 1L;

    @PogoDoubleValue( numValue = "fajhfakh" )
    private double doubleFieldWithErrorInAnnotation;

    public double getDoubleFieldWithErrorInAnnotation()
    {
        return doubleFieldWithErrorInAnnotation;
    }

    public void setDoubleFieldWithErrorInAnnotation(
        double doubleFieldWithErrorInAnnotation )
    {
        this.doubleFieldWithErrorInAnnotation = doubleFieldWithErrorInAnnotation;
    }
}
