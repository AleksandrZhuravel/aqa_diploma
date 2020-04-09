import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    String paymentStatus = "select status from payment_entity where created = (select max(created) from payment_entity);";
    String creditStatus = "select status from credit_request_entity where created = (select max(created) from credit_request_entity);";
    String paymentId = "select payment_id from order_entity where created = (select max(created) from order_entity);";
    String transactionId = "select transaction_id from payment_entity where created = (select max(created) from payment_entity);";
    String bankId = "select bank_id from credit_request_entity where created = (select max(created) from credit_request_entity);";
    String orderAmount = "select amount from payment_entity where created = (select max(created) from payment_entity);";
    String rowCount = "SELECT COUNT(*) FROM order_entity;";
    String url = System.getProperty("test.db.url");
    String user = System.getProperty("test.db.user");
    String password = System.getProperty("test.db.password");

    QueryRunner runner = new QueryRunner();

    public String checkPaymentStatus() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            return runner.query(conn, paymentStatus, new ScalarHandler<>());
        }
    }

    public String checkPaymentId() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            return runner.query(conn, paymentId, new ScalarHandler<>());
        }
    }

    public String checkTransactionId() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            return runner.query(conn, transactionId, new ScalarHandler<>());
        }
    }

    public int checkOrderAmount() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            return runner.query(conn, orderAmount, new ScalarHandler<>());
        }
    }


    public String checkCreditStatus() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            return runner.query(conn, creditStatus, new ScalarHandler<>());
        }
    }

    public String checkBankId() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            return runner.query(conn, bankId, new ScalarHandler<>());
        }
    }

    public long rowCount() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            long rowCountFirst = runner.query(conn, rowCount, new ScalarHandler<>());
            return rowCountFirst;
        }
    }

    public long rowCountChecker() throws SQLException {
        try (
                val conn = DriverManager.getConnection(url, user, password);
        ) {
            long rowCountSecond = runner.query(conn, rowCount, new ScalarHandler<>());
            return rowCountSecond;
        }
    }
}
