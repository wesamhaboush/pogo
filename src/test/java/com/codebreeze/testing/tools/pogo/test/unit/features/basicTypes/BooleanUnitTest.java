package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.DefaultClassInfoStrategy;
import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.common.PodamExclude;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoWithExcludeAnnotationToTestSetters;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.BooleanPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

public class BooleanUnitTest extends AbstractPodamSteps
{

    private final static DefaultClassInfoStrategy classInfoStrategy =
        DefaultClassInfoStrategy.getInstance();

    @BeforeClass
    public static void init()
    {
        classInfoStrategy.addExcludedField( BooleanPojo.class, "value4" );
        classInfoStrategy.addExcludedAnnotation( SimplePojoWithExcludeAnnotationToTestSetters.TestExclude.class );
        classInfoStrategy.addExcludedAnnotation( PodamExclude.class );
        Assert.assertEquals( "Unexpected number of exluded annotations",
                             2, classInfoStrategy.getExcludedAnnotations().size() );
    }

    @AfterClass
    public static void deinit()
    {
        classInfoStrategy.removeExcludedField( BooleanPojo.class, "value4" );
        classInfoStrategy.removeExcludedAnnotation( SimplePojoWithExcludeAnnotationToTestSetters.TestExclude.class );
        Assert.assertEquals( "Unexpected number of exluded annotations",
                             1, classInfoStrategy.getExcludedAnnotations().size() );
    }

    @Test
    public void podamShouldHandleBooleansCorrect() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        BooleanPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( BooleanPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theBooleanValueIsTrue( pojo.isValue1() );
        podamValidationSteps.theValueShouldBeNull( pojo.isValue2() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getValue3() );
        podamValidationSteps.theValueShouldBeNull( pojo.getValue4() );
    }

}
