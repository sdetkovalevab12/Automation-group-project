package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.DashboardPage;
import utils.Driver;

public class LogOutTest extends SignUpOption{
    @Test(groups = "smoke")
    public void LogOut() throws InterruptedException {
        //need to Log In first
        LogInPositive logInPositivePage = new LogInPositive();
        logInPositivePage.goToSignIn();

        //Log Out now
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickLogOutButton();

        String actualLogOutHeader = Driver.getDriver().findElement(By.xpath("//div[@class='portal__main']//h1")).getText();
        String expectedLogOutHeader = "Login";
        Assert.assertEquals(actualLogOutHeader, expectedLogOutHeader);
    }
}
