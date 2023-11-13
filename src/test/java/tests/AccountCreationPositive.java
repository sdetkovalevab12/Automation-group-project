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

public class AccountCreationPositive extends SignUpOption {
    CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
    Faker faker = new Faker();
    int a = 0;
    public AccountCreationPositive() {
    }

    @Test
    public void fillOutValidData () throws InterruptedException, IOException {
        SignUpOption signUpOptionPage = new SignUpOption();
        signUpOptionPage.goToSignUp();

        //filling out the form with appropriate data and storing the information for the future use
        String emailProvided = faker.internet().emailAddress();
        createAnAccountPage.getEmailField().sendKeys(emailProvided);

        if (!createAnAccountPage.getReceiveCouponsCheckBox().isSelected());
        {
            createAnAccountPage.clickReceiveCouponsCheckBox();
        }

        String nameProvided = faker.name().fullName();
        createAnAccountPage.getNameField().sendKeys(nameProvided);

        //Mockaroo Addresses data usage
        String addressData = new String(Files.readAllBytes(Paths.get("./MOCK_DATA.json")));
        JSONArray jsonArray = new JSONArray(addressData);
        for (int i = a; i < jsonArray.length(); i++) {
            String str = jsonArray.get(i).toString();
            JSONObject object1 = new JSONObject(i);

            String addressLine1Provided = object1.getString("addressLine1");
            String country = object1.getString("Country");
            String zip = object1.getString("zipCode");

            createAnAccountPage.getAddressLine1().sendKeys(addressLine1Provided);

            Select countrySelect = new Select(createAnAccountPage.getCountrySelector());
            countrySelect.selectByVisibleText(country);

            createAnAccountPage.getZipField().sendKeys(zip);
            a++;
        }
        String phoneProvided = String.valueOf(faker.phoneNumber().subscriberNumber(10));
        createAnAccountPage.getPhoneField().sendKeys(phoneProvided);

        if (!createAnAccountPage.getSameAsBillingCheckBox().isSelected()) ;
        {
            createAnAccountPage.clickSameAsBillingCheckBox();
        }

        Select companyTypeSelect = new Select(createAnAccountPage.getCompanyTypeSelector());
        companyTypeSelect.selectByVisibleText("Entertainment");
        String companyType = createAnAccountPage.getCompanyTypeSelector().getText();

        String companyNameProvided = faker.company().name();
        createAnAccountPage.getPhoneField().sendKeys(companyNameProvided);

        Select companySizeSelect = new Select(createAnAccountPage.getCompanySizeSelector());
        companySizeSelect.selectByVisibleText("2-10");
        String companySize = createAnAccountPage.getCompanySizeSelector().getText();

        String passwordProvided = faker.internet().password();
        createAnAccountPage.getPasswordCreationField().sendKeys(passwordProvided);

        createAnAccountPage.clickCreateMyAccountButton();
//
//        String AccountDashboardTitle = Driver.getDriver().getTitle();
//        String expectedAccountDashboardTitle = "Restaurant Supplies, Restaurant Supply at WebstaurantStore";
//        Assert.assertEquals(AccountDashboardTitle, expectedAccountDashboardTitle);

    }



}
