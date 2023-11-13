package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

@Data
public class InvalidSearchResultPage {

    public InvalidSearchResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='padded']")
    private WebElement pageHeader;

    @FindBy(xpath = "//div[@class='padded']//p")
    private  WebElement tryAgainMessage;

    @FindBy(id="search_again")
    private  WebElement tips;

    @FindBy(xpath = "//div[@class='grid-item grid-child']")
    private List<WebElement> suggestedCategories;
}
