package com.codebreeze.testing.tools.pogo.test.unit.features.classInfo;

import com.codebreeze.testing.tools.pogo.api.ClassAttribute;
import com.codebreeze.testing.tools.pogo.api.ClassAttributeApprover;
import com.codebreeze.testing.tools.pogo.api.ClassInfo;
import com.codebreeze.testing.tools.pogo.test.dto.EmptyTestPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassInfoTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldReturnAValidClassInfoForPojoWithNoAttributes()
    {
        List<ClassAttribute> attributes = new ArrayList<>();
        ClassInfo expectedClassInfo = PogoFactorySteps.givenAClassInfoForPojoWithNoAttributes( EmptyTestPojo.class,
                                      attributes );
        ClassAttributeApprover nullApprover = null;
        ClassInfo actualClassInfo = PogoInvocationSteps.getClassInfo( EmptyTestPojo.class, nullApprover );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( expectedClassInfo, actualClassInfo );
    }

    @Test
    public void PogoShouldReturnAClassInfoObjectWhichContainsTheSameAttributesAsThePojoBeingProcessed()
    {
        ClassAttributeApprover nullApprover = null;
        ClassInfo actualClassInfo = PogoInvocationSteps.getClassInfo( SimplePojoToTestSetters.class, nullApprover );
        PogoValidationSteps.theObjectShouldNotBeNull( actualClassInfo );
        PogoValidationSteps.theTwoObjectsShouldBeEqual( SimplePojoToTestSetters.class, actualClassInfo.getClassName() );
        Set<String> attribs = new HashSet<>();
        attribs.add( "stringField" );
        attribs.add( "intField" );
        classInfoValidationSteps.theClassInfoAttributesShouldMatchthePojoOnes( attribs, actualClassInfo.getClassAttributes() );
    }
}
