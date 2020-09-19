/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.driver.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PAVANI
 */
public class DriverDAO {

    public int insert(DriverBean driver){
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO driver VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, driver.getFirst_name());
            ps.setString(2, driver.getLast_name());
            ps.setString(3, driver.getGender());
            ps.setString(4, driver.getPhone_no());
            ps.setString(5, driver.getEmail());
            ps.setString(6, driver.getNic());
            ps.setString(7, driver.getDl_no());
            ps.setString(8, driver.getDob());
            ps.setString(9, driver.getAddress());
            result = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DriverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet view(){
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT first_name,last_name,gender,phone_no,email,nic,dl_no,dob,address FROM driver");
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DriverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int delete(String dl_no) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("DELETE FROM driver WHERE dl_no=?");
            ps.setString(1, dl_no);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DriverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int update(DriverBean driver, String dl_no) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE driver SET first_name=?, last_name=?, gender=?, phone_no=?, email=?, nic=?, dob=?, address=? WHERE dl_no=?");
            ps.setString(1, driver.getFirst_name());
            ps.setString(2, driver.getLast_name());
            ps.setString(3, driver.getGender());
            ps.setString(4, driver.getPhone_no());
            ps.setString(5, driver.getEmail());
            ps.setString(6, driver.getNic());
            ps.setString(7, driver.getDob());
            ps.setString(8, driver.getAddress());
            ps.setString(9, dl_no);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DriverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void viewSpecific(DriverBean driver, String dl_no) {
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM driver WHERE dl_no=?");
            ps.setString(1, dl_no);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                driver.setFirst_name(rs.getString("first_name"));
                driver.setLast_name(rs.getString("last_name"));
                driver.setGender(rs.getString("gender"));
                driver.setPhone_no(rs.getString("phone_no"));
                driver.setEmail(rs.getString("email"));
                driver.setNic(rs.getString("nic"));
                driver.setDob(rs.getString("dob"));
                driver.setAddress(rs.getString("address"));
                ps.close();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DriverDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
