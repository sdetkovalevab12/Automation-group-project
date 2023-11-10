package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver() {

        if (driver == null) {
            String browser = ConfigReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrom":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new UnsupportedOperationException(browser + " is not supported. Use chrome, edge, firefox or safari.");
            }
        }
    return driver;
    }


    public static void  quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
}

}
