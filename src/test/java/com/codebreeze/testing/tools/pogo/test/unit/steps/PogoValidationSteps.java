package com.codebreeze.testing.tools.pogo.test.unit.steps;

import org.junit.Assert;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PogoValidationSteps
{

    public void theObjectShouldNotBeNull( Object pojo )
    {
        assertThat( pojo ).isNotNull();
    }

    public void theIntFieldShouldNotBeZero( int intField )
    {
        Assert.assertFalse( "The integer field should not be zero", intField == 0 );
    }

    public void theMapShouldContainAtLeastOneNonEmptyElement( Map<?, ?> map )
    {
        Assert.assertTrue( "The map attribute must be of type HashMap",
                           map instanceof HashMap );
        Assert.assertNotNull( "The map object in the POJO cannot be null", map );
        Set<?> keySet = map.keySet();
        Assert.assertNotNull( "The Map must have at least one element", keySet );
        Object o = map.get( keySet
                            .iterator().next() );
        Assert.assertNotNull( "The map element must not be null!",
                              o );
    }

    public void theTwoObjectsShouldBeEqual( Object expectedObject, Object actualObject )
    {
        Assert.assertEquals( "The two objects are not equal", expectedObject, actualObject );
    }
}
