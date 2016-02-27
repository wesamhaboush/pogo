package com.codebreeze.testing.tools.pogo.test.unit.steps;


import com.codebreeze.testing.tools.pogo.test.dto.docs.example.*;
import org.junit.Assert;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WalkThroughSteps
{


    public void theBankAccountPojoShouldBeCorrectlyFilled( BankAccount pojo )
    {
        Assert.assertNotNull( "The bank account cannot be null!", pojo );
        Assert.assertTrue( "The bank account cannot be zero!",
                           pojo.getAccount() != 0 );
        Assert.assertTrue( "The account balance cannot be zero!",
                           pojo.getBalance() != 0.0 );
        Assert.assertNotNull( "The bank name cannot be null!", pojo.getBank() );
        Assert.assertTrue( "The bank name cannot be empty!", pojo.getBank()
                           .length() > 0 );
        Assert.assertNotNull( "The sort code cannot be null!",
                              pojo.getSortCode() );
        Assert.assertTrue( "The sort code cannot be empty!", pojo.getSortCode()
                           .length() > 0 );
    }

    public void theAddressPojoShouldBeCorrectlyFilled( Address pojo )
    {
        Assert.assertNotNull( "The address cannot be null!", pojo );
        Assert.assertNotNull( "The address1 cannot be null!", pojo.getAddress1() );
        Assert.assertNotNull( "The address2 cannot be null!", pojo.getAddress2() );
        Assert.assertNotNull( "The city cannot be null!", pojo.getCity() );
        Assert.assertNotNull( "The zipCode cannot be null!", pojo.getZipCode() );
        theCountryPojoShouldBeCorrectlyFilled( pojo.getCountry() );
    }


    private void theOrderPojoShouldBeCorrectlyFilled( Order pojo )
    {
        Assert.assertNotNull( "The pojo cannot be null!", pojo );
        Assert.assertTrue( "The order id must not be zero!", pojo.getId() != 0 );
        Calendar createDate = pojo.getCreateDate();
        Assert.assertNotNull( "The create date must not be null!", createDate );
        Assert.assertTrue( "The order total amount must not be zero!",
                           pojo.getTotalAmount() != 0.0 );
        List<OrderItem> orderItems = pojo.getOrderItems();
        Assert.assertNotNull( "The order items must not be null!", orderItems );
        Assert.assertFalse( "The order items must not be empty!",
                            orderItems.isEmpty() );
        int expectedNbrElements = 5;
        Assert.assertTrue( "The expected number of elements "
                           + expectedNbrElements + " does not match the actual number: "
                           + orderItems.size(), orderItems.size() == expectedNbrElements );
        orderItems.forEach( this::theOrderItemPojoShouldBeCorrectlyFilled );
    }


    public void theOrderItemPojoShouldBeCorrectlyFilled( OrderItem pojo )
    {
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getNote() ).isNotNull();
        theArticlePojoShouldBeCorrectlyFilled( pojo.getArticle() );
    }

    public void theArticlePojoShouldBeCorrectlyFilled( Article pojo )
    {
        assertThat( pojo ).isNotNull();
        assertThat( pojo.getItemCost() ).isNotNull();
        assertThat( pojo.getDescription() ).isNotNull();
    }

    private void theCountryPojoShouldBeCorrectlyFilled( Country pojo )
    {
        Assert.assertNotNull( "The pojo cannot be null!", pojo );
        String countryCode = pojo.getCountryCode();
        Assert.assertNotNull( "The country Code cannot be null!", countryCode );
        Assert.assertTrue(
            countryCode.length() > 0 );
        Assert.assertTrue( "country id must be different from zero!",
                           pojo.getCountryId() != 0 );
        Assert.assertNotNull( "The country description must not be null!",
                              pojo.getDescription() );
        Assert.assertTrue( "The country description must not be empty!", pojo
                           .getDescription().length() > 0 );
    }

    public void theClientPojoShouldBeCorrectlyFilled( Client pojo )
    {
        Assert.assertNotNull( "The pojo cannot be null!", pojo );
        Assert.assertNotNull( "The client's first name cannot be null!",
                              pojo.getFirstName() );
        Assert.assertTrue( "The client's first name cannot be empty!", pojo
                           .getFirstName().length() > 0 );
        String expectedFirstName = "Michael";
        Assert.assertEquals( "The client's first name is not "
                             + expectedFirstName, expectedFirstName, pojo.getFirstName() );
        Assert.assertNotNull( "The client's last name cannot be null!",
                              pojo.getLastName() );
        Assert.assertTrue( "The client's last name cannot be empty!", pojo
                           .getLastName().length() > 0 );
        Assert.assertNotNull( "The date created cannot be null!",
                              pojo.getDateCreated() );
        List<Order> orders = pojo.getOrders();
        Assert.assertNotNull( "The orders cannot be null!", orders );
        int expectedOrdersNbr = 3;
        Assert.assertTrue( "The expected number of orders is "
                           + expectedOrdersNbr, orders.size() == expectedOrdersNbr );
        orders.forEach( this::theOrderPojoShouldBeCorrectlyFilled );
        List<Address> addresses = pojo.getAddresses();
        Assert.assertNotNull( "The addresses cannot be null!", addresses );
        int expectedAddressesNbr = 2;
        Assert.assertTrue( "The expected number of addresses is "
                           + expectedAddressesNbr,
                           addresses.size() == expectedAddressesNbr );
        addresses.forEach( this::theAddressPojoShouldBeCorrectlyFilled );
        List<BankAccount> bankAccounts = pojo.getBankAccounts();
        bankAccounts.forEach( this::theBankAccountPojoShouldBeCorrectlyFilled );
    }

}
