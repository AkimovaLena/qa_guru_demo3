package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;


public class AutomationPracticeFormWithPageObjectsTests extends BaseTest{

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    @Test
    void fullFormTest() {
        automationPracticeFormPage.openPage()
                .setFirstName("Elena")
                .setLastName("Akimova")
                .setEmail("qagurubot@gmail.com")
                .setGender("Male")
                .setNumber("1234567890")
                .setDateOfBirth("01","May","1995")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .setCurrentAddress("Some current Address")
                .setState("NCR")
                .setCity("Delhi")
                .addPicture("test.png")
                .submit();

        automationPracticeFormPage.checkResult("Student Name","Elena Akimova")
                .checkResult("Student Email","qagurubot@gmail.com")
                .checkResult("Gender","Male")
                .checkResult("Mobile","1234567890")
                .checkResult("Date of Birth","01 May,1995")
                .checkResult("Subjects","Arts")
                .checkResult("Hobbies","Sports")
                .checkResult("Picture","test.png")
                .checkResult("Address","Some current Address")
                .checkResult("State and City","NCR Delhi");

    }

    @Test
    void minFillFormTest(){
        automationPracticeFormPage.openPage()
                .setFirstName("Elena")
                .setLastName("Akimova")
                .setGender("Male")
                .setNumber("1234567890")
                .submit();

        automationPracticeFormPage.checkResult("Student Name","Elena Akimova")
                .checkResult("Gender","Male")
                .checkResult("Mobile","1234567890");
    }

    @Test
    void incorrectFillFormTest(){
        automationPracticeFormPage.openPage()
                .submit();

        automationPracticeFormPage.errorFistName()
                .errorLastName()
                .errorGender()
                .errorUserNumber();

    }
}
