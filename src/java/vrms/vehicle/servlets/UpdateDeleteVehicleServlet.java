package vrms.vehicle.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vrms.vehicle.classes.VehicleBean;
import vrms.vehicle.classes.VehicleDAO;

public class UpdateDeleteVehicleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String vin = request.getParameter("vin");
        VehicleDAO dao = new VehicleDAO();
        VehicleBean vehicle = new VehicleBean();
        PrintWriter out = response.getWriter();

        if (vin.equals("") || vin.equals("null")) {

            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("window.alert('VIN can not be empty!');");
            out.println("location='web_content/vehicles/update_vehicle.jsp';");
            out.println("</script>");

        } else {

            if (action.equals("Update")) {

                String new_make = request.getParameter("make");
                String new_model = request.getParameter("model");
                String new_yor = request.getParameter("yor");
                String new_vin = request.getParameter("vin1");
                String new_serv_from = request.getParameter("serv_from");
                String new_category = request.getParameter("category");
                String new_rate_per_day_wod = request.getParameter("rate_per_day_wod");
                String new_rate_per_week_wod = request.getParameter("rate_per_week_wod");
                String new_rate_per_month_wod = request.getParameter("rate_per_month_wod");
                String new_excess_mileage_wod = request.getParameter("excess_mileage_wod");
                String new_rate_per_day_wd = request.getParameter("rate_per_day_wd");
                String new_excess_mileage_wd = request.getParameter("excess_mileage_wd");

                dao.viewSpecific(vehicle, vin);

                if (new_make != null && !new_make.isEmpty()) {
                    vehicle.setMake(new_make);
                }
                if (new_model != null && !new_model.isEmpty()) {
                    vehicle.setModel(new_model);
                }
                if (new_yor != null && !new_yor.isEmpty()) {
                    vehicle.setYor(new_yor);
                }
                if(new_vin != null && !new_vin.isEmpty()){
                    vehicle.setVin(new_vin);
                }
                if (new_serv_from != null && !new_serv_from.isEmpty()) {
                    vehicle.setServ_from(new_serv_from);
                }
                if(!new_category.equals("null")){
                    vehicle.setCategory(new_category);
                }
                if (new_rate_per_day_wod != null && !new_rate_per_day_wod.isEmpty()) {
                    vehicle.setRate_per_day_wod(new_rate_per_day_wod);
                }
                if (new_rate_per_week_wod != null && !new_rate_per_week_wod.isEmpty()) {
                    vehicle.setRate_per_week_wod(new_rate_per_week_wod);
                }
                if (new_rate_per_month_wod != null && !new_rate_per_month_wod.isEmpty()) {
                    vehicle.setRate_per_month_wod(new_rate_per_month_wod);
                }
                if (new_excess_mileage_wod != null && !new_excess_mileage_wod.isEmpty()) {
                    vehicle.setExcess_mileage_wd(new_excess_mileage_wd);
                }
                if (new_rate_per_day_wd != null && !new_rate_per_day_wd.isEmpty()) {
                    vehicle.setRate_per_day_wd(new_rate_per_day_wd);
                }
                if (new_excess_mileage_wd != null && !new_excess_mileage_wd.isEmpty()) {
                    vehicle.setExcess_mileage_wd(new_excess_mileage_wd);
                }

                if (dao.update(vehicle, vin) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Vehicle Updated Successfully!');");
                    out.println("location='web_content/vehicles/update_vehicle.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Vehicle could not be Updated! Try Again!');");
                    out.println("location='web_content/vehicles/update_vehicle.jsp';");
                    out.println("</script>");
                }

            } else if (action.equals("Delete")) {

                if (dao.delete(vin) != 0) {

                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Vehicle Deleted Successfully!');");
                    out.println("location='web_content/vehicles/update_vehicle.jsp';");
                    out.println("</script>");

                } else {
                    response.setContentType("text/html");
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Something went wrong! Please Try Again!');");
                    out.println("location='web_content/vehicles/update_vehicle.jsp';");
                    out.println("</script>");
                }

            }

        }

    }

}
