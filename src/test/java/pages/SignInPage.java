package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.Driver;

@Test
public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement logInEmailAddressInputField;

    @FindBy(id = "password")
    private WebElement logInPasswordInputField;

    public WebElement getLogInEmailAddressInputField() {return logInEmailAddressInputField;}
    public WebElement getLogInPasswordInputField() {return logInPasswordInputField;}
}
