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
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WalkThroughExampleUnitTest
{
    @Test
    public void article_setup() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        Article pojo = pogoFactory.manufacturePojo( Article.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getItemCost() ).isNotNull();
        assertThat( pojo.getDescription() ).isNotNull();
    }

    @Test
    public void order_item_setup() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        OrderItem pojo = pogoFactory.manufacturePojo( OrderItem.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getNote() ).isNotNull();
        assertThat( pojo.getArticle() ).isNotNull();
        assertThat( pojo.getArticle().getItemCost() ).isNotNull();
        assertThat( pojo.getArticle().getDescription() ).isNotNull();
    }

    @Test
    public void address_setup() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        Address pojo = pogoFactory.manufacturePojo( Address.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getAddress1() ).isNotNull();
        assertThat( pojo.getAddress2() ).isNotNull();
        assertThat( pojo.getCity() ).isNotNull();
        assertThat( pojo.getZipCode() ).isNotNull();
        assertThat( pojo.getCountry() ).isNotNull();
        assertThat( pojo.getCountry().getCountryCode() ).isNotNull().isNotEmpty();
        assertThat( pojo.getCountry().getCountryId() ).isNotNull();
        assertThat( pojo.getCountry().getDescription() ).isNotNull().isNotEmpty();
    }

    @Test
    public void bank_account_setup() throws Exception
    {
        //given
        PogoFactory pogoFactory = new PogoFactoryImpl();
        //when
        BankAccount pojo = pogoFactory.manufacturePojo( BankAccount.class );
        //then
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getAccount() ).isNotNull();
        assertThat( pojo.getBalance() ).isNotNull();
        assertThat( pojo.getBank() ).isNotNull().isNotEmpty();
        assertThat( pojo.getSortCode() ).isNotNull().isNotEmpty();
    }
}
