package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By username = By.id("txt-username");

    private By password = By.id("txt-password");

    private By loginButton = By.cssSelector("#login button");


    //constructor
    public LoginPage(WebDriver driver) {this.driver = driver;}



    //input username method
    public void setUsername(String inputName) { driver.findElement(username).sendKeys(inputName);}

    //input password method
    public void setPassword(String inputPassword) { driver.findElement(password).sendKeys(inputPassword);}

    //clicking on the login button
    public MakeAppointmentPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new MakeAppointmentPage(driver);
    }

}
