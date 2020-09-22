package vrms.invoice.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceDAO {

    public int Insert(InvoiceBean invoice) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO invoice (nic, first_name, last_name, phone_no, resv_date, resv_until, vin, driver_status, start_mileage, total) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, invoice.getNic());
            ps.setString(2, invoice.getFirst_name());
            ps.setString(3, invoice.getLast_name());
            ps.setString(4, invoice.getPhone_no());
            ps.setString(5, invoice.getStart_date());
            ps.setString(6, invoice.getEnd_date());
            ps.setString(7, invoice.getVin());
            ps.setString(8, invoice.getDriver_status());
            ps.setString(9, invoice.getStart_mileage());
            ps.setString(10, invoice.getTotal());
            result = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
