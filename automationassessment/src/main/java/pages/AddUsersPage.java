package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddUsersPage {

    private WebDriver driver;

    //declare variables
    private By Firstname = By.name("FirstName");
    private By Lastname = By.name("LastName");
    private By Username = By.name("UserName");
    private By Password = By.name("Password");
    private By Customer = By.name("optionsRadios");
    private By Role = By.name("RoleId");
    private By Email = By.name("Email");
    private By Cellphone = By.name("Mobilephone");

    private By SaveButton = By.cssSelector("btn btn-success");

    private By CloseButton = By.className("btn-danger");


    //constructor
    public AddUsersPage(WebDriver driver) {
        this.driver = driver;
    }

    //input data methods
    public void setFirstname(String inputFirstname) {
        driver.findElement(Firstname).sendKeys(inputFirstname);
    }

    public void setLastname(String inputLastname) {
        driver.findElement(Lastname).sendKeys(inputLastname);
    }

    public void setUsername(String inputUsername) {
        driver.findElement(Username).sendKeys(inputUsername);
    }

    public void setPassword(String inputPassword) {
        driver.findElement(Password).sendKeys(inputPassword);
    }

    public void setCustomer(String inputCustomer) {
        driver.findElement(Customer).sendKeys(inputCustomer);
    }

    public void setRole(String inputRole) {
        Select roleSelect = new Select(driver.findElement(Role));
        roleSelect.selectByValue(inputRole);
    }

    public void setEmail(String inputEmail) {
        driver.findElement(Email).sendKeys(inputEmail);
    }

    public void setCellphone(String inputCellphone) {
        driver.findElement(Cellphone).sendKeys(inputCellphone);
    }


    //selecting the customer button
    public void selectCustomer() {
        driver.findElement(Customer).click();
    }

    //clicking the save button
    public void selectSave() {
        driver.findElement(By.className("btn-success")).sendKeys(Keys.ENTER);
    }

    //clicking the close button
    public void selectClose() {
        driver.findElement(CloseButton).click();
    }


    public void clear() {
        driver.findElement(Firstname).clear();
        driver.findElement(Lastname).clear();
        driver.findElement(Username).clear();
        driver.findElement(Password).clear();
        driver.findElement(Email).clear();
        driver.findElement(Cellphone).clear();
    }

}







