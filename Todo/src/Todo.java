import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.println("------Welcome to Todo------");
        boolean isRunning=true;
        Task task=new Task();
        while (isRunning){
            System.out.println("Operation: ");
            System.out.println("1. Add Task\n2. View Task\n3. Delete Task\n4. Mark Task Completed\n5. Edit Task\n6. Exit");
            System.out.print("Enter your Choice: ");
            int choice= obj.nextInt();
            obj.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Enter task Name: ");
                    String tsk= obj.nextLine();
                    System.out.println("Priority:\n1. High\n2. Mid\n3. Low");
                    System.out.print("Enter priority: ");
                    int priority=obj.nextInt();
                    obj.nextLine();
                    task.add(tsk,priority);
                    break;
                case 2:
                    task.view();
                    break;
                case 3:
                    System.out.print("Enter task number to delete: ");
                    int index= obj.nextInt();
                    task.delete(index);
                    break;
                case 4:
                    System.out.print("Enter task number to Complete: ");
                    int index1= obj.nextInt();
                    task.complete(index1);
                    break;
                case 5:
                    System.out.print("Enter task number to Edit: ");
                    int index3= obj.nextInt();
                    obj.nextLine();
                    System.out.print("Enter new task name: ");
                    String newTask= obj.nextLine();
                    System.out.println("Priority:\n1. High\n2. Mid\n3. Low");
                    System.out.print("Enter priority: ");
                    int priority1=obj.nextInt();
                    obj.nextLine();
                    task.edit(index3,newTask,priority1);
                    break;
                case 6:
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
