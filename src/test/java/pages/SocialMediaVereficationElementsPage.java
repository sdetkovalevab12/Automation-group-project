package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SocialMediaVereficationElementsPage {

    public SocialMediaVereficationElementsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='_aagx']")
    private WebElement instagramLogo;

    @FindBy(xpath = "(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]")
    private WebElement youTubeLogo;

    @FindBy(xpath ="//a[@aria-label='Facebook']")
    private WebElement faceBookLogo;

    @FindBy(xpath = "//div[@class='Jea KS5 Zr3 hs0 zI7 iyn Hsu']")
    private WebElement pinterestLogo;

    @FindBy(xpath = "//div[@aria-label='Close']//i")
    private WebElement fbAlert;

    @FindBy(xpath = "//a[@data-e2e='tiktok-logo']")
    private WebElement tikTokLogo;


}
