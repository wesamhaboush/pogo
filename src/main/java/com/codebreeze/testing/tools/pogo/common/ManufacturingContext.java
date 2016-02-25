package com.codebreeze.testing.tools.pogo.common;

import java.util.HashMap;
import java.util.Map;

import com.codebreeze.testing.tools.pogo.api.DataProviderStrategy;

/**
 * Object to hold manufacturing related data
 *
 * @author daivanov
 *
 */
public class ManufacturingContext
{

    /** Constructors sorting order */
    private DataProviderStrategy.Order constructorOrdering = DataProviderStrategy.Order.LIGHT_FIRST;

    /** Map with production counts of objects per type, required
     * for loop detection */
    private final Map<Class<?>, Integer> pojos = new HashMap<>();

    /**
     * Getter for constructor ordering
     * @return constructor ordering
     */
    public DataProviderStrategy.Order getConstructorOrdering()
    {
        return constructorOrdering;
    }

    /**
     * Setter for constructor ordering
     * @param constructorOrdering
     *        constructor ordering
     */
    public void setConstructorOrdering( DataProviderStrategy.Order constructorOrdering )
    {
        this.constructorOrdering = constructorOrdering;
    }

    /**
     * Getter for map with production counts of objects per type
     * @return map with production counts of objects per type
     */
    public Map<Class<?>, Integer> getPojos()
    {
        return pojos;
    }

}
