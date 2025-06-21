import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private HashMap<String, Product> map;

    public static void main(String[] args) {
        System.err.println();

        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        String id, name; int qty; double amt;
        outer: do{
            System.err.print("\nEnter:\n0. Exit\n1. To add a product\n2. To delete a product\n3. To update a product\n4. To display all The products\nEnter: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 0:
                    break outer;

                case 1:
                    System.err.print("Enter Id = ");
                    id = sc.nextLine();
                    System.err.print("Enter Name = ");
                    name = sc.nextLine();
                    System.err.print("Enter Quantity = ");
                    qty = sc.nextInt();
                    System.err.print("Enter Price = ");
                    amt = sc.nextDouble();
                    obj.addProduct(id, name, qty, amt);
                    System.err.println();
                    break;

                case 2:
                    System.err.print("Enter Id = ");
                    id = sc.nextLine();
                    obj.delete(id);
                    break;

                case 3:
                    System.err.print("Enter ID = ");
                    id = sc.nextLine();
                    System.err.print("What do you want to update?\n1. ALL\n2. Name\n3. Quantity\n4. Price\n");
                    choice: do{
                        System.err.print("Enter your choice : ");
                        int updatechoice = sc.nextInt();
                        sc.nextLine();
                        switch (updatechoice) {
                            case 1:
                                System.err.print("Enter Name = ");
                                name = sc.nextLine();
                                System.err.print("Enter Quantity = ");
                                qty = sc.nextInt();
                                System.err.print("Enter Price = ");
                                amt = sc.nextDouble();
                                obj.update(id, name, qty, amt);
                                break choice;

                            case 2:
                                System.err.print("Enter Name = ");
                                name = sc.nextLine();
                                obj.update(id, name);
                                break choice;

                            case 3:
                                System.err.print("Enter Quantity = ");
                                qty = sc.nextInt();
                                obj.update(id, qty);
                                break choice;

                            case 4:
                                System.err.print("Enter Price = ");
                                amt = sc.nextDouble();
                                obj.update(id, amt);
                                break choice;
                        
                            default:
                                System.err.println("Invalid updation, Try again");
                                break;
                        }
                    }while(true);
                    break;

                case 4:
                    obj.displayALL();
                    break;

                default:
                    System.err.println("Invalid choice");
                    break;
            }
        }while(true);
        sc.close();
    }

    Main(){
        map = new HashMap<>();
    }

    private void displayALL(){
        System.err.println("\n{");
        for(String key:map.keySet()) System.err.println("\t"+map.get(key).displayProduct());
        System.err.println("}\n");
    }

    private boolean addProduct(String id, String name, int qty, double amt){

        if(map.containsKey(id)){
            System.err.println("Product with this ID already exsist, try a different product ID");
            return false;
        }
        
        map.put(id, new Product(id, name, qty, amt));

        return true;

    }

    private boolean delete(String id){

        if(!map.containsKey(id)){
            System.err.println("Product with this ID does not exsist, try a different product ID");
            return false;
        }

        map.remove(id);

        return true;
    }

    private boolean update(String id, String name, int qty, double amt){

        if(!map.containsKey(id)){
            System.err.println("Product with this ID does not exsist, try a different product ID");
            return false;
        }

        map.get(id).setName(name);
        map.get(id).setQuantity(qty);
        map.get(id).setPrice(amt);
        
        return true;
    }

    private boolean update(String id, String name){

        if(!map.containsKey(id)){
            System.err.println("Product with this ID does not exsist, try a different product ID");
            return false;
        }

        map.get(id).setName(name);
        
        return true;
    }

    private boolean update(String id, int qty){

        if(!map.containsKey(id)){
            System.err.println("Product with this ID does not exsist, try a different product ID");
            return false;
        }

        map.get(id).setQuantity(qty);
        
        return true;
    }

    private boolean update(String id, double amt){

        if(!map.containsKey(id)){
            System.err.println("Product with this ID does not exsist, try a different product ID");
            return false;
        }

        map.get(id).setPrice(amt);
        
        return true;
    }
}
