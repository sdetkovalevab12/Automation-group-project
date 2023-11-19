package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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


//Verification of the Page title on: main page/ subcategory page/ search page
    @Test
    public void searchTest_WP14()  {
        HomePage homePage= new HomePage();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("mainPageTitle")));
        String categoryName= homePage.getCategories().get(1).getText();
        SeleniumUtils.jsClick(homePage.getCategories().get(1));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(categoryName));
        new HomePage().searchUsingProperties();
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(ConfigReader.getProperty("searchTerm")));
    }

    //Correct search Verificaton (correct amout of results, each result contains search term)
    //Using ConfigReader
    @Test (groups = "smoke")
    public void searchTest_WP15(){

        SearchResultPage searchResultPage = new SearchResultPage();
        new HomePage().searchUsingProperties();
        Assert.assertEquals(searchResultPage.getSearchResults().size(), 60);
        SeleniumUtils.getElementsText(searchResultPage.getItemDescription()).forEach
                (s -> Assert.assertTrue(s.toLowerCase().contains(ConfigReader.getProperty("searchTerm"))));
    }

//Verifying each search result  contains  a search Key Word
//Using Data Provider
    @Test (groups = "smoke", dataProvider = "searhTerms")
    public void searchTest_usingFeedData(String searchTerm) {

        SearchResultPage searchResultPage = new SearchResultPage();
        new HomePage().searchUsingKeyWord(searchTerm);
        SeleniumUtils.getElementsText(searchResultPage.getItemDescription()).forEach
                (s -> Assert.assertTrue(s.toLowerCase().contains(searchTerm)));

    }

    //selecting a category, going to the subcategory page, verifying the page header matches
    @Test
    public void searchTest_WP16(){

        new HomePage().searchUsingProperties();
        SearchResultPage page =new SearchResultPage();
        List<WebElement> categories = page.getSuggestedCategories();
        List<String> categoryNames = SeleniumUtils.getElementsText(categories);
        categories.get(categories.size()-1).click();
        Assert.assertTrue(new SubCategoryPage().getCategoryHeader().getText()
               .contains(categoryNames.get(categoryNames.size()-1)));

    }

    //invalid input search brings user to the page with search tips and suggest a category
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

 //applying filters to search results.Price: Hight to Low
    @Test
    public void searchTest_WP18() {

        new HomePage().searchUsingProperties();
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.applyFilter("Price: High to Low");
        List<String> prices = SeleniumUtils.getElementsText(searchResultPage.getItemPrices());
        List<String> updatedList = new ArrayList<>();
        prices.forEach(s -> updatedList.add(s.replace("$", "").replace("/Each", "").replace(",", "")));
        List<Double> pricesInDouble = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++) {
            pricesInDouble.add(Double.parseDouble(updatedList.get(i)));
        }
        List<Double> copy = new ArrayList<>(pricesInDouble);
        Collections.sort(copy, Collections.reverseOrder());
        Assert.assertEquals(pricesInDouble, copy);

    }

    //Sorting search results by "Price: Low to High"
    @Test
    public void searchTest_WP33(){

        new HomePage().searchUsingProperties();
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.applyFilter("Price: Low to High");
        List<String> prices = SeleniumUtils.getElementsText(searchResultPage.getItemPrices());
        List<String> updatedList= new ArrayList<>();
        prices.removeIf(s ->s.contains("FROM"));
        prices.forEach(s -> updatedList.add(s.replace("$","")
                .replace("/Each","").replace(",","")));
        List<Double> pricesInDouble = new ArrayList<>();
        for (int i=0; i< prices.size(); i++) {
            pricesInDouble.add(Double.parseDouble(updatedList.get(i)));
        }
        List<Double> copy = new ArrayList<>(pricesInDouble);
        Collections.sort(copy);
        Assert.assertEquals(pricesInDouble, copy);

    }

    @DataProvider(name="searhTerms")
    public Object[][] feedData(){
        return new Object[][] {
                {"lid"},{"pan"},{"knife"},{"jam"}, {"ceramic"},
                {"apron"},{"glass"},{"mop"}
        };
    }
}