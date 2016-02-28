package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.api.ClassAttributeApprover;
import com.codebreeze.testing.tools.pogo.api.ClassInfo;
import com.codebreeze.testing.tools.pogo.api.PogoUtils;
import com.codebreeze.testing.tools.pogo.api.TypeProcessor;
import com.codebreeze.testing.tools.pogo.typeManufacturers.TypeManufacturerParamsWrapper;

public class PogoInvocationSteps
{

    public ClassInfo getClassInfo( Class<?> pojoClass, ClassAttributeApprover approver )
    {
        return PogoUtils.getClassInfo( pojoClass, approver );
    }

    public Object whenISendAMessageToTheChannel( TypeManufacturerParamsWrapper wrapper, String qualifier )
    {
        TypeProcessor typeProcessor = new TypeProcessor();
        return typeProcessor.process( wrapper, qualifier );
    }
}
