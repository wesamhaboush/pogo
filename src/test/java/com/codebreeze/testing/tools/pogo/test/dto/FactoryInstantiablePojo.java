package com.codebreeze.testing.tools.pogo.test.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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

    void setTypedValue( T typedValue )
    {
        this.typedValue = typedValue;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString( this, JSON_STYLE );
    }
}
