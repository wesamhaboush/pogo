package com.codebreeze.testing.tools.pogo.test.dto;

/**
 * Abstract factory instantiable class
 *
 * @author daivanov
 *
 */
public abstract class FactoryInstantiablePojo<T>
{

    private T typedValue;

    public static <E> FactoryInstantiablePojo<E> getInstance( E typedValue )
    {
        return new FactoryInstantiablePojoImpl<>( typedValue );
    }

    /**
     * @return the typedValue
     */
    public T getTypedValue()
    {
        return typedValue;
    }

    /**
     * @param typedValue
     *            the typedList to set
     */
    public void setTypedValue( T typedValue )
    {
        this.typedValue = typedValue;
    }
}
