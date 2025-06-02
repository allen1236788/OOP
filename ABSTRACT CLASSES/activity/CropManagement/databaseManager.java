package CropManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseManager {
    String url = "jdbc:mysql://localhost:3306/crops";
    String dbUser = "root";
    String dbPass = "";

 public boolean editPass(int id, double cropQuantity){
            String editquery ="UPDATE users SET cropQuantity=? WHERE id=?";
            try(Connection conn=DriverManager.getConnection(url, dbUser, dbPass);
                PreparedStatement pst=conn.prepareStatement(editquery)){
        
                    pst.setInt(1, id);
                    pst.setDouble(2, cropQuantity);

                    int rowsAffected=pst.executeUpdate();
                    return rowsAffected>0;
            
            } catch (SQLException e) {
                if(e.getErrorCode()==1062){
                    System.out.println("Password cannot be changed.");
                }else{
                    e.printStackTrace();
                }
              
               return false;
            }}
        public boolean updateQuantity(int id, int cropsQuantity) {
         String query = "UPDATE crop SET cropQuantity=? WHERE id=?";

    try {
       
        Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
        PreparedStatement pst = conn.prepareStatement(query);

        pst.setInt(1, id);
        pst.setInt(2, cropsQuantity);

        int rowsUpdated = pst.executeUpdate();
        
        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

      public boolean updateFertilizer(int id, int fertilizerPrice) {
        String query = "UPDATE crop SET fertilizerPrice=? WHERE id=?";

    try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
        PreparedStatement pst = conn.prepareStatement(query)){

        pst.setInt(1, id);
        pst.setInt(2, fertilizerPrice);

        int rowsUpdated = pst.executeUpdate();
        
        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
}
