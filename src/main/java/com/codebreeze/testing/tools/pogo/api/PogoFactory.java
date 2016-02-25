package com.codebreeze.testing.tools.pogo.api;

import java.lang.reflect.Type;

public interface PogoFactory
{

    <T> T manufacturePojo( Class<T> pojoClass, Type... genericTypeArgs );

    <T> T manufacturePojoWithFullData( Class<T> pojoClass, Type... genericTypeArgs );

    <T> T populatePojo( T pojo, Type... genericTypeArgs );

    DataProviderStrategy getStrategy();

    PogoFactory setStrategy( DataProviderStrategy strategy );

    PogoFactory getExternalFactory();

    PogoFactory setExternalFactory( PogoFactory externalFactory );

    ClassInfoStrategy getClassStrategy();

    PogoFactory setClassStrategy( ClassInfoStrategy classInfoStrategy );
}
