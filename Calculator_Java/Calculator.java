import java.util.Scanner;

public class Calculator{
    public static void main(String args[]){
        Scanner obj=new Scanner(System.in);
        System.out.println("------Welcome to Calculator------");
        boolean isExit=true;
        while(isExit){
            System.out.println("Operations:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulos\n" +
                    "6. Power\n7. Exit ");
            System.out.print("Enter your Choice: ");
            int choice= obj.nextInt();
            int num1=0,num2=0;
            if(choice<7) {
                System.out.print("Enter num1: ");
                num1 = obj.nextInt();
                System.out.print("Enter num2: ");
                num2 = obj.nextInt();
            }
            switch (choice){
                case 1:
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 + num2));
                   break;
                case 2:
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 * num2));
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 / num2));
                    }
                    break;
                case 5:
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 % num2));
                    break;
                case 6:
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + Math.pow(num1,num2));
                    break;
                case 7:
                    System.out.println("Exiting");
                    isExit=false;
                    break;
                default:
                    System.out.println("Enter Correct Choice");
                    break;
            }
        }
        System.out.println("------Thank You------");
    }
}