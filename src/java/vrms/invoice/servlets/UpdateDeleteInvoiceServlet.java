package vrms.invoice.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.invoice.classes.InvoiceBean;
import vrms.invoice.classes.InvoiceDAO;

/**
 *
 * @author Jeewantha
 */
public class UpdateDeleteInvoiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String invoice_id = request.getParameter("invoice_id");
        InvoiceBean invoice = new InvoiceBean();
        InvoiceDAO dao = new InvoiceDAO();
        PrintWriter out = response.getWriter();

        if (invoice_id.equals("") || invoice_id.equals("null")) {

            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Invoice ID can not be empty!');");
            out.println("location='web_content/invoice/update_invoice.jsp';");
            out.println("</script>");

        } else {
            if (action.equals("Update")) {

            }
        }
    }

}
