package pages;

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

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "searchval")
    private WebElement searchBar;

    @FindBy (xpath="//div[@data-testid='nav-show-more-data-items']//a")
    private List<WebElement>  categories;

    public void search(){
        this.searchBar.sendKeys(ConfigReader.getProperty("searchTerm"), Keys.ENTER);
    }


}
