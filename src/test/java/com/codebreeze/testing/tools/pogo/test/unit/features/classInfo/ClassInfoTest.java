package com.codebreeze.testing.tools.pogo.test.unit.features.classInfo;

import com.codebreeze.testing.tools.pogo.api.ClassInfo;
import com.codebreeze.testing.tools.pogo.api.ClassAttribute;
import com.codebreeze.testing.tools.pogo.test.dto.EmptyTestPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoWithExcludeAnnotationToTestSetters;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.api.ClassAttributeApprover;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import java.lang.annotation.Annotation;
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

    @Test
    public void inPresenceOfExcludeAnnotationsTheClassInfoObjectShouldContainAValidSetOfPojoAttributes()
    {
        Set<Class<? extends Annotation>> excludeAnnotations =
            PogoFactorySteps.givenASetOfExcludedAnnotationsToBeExcluded(
                SimplePojoWithExcludeAnnotationToTestSetters.TestExclude.class );
        Set<String> excludeFields = new HashSet<>();
        ClassInfo classInfo = PogoFactorySteps.givenAClassInfoForPojoWithWithExcludedAnnotationsAndFields(
                                  SimplePojoWithExcludeAnnotationToTestSetters.class,
                                  excludeAnnotations, excludeFields );
        PogoValidationSteps.theObjectShouldNotBeNull( classInfo );
        Set<String> attribs = new HashSet<>();
        attribs.add( "stringField" );
        attribs.add( "intField" );
        classInfoValidationSteps.theClassInfoAttributesShouldMatchthePojoOnes( attribs, classInfo.getClassAttributes() );
    }

    @Test
    public void inPresenceOfExcludedAttributesTheClassInfoObjectShouldNotContainThoseAttributes()
    {
        Set<Class<? extends Annotation>> excludeAnnotations =
            PogoFactorySteps.givenASetOfExcludedAnnotationsToBeExcluded();
        Set<String> excludeFields = PogoFactorySteps.givenASetOfExcludedFields(
                                        "excludeField1",
                                        "excludeField2",
                                        "excludeField3" );
        ClassInfo classInfo = PogoFactorySteps.givenAClassInfoForPojoWithWithExcludedAnnotationsAndFields(
                                  SimplePojoWithExcludeAnnotationToTestSetters.class,
                                  excludeAnnotations, excludeFields );
        PogoValidationSteps.theObjectShouldNotBeNull( classInfo );
        Set<String> attribs = new HashSet<>();
        attribs.add( "stringField" );
        attribs.add( "intField" );
        classInfoValidationSteps.theClassInfoAttributesShouldMatchthePojoOnes( attribs, classInfo.getClassAttributes() );
    }



}
