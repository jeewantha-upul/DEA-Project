package vrms.invoice.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.invoice.classes.InvoiceBean;
import vrms.invoice.classes.InvoiceDAO;

public class SearchCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equals("Search")) {
            String nic = request.getParameter("nic");

            try {
                InvoiceBean invoice = new InvoiceBean();
                InvoiceDAO dao = new InvoiceDAO();

                ResultSet result = dao.viewSpecificCustomer(invoice, nic);

                if (result.next()) {
                    do {
                        request.setAttribute("first_name", result.getString("first_name"));
                        request.setAttribute("last_name", result.getString("last_name"));
                        request.setAttribute("nic", result.getString("nic"));
                        request.setAttribute("dl_no", result.getString("dl_no"));
                        request.setAttribute("address", result.getString("address"));
                        request.setAttribute("phone_no", result.getString("phone_no"));
                    } while (result.next());
                } else {
                    request.setAttribute("first_name", "N/A");
                    request.setAttribute("last_name", "N/A");
                    request.setAttribute("nic", "N/A");
                    request.setAttribute("dl_no", "N/A");
                    request.setAttribute("address", "N/A");
                    request.setAttribute("phone_no", "N/A");
                }

            } catch (SQLException ex) {
                Logger.getLogger(SearchCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("web_content/invoice/new_invoice.jsp").forward(request, response);
        }else if(action.equals("Search Vehicles")){
            request.setAttribute("category", request.getParameter("category"));
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice_2.jsp");
            dispatch.forward(request, response);
        }

    }

}
