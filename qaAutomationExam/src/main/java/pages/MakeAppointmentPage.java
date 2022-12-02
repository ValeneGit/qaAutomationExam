package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeAppointmentPage {

    private WebDriver driver;

    //declare variables
    private By facilityDropDownList = By.name("facility");
    private By hospitalReadmissionTickBox = By.id("chk_hospotal_readmission");
    private By option1RadioButton = By.cssSelector("input[type='radio'][value='Medicare']");
    private By option2RadioButton = By.cssSelector("input[type='radio'][value='MedicalAid']");
    private By option3RadioButton = By.cssSelector("input[type='radio'][value='None']");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookAppointmentButton = By.id("btn-book-appointment");
    private By makeAppointmentButton = By.id("btn-make-appointment");


    public MakeAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By AppointmentSection = By.id("appointment");

    public boolean hasLoggedIn() {
        try {
            return driver.findElement(AppointmentSection) != null;
        } catch (Exception ex) {
            return false;
        }
    }

    public void setHospitalReadmissionTickBox(String readmit) {

        if(readmit == "Yes") {
            driver.findElement(hospitalReadmissionTickBox).click();
        }
    }
    public void setVisitDate(String datePicker) {
        WebElement visitDatePicker = driver.findElement(visitDate);
        visitDatePicker.sendKeys(datePicker);
    }
    public void setComment(String commentText) {
        WebElement commentTextBox = driver.findElement(comment);
        commentTextBox.clear();
        commentTextBox.sendKeys(commentText);
    }
    public void clickOnHealthCareProgram(String program) {
        switch(program){
            case "Medicare":
                driver.findElement(option1RadioButton).click();
                break;
            case "MedicalAid":
                driver.findElement(option2RadioButton).click();
                break;
            default:
                driver.findElement(option3RadioButton).click();
                break;
        }

    }

    public void setFacility(String facility) {
        driver.findElement(facilityDropDownList).sendKeys(facility);
    }

    public HomePage clickOnBookAppointmentButton() {
        driver.findElement(makeAppointmentButton).click();
        return new HomePage(driver);
    }

    public void clickOnBookAppointmentButtonVoid() {
        driver.findElement(bookAppointmentButton).click();
    }

    public void clickOnMakeAppointmentButton() {
        driver.findElement(makeAppointmentButton).click();
    }
}
