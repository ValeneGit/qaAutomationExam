package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebTablesPage;

public class WhenLandingTests extends BaseTests {


    @Test
    //validate that you are on the User List Table
    public void WhenLandingThenTheWebTablesPageShouldBeAvailable() {
        Assert.assertTrue(webtables.UserListTable != null);
    }

}


