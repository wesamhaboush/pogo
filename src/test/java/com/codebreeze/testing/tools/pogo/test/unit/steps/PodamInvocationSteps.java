package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.*;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapper;

import java.lang.reflect.Type;

public class PodamInvocationSteps
{

    public <T> T whenIInvokeTheFactoryForClass( Class<T> className, PodamFactory podamFactory )
    {
        return podamFactory.manufacturePojo( className );
    }

    public <T> T whenIInvokeThePojoPopulationDirectly( T className, PodamFactory podamFactory )
    {
        return podamFactory.populatePojo( className );
    }

    public <T> T whenIInvokeTheFactoryForClassWithFullConstructor( Class<T> className, PodamFactory podamFactory )
    {
        return podamFactory.manufacturePojoWithFullData( className );
    }

    public ClassInfo getClassInfo( Class<?> pojoClass, ClassAttributeApprover approver )
    {
        return PodamUtils.getClassInfo( pojoClass, approver );
    }

    public <T> T whenIInvokeTheFactoryForGenericTypeWithSpecificType(
        Class<T> pojoClass,
        PodamFactory podamFactory, Type... genericTypeArgs )
    {
        return podamFactory.manufacturePojo( pojoClass, genericTypeArgs );
    }

    public Object whenISendAMessageToTheChannel( TypeManufacturerParamsWrapper wrapper, String qualifier )
    {
        TypeProcessor typeProcessor = new TypeProcessor();
        return typeProcessor.process( wrapper, qualifier );
    }
}
