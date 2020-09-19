package vrms.vehicle.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.vehicle.classes.VehicleBean;
import vrms.vehicle.classes.VehicleDAO;

public class AddVehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String make = request.getParameter("make");
        String model = request.getParameter("model");
        String yor = request.getParameter("yor");
        String vin = request.getParameter("vin");
        String serv_from = request.getParameter("serv_from");
        String category = request.getParameter("category");
        String rate_per_day_wod = request.getParameter("rate_per_day_wod");
        String rate_per_week_wod = request.getParameter("rate_per_week_wod");
        String rate_per_month_wod = request.getParameter("rate_per_month_wod");
        String excess_mileage_wod = request.getParameter("excess_mileage_wod");
        String rate_per_day_wd = request.getParameter("rate_per_day_wd");
        String excess_mileage_wd = request.getParameter("excess_mileage_wd");
        
        VehicleBean vehicle = new VehicleBean();
        
        vehicle.setMake(make);
        vehicle.setModel(model);
        vehicle.setYor(yor);
        vehicle.setVin(vin);
        vehicle.setServ_from(serv_from);
        vehicle.setCategory(category);
        vehicle.setRate_per_day_wod(rate_per_day_wod);
        vehicle.setRate_per_week_wod(rate_per_week_wod);
        vehicle.setRate_per_month_wod(rate_per_month_wod);
        vehicle.setExcess_mileage_wod(excess_mileage_wod);
        vehicle.setRate_per_day_wd(rate_per_day_wd);
        vehicle.setExcess_mileage_wd(excess_mileage_wd);
        
        VehicleDAO dao = new VehicleDAO();
        
        if (dao.insert(vehicle) != 0) {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Vehicle Added Successfully!');");
            out.println("location='web_content/vehicles/new_vehicle.jsp';");
            out.println("</script>");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('Something is Wrong! Please Check Again!');");
            out.println("location='web_content/vehicles/new_vehicle.jsp';");
            out.println("</script>");

        }

    }

}
