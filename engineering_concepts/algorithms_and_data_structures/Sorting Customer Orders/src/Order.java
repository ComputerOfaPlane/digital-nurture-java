public class Order{

    private String orderID;
    private String customerName;
    private double amount;

    Order(String id, String name, double amt){
        this.orderID = id;
        this.customerName = name;
        this.amount = amt;
    }

    public double getTotalPrice(){
        return amount;
    }

    public String display(){
        return "("+orderID+", "+customerName+", "+amount+" )";
    }
}