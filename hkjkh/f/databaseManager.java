import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseManager {
    String url = "jdbc:mysql://localhost:3306/memorial";
    String dbUser = "root";
    String dbPass = "";

    public int registerUser(String f_name, String m_name, String l_name, String contact_num, String Lot, double payment, double balance) {
        String query = "INSERT INTO plan (f_name, m_name, l_name, contact_num, Lot, payment, balance) VALUES (?, ?, ?, ?, ?, ?,?)";

        try {
            Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
            PreparedStatement pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setString(1, f_name);
            pst.setString(2, m_name);
            pst.setString(3, l_name);
            pst.setString(4, contact_num);
            pst.setString(5, Lot);
            pst.setDouble(6, payment);
            pst.setDouble(7, balance);


            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 0) {
                return -1;
            }

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                return -1;
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    
    public boolean lotStandard(int id,String f_name,String lotchoice, double balance,double payment) {
        String query = "INSERT INTO standard (id,f_name,lotchoice,balance,payment) VALUES (?, ?, ?, ?,?)";


        try {
            Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, f_name);
            pst.setString(3, lotchoice);
            pst.setDouble(4, balance);
            pst.setDouble(5,payment);



         int rowsUpdated = pst.executeUpdate();
        
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

        public boolean lotGarden(int id,String f_name,String lotchoice, double balance,double payment) {
        String query = "INSERT INTO garden (id,f_name,lotchoice,balance,payment) VALUES (?, ?, ?, ?,?)";


        try {
            Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, f_name);
            pst.setString(3, lotchoice);
            pst.setDouble(4, balance);
            pst.setDouble(5,payment);



         int rowsUpdated = pst.executeUpdate();
        
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

        public boolean lotMansion(int id,String f_name,String lotchoice, double balance,double payment) {
        String query = "INSERT INTO mansion (id,f_name,lotchoice,balance,payment) VALUES (?, ?, ?, ?,?)";


        try {
            Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, f_name);
            pst.setString(3, lotchoice);
            pst.setDouble(4, balance);
            pst.setDouble(5,payment);



         int rowsUpdated = pst.executeUpdate();
        
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }


    public boolean updatePayment(double balance,int id) {
        String query = "UPDATE plan SET payment = ? WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
        PreparedStatement pst = conn.prepareStatement(query)){

        pst.setDouble(1, balance);
        pst.setInt(2, id);

        int rowsUpdated = pst.executeUpdate();
        
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }
    
    //ga check if user exists in DB (instead sa mock data)
    public boolean userExists(String userId) {
        String query = "SELECT COUNT(*) FROM plan WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, userId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        }
    
