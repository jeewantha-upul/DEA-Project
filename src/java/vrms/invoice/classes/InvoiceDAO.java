package vrms.invoice.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            PreparedStatement ps = con.prepareStatement("INSERT INTO invoice (nic, first_name, last_name, phone_no, resv_date, resv_until, vin, driver_status, start_mileage, end_mileage, total, pay_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, invoice.getNic());
            ps.setString(2, invoice.getFirst_name());
            ps.setString(3, invoice.getLast_name());
            ps.setString(4, invoice.getPhone_no());
            ps.setString(5, invoice.getStart_date());
            ps.setString(6, invoice.getEnd_date());
            ps.setString(7, invoice.getVin());
            ps.setString(8, invoice.getDriver_status());
            ps.setString(9, invoice.getStart_mileage());
            ps.setString(10, invoice.getEnd_mileage());
            ps.setString(11, invoice.getTotal());
            ps.setString(12, invoice.getPayment_status());
            result = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void viewSpecific(InvoiceBean invoice, String invoice_id) {
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM invoice WHERE invoice_id=?");
            ps.setString(1, invoice_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                invoice.setNic(rs.getString("nic"));
                invoice.setFirst_name(rs.getString("first_name"));
                invoice.setLast_name(rs.getString("last_name"));
                invoice.setPhone_no(rs.getString("phone_no"));
                invoice.setStart_date(rs.getString("resv_date"));
                invoice.setEnd_date(rs.getString("resv_until"));
                invoice.setVin(rs.getString("vin"));
                invoice.setDriver_status(rs.getString("driver_status"));
                invoice.setStart_mileage(rs.getString("start_mileage"));
                invoice.setEnd_mileage(rs.getString("end_mileage"));
                invoice.setTotal(rs.getString("total"));
                invoice.setPayment_status(rs.getString("pay_status"));
                ps.close();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int update(InvoiceBean invoice, String invoice_id) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE invoice SET nic=?, first_name=?, last_name=?, phone_no=?, resv_date=?, resv_until=?, vin=?, driver_status=?, start_mileage=?, end_mileage=?, total=?, pay_status=? WHERE invoice_id=?");
            ps.setString(1, invoice.getNic());
            ps.setString(2, invoice.getFirst_name());
            ps.setString(3, invoice.getLast_name());
            ps.setString(4, invoice.getPhone_no());
            ps.setString(5, invoice.getStart_date());
            ps.setString(6, invoice.getEnd_date());
            ps.setString(7, invoice.getVin());
            ps.setString(8, invoice.getDriver_status());
            ps.setString(9, invoice.getStart_mileage());
            ps.setString(10, invoice.getEnd_mileage());
            ps.setString(11, invoice.getTotal());
            ps.setString(12, invoice.getPayment_status());
            ps.setString(13, invoice_id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int delete(String invoice_id) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("DELETE FROM invoice WHERE invoice_id=?");
            ps.setString(1, invoice_id);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet view() {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM invoice");
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
