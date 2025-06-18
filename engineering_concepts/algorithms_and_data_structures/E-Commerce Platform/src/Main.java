import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products = ");
        int n = sc.nextInt();

        sc.nextLine();

        Ecommerce obj = new Ecommerce(n,sc);

        System.out.println();

        do{
            System.out.print("Do you want to:\n0. Exit\n1. Binary Search\n2. Linear Search\n3. Display the products\nEnter : ");
            int choice = sc.nextInt();

            if(choice==0) break;

            String id;

            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the ID to be searched = ");
                    id = sc.nextLine();
                    if(!obj.getisSorted()) obj.sort();
                    obj.binarySearch(id);
                    break;
            
                case 2:
                    System.out.print("Enter the ID to be searched = ");
                    id = sc.nextLine();
                    obj.linearSearch(id);
                    break;

                default:
                    obj.displayArray();
                    break;
            }

            System.out.println();

        }while(true);

        sc.close();

        System.out.println();
    }
}
