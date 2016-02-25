/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.features.walkThroughExample;

import com.codebreeze.testing.tools.pogo.api.PodamFactory;
import com.codebreeze.testing.tools.pogo.test.dto.docs.example.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPodamSteps;
import org.junit.Test;

/**
 * A set of tests to check the Walk-through example
 *
 * @author mtedone
 *
 */
public class WalkThroughExampleUnitTest extends AbstractPodamSteps
{

    @Test
    public void testCountrySetup() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        Country pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( Country.class, podamFactory );
        walkThroughSteps.theCountryPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testArticleSetup() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        Article pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( Article.class, podamFactory );
        walkThroughSteps.theArticlePojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testOrderItemSetup() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        OrderItem pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( OrderItem.class, podamFactory );
        walkThroughSteps.theOrderItemPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testOrderSetup() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        Order pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( Order.class, podamFactory );
        walkThroughSteps.theOrderPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testAddressSetup() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        Address pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( Address.class, podamFactory );
        walkThroughSteps.theAddressPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testBankAccountSetup() throws Exception
    {
        PodamFactory podamFactory = podamFactorySteps.givenAStandardPodamFactory();
        BankAccount pojo = podamInvocationSteps.whenIInvokeTheFactoryForClass( BankAccount.class, podamFactory );
        walkThroughSteps.theBankAccountPojoShouldBeCorrectlyFilled( pojo );
    }
}
