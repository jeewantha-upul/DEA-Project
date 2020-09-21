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

        if (action.equals("Search Customer")) {
            request.setAttribute("nic", request.getParameter("nic"));
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice_1.jsp");
            dispatch.forward(request, response);
        } else if (action.equals("Search Vehicles")) {
            request.setAttribute("category", request.getParameter("category"));
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice_2.jsp");
            dispatch.forward(request, response);
        } else if (action.equals("Search Drivers")) {
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice_3.jsp");
            dispatch.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            InvoiceBean invoice = new InvoiceBean();
            InvoiceDAO dao = new InvoiceDAO();
            ResultSet rs;
            
            String action = request.getParameter("action");
            
            switch (action) {
                case "Add Customer":
                    String nic = request.getParameter("nic");
                    rs = dao.viewSpecificCustomer(nic);
                    invoice.setNic(rs.getString("nic"));
                    break;
                case "Add Vehicle":
                    String vin = request.getParameter("vin");
                    invoice.setVin(vin);
                    break;
                case "Add Driver":
                    String dl_no = request.getParameter("dl_no");
                    invoice.setDl_no(dl_no);
                    break;
                default:
                    break;
            }
            RequestDispatcher dispatch = request.getRequestDispatcher("web_content/invoice/new_invoice.jsp");
            dispatch.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
