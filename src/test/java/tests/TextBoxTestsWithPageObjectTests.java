package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.TextBoxPage;

import java.util.Map;


public class TextBoxTestsWithPageObjectTests extends BaseTest {

    TextBoxPage textBoxPage = new TextBoxPage();



    @Test
    void fillFormTest() {
        textBoxPage.open()
                .setName("Elena")
                .setEmail("qagurubot@gmail.com")
                .setCurrentAddress("Some adders 1")
                .setPermanentAddress("Some adders 2")
                .submit();

        textBoxPage.checkResult("Elena",
                "qagurubot@gmail.com",
                "Some adders 1",
                "Some adders 2");


    }
}
