package vrms.invoice.classes;

public class InvoiceBean {
     
    private String nic;
    private String start_date;
    private String end_date;
    private String category;
    private String make;
    private String model;
    private String driver;
    private float fee;
    private float start_mileage;
    private float end_mileage;
    private float total;
    private String status;
    private String vin;
    private String dl_no;
    String first_name;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getStart_mileage() {
        return start_mileage;
    }

    public void setStart_mileage(float start_mileage) {
        this.start_mileage = start_mileage;
    }

    public float getEnd_mileage() {
        return end_mileage;
    }

    public void setEnd_mileage(float end_mileage) {
        this.end_mileage = end_mileage;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public String getDl_no() {
        return dl_no;
    }

    public void setDl_no(String dl_no) {
        this.dl_no = dl_no;
    }
   
}
