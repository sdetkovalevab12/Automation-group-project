package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import java.util.List;

@Data
public class SearchResultPage {
    public SearchResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(id="ProductBoxContainer")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//span[@data-testid='itemDescription']")
    private List<WebElement> itemDescription;

    @FindBy(xpath = "//p[@class='font-semibold h-12 text-xs leading-4 mb-0 max-h-full overflow-hidden sm:text-sm sm:leading-4 whitespace-pre-line']")
    private List<WebElement> suggestedCategories;

    @FindBy(id = "sort_options")
     private WebElement  filter;

    @FindBy(xpath = "//p[@data-testid='price']|//p[@class='price font-semibold text-2xl leading-none mb-0 relative text-red-500 z-5']")
    private List<WebElement> itemPrices;

    public void applyFilter(String dropDownOption){
        Select select = new Select(filter);
        select.selectByVisibleText(dropDownOption);
    }









}
