package com.codebreeze.testing.tools.pogo.test.unit;

import com.codebreeze.testing.tools.pogo.test.unit.steps.*;

public abstract class AbstractPodamSteps
{

    protected PodamFactorySteps podamFactorySteps;

    protected PodamInvocationSteps podamInvocationSteps;

    protected PodamValidationSteps podamValidationSteps;

    protected OneDimentionalPojoValidationSteps oneDimentionalPojoValidationSteps;

    protected PodamStrategySteps podamStrategySteps;

    protected RecursivePojoValidationSteps recursivePojoValidationSteps;

    protected ConstructorSelfReferenceValidationSteps constructorSelfReferenceValidationSteps;

    protected ClassInfoValidationSteps classInfoValidationSteps;

    protected WalkThroughSteps walkThroughSteps;
}
