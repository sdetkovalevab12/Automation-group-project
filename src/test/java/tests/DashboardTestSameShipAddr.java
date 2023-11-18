package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.DashboardPage;
import utils.Driver;

public class DashboardTestSameShipAddr extends AccountCreationPositiveDifferentShippingAddress{ {
    PageFactory.initElements(Driver.getDriver(), this);
}
    CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void checkDashBoardInfo () {
        String zipRetrieve = dashboardPage.getShippingCityStateZip().getText();
        String shipZipFromDashboard = zipRetrieve.substring(zipRetrieve.length()-5);

        //1st column
        Assert.assertEquals(dashboardPage.getAccountInfoFullName().getText(), createAnAccountPage.getNameProvided());
        Assert.assertEquals(dashboardPage.getAccountInfoCompanyName(),createAnAccountPage.getCompanyNameField());
        Assert.assertEquals(dashboardPage.getAccountInfoEmail().getText(), createAnAccountPage.getEmailProvided());

        //2nd column
            Assert.assertEquals(dashboardPage.getAccountShippingFullName().getText(), createAnAccountPage.getNameProvided());
            Assert.assertEquals(dashboardPage.getAccountShippingCompanyName().getText(), createAnAccountPage.getCompanyNameProvided());
            Assert.assertEquals(dashboardPage.getAccountShippingStreetAddress(), createAnAccountPage.getAddressLine1());
            Assert.assertEquals(shipZipFromDashboard, createAnAccountPage.getZip());
            Assert.assertEquals(dashboardPage.getAccountShippingCountry().getText(), createAnAccountPage.getCountrySelected());
        
        //3rd column
        //Assert.assertEquals(dashboardPage.

    }






}
