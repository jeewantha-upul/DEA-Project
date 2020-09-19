/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrms.driver.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.driver.classes.DriverBean;
import vrms.driver.classes.DriverDAO;

/**
 *
 * @author PAVANI
 */
public class UpdateDeleteDriverServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String dl_no = request.getParameter("dl_no");
        DriverDAO dao = new DriverDAO();
        DriverBean driver = new DriverBean();
        PrintWriter out = response.getWriter();

        if (dl_no.equals("") || dl_no.equals("null")) {

            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Driver License Number can not be empty!');");
            out.println("location='web_content/drivers/update_driver.jsp';");
            out.println("</script>");

        } else {

            if (action.equals("Update")) {

                String new_first_name = request.getParameter("first_name");
                String new_last_name = request.getParameter("last_name");
                String new_gender = request.getParameter("gender");
                String new_phone_no = request.getParameter("phone_no");
                String new_email = request.getParameter("email");
                String new_nic = request.getParameter("nic");
                String new_dob = request.getParameter("dob");
                String new_address = request.getParameter("address");

                dao.viewSpecific(driver, dl_no);

                if (new_first_name != null && !new_first_name.isEmpty()) {
                    driver.setFirst_name(new_first_name);
                }
                if (new_last_name != null && !new_last_name.isEmpty()) {
                    driver.setLast_name(new_last_name);
                }
                if (new_gender != null && !new_gender.isEmpty()) {
                    driver.setGender(new_gender);
                }
                if (new_phone_no != null && !new_phone_no.isEmpty()) {
                    driver.setPhone_no(new_phone_no);
                }
                if (new_email != null && !new_email.isEmpty()) {
                    driver.setEmail(new_email);
                }
                if (new_nic != null && !new_nic.isEmpty()) {
                    driver.setNic(new_nic);
                }
                if (new_dob != null && !new_dob.isEmpty()) {
                    driver.setDob(new_dob);
                }
                if (new_address != null && !new_address.isEmpty()) {
                    driver.setAddress(new_address);
                }

                if (dao.update(driver, dl_no) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Driver Updated Successfully!');");
                    out.println("location='web_content/drivers/update_driver.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('User could not be Updated! Try Again!');");
                    out.println("location='web_content/drivers/update_driver.jsp';");
                    out.println("</script>");
                }

            } else if (action.equals("Delete")) {

                if (dao.delete(dl_no) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Driver Deleted Successfully!');");
                    out.println("location='web_content/drivers/update_driver.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Something went wrong! Please Try Again!');");
                    out.println("location='web_content/drivers/update_driver.jsp';");
                    out.println("</script>");
                }

            }

        }
        
    }

}
