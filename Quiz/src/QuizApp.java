import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.println("Welcome to Quiz App");
        boolean isRunning=true;
        Operation op=new Operation();
        op.loadQuest();
        while (isRunning){
            System.out.println("1. Start Quiz\n2. View High Score\n3. Exit");
            System.out.print("Enter Your Choice: ");
            int choice= obj.nextInt();
            obj.nextLine();
            switch(choice){
                case 1:
                    System.out.print("Enter UserName: ");
                    String name= obj.nextLine();
                    op.startQuiz(name);
                    break;
                case 2:
                    op.highScore();
                    break;
                case 3:
                    System.out.println("Thank You");
                    isRunning=false;
                    break;
                default:
                    System.out.println("Enter Correct Choice");
                    break;
            }
        }
    }
}
