import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main obj = new Main();
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.print("\nEnter Principal amount = ");
        double principal = sc.nextDouble();
        System.out.print("Enter interest Rate = ");
        double rate = sc.nextDouble();
        System.out.print("Enter the number of years = ");
        int years = sc.nextInt();

        sc.close();

        double futureValue = obj.futureValue(principal, rate, years);

        System.out.println("\nFuture Value = " + df.format(futureValue));
        System.out.println();

    }
    public double futureValue(double principal, double rate, int years){
        if(years==0) return principal;
        double interest = (principal * rate)/100.0;
        return futureValue(principal + interest, rate, years-1);
    }
}
