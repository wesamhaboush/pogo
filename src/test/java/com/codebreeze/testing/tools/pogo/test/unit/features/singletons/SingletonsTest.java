package com.codebreeze.testing.tools.pogo.test.unit.features.singletons;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.OneDimensionalTestPojo;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.dto.SingletonWithParametersInStaticFactoryPojo;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

import java.util.List;
import java.util.Map;

public class SingletonsTest extends AbstractPogoSteps
{


    @Test
    public void PogoShouldHandleSingletonsWithParametersInPublicStaticMethod() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        SingletonWithParametersInStaticFactoryPojo pojo =
            PogoInvocationSteps.whenIInvokeTheFactoryForClass( SingletonWithParametersInStaticFactoryPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theCalendarFieldShouldNotBeNull( pojo.getCreateDate() );
        PogoValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getFirstName() );
        List<OneDimensionalTestPojo> pojoList = pojo.getPojoList();
        PogoValidationSteps.theListShouldNotBeNullAndContainAtLeastOneNonEmptyElement( pojoList );
        Map<String, OneDimensionalTestPojo> pojoMap = pojo.getPojoMap();
        PogoValidationSteps.theMapShouldContainAtLeastOneNonEmptyElement( pojoMap );
    }

}
