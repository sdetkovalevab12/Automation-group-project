package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
@Data
public class ReturnAndOrders {

 public ReturnAndOrders(){
     PageFactory.initElements(Driver.getDriver(),this);
 }

 @FindBy(xpath="(//span[@class='leading-none'])[2]")
    private WebElement returnOrdder;

 @FindBy(id ="the_login_button")
    private WebElement loginBtn;

 @FindBy(id = "email")
    private WebElement username;

 @FindBy(id = "password")
    private WebElement password;

 @FindBy(xpath = "//a[@href='/myaccount/orders/' and @class='account-nav__item' and text()='View Orders']")
    private WebElement viewOrders;

 @FindBy(xpath = "//strong[contains(text(), 'No orders found')]")
    private WebElement noOrderText;

 @FindBy(xpath = "//a[@href='/myaccount/returns/']")
    private WebElement viewReturns;

 @FindBy(xpath = "//p[@class='alert' and contains(text(), 'No returns have been found.')]")
    private WebElement noReturns;

 @FindBy(xpath = "//a[@class='account-nav__heading' and @href='/myaccount/ordernotifications/']")
    private WebElement orderNotification;

 @FindBy(id ="emailUpdates")
    private WebElement checkBoxNotification;

 @FindBy(xpath = "//a[@class='account-nav__heading' and @href='/myaccount/shipping/']")
    private WebElement verifyingShipingAdress;

 @FindBy(xpath = "//i[@class='icon-select-empty' and @role='checkbox']")
    private WebElement checkBoxShiping;
}

