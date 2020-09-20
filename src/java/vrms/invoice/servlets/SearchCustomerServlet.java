package vrms.invoice.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.invoice.classes.InvoiceBean;

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
        }else if(action.equals("Add Customer")){
            String nic = request.getParameter("nic");
            invoice.setNic(nic);
            
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
}
