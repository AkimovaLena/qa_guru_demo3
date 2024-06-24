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

    @Step("Вводим FirstName")
    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим LastName")
    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вводим Email")
    public AutomationPracticeFormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбираем Gender")
    public AutomationPracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Вводим MobileNumber")
    public AutomationPracticeFormPage setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Выбираем DateOfBirth")
    public AutomationPracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Добавляем Subjects")
    public AutomationPracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбираем Hobbies")
    public AutomationPracticeFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Вводим CurrentAddress")
    public AutomationPracticeFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Выбираем State")
    public AutomationPracticeFormPage setState(String value) {
        selectState.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Выбираем City")
    public AutomationPracticeFormPage setCity(String value) {
        selectCity.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Загружаем Picture")
    public AutomationPracticeFormPage addPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;
    }

    @Step("Нажимаем submit")
    public AutomationPracticeFormPage submit() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем сохранение в форме регистрации поля {key}")
    public AutomationPracticeFormPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверяем что поле FistName подсвечено красным ")
    public AutomationPracticeFormPage errorFistName() {
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    @Step("Проверяем что поле LastName подсвечено красным ")
    public AutomationPracticeFormPage errorLastName() {
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    @Step("Проверяем что поле Gender подсвечено красным ")
    public AutomationPracticeFormPage errorGender() {
        genderWrapper.$("label").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    @Step("Проверяем что поле Number подсвечено красным ")
    public AutomationPracticeFormPage errorUserNumber() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

}
