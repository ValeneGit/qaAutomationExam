package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage {

    private WebDriver driver;

    private By AddUserButton = By.className("btn-link");

    private By SaveButton = By.name("btn btn-success");

    private By CloseButton = By.className("btn btn-danger");

    public By UserListTable = By.tagName("table");

    public void setUserListTable(String inputUserListTable) {driver.findElement(UserListTable).sendKeys(inputUserListTable);}

    //validate that you are on the pages.User List Table
    public void selectUserListTable(){
        driver.findElement(UserListTable);
    }

    public WebTablesPage (WebDriver driver){
        this.driver = driver;

    }
    public WebTablesPage clickAddUserButton(){
        driver.findElement(AddUserButton).click();
        return new WebTablesPage(driver);
    }

}
