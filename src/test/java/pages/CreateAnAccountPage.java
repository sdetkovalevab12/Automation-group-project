package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tests.AccountCreationPositive;
import tests.TestBase;
import utils.Driver;

@Data
public class CreateAnAccountPage extends TestBase {
    public CreateAnAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    Faker faker = new Faker();

    @FindBy(xpath = "//li[@class = 'list-none relative']//button[@type = 'button']")
    private WebElement signInAccountButton;

    @FindBy(xpath = "//a[@href = '/myaccount.html?goto=register']")
    private WebElement signUpButton;

    @FindBy(xpath = "//a[@href = '/myaccount/']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href = '/myaccount/?logout=Y']")
    private WebElement logOutButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "receive_specials")
    private WebElement receiveCouponsCheckBox;

    @FindBy(id = "billname")
    private WebElement nameField;

    @FindBy(id = "billaddr")
    private WebElement addressLine1;

    @FindBy(id = "billcountry")
    private WebElement countrySelector;

    @FindBy(id = "billzip")
    private WebElement zipField;

    @FindBy(id = "billphone")
    private WebElement phoneField;

    @FindBy(id = "same")
    private WebElement sameAsBillingCheckBox;

    @FindBy(id = "profileCompanyType")
    private WebElement companyTypeSelector;

    @FindBy(id = "profileCompanyCategory")
    private WebElement companyCategorySelector;

    @FindBy(id = "billcompany")
    private WebElement companyNameField;

    @FindBy(id = "billnum_employees")
    private WebElement companySizeSelector;

    @FindBy(id = "password")
    private WebElement passwordCreationField;

    @FindBy(id = "complete_registration")
    private WebElement createMyAccountButton;

    //Shipping Address
    @FindBy(id = "shipname")
            private WebElement shipName;
            String fullNameShip = faker.name().fullName();

    @FindBy(id = "shipcompany")
            private WebElement shipCompany;
            String companyShip = faker.company().name();

    @FindBy(id = "shipaddr")
            private WebElement shipAddressLine1;
            String addressLine1Ship = "1600 Amphitheatre Pkwy";

    @FindBy(id = "shipzip")
            private WebElement shipZip;
            String zipCodeShip = "94043";

    @FindBy(id = "shipphone")
            private WebElement shipPhone;
            String phoneShip = String.valueOf(faker.phoneNumber().subscriberNumber(10));

    @FindBy(id = "shipcountry")
            private WebElement countrySelectorShip;

    String nameProvided = faker.name().fullName();
    String emailProvided = faker.internet().emailAddress();
    String addressLine1Provided = "302 S Market St";
    String countrySelected = getCountrySelected();
    String zip = "95113";
    String phoneProvided = String.valueOf(faker.phoneNumber().subscriberNumber(10));
    String passwordProvided = faker.internet().password();
    String companyTypeSelected = getCompanyTypeSelected();
    String companyCategorySelected = getCompanyCategorySelected();
    String companyNameProvided = faker.company().name();




    public void clickSignInAccountButton() {
        signInAccountButton.click();
    }
    public void clickSignUpButton() {
        signUpButton.click();
    }
    public void clickSignInButton() {
        signInButton.click();
    }
    public void clickLogOutButton() {logOutButton.click();}
    public void clickReceiveCouponsCheckBox() {receiveCouponsCheckBox.click();}
    public void clickSameAsBillingCheckBox() {sameAsBillingCheckBox.click();}
    public void clickCreateMyAccountButton() {createMyAccountButton.click();}


}