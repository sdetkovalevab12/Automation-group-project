package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.SignInPage;
import utils.Driver;

public class LogInNegative extends SignUpOption {
    @Test (groups = "smoke")
    public void goToSignIn() throws InterruptedException {
        //takes the User to the Sign-In Page and verifies that this is the correct Page
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickSignInButton();
        String SignInPageTitle = Driver.getDriver().getTitle();
        String expectedSignInPageTitle = "Sign In or Create an Account!";
        Assert.assertEquals(SignInPageTitle, expectedSignInPageTitle);

        //User provides invalid credentials
        SignInPage signInPage = new SignInPage();
        signInPage.getLogInEmailAddressInputField().sendKeys(" ");
        signInPage.getLogInPasswordInputField().sendKeys(" ", Keys.ENTER);

    }
}