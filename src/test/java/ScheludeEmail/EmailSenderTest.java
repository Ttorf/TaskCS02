package ScheludeEmail;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;
import java.sql.*;
import java.util.logging.*;
import java.sql.ResultSet;
import java.sql.Statement;

class EmailSenderTest {

    @Test
    void emailSendWithLog() throws InterruptedException {
        Boolean expected = true;
        EmailSender emailSender = new EmailSender();
        emailSender.emailSendWithLog();
        Thread.sleep(4000);
        CheckListDB(expected, dBGetData());
    }

    public boolean dBGetData() {
        Queue<Integer> list = new LinkedList<>();
        String sqlQuery = "SELECT * FROM emailtable where sended = 'true'";
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name = "postgres";
        String password = "65432179ss";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = null;

            statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery(sqlQuery);
            while (result1.next()) {
                list.add(result1.getInt("id_email"));
            }

        } catch (Exception ex) {
            Logger.getLogger(DataInsertGetUpdateFromBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataInsertGetUpdateFromBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list.size() > 0;

    }

    public static void CheckListDB(Boolean current, Boolean expected) {

        Assert.assertEquals("Проблемы с базой данных ", current, expected);

    }
}