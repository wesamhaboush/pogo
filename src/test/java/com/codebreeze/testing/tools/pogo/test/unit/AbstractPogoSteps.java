package com.codebreeze.testing.tools.pogo.test.unit;

import com.codebreeze.testing.tools.pogo.test.unit.steps.*;

public abstract class AbstractPogoSteps
{

    protected final PogoFactorySteps PogoFactorySteps = new PogoFactorySteps();

    protected final PogoInvocationSteps PogoInvocationSteps = new PogoInvocationSteps();

    protected final PogoValidationSteps PogoValidationSteps = new PogoValidationSteps();

    protected final ClassInfoValidationSteps classInfoValidationSteps = new ClassInfoValidationSteps();

    protected final WalkThroughSteps walkThroughSteps = new WalkThroughSteps();
}
