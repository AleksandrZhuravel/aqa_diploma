import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class OrderPage {
    public OrderPage() {
    }

    private SelenideElement form = $(By.className("App_appContainer__3jRx1"));
    private SelenideElement paymentButton = form.$(byText("Купить"));
    private SelenideElement creditButton = form.$(byText("Купить в кредит"));
    private SelenideElement fieldBlock = form.$(By.className("form"));
    private SelenideElement cardNumberField = fieldBlock.$("[placeholder='0000 0000 0000 0000']");
    private SelenideElement cardNumberFieldEmptyMessage = $(byXpath("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[3]"));
    private SelenideElement cardMonthField = fieldBlock.$("[placeholder='08']");
    private SelenideElement cardMonthFieldEmptyMessage = $(byXpath("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[3]"));
    private SelenideElement cardYearField = fieldBlock.$("[placeholder='22']");
    private SelenideElement cardYearFieldEmptyMessage = $(byXpath("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[3]"));
    private SelenideElement customerNameField = $(byXpath("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input"));
    private SelenideElement customerNameFieldEmptyMessage = $(byXpath("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[3]"));
    private SelenideElement cvvNumberField = fieldBlock.$("[placeholder='999']");
    private SelenideElement cvvNumberFieldEmptyMessage = $(byXpath("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[3]"));
    private SelenideElement continueButton = fieldBlock.$(By.className("button"));
    private SelenideElement successMessage = form.$(By.className("notification_status_ok"));
    private SelenideElement errorMessage = form.$(By.className("notification_status_error"));


    public void choicePayment() {
        paymentButton.click();
    }

    public void choiceCredit() {
        creditButton.click();
    }

    public void continueClick() {
        continueButton.click();
    }

    public void successMessageCheck() {

        successMessage.waitUntil((Condition.visible), 15000);
    }

    public void checkErrorMessage() {

        errorMessage.waitUntil((Condition.visible), 15000);
    }

    public void inputCardNumber(DataHelper.CardNumber cardNumber) {

        cardNumberField.setValue(cardNumber.getCardNumber());
    }

    public void inputCardMonth(DataHelper.CardMonth cardMonth) {
        cardMonthField.setValue(cardMonth.getCardMonth());
    }

    public void inputCardYear(DataHelper.CardYear cardYear) {
        cardYearField.setValue(cardYear.getCardYear());
    }

    public void inputCustomerName(DataHelper.CustomerName customerName) {
        customerNameField.setValue(customerName.getCustomerName());
    }

    public void inputCardCVV(DataHelper.CardCVV cardCVV) {
        cvvNumberField.setValue(cardCVV.getCardCVV());
    }

    public void checkEmptyCardNumberField() {
        cardNumberField.shouldBe(Condition.empty);
        cardNumberFieldEmptyMessage.shouldBe(Condition.visible);
        cardNumberFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cardNumberFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkEmptyCardMonthField() {
        cardMonthField.shouldBe(Condition.empty);
        cardMonthFieldEmptyMessage.shouldBe(Condition.visible);
        cardMonthFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cardMonthFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkEmptyCardYearField() {
        cardYearField.shouldBe(Condition.empty);
        cardYearFieldEmptyMessage.shouldBe(Condition.visible);
        cardYearFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cardYearFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkEmptyCustomerNameField() {
        customerNameField.shouldBe(Condition.empty);
        customerNameFieldEmptyMessage.shouldBe(Condition.visible);
        customerNameFieldEmptyMessage.shouldHave(text("Поле обязательно для заполнения"));
        customerNameFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkEmptyCVVNumberField() {
        cvvNumberField.shouldBe(Condition.empty);
        cvvNumberFieldEmptyMessage.shouldBe(Condition.visible);
        cvvNumberFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cvvNumberFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkCardNumberFieldEmptyMessage() {
        cardNumberFieldEmptyMessage.shouldBe(Condition.visible);
        cardNumberFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cardNumberFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkCardMonthFieldEmptyMessage() {
        cardMonthFieldEmptyMessage.shouldBe(Condition.visible);
        cardMonthFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cardMonthFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkCardYearFieldEmptyMessage() {
        cardYearFieldEmptyMessage.shouldBe(Condition.visible);
        cardYearFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cardYearFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkCustomerNameFieldEmptyMessage() {
        customerNameFieldEmptyMessage.shouldBe(Condition.visible);
        customerNameFieldEmptyMessage.shouldHave(text("Поле обязательно для заполнения"));
        customerNameFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void checkCVVNumberFieldEmptyMessage() {
        cvvNumberFieldEmptyMessage.shouldBe(Condition.visible);
        cvvNumberFieldEmptyMessage.shouldHave(text("Неверный формат"));
        cvvNumberFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void falseMonthMessage() {
        cardMonthFieldEmptyMessage.shouldBe(Condition.visible);
        cardMonthFieldEmptyMessage.shouldHave(text("Неверно указан срок действия карты"));
        cardMonthFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }

    public void lastYearMessage() {
        cardYearFieldEmptyMessage.shouldBe(Condition.visible);
        cardYearFieldEmptyMessage.shouldHave(text("Истёк срок действия карты"));
        cardYearFieldEmptyMessage.shouldHave(cssValue("color", "rgba(255, 92, 92, 1)"));
    }
}
