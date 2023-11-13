package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import utils.Driver;

public class SignUpOption extends TestBase {
    @Test
    public void goToSignUp() throws InterruptedException {
        //takes the User to the Account Registration Page and verifies that this is the correct Page

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickSignUpButton();
        String SignUpPageTitle = Driver.getDriver().getTitle();
        String expectedSignUpPageTitle = "WebstaurantStore: Account Registration";
        Assert.assertEquals(SignUpPageTitle, expectedSignUpPageTitle);
    }
}
