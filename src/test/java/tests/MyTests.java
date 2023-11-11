package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumUtils;

public class MyTests extends TestBase{



    @Test
    public void testcase001() throws InterruptedException {

        HomePage homePage = new HomePage();
        String expected = "knife";
        homePage.getSearchBar().sendKeys(expected, Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(expected));

    }
}
