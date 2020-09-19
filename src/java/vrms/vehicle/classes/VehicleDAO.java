/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.vehicle.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class VehicleDAO {

    public int insert(VehicleBean vehicle) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehicle VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vehicle.getMake());
            ps.setString(2, vehicle.getModel());
            ps.setString(3, vehicle.getYor());
            ps.setString(4, vehicle.getVin());
            ps.setString(5, vehicle.getServ_from());
            ps.setString(6, vehicle.getCategory());
            ps.setString(7, vehicle.getRate_per_day_wod());
            ps.setString(8, vehicle.getRate_per_week_wod());
            ps.setString(9, vehicle.getRate_per_month_wod());
            ps.setString(10, vehicle.getExcess_milage_wod());
            ps.setString(11, vehicle.getRate_per_day_wd());
            ps.setString(12, vehicle.getExcess_milage_wd());
            result = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
    
    public ResultSet view(){
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM vehicle");
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
