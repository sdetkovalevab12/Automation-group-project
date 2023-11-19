package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReturnAndOrders;
import utils.Driver;
import utils.SeleniumUtils;

public class TestingReturnAndOrder extends TestBase{
@Test(groups = "smoke")
    public void testCase1(){

// Click return and order and logging inn the account

    ReturnAndOrders returnAndOrders = new ReturnAndOrders();
    returnAndOrders.getReturnOrdder().click();
    returnAndOrders.getUsername().sendKeys("pojo@fastmail.us");
    returnAndOrders.getPassword().sendKeys("D5-test");
    returnAndOrders.getLoginBtn().click();

    // Verifying orders by clicking on order button

    }

    @Test(groups = "smoke")
    public void testCase2(){

    // Verifying orders by clicking on order button and verifying there is no orders

        ReturnAndOrders returnAndOrders = new ReturnAndOrders();
        returnAndOrders.getReturnOrdder().click();
        returnAndOrders.getUsername().sendKeys("pojo@fastmail.us");
        returnAndOrders.getPassword().sendKeys("D5-test");
        returnAndOrders.getLoginBtn().click();
        returnAndOrders.getViewOrders().click();
        Assert.assertTrue(returnAndOrders.getNoOrderText().isDisplayed());

    }

    @Test(groups = "smoke")
    public void testCase3(){
        //Verifying return orders by clicking return button and verifying there is no returns

        ReturnAndOrders returnAndOrders = new ReturnAndOrders();
        returnAndOrders.getReturnOrdder().click();
        returnAndOrders.getUsername().sendKeys("pojo@fastmail.us");
        returnAndOrders.getPassword().sendKeys("D5-test");
        returnAndOrders.getLoginBtn().click();
        returnAndOrders.getViewReturns().click();
        Assert.assertTrue(returnAndOrders.getNoReturns().isDisplayed());

    }
     @Test(groups = "smoke")
    public void testCase4() throws InterruptedException {
    //Verifying if i get notification by email

        ReturnAndOrders returnAndOrders = new ReturnAndOrders();
        returnAndOrders.getReturnOrdder().click();
        returnAndOrders.getUsername().sendKeys("pojo@fastmail.us");
        returnAndOrders.getPassword().sendKeys("D5-test");
        returnAndOrders.getLoginBtn().click();
        returnAndOrders.getOrderNotification().click();
        Assert.assertTrue(returnAndOrders.getCheckBoxNotification().isDisplayed());
        Assert.assertTrue(returnAndOrders.getCheckBoxNotification().isSelected());
    }
    @Test
    public void testCase5(){

      // Verifying if shipping address if its saved on account

        ReturnAndOrders returnAndOrders = new ReturnAndOrders();
        returnAndOrders.getReturnOrdder().click();
        returnAndOrders.getUsername().sendKeys("pojo@fastmail.us");
        returnAndOrders.getPassword().sendKeys("D5-test");
        returnAndOrders.getLoginBtn().click();
        returnAndOrders.getVerifyingShipingAdress().click();
        Assert.assertTrue(returnAndOrders.getCheckBoxShiping().isDisplayed());


    }

}
