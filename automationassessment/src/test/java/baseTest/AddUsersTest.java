package baseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.UserDataPage;

import java.util.ArrayList;
import java.util.List;

public class AddUsersTest extends BaseTests {

    @Test()
    public void AddUsersTest() {

        //add user functionality
        webtables.clickAddUserButton();

        Object[] v = UserListTableData();

        for (Object dat : v) {
            UserDataPage user = (UserDataPage) dat;

            addUsersPage.setFirstname(user.Firstname);
            addUsersPage.setLastname(user.Lastname);
            addUsersPage.setUsername(user.Username);
            addUsersPage.setPassword(user.Password);
            addUsersPage.setCustomer(user.Customer);
            addUsersPage.setRole(user.Role);
            addUsersPage.setEmail(user.Email);
            addUsersPage.setCellphone(user.Cellphone);

            addUsersPage.selectSave();
            if (dat != v[v.length - 1]) {
                webtables.clickAddUserButton();
                addUsersPage.clear();
            }

        }
    }


    @DataProvider
    public Object[] UserListTableData() {
        Object[][] data = new Object[2][7];


        List<UserDataPage> users = new ArrayList();

        UserDataPage user1 = new UserDataPage("FName1", "LName1", "User1", "Pass1", "Company AAA", "2", "admin@mail.com", "082555");
        UserDataPage user2 = new UserDataPage("FName2", "LName2", "User2", "Pass2", "Company BBB", "1", "customer@mail.com", "083444");

        users.add(user1);
        users.add(user2);

        return users.toArray();

    }

}


