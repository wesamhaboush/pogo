package com.codebreeze.testing.tools.pogo.test.unit.features.basicTypes;

import com.codebreeze.testing.tools.pogo.api.DefaultClassInfoStrategy;
import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.common.PogoExclude;
import com.codebreeze.testing.tools.pogo.test.dto.SimplePojoWithExcludeAnnotationToTestSetters;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.BooleanPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

public class BooleanUnitTest extends AbstractPogoSteps
{

    private final static DefaultClassInfoStrategy classInfoStrategy =
        DefaultClassInfoStrategy.getInstance();

    @BeforeClass
    public static void init()
    {
        classInfoStrategy.addExcludedField( BooleanPojo.class, "value4" );
        classInfoStrategy.addExcludedAnnotation( SimplePojoWithExcludeAnnotationToTestSetters.TestExclude.class );
        classInfoStrategy.addExcludedAnnotation( PogoExclude.class );
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
    public void PogoShouldHandleBooleansCorrect() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        BooleanPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( BooleanPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theBooleanValueIsTrue( pojo.isValue1() );
        PogoValidationSteps.theValueShouldBeNull( pojo.isValue2() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getValue3() );
        PogoValidationSteps.theValueShouldBeNull( pojo.getValue4() );
    }

}
