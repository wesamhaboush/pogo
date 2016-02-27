/**
 *
 */
package com.codebreeze.testing.tools.pogo.test.unit.features.walkThroughExample;

import com.codebreeze.testing.tools.pogo.api.PogoFactory;
import com.codebreeze.testing.tools.pogo.api.PogoFactoryImpl;
import com.codebreeze.testing.tools.pogo.test.dto.docs.example.Address;
import com.codebreeze.testing.tools.pogo.test.dto.docs.example.Article;
import com.codebreeze.testing.tools.pogo.test.dto.docs.example.BankAccount;
import com.codebreeze.testing.tools.pogo.test.dto.docs.example.OrderItem;
import com.codebreeze.testing.tools.pogo.test.unit.AbstractPogoSteps;
import org.junit.Test;

public class WalkThroughExampleUnitTest extends AbstractPogoSteps
{


    @Test
    public void testArticleSetup() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        Article pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Article.class, PogoFactory );
        walkThroughSteps.theArticlePojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testOrderItemSetup() throws Exception
    {
        PogoFactory pogoFactory = new PogoFactoryImpl();
        OrderItem pojo = pogoFactory.manufacturePojo( OrderItem.class );
        walkThroughSteps.theOrderItemPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testAddressSetup() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        Address pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( Address.class, PogoFactory );
        walkThroughSteps.theAddressPojoShouldBeCorrectlyFilled( pojo );
    }

    @Test
    public void testBankAccountSetup() throws Exception
    {
        PogoFactory PogoFactory = new PogoFactoryImpl();
        BankAccount pojo = PogoInvocationSteps.whenIInvokeTheFactoryForClass( BankAccount.class, PogoFactory );
        walkThroughSteps.theBankAccountPojoShouldBeCorrectlyFilled( pojo );
    }
}
