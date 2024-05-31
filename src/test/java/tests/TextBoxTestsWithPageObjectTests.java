package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


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
