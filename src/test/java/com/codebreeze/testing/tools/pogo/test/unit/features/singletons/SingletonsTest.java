package com.codebreeze.testing.tools.pogo.test.unit.features.singletons;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.OneDimensionalTestPojo;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.SingletonWithParametersInStaticFactoryPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

import java.util.List;
import java.util.Map;

public class SingletonsTest extends AbstractPodamSteps
{


    @Test
    public void podamShouldHandleSingletonsWithParametersInPublicStaticMethod() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        SingletonWithParametersInStaticFactoryPojo pojo =
            podamInvocationSteps.whenIInvokeTheFactoryForClass( SingletonWithParametersInStaticFactoryPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theCalendarFieldShouldNotBeNull( pojo.getCreateDate() );
        podamValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        List<OneDimensionalTestPojo> pojoList = pojo.getPojoList();
        podamValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( pojoList );
        Map<String, OneDimensionalTestPojo> pojoMap = pojo.getPojoMap();
        podamValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( pojoMap );
    }

}
