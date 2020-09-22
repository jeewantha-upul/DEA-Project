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
public class AddInvoiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nic = request.getParameter("nic");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String phone_no = request.getParameter("phone_no");
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String vin = request.getParameter("vin");
        String driver_status = request.getParameter("driver_status");
        String dl_no = request.getParameter("dl_no");
        String start_mileage = request.getParameter("start_mileage");
        String total = request.getParameter("total");
        
        InvoiceBean invoice = new InvoiceBean();
        
        if((nic != null && !nic.isEmpty()) && (vin != null && !vin.isEmpty())){
            invoice.setNic(nic);
            invoice.setFirst_name(first_name);
            invoice.setLast_name(last_name);
            invoice.setPhone_no(phone_no);
            invoice.setStart_date(start_date);
            invoice.setEnd_date(end_date);
            invoice.setVin(vin);
            if(driver_status.equals("wod")){
                invoice.setDriver_status("Without Driver");
            }else{
                invoice.setDriver_status(dl_no);
            }
            invoice.setStart_mileage(start_mileage);
            invoice.setTotal(total);
            invoice.setEnd_mileage("Yet to Update");
            invoice.setPayment_status("Yet to Pay");
        }
        
        InvoiceDAO dao = new InvoiceDAO();
        
        if(dao.Insert(invoice) != 0){
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Invoice Added Successfully!');");
            out.println("location='web_content/invoice/new_invoice.jsp';");
            out.println("</script>");
        }else{
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Something went wrong! Try again!');");
            out.println("location='web_content/invoice/new_invoice.jsp';");
            out.println("</script>");
        }

    }

}
