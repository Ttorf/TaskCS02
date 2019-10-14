package ScheludeEmail;

import GeneratorDataForBD.NameThemeData;

import java.util.logging.Logger;
import java.sql.*;
import java.util.logging.*;

public class DataInsertGetUpdateFromBD {
    private static Logger log = Logger.getLogger(EmailSender.class.getName());

    public void updateDataWithSended() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name = "postgres";
        String password = "65432179ss";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = null;

            statement = connection.createStatement();
            statement.executeUpdate(
                    "UPDATE emailtable SET sended = 'true' where sended =  'false'");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("Письма отправлены ");
    }

    public void insertDataBD() {
        NameThemeData nameThemeData = new NameThemeData();
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name = "postgres";
        String password = "65432179ss";
        String namerd = nameThemeData.randomName();
        java.sql.Date date = nameThemeData.dataNowGenerationString();
        String themes = nameThemeData.randomTheme();
        boolean bad = false;
        String sometext = "some text";
        log.info("Получены письма на рассылку ");
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO emailtable(id_email,bodyemail,sended,namefrom,datasended,theme) VALUES (?, ?, ?, ?, ?,?)");
            pstmt.setInt(1, (int) (Math.random() * 100));
            pstmt.setString(2, sometext);
            pstmt.setBoolean(3, bad);
            pstmt.setString(4, namerd);
            pstmt.setDate(5, date);
            pstmt.setString(6, themes);
            pstmt.executeUpdate();
            log.info("Рассылка письма в процессе ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataInsertGetUpdateFromBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}



