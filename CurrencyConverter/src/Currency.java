import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        Convertor con=new Convertor();
        System.out.print("Enter the Country/Currency (eg. India/IND) : ");
        String country= obj.nextLine();
        System.out.print("Enter the Amount to change: ");
        double amount= obj.nextDouble();
        obj.nextLine();
        System.out.print("Enter the Country/Currency to Convert from "+country+": ");
        String country1= obj.nextLine();
        double total=con.convert(country,country1,amount);
        System.out.println(amount + " " + country + " = " + total + " " + country1);

    }
}
