import java.time.LocalDate;

public class Order {

    private int orderNo;

    private LocalDate orderDate;
    private double orderAmount;

    private Commissioned commissioned;

    Order(int orderNo , double orderAmount ,LocalDate orderDate, Commissioned commissioned){
        this.orderNo = orderNo;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.commissioned = commissioned;
        commissioned.addOrders(this);

    }


    public Commissioned getCommissioned() {
        return commissioned;
    }

    public void setCommissioned(Commissioned commissioned) {
        this.commissioned = commissioned;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
}
