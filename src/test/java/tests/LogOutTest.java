package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import utils.Driver;

public class LogOutTest extends SignUpOption{
    @Test
    public void LogOut() throws InterruptedException {
        //need to Log In first
        LogInPositive logInPositivePage = new LogInPositive();
        logInPositivePage.goToSignIn();

        //Log Out now
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickLogOutButton();
        String SignInPageTitle = Driver.getDriver().getTitle();
        String expectedSignInPageTitle = "Sign In or Create an Account!";
        Assert.assertEquals(SignInPageTitle, expectedSignInPageTitle);
    }
}
