package com.codebreeze.testing.tools.pogo.test.unit.steps;

import com.codebreeze.testing.tools.pogo.test.dto.RecursivePojo;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveMap;
import com.codebreeze.testing.tools.pogo.test.dto.pdm6.RecursiveList;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class RecursivePojoValidationSteps
{

    public void allPojosInTheRecursiveStrategyShouldBeValid( RecursivePojo pojo )
    {
        Assert.assertTrue( "The integer value in the pojo should not be zero!",
                           pojo.getIntField() != 0 );
        RecursivePojo parentPojo = pojo.getParent();
        Assert.assertNotNull( "The parent pojo cannot be null!", parentPojo );
        Assert.assertTrue(
            "The integer value in the parent pojo should not be zero!",
            parentPojo.getIntField() != 0 );
        Assert.assertNotNull(
            "The parent attribute of the parent pojo cannot be null!",
            parentPojo.getParent() );
    }

    public void thePojoListShouldNotBeNull( List<RecursiveList> list )
    {
        Assert.assertNotNull( "The list should not be null" );
    }

    public void thePojoListShouldNotBeEmpty( List<RecursiveList> list )
    {
        Assert.assertTrue( "The pojo's recursive list cannot be empty!", !list.isEmpty() );
    }

    public void thePojoMapShouldNotBeNull( Map<String, RecursiveMap> map )
    {
        Assert.assertNotNull( "The recursive map should not be null", map );
    }

    public void thePojoMapShouldNotBeEmpty( Map<String, RecursiveMap> map )
    {
        Assert.assertTrue( "The pojo's recursive map cannot be empty!", !map.isEmpty() );
    }
}
