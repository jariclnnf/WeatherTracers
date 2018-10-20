package generalPage;
import dbUtil.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneralModel {
    Connection conn;

    public GeneralModel(){

        try{
            this.conn = dbConnection.getConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        if(this.conn == null){
            System.exit(1);
        }
    }

    public boolean isDatabasedConnected(){

        return this.conn != null;
    }

    public boolean isOn(String year, String historicalMiniAvg, String historicalMaxAvg)throws Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM historical_pressure where year = ? and historicalMiniAvg = ? and historicalMaxAvg = ?";

        try{
            pr = this.conn.prepareStatement(sql);
            pr.setString(1,year);
            pr.setString(2,historicalMiniAvg);
            pr.setString(3,historicalMaxAvg);

            rs = pr.executeQuery();



            return (rs.next()? true:false);
        }
        catch (SQLException ex){
            return false;
        }
        finally{
            pr.close();
            rs.close();
        }
    }



}
