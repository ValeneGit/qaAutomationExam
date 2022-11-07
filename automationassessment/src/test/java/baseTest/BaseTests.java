package baseTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddUsersPage;
import pages.WebTablesPage;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    public WebDriver driver;
    protected AddUsersPage addUsersPage;
    protected WebTablesPage webtables;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");

        webtables = new WebTablesPage(driver);
        addUsersPage = new AddUsersPage(driver);

    }

    //capture passed and failed screenshots after test run
    @AfterMethod
    public void captureScreenshots(ITestResult testResult) {

        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File directory = new File(System.getProperty("user.dir")
                    + "/resources/Screenshots/Failed Screenshots/");

            if(!directory.exists()){
                try {
                    directory.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            File destination = new File(directory.getPath() + "/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            File directory = new File(System.getProperty("user.dir")
                    + "/resources/Screenshots/Passed Screenshots/");

            if(!directory.exists()){
                try {
                    directory.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            File destination = new File(directory.getPath() + "/" + testResult.getName() + "_" + testResult.getStartMillis() + ".png");

            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @AfterMethod()
    public void tearDown() {
       driver.quit();
    }

}




