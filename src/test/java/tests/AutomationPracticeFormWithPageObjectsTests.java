package tests;


import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import testData.TestData;




public class   AutomationPracticeFormWithPageObjectsTests extends BaseTest{

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    TestData testData = new TestData();

    @Test
    void fullFormTest() {


        AutomationPracticeFormPage submit = automationPracticeFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.mobile)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setCurrentAddress(testData.streetAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .addPicture(testData.file)
                .submit();

        automationPracticeFormPage.checkResult("Student Name",testData.firstName+" "+testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.mobile)
                .checkResult("Date of Birth",testData.day+" "+testData.month+","+testData.year)
                .checkResult("Subjects",testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture",testData.file)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City",testData.state + " " + testData.city);

    }

    @Test
    void minFillFormTest(){
        automationPracticeFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.mobile)
                .submit();

        automationPracticeFormPage.checkResult("Student Name",testData.firstName+" "+testData.lastName)
                .checkResult("Gender",testData.gender)
                .checkResult("Mobile",testData.mobile);
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
