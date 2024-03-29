package FinalProject.antermakan.models;

public class Order {
    private String order_stall;
    private String order_list;
    private String total;
    private String status;

    public Order(String order_stall, String order_list, String total, String status) {
        this.order_stall = order_stall;
        this.order_list = order_list;
        this.total = total;
        this.status = status;
    }

    public String getOrder_stall() {
        return order_stall;
    }

    public void setOrder_stall(String order_stall) {
        this.order_stall = order_stall;
    }

    public String getOrder_list() {
        return order_list;
    }

    public void setOrder_list(String order_list) {
        this.order_list = order_list;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
