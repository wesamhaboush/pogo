package com.codebreeze.testing.tools.pogo.test.dto;

class FactoryInstantiablePojoImpl<T> extends FactoryInstantiablePojo<T>
{

    protected FactoryInstantiablePojoImpl( T typedValue )
    {
        setTypedValue( typedValue );
    }
}
