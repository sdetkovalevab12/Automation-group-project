package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SocialMediaVereficationElementsPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Set;

public class SocialMediaConnectionTest extends TestBase{


@Test
public void  instagrammTest_WP_35() {

    new HomePage().getInstagramLink().click();
    SeleniumUtils.switchToWindow("WebstaurantStore (@webstaurantstore) • Instagram photos and videos");
    SeleniumUtils.waitForPageToLoad(4);
    Assert.assertTrue(new SocialMediaVereficationElementsPage().getInstagramLogo().isDisplayed());
   }

    @Test
    public void youTubeTest_WP_35() {

    new HomePage().getYouTubeLink().click();
    SeleniumUtils.switchToWindow("WebstaurantStore - YouTube");
    SeleniumUtils.waitForPageToLoad(5);
    Assert.assertTrue(new SocialMediaVereficationElementsPage().getYouTubeLogo().isDisplayed());
     }

    @Test
    public void facebookTest_WP_35(){

    SocialMediaVereficationElementsPage icons = new SocialMediaVereficationElementsPage();
    new HomePage().getFaceBookLink().click();
 // SeleniumUtils.switchToWindow("WebstaurantStore | Facebook");  //didn't work
    SeleniumUtils.switchBetween2Windows();
   SeleniumUtils.jsClick(icons.getFbAlert());
   Assert.assertTrue(icons.getFaceBookLogo().isDisplayed());
   }

@Test
    public void pinterestTest_WP_35(){

    new HomePage().getPinterestLink().click();
    SeleniumUtils.switchToWindow("WebstaurantStore (webstaurant) | Official Pinterest account");
    Assert.assertTrue(new SocialMediaVereficationElementsPage().getPinterestLogo().isDisplayed());
}

    @Test
    public void tikTokTest_WP_35() {

    new HomePage().getTikTokLink().click();
    //SeleniumUtils.switchToWindow("WebstaurantStore (@webstaurantstore) Official  | TikTok");
        SeleniumUtils.switchBetween2Windows();
        SeleniumUtils.waitForPageToLoad(10);
        Assert.assertTrue(new SocialMediaVereficationElementsPage().getTikTokLogo().isDisplayed());
    // Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.tiktok.com/@webstaurantstore");
    }

}
