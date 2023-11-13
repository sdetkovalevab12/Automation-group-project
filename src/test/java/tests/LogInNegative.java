package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.SignInPage;
import utils.Driver;


public class LogInNegative extends TestBase {
    Faker faker = new Faker();
    String AccountDashboardTitle = Driver.getDriver().getTitle();
    String expectedAccountDashboardTitle = "Restaurant Supplies, Restaurant Supply at WebstaurantStore";
    SignInPage signInPage = new SignInPage();
    @BeforeMethod
    public void goToSignIn() {


        //takes the User to the Sign-In Page and verifies that this is the correct Page
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickSignInButton();
        String SignInPageTitle = Driver.getDriver().getTitle();
        String expectedSignInPageTitle = "Sign In or Create an Account!";
        Assert.assertEquals(SignInPageTitle, expectedSignInPageTitle);
    }

    //User provides invalid credentials
    @Test
    public void validEmailInvalidPass(){
        signInPage.getLogInEmailAddressInputField().sendKeys("pojo@fastmail.us");
        signInPage.getLogInPasswordInputField().sendKeys(faker.internet().password(), Keys.ENTER);
        Assert.assertNotEquals(AccountDashboardTitle, expectedAccountDashboardTitle);
    }
    @Test
    public void invalidEmailValidPass(){
        signInPage.getLogInEmailAddressInputField().sendKeys(faker.internet().emailAddress());
        signInPage.getLogInPasswordInputField().sendKeys("D5-test", Keys.ENTER);
        Assert.assertNotEquals(AccountDashboardTitle, expectedAccountDashboardTitle);
    }
    @Test
    public void invalidEmailInvalidPass(){
        signInPage.getLogInEmailAddressInputField().sendKeys(faker.internet().emailAddress()+"1");
        signInPage.getLogInPasswordInputField().sendKeys(faker.internet().password()+"1", Keys.ENTER);
        Assert.assertNotEquals(AccountDashboardTitle, expectedAccountDashboardTitle);
    }
}