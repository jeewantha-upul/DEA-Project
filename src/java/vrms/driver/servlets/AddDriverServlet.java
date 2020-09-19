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
public class AddDriverServlet extends HttpServlet {

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

        DriverBean driver = new DriverBean();

        driver.setFirst_name(first_name);
        driver.setLast_name(last_name);
        driver.setGender(gender);
        driver.setPhone_no(phone_no);
        driver.setEmail(email);
        driver.setNic(nic);
        driver.setDl_no(dl_no);
        driver.setDob(dob);
        driver.setAddress(address);

        DriverDAO dao = new DriverDAO();

        if (dao.insert(driver) != 0) {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Driver Added Successfully!');");
            out.println("location='web_content/drivers/new_driver.jsp';");
            out.println("</script>");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Something is Wrong! Please Check Again!');");
            out.println("location='web_content/drivers/new_driver.jsp';");
            out.println("</script>");

        }

    }

}
