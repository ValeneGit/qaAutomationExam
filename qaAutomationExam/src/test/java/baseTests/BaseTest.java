package baseTests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    protected HomePage homePage;

    String BASEURL = "https://katalon-demo-cura.herokuapp.com/";

    @BeforeSuite
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        homePage = new HomePage(driver);

    }

    //capture pass and fail screenshots
    @AfterMethod
    public void captureScreenshots(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()){

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/resources/screenshots/failResults/" +testResult.getName()+"_FAIL" +testResult.getStartMillis() +".png");

            try {
                org.openqa.selenium.io.FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/resources/screenshots/passResults/" +testResult.getName()+"_PASS" +testResult.getStartMillis() +".png");

            try {
                FileHandler.copy(source,destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


    //close browser and end session
    @AfterSuite
    public void tearDown() {driver.quit();}

}
