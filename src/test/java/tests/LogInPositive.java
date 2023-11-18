package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.DashboardPage;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;

public class LogInPositive extends TestBase{
    @Test (groups = "smoke")
    public void goToSignIn() throws InterruptedException { {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        //takes the User to the Sign-In Page and verifies that this is the correct Page, provides valid credentials,
        //Logs In and verifies that the Page is the Account Dashboard Page

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickSignInButton();
        String SignInPageTitle = Driver.getDriver().getTitle();
        String expectedSignInPageTitle = "Sign In or Create an Account!";
        Assert.assertEquals(SignInPageTitle, expectedSignInPageTitle);

        SignInPage signInPage = new SignInPage();
        signInPage.getLogInEmailAddressInputField().sendKeys(ConfigReader.getProperty("username"));
        signInPage.getLogInPasswordInputField().sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);

        Thread.sleep(2000);

        String actualHeader = Driver.getDriver().findElement(By.xpath("//h1[@class='page-header']")).getText();
        String expectedHeader = "Account Dashboard";
        Assert.assertEquals(actualHeader, expectedHeader);

    }
}
