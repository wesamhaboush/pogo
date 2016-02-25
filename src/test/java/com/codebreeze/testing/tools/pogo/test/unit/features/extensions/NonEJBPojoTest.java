package com.codebreeze.testing.tools.pogo.test.unit.features.extensions;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.NonEJBPojo;
import org.junit.Test;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;

/**
 * Test @uk.co.jemos.Pogo.test.dto.NonEJBPojo@ construction
 *
 * @author daivanov
 *
 */
public class NonEJBPojoTest extends AbstractPogoSteps
{

    @Test
    public void PogoShouldHandleAttributesInAccordanceWithCustomClassInfoStrategies() throws Exception
    {
        NonEJBClassInfoStrategy classInfoStrategy = PogoFactorySteps.givenANonEJBClassInfoStrategy();
        PogoFactory PogoFactory = PogoFactorySteps.givenAPogoFactoryWithCustomClassInfoStrategy( classInfoStrategy );
        NonEJBPojo pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( NonEJBPojo.class, PogoFactory );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo );
        PogoValidationSteps.theStringFieldCannotBeNullOrEmpty( pojo.getMyString() );
        PogoValidationSteps.theObjectShouldNotBeNull( pojo.getMyLong() );
    }
}
