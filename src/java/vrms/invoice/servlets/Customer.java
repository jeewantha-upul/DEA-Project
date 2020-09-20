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

public class Customer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            String nic = (String) request.getAttribute("nic");

            InvoiceDAO dao = new InvoiceDAO();
            ResultSet result = dao.viewSpecificCustomer(nic);

            if (result.isBeforeFirst()) {
                while (result.next()) {
                    out.print("<tr><td>" + result.getString("nic") + "</td><td>" + result.getString("first_name") + "</td><td>" + result.getString("last_name") + "</td><td>" + result.getString("phone_no") + "</td><td>" + result.getString("dl_no") + "</td><td>" + result.getString("address") + "</td></tr>");
                }
            } else {
                out.print("<tr><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td></tr>");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
