package tests;


import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import testdata.TestData;

@Tag("automation_practice_form")
public class AutomationPracticeFormWithPageObjectsTests extends BaseTest {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    TestData testData = new TestData();

    @Test

    @Owner("EAkimova")
    @Story("Регистрация")
    @DisplayName("Заполнение формы регистрации")
    void fullFormTest() {

        automationPracticeFormPage.openPage()
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

        automationPracticeFormPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.mobile)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.file)
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.state + " " + testData.city);

    }

    @Test
    @Owner("EAkimova")
    @Story("Регистрация")
    @DisplayName("Заполнение только обязательных полей в форме регистрации")
    void minFillFormTest() {
        automationPracticeFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.mobile)
                .submit();

        automationPracticeFormPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.mobile);
    }

    @Test
    @Owner("EAkimova")
    @Story("Регистрация")
    @DisplayName("Негативный кейс")
    void incorrectFillFormTest() {
        automationPracticeFormPage.openPage()
                .submit();

        automationPracticeFormPage.errorFistName()
                .errorLastName()
                .errorGender()
                .errorUserNumber();

    }
}
