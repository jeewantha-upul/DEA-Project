package vrms.invoice.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceDAO {

    public ResultSet viewSpecificCustomer(String nic) {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE nic=?");
            ps.setString(1, nic);
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet viewVehicles(String category) {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT make, model, yor, vin, rate_per_day_wod, rate_per_week_wod, rate_per_month_wod, excess_mileage_wod, rate_per_day_wd, excess_mileage_wd FROM vehicle WHERE category=?");
            ps.setString(1, category);
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet viewDrivers() {
        
        ResultSet result = null;
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT first_name,last_name,phone_no,nic,dl_no FROM driver");
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}