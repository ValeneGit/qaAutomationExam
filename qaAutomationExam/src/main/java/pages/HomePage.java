package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By makeAppointmentButton = By.id("btn-make-appointment");

    public HomePage(WebDriver driver) {this.driver = driver;}

    public LoginPage clickOnMakeAppointmentButton(){
        driver.findElement(makeAppointmentButton).click();
        return new LoginPage(driver);
    }

}
