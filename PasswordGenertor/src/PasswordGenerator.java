import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        boolean isRunning=true;
        Operation op=new Operation();
        System.out.println("Welcome to Password Generator");
        while (isRunning){
            System.out.println("1. Generate Password\n2. Exit");
            System.out.print("Enter Your Choice: ");
            int choice=obj.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter the Length: ");
                    int len= obj.nextInt();
                    obj.nextLine();
                    System.out.print("Include uppercase? (y/n): ");
                    char up=obj.next().charAt(0);
                    boolean upper=(up=='y'||up=='Y');
                    System.out.print("Include lowercase? (y/n): ");
                    char low=obj.next().charAt(0);
                    boolean lower=(low=='y'||low=='Y');
                    System.out.print("Include numbers? (y/n): ");
                    char number=obj.next().charAt(0);
                    boolean num=(number=='y'||number=='Y');
                    System.out.print("Include special characters? (y/n): ");
                    char specl=obj.next().charAt(0);
                    boolean spl=(specl=='y'||specl=='Y');
                    op.generate(len,upper,lower,num,spl);
                    break;
                case 2:
                    isRunning=false;
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Enter Correct choice");
                    break;
            }
        }
    }
}
