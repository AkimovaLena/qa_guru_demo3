package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends BaseTest {

    @Test
    @Tag("text_box")
    void fillFormTet() {

        open("/text-box");
        executeJavaScript("$('#Ad.Plus-970x250-2').remove()");
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

