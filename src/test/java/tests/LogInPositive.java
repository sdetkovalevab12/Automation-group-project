package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;

public class LogInPositive extends SignUpOption{
    @Test
    public void goToSignIn() throws InterruptedException {
        //takes the User to the Sign-In Page and verifies that this is the correct Page, provides valid credentials,
        // Logs In and verifies that the Page is the Account Dashboard Page

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
        String AccountDashboardTitle = Driver.getDriver().getTitle();
        String expectedAccountDashboardTitle = "Restaurant Supplies, Restaurant Supply at WebstaurantStore";
        Assert.assertEquals(AccountDashboardTitle, expectedAccountDashboardTitle);

    }
}
