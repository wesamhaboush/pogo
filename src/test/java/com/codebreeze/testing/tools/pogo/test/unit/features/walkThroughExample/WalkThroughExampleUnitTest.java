/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.features.walkThroughExample;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.test.dto.docs.example.*;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

public class WalkThroughExampleUnitTest extends AbstractPogoSteps
{

    @Test
    public void testCountrySetup() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        Country pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Country.class, PogoFactory );
        walkThroughSteps.theCountryPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testArticleSetup() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        Article pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Article.class, PogoFactory );
        walkThroughSteps.theArticlePojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testOrderItemSetup() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        OrderItem pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( OrderItem.class, PogoFactory );
        walkThroughSteps.theOrderItemPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testOrderSetup() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        Order pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Order.class, PogoFactory );
        walkThroughSteps.theOrderPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testAddressSetup() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        Address pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Address.class, PogoFactory );
        walkThroughSteps.theAddressPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testBankAccountSetup() throws Exception
    {
        PogoFactory PogoFactory = PogoFactorySteps.givenAStandardPogoFactory();
        BankAccount pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( BankAccount.class, PogoFactory );
        walkThroughSteps.theBankAccountPojoShouldBeCorrectlyFilled( pojo );
    }
}
