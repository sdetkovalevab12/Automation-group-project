package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HelpCenter;
import utils.Driver;
import utils.SeleniumUtils;

public class TestingHelpCenter extends TestBase {
    @Test
    public void testCase1(){

        //Clicking on Help Center from main page and verifying user is in help center

        HelpCenter helpCenter = new HelpCenter();
        helpCenter.getHelpCenterButn().click();
        Assert.assertTrue(helpCenter.getHelpCenterButn().isDisplayed());
    }
    @Test
    public void testCase2(){

        // Verifying chat now button by clicking on the chat now button
        //and opening a new window

        HelpCenter helpCenter = new HelpCenter();
        helpCenter.getHelpCenterButn().click();
        helpCenter.getChatNowButn().click();
        SeleniumUtils.switchToWindow(  "WebstaurantStore: Frequently Asked Questions");


    }



    @Test
    public void testCase3() {

        // Accessing  Help Center Menu and clicking on Chat now button verifying its working


        HelpCenter helpCenter = new HelpCenter();
        helpCenter.getHelpCenterButn().click();
        helpCenter.getChatNowButn().click();
        SeleniumUtils.switchToWindow(  "WebstaurantStore Online Chat");
        Driver.getDriver().manage().window().maximize();


    }

    @Test
    public void testCase4() throws InterruptedException {
        // Switching window and navigating to new window and selecting issue from the drop down menu

        HelpCenter helpCenter = new HelpCenter();
        helpCenter.getHelpCenterButn().click();
        helpCenter.getChatNowButn().click();
        SeleniumUtils.switchToWindow(  "WebstaurantStore Online Chat");
        Driver.getDriver().manage().window().maximize();
        helpCenter.getSelectIssues().click();
        Thread.sleep(2000);

    }

    @Test
    public void testCase5() throws InterruptedException {
        // Using java script execute user will scroll down to the page and click on the help Center from the
        //bottom of the page making sure its working

        HelpCenter helpCenter = new HelpCenter();
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,5000);");
        Thread.sleep(3000);
        helpCenter.getHelpCenterBottomPage().click();

    }

}
