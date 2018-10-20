package dbUtil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection{
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0603";
    private static final String CONN = "jdbc:mysql://localhost:3306/hurricane_condition?verifyServerCertificate=false&useSSL=true";
    public static Connection getConnection() throws SQLException {

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();

        }
        return null;
    }
}
