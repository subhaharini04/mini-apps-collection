import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.println("------Welcome to Todo------");
        boolean isRunning=true;
        while (isRunning){
            Task task=new Task();
            System.out.println("Operation: ");
            System.out.println("1. Add Task\n2. View Task\n3. Delete Task\n4. Mark Task Completed\n5. Exit");
            System.out.print("Enter your Choice: ");
            int choice= obj.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Task Name: ");
                    String tsk= obj.nextLine();
                    task.add();
                    break;
                case 2:
                    task.view();
                    break;
                case 3:
                    task.delete();
                    break;
                case 4:
                    task.complete();
                    break;
                case 5:
                    isRunning=false;
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Enter correct choice");
                    break;
            }
        }
    }
}
