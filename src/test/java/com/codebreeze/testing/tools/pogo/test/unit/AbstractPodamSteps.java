package com.codebreeze.testing.tools.pogo.test.unit;

import com.codebreeze.testing.tools.pogo.test.unit.steps.*;

public abstract class AbstractPodamSteps
{

    protected PodamFactorySteps podamFactorySteps = new PodamFactorySteps();

    protected PodamInvocationSteps podamInvocationSteps = new PodamInvocationSteps();

    protected PodamValidationSteps podamValidationSteps = new PodamValidationSteps();

    protected OneDimentionalPojoValidationSteps oneDimentionalPojoValidationSteps = new OneDimentionalPojoValidationSteps();

    protected PodamStrategySteps podamStrategySteps = new PodamStrategySteps();

    protected RecursivePojoValidationSteps recursivePojoValidationSteps = new RecursivePojoValidationSteps();

    protected ConstructorSelfReferenceValidationSteps constructorSelfReferenceValidationSteps = new
    ConstructorSelfReferenceValidationSteps();

    protected ClassInfoValidationSteps classInfoValidationSteps = new ClassInfoValidationSteps();

    protected WalkThroughSteps walkThroughSteps = new WalkThroughSteps();
}
