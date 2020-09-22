package vrms.dashboard.servlets;

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
import vrms.dashboard.classes.DashboardDAO;

/**
 *
 * @author Jeewantha
 */
public class ViewDashCusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            DashboardDAO dao = new DashboardDAO();
            ResultSet result = dao.viewCustomer();
            if (result.isBeforeFirst()) {
                while (result.next()) {
                    out.print("<tr><td>" + result.getString("first_name") + "</td><td>" + result.getString("phone_no") + "</td><td>" + result.getString("address") + "</td><td>" + result.getString("email") + "</td><td>" + result.getString("nic") + "</td></tr>");
                }
            } else {
                out.print("<tr><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td><td>N/A</td></tr>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewDashCusServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
