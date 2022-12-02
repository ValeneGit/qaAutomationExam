package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage {

    private WebDriver driver;

    private By AppointmentSection = By.id("appointment");

    private By goToHomePageBtn = By.cssSelector("#summary > div > div > div:nth-child(7) > p > a");

    public AppointmentConfirmationPage (WebDriver driver) {this.driver = driver;}

    public String appointmentSection (){
        return driver.findElement(AppointmentSection).getText();
    }

    public MakeAppointmentPage clickOnGoToHomePageBtn(){
        driver.findElement(goToHomePageBtn).click();
        return new MakeAppointmentPage(driver);
    }
}
