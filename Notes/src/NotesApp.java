import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        System.out.println("------Welcome to Note App------");
        boolean isRunning=true;
        Note note=new Note();
        while (isRunning){
            System.out.println("Operation: ");
            System.out.println("1. Add Note\n2. View Notes\n3. Delete Note\n4. Edit Note\n5. Exit");
            System.out.print("Enter your Choice: ");
            int choice= obj.nextInt();
            obj.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Enter Title: ");
                    String title= obj.nextLine();
                    System.out.print("Enter Content: ");
                    String content=obj.nextLine();
                    note.add(title,content);
                    break;
                case 2:
                    note.view();
                    break;
                case 3:
                    System.out.print("Enter Note number to delete: ");
                    int index= obj.nextInt();
                    note.delete(index);
                    break;
                case 4:
                    System.out.print("Enter Note number to Edit: ");
                    int index2= obj.nextInt();
                    obj.nextLine();
                    System.out.print("Enter new Title: ");
                    String newNote= obj.nextLine();
                    System.out.print("Enter new Content: ");
                    String newContent= obj.nextLine();
                    note.edit(index2,newNote,newContent);
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