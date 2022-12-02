package baseTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentConfirmationPage;
import pages.LoginPage;
import pages.MakeAppointmentPage;

public class MakeAppointmentTest extends BaseTest {

    @Test(priority = 1, dataProvider = "LoginData")
    public void loginSuccessfulTest(String username, String password, boolean Success){

        //login functionality
        LoginPage loginPage = homePage.clickOnMakeAppointmentButton();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        MakeAppointmentPage getMakeAppointmentMessage = loginPage.clickLoginButton();
        Assert.assertEquals(Success, getMakeAppointmentMessage.hasLoggedIn());
    }

    @Test(priority = 2, dataProvider = "BookingDetails")
    public void bookAppointmentTest(String facility, String readmission, String program, String date, String comment) {

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.setFacility(facility);
        makeAppointmentPage.setHospitalReadmissionTickBox(readmission);
        makeAppointmentPage.clickOnHealthCareProgram(program);
        makeAppointmentPage.setVisitDate(date);
        makeAppointmentPage.setComment(comment);
        makeAppointmentPage.clickOnBookAppointmentButtonVoid();

        AppointmentConfirmationPage confirm = new AppointmentConfirmationPage(driver);
        Assert.assertTrue(confirm != null);
        confirm.clickOnGoToHomePageBtn();

    }

    @DataProvider()
    public Object[][] BookingDetails() {
        Object[][] data = new Object[3][5];
        data[0][0] = "Tokyo CURA Healthcare Center"; data[0][1] = "Yes"; data[0][2] = "Medicare"; data[0][3] = "01/11/2022"; data[0][4] = "Book First Appointment";
        data[1][0] = "Hongkong CURA Healthcare Center"; data[1][1] = "Yes"; data[1][2] = "Medicaid"; data[1][3] = "02/11/2022"; data[1][4] = "Book Second Appointment";
        data[2][0] = "Seoul CURA Healthcare Center"; data[2][1] = "Yes"; data[2][2] = "None"; data[2][3] = "03/11/2022"; data[2][4] = "Book Third Appointment";
        return data;

    }

    @DataProvider()
    public Object[][] LoginData(){
        Object[][] data = new Object[2][3];
        data[0][0] = "John Doe2"; data[0][1] = "ThisIsNotAPassword2"; data[0][2] = false; //validate incorrect credentials
        data[1][0] = "John Doe"; data[1][1] = "ThisIsNotAPassword"; data[1][2] = true; //validate correct credentials

        return data;

    }
}
