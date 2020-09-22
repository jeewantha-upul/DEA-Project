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

/**
 *
 * @author Jeewantha
 */
public class ViewInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            InvoiceDAO dao = new InvoiceDAO();
            ResultSet result = dao.view();
            if (result.isBeforeFirst()) {
                while (result.next()) {
                    out.print("<tr><td>" + result.getString("invoice_id") + "</td><td>" + result.getString("nic") + "</td><td>" + result.getString("first_name") + "</td><td>" + result.getString("last_name") + "</td><td>" + result.getString("phone_no") + "</td><td>" + result.getString("vin") + "</td><td>" + result.getString("start_mileage") + "</td><td>" + result.getString("end_mileage") + "</td><td>" + result.getString("driver_status") + "</td><td>" + result.getString("resv_date") + "</td><td>" + result.getString("resv_until") + "</td><td>" + result.getString("total") + "</td><td>" + result.getString("pay_status") + "</td></tr>");
                }
            } else {
                out.print("<tr><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td></tr>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewInvoiceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
