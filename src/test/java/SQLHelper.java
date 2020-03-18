import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SQLHelper {
    public SQLHelper() {
    }

    String paymentStatus = "select status from payment_entity where created = (select max(created) from payment_entity);";
    String creditStatus = "select status from credit_request_entity where created = (select max(created) from credit_request_entity);";
    String paymentId = "select payment_id from order_entity where created = (select max(created) from order_entity);";
    String transactionId = "select transaction_id from payment_entity where created = (select max(created) from payment_entity);";
    String bankId = "select bank_id from credit_request_entity where created = (select max(created) from credit_request_entity);";
    String orderAmount = "select amount from payment_entity where created = (select max(created) from payment_entity);";
    QueryRunner runner = new QueryRunner();

    public void dbPayment(DataHelper.BankAnswer bankAnswer, DataHelper.OrderAmount orderAmountNumber) throws SQLException {
        try (
                // val conn = DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/postgres", "postgres", "postgres");
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
        ) {
            val paymentStatusVal = runner.query(conn, paymentStatus, new ScalarHandler<>());
            val paymentIdVal = runner.query(conn, paymentId, new ScalarHandler<>());
            val transactionIdVal = runner.query(conn, transactionId, new ScalarHandler<>());
            val orderAmountVal = runner.query(conn, orderAmount, new ScalarHandler<>());
            assertEquals(bankAnswer.getBankAnswer(), paymentStatusVal);
            assertEquals(transactionIdVal, paymentIdVal);
            assertEquals(orderAmountNumber.getOrderAmountNumber(), orderAmountVal);
        }

    }


    public void dbCredit(DataHelper.BankAnswer bankAnswer) throws SQLException {
        try (
                // val conn = DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/postgres", "postgres", "postgres");
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
        ) {
            val creditStatusVal = runner.query(conn, creditStatus, new ScalarHandler<>());
            val paymentIdVal = runner.query(conn, paymentId, new ScalarHandler<>());
            val bankIdVal = runner.query(conn, bankId, new ScalarHandler<>());
            assertEquals(bankAnswer.getBankAnswer(), creditStatusVal);
            assertEquals(bankIdVal, paymentIdVal);
        }

    }

}
