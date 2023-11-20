package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class HelpCenter {
    public HelpCenter(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[@data-testid='alert-banner-left-container'][1]")
    private WebElement helpCenterButn;

    @FindBy(id ="chat-button")
    private WebElement chatNowButn;

    @FindBy(id = "issue")
    private WebElement selectIssues;

    @FindBy(xpath = "(//a[@href='/ask.html'])[4]")
    private WebElement helpCenterBottomPage;

}
