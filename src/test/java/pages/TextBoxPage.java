package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage {

    private final SelenideElement nameInput = $("[id=userName]"),
            emailInput = $("[id=userEmail]"),
            currentAddressInput = $("[id=currentAddress]"),
            permanentAddressInput = $("[id=permanentAddress]"),
            submitButton = $("[id=submit]"),
            result = $("[id=output]");

    public TextBoxPage open() {
        Selenide.open("/text-box");
        return this;
    }

    public TextBoxPage setName(String value) {
        nameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.scrollIntoView(true).click();
        return this;
    }

    public TextBoxPage checkResult(String name, String email, String currentAddress, String permanentAddress) {

        result.$("[id=name").shouldHave(text(name));
        result.$("[id=email").shouldHave(text(email));
        result.$("[id=currentAddress").shouldHave(text(currentAddress));
        result.$("[id=permanentAddress").shouldHave(text(permanentAddress));

        return this;
    }


}
