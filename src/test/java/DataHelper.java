import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class CardNumber {
        private String cardNumber;

    }

    public static CardNumber getFirstCardNumber() {
        return new CardNumber("4444 4444 4444 4441");
    }

    public static CardNumber getSecondCardNumber() {
        return new CardNumber("4444 4444 4444 4442");
    }

    public static CardNumber getThirdCardNumber() {
        return new CardNumber("4444 4444 4444 4443");
    }

    public static CardNumber getIncorrectCardNumber() {
        return new CardNumber("NNNN NNNN NNNN NNNN");
    }

    public static CardNumber getSpecialsCardNumber() {
        return new CardNumber("@@");
    }

    @Value
    public static class CardMonth {
        private String cardMonth;
    }

    public static CardMonth getFalseMonth() {
        return new CardMonth("13");
    }

    public static CardMonth getIncorrectMonth() {
        return new CardMonth("NN");
    }

    public static CardMonth getLastMonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String lastMonth = LocalDate.now().minusMonths(1).format(formatter);
        return new CardMonth(lastMonth);
    }

    public static CardMonth getThisMonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String thisMonth = LocalDate.now().format(formatter);
        return new CardMonth(thisMonth);
    }

    public static CardMonth getSpecialsCardMonth() {
        return new CardMonth("@@");
    }

    @Value
    public static class CardYear {
        private String cardYear;
    }

    public static CardYear getThisYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        String thisYear = LocalDate.now().format(formatter);
        return new CardYear(thisYear);
    }

    public static CardYear getNextYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        String nextYear = LocalDate.now().plusYears(1).format(formatter);
        return new CardYear(nextYear);
    }

    public static CardYear getLastYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        String lastYear = LocalDate.now().minusYears(1).format(formatter);
        return new CardYear(lastYear);
    }

    public static CardYear getIncorrectYear() {
        return new CardYear("NN");
    }

    public static CardYear getSpecialsCardYear() {
        return new CardYear("@@");
    }

    @Value
    public static class CustomerName {
        private String customerName;
    }

    public static CustomerName getCorrectCustomerName() {
        Faker faker;
        faker = new Faker();
        String customerName = faker.name().fullName();
        return new CustomerName(customerName);
    }

    public static CustomerName getIncorrectCustomerName() {
        return new CustomerName("1 1");
    }

    public static CustomerName getSpecialsCustomerName() {
        return new CustomerName("@@");
    }

    @Value
    public static class CardCVV {
        private String cardCVV;
    }

    public static CardCVV getCorrectCVV() {
        Faker faker;
        faker = new Faker();
        int intCardCVV = faker.number().numberBetween(100, 999);
        String cardCVV = Integer.toString(intCardCVV);
        return new CardCVV(cardCVV);
    }

    public static CardCVV getIncorrectCVV() {
        return new CardCVV("NNN");
    }

    public static CardCVV getSpecialsCardCVV() {
        return new CardCVV("@@");
    }

    @Value
    public static class BankAnswer {
        private String bankAnswer;
    }

    public static BankAnswer getApproved() {
        return new BankAnswer("APPROVED");
    }

    public static BankAnswer getDeclined() {
        return new BankAnswer("DECLINED");
    }

    @Value
    public static class OrderAmount {
        private int orderAmountNumber;
    }

    public static OrderAmount getOrderAmountActual() {
        return new OrderAmount(4500000);
    }
}