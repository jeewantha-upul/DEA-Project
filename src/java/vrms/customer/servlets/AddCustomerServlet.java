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
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String phone_no = request.getParameter("phone_no");
        String email = request.getParameter("email");
        String nic = request.getParameter("nic");
        String dl_no = request.getParameter("dl_no");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");

        CustomerBean customer = new CustomerBean();

        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setGender(gender);
        customer.setPhone_no(phone_no);
        customer.setEmail(email);
        customer.setNic(nic);
        customer.setDl_no(dl_no);
        customer.setDob(dob);
        customer.setAddress(address);

        CustomerDAO dao = new CustomerDAO();

        if (dao.insert(customer) != 0) {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Customer Added Successfully!');");
            out.println("location='web_content/customers/new_customer.jsp';");
            out.println("</script>");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Something is Wrong! Please Check Again!');");
            out.println("location='web_content/customers/new_customer.jsp';");
            out.println("</script>");

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
