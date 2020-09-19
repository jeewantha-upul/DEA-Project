/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.customer.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.customer.classes.CustomerDAO;

/**
 *
 * @author LENOVO
 */
public class ViewCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            CustomerDAO dao = new CustomerDAO();
            ResultSet result = dao.view();
            while (result.next()) {
                out.print("<tr><td>" + result.getString("nic") + "</td><td>" + result.getString("first_name") + "</td><td>" + result.getString("last_name") + "</td><td>" + result.getString("gender") + "</td><td>" + result.getString("phone_no") + "</td><td>" + result.getString("email") + "</td><td>" + result.getString("dl_no") + "</td><td>"+ result.getString("dob") + "</td><td>"+ result.getString("address") + "</td></tr>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
