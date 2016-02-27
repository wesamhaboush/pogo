package com.codebreeze.testing.tools.pogo.common;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

import java.util.HashMap;
import java.util.Map;

public class ManufacturingContext
{

    private DataProviderStrategy.Order constructorOrdering = DataProviderStrategy.Order.LIGHT_FIRST;

    private final Map<Class<?>, Integer> pojos = new HashMap<>();

    public DataProviderStrategy.Order getConstructorOrdering()
    {
        return constructorOrdering;
    }

    public void setConstructorOrdering( DataProviderStrategy.Order constructorOrdering )
    {
        this.constructorOrdering = constructorOrdering;
    }

    public Map<Class<?>, Integer> getPojos()
    {
        return pojos;
    }

}
