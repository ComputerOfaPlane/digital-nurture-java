public class Product{

    private String productId;
    private String productName;
    private int quantity;
    private double price;

    Product(String id, String name, int qty, double amt){
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = amt;
    }

    public void setName(String s){
        this.productName = s;
    }
    public String getName(){
        return productName;
    }

    public void setQuantity(int q){
        this.quantity = q;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setPrice(double d){
        this.price = d;
    }
    public double getPrice(){
        return price;
    }

    public String getId(){
        return productId;
    }

    public String displayProduct(){
        return "{ id=" + productId + ", name=" + productName+", quantity="+quantity+", price="+price+" }";
    }
}