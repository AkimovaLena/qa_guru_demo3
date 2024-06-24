package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            tableResponsive = $(".table-responsive"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            selectState = $(byText("Select State")),
            selectCity = $(byText("Select City")),
            pictureInput = $("input#uploadPicture"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу")
    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public AutomationPracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setState(String value) {
        selectState.click();
        $(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setCity(String value) {
        selectCity.click();
        $(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage addPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public AutomationPracticeFormPage submit() {
        submitButton.click();
        return this;
    }

    public AutomationPracticeFormPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public AutomationPracticeFormPage errorFistName() {
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public AutomationPracticeFormPage errorLastName() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public AutomationPracticeFormPage errorGender() {
        genderWrapper.$("label").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public AutomationPracticeFormPage errorUserNumber() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

}
