package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement transferButton=$("[data-test-id='action-transfer']");
    private final SelenideElement amountInput=$("[data-test-id='amount'] input");
    private final SelenideElement fromInput=$("[data-test-id='from'] input");
    private final SelenideElement transferHead=$(byText("Пополнение карты"));
    public TransferPage(){
        transferHead.shouldBe(visible);
    }
public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
}
public DashboardPage makeValidTransfer (String amountToTransfer, DataHelper.CardInfo cardInfo){
       makeTransfer(amountToTransfer,cardInfo);
   return new DashboardPage();
}
}
