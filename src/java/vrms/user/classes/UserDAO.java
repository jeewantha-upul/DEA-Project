package vrms.user.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    public ResultSet check(UserBean user) {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT first_name,user_role FROM user WHERE user_name=? AND password=?");
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPassword1());
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String insert(UserBean user) {
        String result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getFirst_name());
            ps.setString(3, user.getLast_name());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getPhone_no());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getUser_role());
            ps.setString(8, user.getPassword1());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = user.getUser_name();
                ps.close();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public ResultSet view() {
        ResultSet result = null;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT user_name,first_name,last_name,gender,phone_no,email,user_role FROM user ORDER BY user_name ASC");
            result = ps.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int delete(String user_name) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE user_name=?");
            ps.setString(1, user_name);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int update(UserBean user, String uname) {
        int result = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE user SET first_name=?, last_name=?, gender=?, phone_no=?, email=?, user_role=?, password=? WHERE user_name=?");
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPhone_no());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getUser_role());
            ps.setString(7, user.getPassword1());
            ps.setString(8, uname);
            int rs = ps.executeUpdate();
            if (rs == 1) {
                result = 1;
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void viewSpecific(UserBean user, String user_name) {
        try {
            String url = "jdbc:mysql://localhost:3306/vrms_db";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE user_name=?");
            ps.setString(1, user_name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setGender(rs.getString("gender"));
                user.setPhone_no(rs.getString("phone_no"));
                user.setEmail(rs.getString("email"));
                user.setUser_role(rs.getString("user_role"));
                user.setPassword1(rs.getString("password"));
                user.setPassword2(rs.getString("password"));
                ps.close();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
