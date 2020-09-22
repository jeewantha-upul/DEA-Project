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
                String new_nic = request.getParameter("nic");
                String new_first_name = request.getParameter("first_name");
                String new_last_name = request.getParameter("last_name");
                String new_phone_no = request.getParameter("phone_no");
                String new_start_date = request.getParameter("start_date");
                String new_end_date = request.getParameter("end_date");
                String new_vin = request.getParameter("vin");
                String new_driver_status = request.getParameter("driver_status");
                String new_dl_no = request.getParameter("dl_no");
                String new_start_mileage = request.getParameter("start_mileage");
                String new_end_mileage = request.getParameter("end_mileage");
                String new_total = request.getParameter("total");
                String new_pay_status = request.getParameter("pay_status");

                dao.viewSpecific(invoice, invoice_id);

                if (new_nic != null && !new_nic.isEmpty()) {
                    invoice.setNic(new_nic);
                }
                if (new_first_name != null && !new_first_name.isEmpty()) {
                    invoice.setFirst_name(new_first_name);
                }
                if (new_last_name != null && !new_last_name.isEmpty()) {
                    invoice.setLast_name(new_last_name);
                }
                if (new_phone_no != null && !new_phone_no.isEmpty()) {
                    invoice.setPhone_no(new_phone_no);
                }
                if (new_start_date != null && !new_start_date.isEmpty()) {
                    invoice.setStart_date(new_start_date);
                }
                if (new_end_date != null && !new_end_date.isEmpty()) {
                    invoice.setEnd_date(new_end_date);
                }
                if (new_vin != null && !new_vin.isEmpty()) {
                    invoice.setVin(new_vin);
                }
                if (new_driver_status.equals("wd")) {
                    invoice.setDriver_status(new_dl_no);
                } else if (new_driver_status.equals("wod")) {
                    invoice.setDriver_status("Without Driver");
                }
                if (new_start_mileage != null && !new_start_mileage.isEmpty()) {
                    invoice.setStart_mileage(new_start_mileage);
                }
                if (new_end_mileage != null && !new_end_mileage.isEmpty()) {
                    invoice.setEnd_mileage(new_end_mileage);
                }
                if (new_total != null && !new_total.isEmpty()) {
                    invoice.setTotal(new_total);
                }
                if (new_pay_status != null && !new_pay_status.isEmpty()) {
                    invoice.setPayment_status(new_pay_status);
                }

                if (dao.update(invoice, invoice_id) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Invoice Updated Successfully!');");
                    out.println("location='web_content/invoice/update_invoice.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Invoice could not be Updated! Try Again!');");
                    out.println("location='web_content/invoice/update_invoice.jsp';");
                    out.println("</script>");
                }

            } else if (action.equals("Delete")) {

                if (dao.delete(invoice_id) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Invoice Deleted Successfully!');");
                    out.println("location='web_content/invoice/update_invoice.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Something went wrong! Please Try Again!');");
                    out.println("location='web_content/invoice/update_invoice.jsp';");
                    out.println("</script>");
                }

            }
        }
    }

}
