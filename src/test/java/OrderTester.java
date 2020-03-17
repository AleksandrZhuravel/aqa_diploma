import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class OrderTester {

    @BeforeEach
    public void openPage() {
        open("http://localhost:8080/");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName(value = "01. Order should be approved with the card number 41")
    void orderShouldBeApprovedWithCardFortyOne() throws SQLException {
        val orderPage = new OrderPage();
        val sqlHelper = new SQLHelper();
        orderPage.choicePayment();
        orderPage.cardNumberInput(DataHelper.getFirstCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.successMessageCheck();
        sqlHelper.dbPayment(DataHelper.getApproved(), DataHelper.getOrderAmountActual());
    }

    @Test
    @DisplayName(value = "02. Order should be approved with the card number 42")
    void orderShouldBeApprovedWithCardFortyTwo() throws SQLException {
        val orderPage = new OrderPage();
        val sqlHelper = new SQLHelper();
        orderPage.choicePayment();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.successMessageCheck();
        sqlHelper.dbPayment(DataHelper.getDeclined(), DataHelper.getOrderAmountActual());
    }

    @Test
    @DisplayName(value = "03. Order should be denied with the card number 43")
    void orderShouldBeDeniedWithCardFortyThree() {
        val orderPage = new OrderPage();
        orderPage.choicePayment();
        orderPage.cardNumberInput(DataHelper.getThirdCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.errorMessageCheck();
    }

    @Test
    @DisplayName(value = "04. Incorrect values will not be entered")
    void incorrectValuesWillNotBeEntered() {
        val orderPage = new OrderPage();
        orderPage.choicePayment();
        orderPage.cardNumberInput(DataHelper.getIncorrectCardNumber());
        orderPage.cardMonthInput(DataHelper.getIncorrectMonth());
        orderPage.cardYearInput(DataHelper.getIncorrectYear());
        orderPage.customerNameInput(DataHelper.getIncorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getIncorrectCVV());
        orderPage.continueClick();
        orderPage.emptyFields();
    }

    @Test
    @DisplayName(value = "05. Incorrect values(specials) will not be entered")
    void specialsWillNotBeEntered() {
        val orderPage = new OrderPage();
        orderPage.choicePayment();
        orderPage.cardNumberInput(DataHelper.getSpecialsCardNumber());
        orderPage.cardMonthInput(DataHelper.getSpecialsCardMonth());
        orderPage.cardYearInput(DataHelper.getSpecialsCardYear());
        orderPage.customerNameInput(DataHelper.getSpecialsCustomerName());
        orderPage.cardCVVInput(DataHelper.getSpecialsCardCVV());
        orderPage.continueClick();
        orderPage.emptyFields();
    }


    @Test
    @DisplayName(value = "06. Empty fields should be highlighted")
    void emptyFieldsShouldBeHighlighted() {
        val orderPage = new OrderPage();
        orderPage.choicePayment();
        orderPage.continueClick();
        orderPage.emptyFieldsMessage();
    }


    @Test
    @DisplayName(value = "07. Nonexistent month should be allocated")
    void nonexistentMonthShouldBeAllocated() {
        val orderPage = new OrderPage();
        orderPage.choicePayment();
        orderPage.continueClick();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getFalseMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.falseMonthMessage();
    }

    @Test
    @DisplayName(value = "08. Expired month card should be allocated")
    void expiredMonthCardShouldBeAllocated() {
        val orderPage = new OrderPage();
        orderPage.choicePayment();
        orderPage.continueClick();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getLastMonth());
        orderPage.cardYearInput(DataHelper.getThisYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.falseMonthMessage();
    }

    @Test
    @DisplayName(value = "09. Expired year card should be allocated")
    void expiredYearCardShouldBeAllocated() {
        val orderPage = new OrderPage();
        orderPage.choicePayment();
        orderPage.continueClick();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getLastYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.lastYearMessage();
    }

    @Test
    @DisplayName(value = "10. Credit should be approved with the card number 41")
    void creditShouldBeApprovedWithCardFortyOne() throws SQLException {
        val orderPage = new OrderPage();
        val sqlHelper = new SQLHelper();
        orderPage.choiceCredit();
        orderPage.cardNumberInput(DataHelper.getFirstCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.successMessageCheck();
        sqlHelper.dbCredit(DataHelper.getApproved());
    }

    @Test
    @DisplayName(value = "11. Credit should be approved with the card number 42")
    void creditShouldBeApprovedWithCardFortyTwo() throws SQLException {
        val orderPage = new OrderPage();
        val sqlHelper = new SQLHelper();
        orderPage.choiceCredit();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.successMessageCheck();
        sqlHelper.dbCredit(DataHelper.getDeclined());
    }

    @Test
    @DisplayName(value = "12. Credit should be denied with the card number 43")
    void creditShouldBeDeniedWithCardFortyThree() {
        val orderPage = new OrderPage();
        orderPage.choiceCredit();
        orderPage.cardNumberInput(DataHelper.getThirdCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.errorMessageCheck();
    }

    @Test
    @DisplayName(value = "13. Incorrect values will not be entered credit")
    void incorrectValuesWillNotBeEnteredCredit() {
        val orderPage = new OrderPage();
        orderPage.choiceCredit();
        orderPage.cardNumberInput(DataHelper.getIncorrectCardNumber());
        orderPage.cardMonthInput(DataHelper.getIncorrectMonth());
        orderPage.cardYearInput(DataHelper.getIncorrectYear());
        orderPage.customerNameInput(DataHelper.getIncorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getIncorrectCVV());
        orderPage.continueClick();
        orderPage.emptyFields();
    }

    @Test
    @DisplayName(value = "14. Incorrect values(specials) will not be entered credit")
    void specialsWillNotBeEnteredCredit() {
        val orderPage = new OrderPage();
        orderPage.choiceCredit();
        orderPage.cardNumberInput(DataHelper.getSpecialsCardNumber());
        orderPage.cardMonthInput(DataHelper.getSpecialsCardMonth());
        orderPage.cardYearInput(DataHelper.getSpecialsCardYear());
        orderPage.customerNameInput(DataHelper.getSpecialsCustomerName());
        orderPage.cardCVVInput(DataHelper.getSpecialsCardCVV());
        orderPage.continueClick();
        orderPage.emptyFields();
    }


    @Test
    @DisplayName(value = "15. Empty fields should be highlighted credit")
    void emptyFieldsShouldBeHighlightedCredit() {
        val orderPage = new OrderPage();
        orderPage.choiceCredit();
        orderPage.continueClick();
        orderPage.emptyFieldsMessage();
    }


    @Test
    @DisplayName(value = "16. Nonexistent month should be allocated credit")
    void nonexistentMonthShouldBeAllocatedCredit() {
        val orderPage = new OrderPage();
        orderPage.choiceCredit();
        orderPage.continueClick();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getFalseMonth());
        orderPage.cardYearInput(DataHelper.getNextYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.falseMonthMessage();
    }

    @Test
    @DisplayName(value = "17. Expired month credit card should be allocated")
    void expiredMonthCreditCardShouldBeAllocated() {
        val orderPage = new OrderPage();
        orderPage.choiceCredit();
        orderPage.continueClick();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getLastMonth());
        orderPage.cardYearInput(DataHelper.getThisYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.falseMonthMessage();
    }

    @Test
    @DisplayName(value = "18. Expired year credit card should be allocated")
    void expiredYearCreditCardShouldBeAllocated() {
        val orderPage = new OrderPage();
        orderPage.choiceCredit();
        orderPage.continueClick();
        orderPage.cardNumberInput(DataHelper.getSecondCardNumber());
        orderPage.cardMonthInput(DataHelper.getThisMonth());
        orderPage.cardYearInput(DataHelper.getLastYear());
        orderPage.customerNameInput(DataHelper.getCorrectCustomerName());
        orderPage.cardCVVInput(DataHelper.getCorrectCVV());
        orderPage.continueClick();
        orderPage.lastYearMessage();
    }

}
