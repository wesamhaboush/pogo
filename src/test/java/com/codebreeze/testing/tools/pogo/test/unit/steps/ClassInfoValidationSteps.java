package com.codebreeze.testing.tools.pogo.test.unit.steps;


import com.codebreeze.testing.tools.pogo.api.ClassAttribute;
import org.junit.Assert;

import java.util.Set;

public class ClassInfoValidationSteps
{

    public void theClassInfoAttributesShouldMatchthePojoOnes( Set<String> attribs, Set<ClassAttribute> classAttributes )
    {
        Assert.assertEquals( "Wrong number of attributes" + classAttributes, attribs.size(),
                             classAttributes.size() );

        for ( ClassAttribute attribute : classAttributes )
        {
            String attrName = attribute.getAttribute().getName();

            if ( !attribs.contains( attrName ) )
            {
                Assert.fail( "Unexpected attribute " + attrName );
            }

            Assert.assertEquals( "Wrong number of getters " + attribute.getGetters(),
                                 1, attribute.getGetters().size() );
            Assert.assertEquals( "Wrong number of setters " + attribute.getSetters(),
                                 1, attribute.getSetters().size() );
        }
    }

}
