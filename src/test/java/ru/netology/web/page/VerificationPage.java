package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyButton = $("[data-test-id='action-verify']");

    public VerificationPage() {
        $("h2").shouldHave(Condition.exactText("Интернет Банк")).shouldBe(visible);
    }

    public DashboardPage validVerification (DataHelper.VerificationCode verificationCode) {
codeField.setValue(verificationCode.getCode());
verifyButton.click();
return new DashboardPage();
    }
}
