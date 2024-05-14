package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests extends BaseTest{



    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Akimova");
        $("#userEmail").setValue("qagurubot@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day.react-datepicker__day--017").click();
        $("#subjectsInput").setValue("A");
        $(byText("Arts")).click();
        $(byText("Sports")).click();
        $("#currentAddress").setValue("Some current Address");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("input#uploadPicture").uploadFromClasspath("test.png");
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Elena Akimova"));
        $(".table-responsive").shouldHave(text("qagurubot@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("17 April,2024"));
        $(".table-responsive").shouldHave(text("Arts"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test.png"));
        $(".table-responsive").shouldHave(text("Some current Address"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));



    }
}
