package com.codebreeze.testing.tools.pogo.test.unit;

import com.codebreeze.testing.tools.pogo.test.unit.steps.*;

public abstract class AbstractPogoSteps
{

    protected final PogoFactorySteps PogoFactorySteps = new PogoFactorySteps();

    protected final PogoInvocationSteps PogoInvocationSteps = new PogoInvocationSteps();

    protected final PogoValidationSteps PogoValidationSteps = new PogoValidationSteps();

    protected final OneDimentionalPojoValidationSteps oneDimentionalPojoValidationSteps = new
    OneDimentionalPojoValidationSteps();

    protected final PogoStrategySteps PogoStrategySteps = new PogoStrategySteps();

    protected final RecursivePojoValidationSteps recursivePojoValidationSteps = new RecursivePojoValidationSteps();

    protected final ConstructorSelfReferenceValidationSteps constructorSelfReferenceValidationSteps = new
    ConstructorSelfReferenceValidationSteps();

    protected final ClassInfoValidationSteps classInfoValidationSteps = new ClassInfoValidationSteps();

    protected final WalkThroughSteps walkThroughSteps = new WalkThroughSteps();
}
