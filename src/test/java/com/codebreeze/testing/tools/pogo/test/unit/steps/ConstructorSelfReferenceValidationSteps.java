package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.test.dto.ConstructorWithSelfReferencesButNoDefaultConstructorPojo;
import com.codebreeze.testing.tools.pogo.test.dto.ConstructorWithSelfReferencesPojoAndDefaultConstructor;
import org.junit.Assert;

public class ConstructorSelfReferenceValidationSteps
{

    public void theFirstSelfReferenceForPojoWithDefaultConstructorShouldNotBeNull(
        ConstructorWithSelfReferencesPojoAndDefaultConstructor parentPojo )
    {
        Assert.assertNotNull( "The first self-reference should not be null", parentPojo.getParent() );
    }

    public void theSecondSelfReferenceForPojoWithDefaultConstructorShouldNotBeNull(
        ConstructorWithSelfReferencesPojoAndDefaultConstructor parentPojo )
    {
        Assert.assertNotNull( "The second self-reference should not be null", parentPojo.getAnotherParent() );
    }

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
