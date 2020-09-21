/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.customer.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrms.user.classes.UserDAO;

/**
 *
 * @author Kavinda
 */
public class CustomerDAO {

    public int insert(CustomerBean customer) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.setString(3, customer.getGender());
            ps.setString(4, customer.getPhone_no());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getNic());
            ps.setString(7, customer.getDl_no());
            ps.setString(8, customer.getDob());
            ps.setString(9, customer.getAddress());
            result = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet view() {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT first_name,last_name,gender,phone_no,email,nic,dl_no,dob,address FROM customer ORDER BY first_name ASC");
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void viewSpecific(CustomerBean customer, String nic) {

        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE nic=?");
            ps.setString(1, nic);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setGender(rs.getString("gender"));
                customer.setPhone_no(rs.getString("phone_no"));
                customer.setEmail(rs.getString("email"));
                customer.setNic(rs.getString("nic"));
                customer.setDl_no(rs.getString("dl_no"));
                customer.setDob(rs.getString("dob"));
                customer.setAddress(rs.getString("address"));
                ps.close();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int update(CustomerBean customer, String nic) {

        int result = 0;

        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE customer SET first_name=?, last_name=?, gender=?, phone_no=?, email=?, nic=?, dl_no=?, dob=?, address=? WHERE nic=?");
            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.setString(3, customer.getGender());
            ps.setString(4, customer.getPhone_no());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getNic());
            ps.setString(7, customer.getDl_no());
            ps.setString(8, customer.getDob());
            ps.setString(9, customer.getAddress());
            ps.setString(10, nic);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int delete(String nic) {

        int result = 0;
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE nic=?");
            ps.setString(1, nic);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
