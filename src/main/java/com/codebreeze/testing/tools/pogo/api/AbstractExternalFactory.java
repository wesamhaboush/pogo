package com.codebreeze.testing.tools.pogo.api;

import java.lang.reflect.Type;

/**
 * Adapter pattern for boilerplate code when creating an external factory
 *
 * @author Marco Tedone
 *
 * @since 5.2.1
 */
public abstract class AbstractExternalFactory implements PogoFactory
{

    @Override
    public <T> T manufacturePojoWithFullData( Class<T> pojoClass,
            Type... genericTypeArgs )
    {
        return this.manufacturePojo( pojoClass, genericTypeArgs );
    }

    @Override
    public DataProviderStrategy getStrategy()
    {
        return null;
    }

    @Override
    public PogoFactory setStrategy( DataProviderStrategy strategy )
    {
        return this;
    }

    @Override
    public ClassInfoStrategy getClassStrategy()
    {
        return null;
    }

    @Override
    public PogoFactory setClassStrategy(
        ClassInfoStrategy classInfoStrategy )
    {
        return this;
    }

    @Override
    public PogoFactory getExternalFactory()
    {
        return null;
    }

    @Override
    public PogoFactory setExternalFactory( PogoFactory externalFactory )
    {
        return this;
    }

}
