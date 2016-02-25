/**
 *
 */
package com.codebreeze.testing.tools.pogo.api;

import com.codebreeze.testing.tools.pogo.exceptions.PogoMockeryException;

import java.lang.reflect.Type;

/**
 * Contract for Pogo factory
 *
 * @author mtedone
 *
 * @since 2.0.0
 *
 */
public interface PogoFactory
{

    /**
     * Generic method which returns an instance of the given class filled with
     * dummy values, using the default data provider strategy.
     *
     * <p>
     * This method uses {@link RandomDataProviderStrategyImpl} as the default
     * implementation.
     * </p>
     *
     * @param <T>
     *            The type for which a filled instance is required
     * @param pojoClass
     *            The name of the class for which an instance filled with values
     *            is required
     * @param genericTypeArgs
     *            The generic Type arguments for a generic class instance
     * @return An instance of &lt;T&gt; filled with dummy values
     *
     * @throws PogoMockeryException
     *             if a problem occurred while creating a POJO instance or while
     *             setting its state
     */
    <T> T manufacturePojo( Class<T> pojoClass, Type... genericTypeArgs );

    /**
     * Generic method which returns an instance of the given class filled with
     * dummy values, using the default data provider strategy. In order to
     * instantiate class, constructor with the most parameters is used.
     *
     * <p>
     * This method uses {@link RandomDataProviderStrategyImpl} as the default
     * implementation.
     * </p>
     *
     * @param <T>
     *            The type for which a filled instance is required
     * @param pojoClass
     *            The name of the class for which an instance filled with values
     *            is required
     * @param genericTypeArgs
     *            The generic Type arguments for a generic class instance
     * @return An instance of &lt;T&gt; filled with dummy values
     *
     * @throws PogoMockeryException
     *             if a problem occurred while creating a POJO instance or while
     *             setting its state
     */
    <T> T manufacturePojoWithFullData( Class<T> pojoClass, Type... genericTypeArgs );

    /**
     * Generic method which populates an instance of the given class with
     * dummy values, using the default data provider strategy.
     *
     * <p>
     * This method uses {@link RandomDataProviderStrategyImpl} as the default
     * implementation.
     * </p>
     *
     * @param <T>
     *            The type for which a filled instance is required
     * @param pojo
     *            The instance to be filled with values
     * @param genericTypeArgs
     *            The generic Type arguments for a generic class instance
     * @return The same instance of object for chaining
     *
     * @throws PogoMockeryException
     *             if a problem occurred while creating a POJO instance or while
     *             setting its state
     * @since 5.4.0
     */
    <T> T populatePojo( T pojo, Type... genericTypeArgs );

    /**
     * It returns the strategy for this factory.
     *
     * @return the strategy
     */
    DataProviderStrategy getStrategy();

    /**
     * Sets the data provider strategy for this factory
     *
     * @param strategy
     *             A data provider strategy to be used by this factory
     * @return instance of the factory for chaining
     */
    PogoFactory setStrategy( DataProviderStrategy strategy );

    /**
     * It returns the external factory assigned to this factory.
     *
     * @return the strategy
     */
    PogoFactory getExternalFactory();

    /**
     * Sets an external factory for this factory to delegate requests it cannot
     * process
     *
     * @param externalFactory
     *             An external factory to be used by this factory
     * @return instance of this factory for chaining
     */
    PogoFactory setExternalFactory( PogoFactory externalFactory );

    /**
     * It returns the class info strategy for this factory.
     *
     * @return the class info strategy for this factory
     */
    ClassInfoStrategy getClassStrategy();

    /**
     * Sets the class info strategy for this factory
     *
     * @param classInfoStrategy
     *             A class info strategy to be used by this factory
     * @return instance of the factory for chaining
     */
    PogoFactory setClassStrategy( ClassInfoStrategy classInfoStrategy );

}
