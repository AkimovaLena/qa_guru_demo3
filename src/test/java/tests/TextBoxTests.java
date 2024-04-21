package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy="eager";
        Configuration.browserSize="1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTets() {
        open("/text-box");
        $("[id=userName]").setValue("Elena");
        $("[id=userEmail]").setValue("qagurubot@gmail.com");
        $("[id=currentAddress]").setValue("Some adders 1");
        $("[id=permanentAddress]").setValue("Some adders 2");
        $("[id=submit]").click();

        $("[id=output]").$("[id=name").shouldHave(text("Elena"));
        $("[id=output]").$("[id=email").shouldHave(text("qagurubot@gmail.com"));
        $("[id=output]").$("[id=currentAddress").shouldHave(text("Some adders 1"));
        $("[id=output]").$("[id=permanentAddress").shouldHave(text("Some adders 2"));



    }
}
