package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.Driver;

@Test
public class CreateAnAccountPage extends TestBase {
    public CreateAnAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    @FindBy(id = "billcompany")
    private WebElement companyNameField;

    @FindBy(id = "billnum_employees")
    private WebElement companySizeSelector;

    @FindBy(id = "password")
    private WebElement passwordCreationField;

    @FindBy(id = "complete_registration")
    private WebElement createMyAccountButton;

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


}