package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SubCategoryPage {
    public SubCategoryPage(){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath="//h1[@class='page-header']")
    private WebElement categoryHeader;

}
