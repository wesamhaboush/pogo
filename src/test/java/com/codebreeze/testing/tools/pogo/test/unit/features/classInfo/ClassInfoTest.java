package com.codebreeze.testing.tools.pogo.test.unit.features.classInfo;

import com.codebreeze.testing.tools.pogo.api.ClassInfo;
import com.codebreeze.testing.tools.pogo.api.ClassAttribute;
import com.codebreeze.testing.tools.pogo.test.dto.EmptyTestPojo;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoWithExcludeAnnotationToTestSetters;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoToTestSetters;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.api.ClassAttributeApprover;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassInfoTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldReturnAValidClassInfoForPojoWithNoAttributes()
    {
        List<ClassAttribute> attributes = new ArrayList<>();
        ClassInfo expectedClassInfo = podamFactorySteps.givenAClassInfoForPojoWithNoAttributes( EmptyTestPojo.class,
                                      attributes );
        ClassAttributeApprover nullApprover = null;
        ClassInfo actualClassInfo = podamInvocationSteps.getClassInfo( EmptyTestPojo.class, nullApprover );
        podamValidationSteps.theTwoObjectsShouldBeEqual( expectedClassInfo, actualClassInfo );
    }

    @Test
    public void podamShouldReturnAClassInfoObjectWhichContainsTheSameAttributesAsThePojoBeingProcessed()
    {
        ClassAttributeApprover nullApprover = null;
        ClassInfo actualClassInfo = podamInvocationSteps.getClassInfo( SimplePojoToTestSetters.class, nullApprover );
        podamValidationSteps.theObjectShouldNotBeNull( actualClassInfo );
        podamValidationSteps.theTwoObjectsShouldBeEqual( SimplePojoToTestSetters.class, actualClassInfo.getClassName() );
        Set<String> attribs = new HashSet<>();
        attribs.add( "stringField" );
        attribs.add( "intField" );
        classInfoValidationSteps.theClassInfoAttributesShouldMatchthePojoOnes( attribs, actualClassInfo.getClassAttributes() );
    }

    @Test
    public void inPresenceOfExcludeAnnotationsTheClassInfoObjectShouldContainAValidSetOfPojoAttributes()
    {
        Set<Class<? extends Annotation>> excludeAnnotations =
            podamFactorySteps.givenASetOfExcludedAnnotationsToBeExcluded(
                SimplePojoWithExcludeAnnotationToTestSetters.TestExclude.class );
        Set<String> excludeFields = new HashSet<>();
        ClassInfo classInfo = podamFactorySteps.givenAClassInfoForPojoWithWithExcludedAnnotationsAndFields(
                                  SimplePojoWithExcludeAnnotationToTestSetters.class,
                                  excludeAnnotations, excludeFields );
        podamValidationSteps.theObjectShouldNotBeNull( classInfo );
        Set<String> attribs = new HashSet<>();
        attribs.add( "stringField" );
        attribs.add( "intField" );
        classInfoValidationSteps.theClassInfoAttributesShouldMatchthePojoOnes( attribs, classInfo.getClassAttributes() );
    }

    @Test
    public void inPresenceOfExcludedAttributesTheClassInfoObjectShouldNotContainThoseAttributes()
    {
        Set<Class<? extends Annotation>> excludeAnnotations =
            podamFactorySteps.givenASetOfExcludedAnnotationsToBeExcluded();
        Set<String> excludeFields = podamFactorySteps.givenASetOfExcludedFields(
                                        "excludeField1",
                                        "excludeField2",
                                        "excludeField3" );
        ClassInfo classInfo = podamFactorySteps.givenAClassInfoForPojoWithWithExcludedAnnotationsAndFields(
                                  SimplePojoWithExcludeAnnotationToTestSetters.class,
                                  excludeAnnotations, excludeFields );
        podamValidationSteps.theObjectShouldNotBeNull( classInfo );
        Set<String> attribs = new HashSet<>();
        attribs.add( "stringField" );
        attribs.add( "intField" );
        classInfoValidationSteps.theClassInfoAttributesShouldMatchthePojoOnes( attribs, classInfo.getClassAttributes() );
    }



}
