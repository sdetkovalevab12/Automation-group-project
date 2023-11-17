package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.DashboardPage;
public class DashboardTests extends TestBase{
    CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void checkDashBoardInfo (){

        //1st column
        Assert.assertEquals(dashboardPage.getAccountInfoFullName().getText(), createAnAccountPage.getNameProvided());
        Assert.assertEquals(dashboardPage.getAccountInfoCompanyName(),createAnAccountPage.getCompanyNameField());
        Assert.assertEquals(dashboardPage.getAccountInfoEmail().getText(), createAnAccountPage.getEmailProvided());

        //2nd column
        if (createAnAccountPage.getSameAsBillingCheckBox().isSelected())
        {
            Assert.assertEquals(dashboardPage.getAccountShippingFullName().getText(), createAnAccountPage.getNameProvided());
            Assert.assertEquals(dashboardPage.getAccountShippingCompanyName().getText(), createAnAccountPage.getCompanyNameProvided());
            Assert.assertEquals(dashboardPage.getAccountShippingStreetAddress(), createAnAccountPage.getAddressLine1());
            Assert.assertEquals(dashboardPage.getShipZipFromDashboard(), createAnAccountPage.getZip());
            Assert.assertEquals(dashboardPage.getAccountShippingCountry().getText(), createAnAccountPage.getCountrySelected());
        }else{
            Assert.assertEquals(createAnAccountPage.getNameField().getText(), "re re");

        }
        //3rd column
        //Assert.assertEquals(dashboardPage.

    }






}
