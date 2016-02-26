package com.codebreeze.testing.tools.pogo.test.dto;

public abstract class FactoryInstantiablePojo<T>
{

    private T typedValue;

    public static <E> FactoryInstantiablePojo<E> getInstance( E typedValue )
    {
        return new FactoryInstantiablePojoImpl<>( typedValue );
    }

    public T getTypedValue()
    {
        return typedValue;
    }

    public void setTypedValue( T typedValue )
    {
        this.typedValue = typedValue;
    }
}
