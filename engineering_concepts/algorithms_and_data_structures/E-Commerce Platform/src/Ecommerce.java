import java.util.Arrays;
import java.util.Scanner;

public class Ecommerce {
    
    private Product product[];
    private int size;
    private boolean isSorted;
    private Scanner sc;

    public Ecommerce(int n, Scanner c){
        this.size = n;
        this.isSorted = false;
        this.sc = c;
        this.product = new Product[size];

        for(int i=0; i<size; ++i) product[i] = inputProduct(sc);
    }

    public void linearSearch(String id){
        for(int i=0; i<size; ++i){
            if(id.equals(product[i].getID())){
                System.out.print("Product found :=" + product[i].displayInformation());
                System.out.println();
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void binarySearch(String id){
        int left = 0, right = size-1;
        while(left<=right){
            int mid = (right + left) / 2;
            int compare = product[mid].getID().compareTo(id);
            if(compare == 0){
                System.out.print("Product found :=" + product[mid].displayInformation());
                System.out.println();
                return;
            }
            if(compare < 0) left = mid + 1;
            else right = mid - 1;
        }
        System.out.println("Product not found");
    }

    private Product inputProduct(Scanner sc){
        System.out.println();
        System.out.print("Enter the product's ID = ");
        String id = sc.nextLine();
        System.out.print("Enter the product's name = ");
        String name = sc.nextLine();
        System.out.print("Enter the product category = ");
        String category = sc.nextLine();
        return new Product(id, name, category);
    }

    public void displayArray(){
        System.out.print("\n{ " + product[0].displayInformation());
        for(int i=1; i<size; ++i) System.out.print(", " + product[i].displayInformation());
        System.out.println(" }");
    }

    public void sort(){
        isSorted = true;
        Arrays.sort(product, (a,b)->a.getID().compareTo(b.getID()));
    }

    public boolean getisSorted(){
        return isSorted;
    }
}