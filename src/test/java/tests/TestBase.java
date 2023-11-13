package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentTest logger;


    @BeforeMethod(alwaysRun = true)
    public void setUpTest(Method method){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger = extentReports.createTest(method.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void cleanUp(ITestResult testResult){
        if(testResult.getStatus()==ITestResult.SUCCESS) {
            logger.pass("Test Passed."+testResult.getName());
        }else if (testResult.getStatus()==ITestResult.SKIP) {
            logger.skip("Test Skipped." + testResult.getName());
        }else if(testResult.getStatus()==ITestResult.FAILURE){
            logger.fail("Test Failed."+testResult.getName());
            logger.fail(testResult.getThrowable());
            String path = SeleniumUtils.getScreenshot("failedTest");
            logger.addScreenCaptureFromPath(path);
        }
        //Driver.quitDriver();
    }


@BeforeSuite(alwaysRun = true)
   public void setUpReport(){
       extentReports = new ExtentReports();
       String path =System.getProperty("user.dir")+"/target/extentReports/report.html";
       htmlReporter= new ExtentSparkReporter(path);
       extentReports.attachReporter(htmlReporter);
       extentReports.setSystemInfo("Project", "Webstaurant Store");
       extentReports.setSystemInfo("SDETs ", "Elizaveta K, Kamila D, Mihail V, Sami B, Slava Q");
       extentReports.setSystemInfo("OS ", System.getProperty("os.name"));
       extentReports.setSystemInfo("Browser ", ConfigReader.getProperty("browser"));
       extentReports.setSystemInfo("URL", ConfigReader.getProperty("url"));
   }

   @AfterSuite(alwaysRun = true)
    public static void tearDownReport(){
        extentReports.flush();
   }

}
