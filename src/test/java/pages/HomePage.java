package pages;

import freemarker.template.Template;
import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

@Data
public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "searchval")
    private WebElement searchBar;


    @FindBy(xpath = "//div[@data-testid='nav-show-more-data-items']//a")
    private List<WebElement> categories;

    @FindBy(xpath = "//li[@class = 'list-none relative']//button[@type = 'button']")
    private WebElement signInAccountButton;

    @FindBy(xpath="//a[@href='https://www.instagram.com/WebstaurantStore/']")
    private WebElement instagramLink;

    @FindBy(xpath="//a[@href='https://www.youtube.com/user/WebstaurantStore']")
    private WebElement youTubeLink;

    @FindBy(xpath="//a[@href='https://www.facebook.com/WebstaurantStore']")
    private WebElement FaceBookLink;

    @FindBy(xpath="//a[@href='https://www.tiktok.com/@webstaurantstore']")
    private WebElement TikTokLink;

    @FindBy(xpath="//a[@href='https://www.pinterest.com/webstaurant/']")
    private WebElement pinterestLink;

    public void searchUsingProperties() {
        this.searchBar.sendKeys(ConfigReader.getProperty("searchTerm"), Keys.ENTER);
    }


    public void searchUsingKeyWord(String key) {
            searchBar.sendKeys(key);
    }


}