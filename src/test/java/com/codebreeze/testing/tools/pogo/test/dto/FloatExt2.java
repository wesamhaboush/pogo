package com.codebreeze.testing.tools.pogo.test.dto;

public class FloatExt2 implements ObjectExt<Float>
{

    private Float value;

    @Override
    public Float getValue()
    {
        return value;
    }

    @Override
    public void setValue( Float value )
    {
        this.value = value;
    }
}
