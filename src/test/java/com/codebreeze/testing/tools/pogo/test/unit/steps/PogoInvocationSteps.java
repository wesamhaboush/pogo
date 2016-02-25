package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.*;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapper;

import java.lang.reflect.Type;

public class PogoInvocationSteps
{

    public <T> T whenIInvokeTheFactoryForClass( Class<T> className, PogoFactory PogoFactory )
    {
        return PogoFactory.manufacturePojo( className );
    }

    public <T> T whenIInvokeThePojoPopulationDirectly( T className, PogoFactory PogoFactory )
    {
        return PogoFactory.populatePojo( className );
    }

    public <T> T whenIInvokeTheFactoryForClassWithFullConstructor( Class<T> className, PogoFactory PogoFactory )
    {
        return PogoFactory.manufacturePojoWithFullData( className );
    }

    public ClassInfo getClassInfo( Class<?> pojoClass, ClassAttributeApprover approver )
    {
        return PogoUtils.getClassInfo( pojoClass, approver );
    }

    public <T> T whenIInvokeTheFactoryForGenericTypeWithSpecificType(
        Class<T> pojoClass,
        PogoFactory PogoFactory, Type... genericTypeArgs )
    {
        return PogoFactory.manufacturePojo( pojoClass, genericTypeArgs );
    }

    public Object whenISendAMessageToTheChannel( TypeManufacturerParamsWrapper wrapper, String qualifier )
    {
        TypeProcessor typeProcessor = new TypeProcessor();
        return typeProcessor.process( wrapper, qualifier );
    }
}
