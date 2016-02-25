package com.codebreeze.testing.tools.pogo.test.unit.features.constructors;

class PackagePrivatePojo
{

    public PackagePrivatePojo()
    {
    }

    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue( String value )
    {
        this.value = value;
    }
}
