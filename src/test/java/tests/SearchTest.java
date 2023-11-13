package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InvalidSearchResultPage;
import pages.SearchResultPage;
import pages.SubCategoryPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTest extends TestBase{



    @Test
    public void searchTest_WP14()  {
        HomePage homePage= new HomePage();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("mainPageTitle")));
        String categoryName= homePage.getCategories().get(1).getText();
        SeleniumUtils.jsClick(homePage.getCategories().get(1));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(categoryName));
       // homePage.getSearchBar().sendKeys(ConfigReader.getProperty("searchTerm"), Keys.ENTER);
        new HomePage().search();
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(ConfigReader.getProperty("searchTerm")));
    }

    @Test
    public void searchTest_WP15(){

        SearchResultPage searchResultPage = new SearchResultPage();
        //new HomePage().getSearchBar().sendKeys(ConfigReader.getProperty("searchTerm"), Keys.ENTER);
        new HomePage().search();
        Assert.assertEquals(searchResultPage.getSearchResults().size(), 60);
        SeleniumUtils.getElementsText(searchResultPage.getItemDescription()).forEach
                (s -> Assert.assertTrue(s.toLowerCase().contains(ConfigReader.getProperty("searchTerm"))));
    }

    @Test
    public void searchTest_WP16(){

       // new HomePage().getSearchBar().sendKeys(ConfigReader.getProperty("searchTerm"), Keys.ENTER);
        new HomePage().search();
        SearchResultPage page =new SearchResultPage();
        List<WebElement> categories = page.getSuggestedCategories();
        List<String> categoryNames = SeleniumUtils.getElementsText(categories);
        categories.get(categories.size()-1).click();
        Assert.assertTrue(new SubCategoryPage().getCategoryHeader().getText()
               .contains(categoryNames.get(categoryNames.size()-1)));

    }

    @Test
    public void searchTest_WP17(){

        InvalidSearchResultPage invalidSearchResultPage= new InvalidSearchResultPage();
        String invalidSearch = SeleniumUtils.generateRandomSequenceOfChar(10).toLowerCase();
        new HomePage().getSearchBar().sendKeys(invalidSearch, Keys.ENTER);
        String expected="Sorry, we couldn't find any matches for \""+invalidSearch+"\"\nTry entering a different search term.";
        Assert.assertEquals(invalidSearchResultPage.getPageHeader().getText(), expected);
        Assert.assertTrue(invalidSearchResultPage.getTips().isDisplayed());
        Assert.assertEquals(invalidSearchResultPage.getSuggestedCategories().size(), 12);

    }


    @Test
    public void searchTest_WP18(){

       new HomePage().search();
       SearchResultPage searchResultPage= new SearchResultPage();
       searchResultPage.applyFilter("Price: High to Low");
       List<String> prices = SeleniumUtils.getElementsText(searchResultPage.getItemPrices());
       List<String> updatedList= new ArrayList<>();
       prices.forEach(s -> updatedList.add(s.replace("$","").replace("/Each","").replace(",","")));
       List<Double> pricesInDouble = new ArrayList<>();
        for (int i=0; i< prices.size(); i++) {
            pricesInDouble.add(Double.parseDouble(updatedList.get(i)));
        }
       List<Double> copy=new ArrayList<>(pricesInDouble);
       Collections.sort(copy, Collections.reverseOrder());
       Assert.assertEquals(pricesInDouble, copy);
    }
}
