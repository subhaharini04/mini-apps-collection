import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.print("Enter the place: ");
        String place= obj.nextLine();
        WeatherOp op=new WeatherOp();

        op.view(place);
    }
}
