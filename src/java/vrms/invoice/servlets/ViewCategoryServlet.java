/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.invoice.servlets;

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
import vrms.invoice.classes.InvoiceDAO;

public class ViewCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            String category = (String) request.getAttribute("category");

            InvoiceDAO dao = new InvoiceDAO();
            ResultSet result = dao.viewVehicles(category);
            if(result.isBeforeFirst()){
                while (result.next()) {
                out.print("<tr><td>" + result.getString("vin") + "</td><td>" + result.getString("make") + "</td><td>" + result.getString("model") + "</td><td>" + result.getString("yor") + "</td><td>" + result.getString("rate_per_day_wod") + "</td><td>" + result.getString("rate_per_week_wod") + "</td><td>" + result.getString("rate_per_month_wod") + "</td><td>" + result.getString("excess_mileage_wod") + "</td><td>" + result.getString("rate_per_day_wd") + "</td><td>" + result.getString("excess_mileage_wd") + "</td></tr>");
            }
            }else{
                out.print("<tr><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td></tr>");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
