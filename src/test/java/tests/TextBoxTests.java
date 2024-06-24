package tests;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends BaseTest {

    @Test
    void fillFormTet() {

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

