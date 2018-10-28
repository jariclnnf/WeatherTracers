package generalPage;

import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GeneralController implements Initializable{


    GeneralModel generalModel = new GeneralModel();

    @FXML
    private Label dbStatus;

    @FXML
    private TextField yearField;
    @FXML
    private TextField miniField;
    @FXML
    private TextField maxField;

    @FXML
    private TableView<GneralData> pressureTable;
    @FXML
    private TableColumn<GneralData, String> yearCol;
    @FXML
    private TableColumn<GneralData, String> minCol;
    @FXML
    private TableColumn<GneralData, String> maxCol;

    private dbConnection dbconn;
    private ObservableList<GneralData> data;
    private String sql = "SELECT * FROM historical_pressure";
    public void initialize(URL url, ResourceBundle rb){

        if(this.generalModel.isDatabasedConnected()){

            this.dbStatus.setText("Connected to Database");
        }
        else{
            this.dbStatus.setText("Not Connected to Database");
        }
    }

    @FXML
    private void loadPressureData(ActionEvent event) throws SQLException{
        try{

            Connection connection = dbconn.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = connection.createStatement().executeQuery(sql);

            while(rs.next()){
                this.data.add(new GneralData(rs.getString(1),
                        rs.getString(2),rs.getString(3)));
            }
        }
        catch (SQLException e){
            System.err.println("Error " + e);
        }

        this.yearCol.setCellValueFactory(new PropertyValueFactory<GneralData, String>("YEAR"));
        this.minCol.setCellValueFactory(new PropertyValueFactory<GneralData, String>("MINI_AVG"));
        this.maxCol.setCellValueFactory(new PropertyValueFactory<GneralData, String>("MAX_AVG"));

        this.pressureTable.setItems(null);
        this.pressureTable.setItems(this.data);
    }

    @FXML
    private void addPressure(ActionEvent event){


        String sqlInsert = "INSERT INTO historical_pressure(year, historicalMiniAverage, historicalMaxAverage) " +
                "VALUES (?,?,?)";

        try{
            Connection connection = dbconn.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sqlInsert);

            stmt.setString(1,this.yearField.getText());
            stmt.setString(2,this.miniField.getText());
            stmt.setString(3,this.maxField.getText());

            stmt.execute();
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void clearFields(ActionEvent event){
        this.yearField.setText("");
        this.minCol.setText("");
        this.maxCol.setText("");

    }
}
