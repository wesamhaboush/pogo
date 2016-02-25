package com.codebreeze.testing.tools.pogo.test.unit.features.extensions;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.NonEJBPojo;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;

/**
 * Test @uk.co.jemos.podam.test.dto.NonEJBPojo@ construction
 *
 * @author daivanov
 *
 */
public class NonEJBPojoTest extends AbstractPodamSteps
{

    @Test
    public void podamShouldHandleAttributesInAccordanceWithCustomClassInfoStrategies() throws Exception
    {
        NonEJBClassInfoStrategy classInfoStrategy = podamFactorySteps.givenANonEJBClassInfoStrategy();
        PodamFactory podamFactory = podamFactorySteps.givenAPodamFactoryWithCustomClassInfoStrategy( classInfoStrategy );
        NonEJBPojo pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( NonEJBPojo.class, podamFactory );
        podamValidationSteps.theObjectShouldNotBeNull( pojo );
        podamValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getMyString() );
        podamValidationSteps.theObjectShouldNotBeNull( pojo.getMyLong() );
    }
}
