package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.Driver;

@Test
public class CreateAnAccountPage {
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