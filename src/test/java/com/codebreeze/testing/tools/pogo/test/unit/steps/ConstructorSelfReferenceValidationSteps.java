package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.test.dto.ConstructorWithSelfReferencesButNoDefaultConstructorPojo;
import org.junit.Assert;

public class ConstructorSelfReferenceValidationSteps
{
    public void theFirstSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull(
        ConstructorWithSelfReferencesButNoDefaultConstructorPojo parentPojo )
    {
        Assert.assertNotNull( "The first self-reference should not be null", parentPojo.getParent() );
    }

    public void theSecondSelfReferenceForPojoWithoutDefaultConstructorShouldNotBeNull(
        ConstructorWithSelfReferencesButNoDefaultConstructorPojo parentPojo )
    {
        Assert.assertNotNull( "The seciond self-reference should not be null", parentPojo.getAnotherParent() );
    }
}
