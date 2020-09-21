/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.customer.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.customer.classes.CustomerBean;
import vrms.customer.classes.CustomerDAO;

/**
 *
 * @author LENOVO
 */
public class UpdateDeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String nic = request.getParameter("nic");
        CustomerDAO dao = new CustomerDAO();
        CustomerBean customer = new CustomerBean();
        PrintWriter out = response.getWriter();

        if (nic.equals("") || nic.equals("null")) {

            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('NIC can not be empty!');");
            out.println("location='web_content/customers/update_customer.jsp';");
            out.println("</script>");

        } else {

            if (action.equals("Update")) {

                String new_first_name = request.getParameter("first_name");
                String new_last_name = request.getParameter("last_name");
                String new_gender = request.getParameter("gender");
                String new_phone_no = request.getParameter("phone_no");
                String new_email = request.getParameter("email");
                String new_nic = request.getParameter("nic1");
                String new_dl_no = request.getParameter("dl_no");
                String new_dob = request.getParameter("dob");
                String new_address = request.getParameter("address");

                dao.viewSpecific(customer, nic);

                if (new_first_name != null && !new_first_name.isEmpty()) {
                    customer.setFirst_name(new_first_name);
                }
                if (new_last_name != null && !new_last_name.isEmpty()) {
                    customer.setLast_name(new_last_name);
                }
                if (new_gender != null && !new_gender.isEmpty()) {
                    customer.setGender(new_gender);
                }
                if (new_phone_no != null && !new_phone_no.isEmpty()) {
                    customer.setPhone_no(new_phone_no);
                }
                if (new_email != null && !new_email.isEmpty()) {
                    customer.setEmail(new_email);
                }
                if (new_nic != null && !new_nic.isEmpty()) {
                    customer.setNic(new_nic);
                }
                if (new_dl_no != null && !new_dl_no.isEmpty()) {
                    customer.setDl_no(new_dl_no);
                }
                if (new_dob != null && !new_dob.isEmpty()) {
                    customer.setDob(new_dob);
                }
                if (new_address != null && !new_address.isEmpty()) {
                    customer.setAddress(new_address);
                }  

                if (dao.update(customer, nic) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Customer Updated Successfully!');");
                    out.println("location='web_content/customers/update_customer.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Customer could not be Updated! Try Again!');");
                    out.println("location='web_content/customers/update_customer.jsp';");
                    out.println("</script>");
                }

            } else if (action.equals("Delete")) {

                if (dao.delete(nic) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('User Deleted Successfully!');");
                    out.println("location='web_content/customers/update_customer.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Something went wrong! Please Try Again!');");
                    out.println("location='web_content/users/update_customer.jsp';");
                    out.println("</script>");
                }

            }

        }
        
    }

}
