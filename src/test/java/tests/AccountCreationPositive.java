package tests;

import com.github.javafaker.Faker;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import utils.Driver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AccountCreationPositive extends TestBase {

    Faker faker = new Faker();

    @Test
    public void fillOutValidData () throws InterruptedException {
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
        createAnAccountPage.clickSignInAccountButton();
        createAnAccountPage.clickSignUpButton();

        //filling out the form with appropriate data and storing the information for the future use
        String emailProvided = faker.internet().emailAddress();
        createAnAccountPage.getEmailField().sendKeys(emailProvided);

        if (createAnAccountPage.getReceiveCouponsCheckBox().isSelected()){
            createAnAccountPage.clickReceiveCouponsCheckBox();
        }

        String nameProvided = faker.name().fullName();
        createAnAccountPage.getNameField().sendKeys(nameProvided);

        //Mockaroo Addresses data usage
//        String addressData = new String(Files.readAllBytes(Paths.get("./MOCK_DATA.json")));
//        JSONArray jsonArray = new JSONArray(addressData);
//        for (int i = 0; i < jsonArray.length(); i++) {
//            String str = jsonArray.get(i).toString();
//            JSONObject object1 = new JSONObject(i);
//
//            String addressLine1Provided = object1.getString("addressLine1");
//            String country = object1.getString("Country");
//            String zip = object1.getString("zipCode");
//
//            createAnAccountPage.getAddressLine1().sendKeys(addressLine1Provided);
//
//            Select countrySelect = new Select(createAnAccountPage.getCountrySelector());
//            countrySelect.selectByVisibleText(country);
//
//            createAnAccountPage.getZipField().sendKeys(zip);
//
//        }

        String addressLine1Provided = "302 S Market St";
        createAnAccountPage.getAddressLine1().sendKeys(addressLine1Provided);

        Select countrySelect = new Select(createAnAccountPage.getCountrySelector());
        countrySelect.selectByVisibleText("United States");

        String zip = "95113";
        createAnAccountPage.getZipField().sendKeys(zip);

        String phoneProvided = String.valueOf(faker.phoneNumber().subscriberNumber(10));
        createAnAccountPage.getPhoneField().sendKeys(phoneProvided);

        if (!(createAnAccountPage.getSameAsBillingCheckBox().isSelected()))
        {
            createAnAccountPage.clickSameAsBillingCheckBox();
        }

        Select companyTypeSelect = new Select(createAnAccountPage.getCompanyTypeSelector());
        companyTypeSelect.selectByVisibleText("Entertainment");
        String companyType = createAnAccountPage.getCompanyTypeSelector().getText();

        Select companyCategorySelect = new Select(createAnAccountPage.getCompanyCategorySelector());
        companyCategorySelect.selectByVisibleText("Other");
        String companyCategory = createAnAccountPage.getCompanyCategorySelector().getText();

        String companyNameProvided = faker.company().name();
        createAnAccountPage.getCompanyNameField().sendKeys(companyNameProvided);
        System.out.println(companyNameProvided);

        Select companySizeSelect = new Select(createAnAccountPage.getCompanySizeSelector());
        companySizeSelect.selectByVisibleText("2-10");
        String companySize = createAnAccountPage.getCompanySizeSelector().getText();

        String passwordProvided = faker.internet().password();
        createAnAccountPage.getPasswordCreationField().sendKeys(passwordProvided);

        createAnAccountPage.clickCreateMyAccountButton();
        Thread.sleep(3000);

        String AccountDashboardTitle = Driver.getDriver().getTitle();
        String expectedAccountDashboardTitle = "Restaurant Supplies, Restaurant Supply at WebstaurantStore";
        Assert.assertEquals(AccountDashboardTitle, expectedAccountDashboardTitle);

    }



}
