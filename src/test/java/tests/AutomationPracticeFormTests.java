package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy="eager";
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTets() {
        open("/automation-practice-form");
        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Akimova");
        $("#userEmail").setValue("qagurubot@gmail.com");
        $(byText("Male")).click();

        $("[id=permanentAddress]").setValue("Some adders 2");
       

        $("[id=output]").$("[id=name").shouldHave(text("Elena"));
        $("[id=output]").$("[id=email").shouldHave(text("qagurubot@gmail.com"));
        $("[id=output]").$("[id=currentAddress").shouldHave(text("Some adders 1"));
        $("[id=output]").$("[id=permanentAddress").shouldHave(text("Some adders 2"));



    }
}
