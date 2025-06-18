public class Product {

    private String productID;
    private String productName;
    private String category;

    public Product(String id, String name, String group){
        this.productID = id;
        this.productName = name;
        this.category = group;
    }

    public String displayInformation(){
        return "(" + productID + ", " + productName + ", " + category + ")";
    }

    public String getID(){
        return productID;
    }

    public String getName(){
        return productName;
    }

    public String getCategory(){
        return category;
    }
}
