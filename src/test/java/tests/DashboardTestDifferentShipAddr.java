package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.DashboardPage;
public class DashboardTestDifferentShipAddr extends AccountCreationPositiveDifferentShippingAddress{
    CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void checkDashBoardInfo () {

        //1st column
        Assert.assertEquals(dashboardPage.getAccountInfoFullName().getText(), createAnAccountPage.getNameProvided());
        Assert.assertEquals(dashboardPage.getAccountInfoCompanyName(),createAnAccountPage.getCompanyNameField());
        Assert.assertEquals(dashboardPage.getAccountInfoEmail().getText(), createAnAccountPage.getEmailProvided());

        //2nd column
            Assert.assertEquals(dashboardPage.getAccountShippingFullName().getText(), createAnAccountPage.getFullNameShip());
            Assert.assertEquals(dashboardPage.getAccountShippingCompanyName().getText(), createAnAccountPage.getCompanyShip());
            Assert.assertEquals(dashboardPage.getAccountShippingStreetAddress(), createAnAccountPage.getAddressLine1Ship());
            Assert.assertEquals(dashboardPage.getShipZipFromDashboard(), createAnAccountPage.getZipCodeShip());
            Assert.assertEquals(dashboardPage.getAccountShippingCountry().getText(), createAnAccountPage.getCountrySelectedShip());

        //3rd column
        //Assert.assertEquals(dashboardPage.

    }






}
