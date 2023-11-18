package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.DashboardPage;
import utils.Driver;

public class AccountCreationPositiveDifferentShippingAddress extends TestBase {

    @Test(groups = "smoke")
    public void fillOutValidData () throws InterruptedException { {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickSignUpButton();

        //filling out the form with appropriate data and storing the information for the future use

        createAnAccountPage.getEmailField().sendKeys(createAnAccountPage.getEmailProvided());

        if (createAnAccountPage.getReceiveCouponsCheckBox().isSelected()){
            createAnAccountPage.clickReceiveCouponsCheckBox();
        }

        createAnAccountPage.getNameField().sendKeys(createAnAccountPage.getNameProvided());
        createAnAccountPage.getAddressLine1().sendKeys(createAnAccountPage.getAddressLine1Provided());

        Select countrySelect = new Select(createAnAccountPage.getCountrySelector());
        countrySelect.selectByVisibleText("United States");
        String countrySelected = createAnAccountPage.getCountrySelected();

        createAnAccountPage.getZipField().sendKeys(createAnAccountPage.getZip());
        createAnAccountPage.getPhoneField().sendKeys(createAnAccountPage.getPhoneProvided());

        if (createAnAccountPage.getSameAsBillingCheckBox().isSelected())
        {
            createAnAccountPage.clickSameAsBillingCheckBox();
        }

        //different Shipping Address
        createAnAccountPage.getShipName().sendKeys(createAnAccountPage.getFullNameShip());
        createAnAccountPage.getShipCompany().sendKeys(createAnAccountPage.getCompanyShip());
        createAnAccountPage.getShipAddressLine1().sendKeys(createAnAccountPage.getAddressLine1Ship());

        Select countrySelectShip = new Select(createAnAccountPage.getCountrySelectorShip());
        countrySelectShip.selectByVisibleText("United States");
        String countrySelectedShip = createAnAccountPage.getCountrySelected();

        createAnAccountPage.getShipZip().sendKeys(createAnAccountPage.getZipCodeShip());
        createAnAccountPage.getShipPhone().sendKeys(createAnAccountPage.getPhoneShip());

        Select companyTypeSelect = new Select(createAnAccountPage.getCompanyTypeSelector());
        companyTypeSelect.selectByVisibleText("Entertainment");
        String companyType = createAnAccountPage.getCompanyTypeSelector().getText();

        Select companyCategorySelect = new Select(createAnAccountPage.getCompanyCategorySelector());
        companyCategorySelect.selectByVisibleText("Other");
        String companyCategory = createAnAccountPage.getCompanyCategorySelector().getText();

        createAnAccountPage.getCompanyNameField().sendKeys(createAnAccountPage.getCompanyNameProvided());

        Select companySizeSelect = new Select(createAnAccountPage.getCompanySizeSelector());
        companySizeSelect.selectByVisibleText("2-10");
        String companySize = createAnAccountPage.getCompanySizeSelector().getText();

        createAnAccountPage.getPasswordCreationField().sendKeys(createAnAccountPage.getPasswordProvided());
        Thread.sleep(1000);
        createAnAccountPage.clickCreateMyAccountButton();
        Thread.sleep(3000);

        String actualHeader = Driver.getDriver().findElement(By.xpath("//h1[@class='page-header']")).getText();
        String expectedHeader = "Account Dashboard";
        Assert.assertEquals(actualHeader, expectedHeader);

    }

}
