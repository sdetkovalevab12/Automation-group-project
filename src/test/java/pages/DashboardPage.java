package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import utils.Driver;

@Data
public class DashboardPage extends TestBase {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //1st column
    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[2]/div/text()[1]")
    private WebElement accountInfoFullName;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[2]/div/text()[2]")
    private WebElement accountInfoCompanyName;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[2]/div/text()[4]")
    private WebElement accountInfoEmail;

    //2nd column
    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[3]/div/text()[1]")
    private WebElement accountShippingFullName;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[3]/div/text()[2]")
    private WebElement accountShippingCompanyName;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[3]/div/text()[3]")
    private WebElement accountShippingStreetAddress;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[3]/div/text()[4]")
    private WebElement shippingCityStateZip;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[3]/div/text()[5]")
    private WebElement accountShippingCountry;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[3]/div/text()[8]")
    private WebElement accountShippingAddressType;

    //3rd column
    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[4]/div/text()[1]")
    private WebElement accountBillingFullName;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[4]/div/text()[2]")
    private WebElement accountBillingCompanyName;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[4]/div/text()[3]")
    private WebElement accountBillingStreetAddress;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[4]/div/text()[4]")
    private WebElement accountBillingCityStateZip;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[4]/div/text()[5]")
    private WebElement accountBillingCountry;

    @FindBy(xpath = "//div[@class='account__section-innerdashboard clearfix']/div[4]/div/text()[6]")
    private WebElement accountBillingPhoneNumber;

    //general
//    @FindBy(xpath = "//h1[@class='page-header']")
//    private WebElement pageHeader;



}
