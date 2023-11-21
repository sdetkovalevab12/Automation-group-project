package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();


    private Driver(){}


    public static synchronized WebDriver getDriver(){

        if(drivers.get() == null){

            String browser = System.getProperty("browser");


            if(browser == null){
                browser = ConfigReader.getProperty("browser").toLowerCase();
            }


            switch (browser){
                case "chrome":
                    drivers.set(new ChromeDriver());
                    break;
                case "chromeheadless":
                    drivers.set(new ChromeDriver(new ChromeOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                    break;
                case "edge":
                    drivers.set(new EdgeDriver());
                    break;
                case "edgeheadless":
                    drivers.set(new EdgeDriver(new EdgeOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                    break;
                case "firefox":
                    drivers.set(new FirefoxDriver());
                    break;
                case "firefoxheadless":
                    drivers.set(new FirefoxDriver(new FirefoxOptions().addArguments("--headless").addArguments("window-size=1920x1080")));
                    break;
                case "safari":
                    drivers.set(new SafariDriver());
                    break;
                default:
                    throw new UnsupportedOperationException(browser + " is not supported. Use chrome, edge, firefox or safari.");

            }
        }
        return drivers.get();
    }

    public static synchronized void quitDriver(){
        if(drivers.get() != null){
            drivers.get().quit();
            drivers.remove();
        }

    }

}
