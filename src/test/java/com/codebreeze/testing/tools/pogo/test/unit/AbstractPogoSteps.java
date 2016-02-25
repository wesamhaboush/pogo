package com.codebreeze.testing.tools.pogo.test.unit;

import com.codebreeze.testing.tools.pogo.test.unit.steps.*;

public abstract class AbstractPogoSteps
{

    protected PogoFactorySteps PogoFactorySteps = new PogoFactorySteps();

    protected PogoInvocationSteps PogoInvocationSteps = new PogoInvocationSteps();

    protected PogoValidationSteps PogoValidationSteps = new PogoValidationSteps();

    protected OneDimentionalPojoValidationSteps oneDimentionalPojoValidationSteps = new OneDimentionalPojoValidationSteps();

    protected PogoStrategySteps PogoStrategySteps = new PogoStrategySteps();

    protected RecursivePojoValidationSteps recursivePojoValidationSteps = new RecursivePojoValidationSteps();

    protected ConstructorSelfReferenceValidationSteps constructorSelfReferenceValidationSteps = new
    ConstructorSelfReferenceValidationSteps();

    protected ClassInfoValidationSteps classInfoValidationSteps = new ClassInfoValidationSteps();

    protected WalkThroughSteps walkThroughSteps = new WalkThroughSteps();
}
