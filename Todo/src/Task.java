import java.util.ArrayList;

class setOfTask {
    String task;
    boolean isCompleted;
    int priority;

    setOfTask(String task,int priority) {
        this.task = task;
        this.isCompleted = false;
        this.priority=priority;
    }
}

public class Task{
    ArrayList<setOfTask> listOfTask=new ArrayList<>();

    public void add(String tsk,int priority){
        setOfTask task1=new setOfTask(tsk,priority);
        listOfTask.add(task1);
    }

    public void view(){
        listOfTask.sort((a, b) -> Integer.compare(a.priority, b.priority));
        if(listOfTask.isEmpty()){
            System.out.println("No Task Available!");
        }
        for (int i=0;i<listOfTask.size();i++){
            setOfTask t=listOfTask.get(i);
            String pText = switch (t.priority) {
                case 1 -> "High";
                case 2 -> "Medium";
                case 3 -> "Low";
                default -> "Unknown";
            };
            String status=t.isCompleted ? "[✓]":"[ ]";
            System.out.println((i+1)+" "+status+" "+t.task+" "+ pText);
        }
    }
    public void delete(int index){
        if(index<=0 || index>listOfTask.size()){
            System.out.println("Invalid task number");
            return;
        }
        listOfTask.remove(index-1);
        System.out.println("Deleted Successfully");
        view();
    }

    public void complete(int index){
        if(index<=0 || index>listOfTask.size()){
            System.out.println("Invalid task number");
            return;
        }
        listOfTask.get(index-1).isCompleted=true;
        System.out.println("Task Completed Successfully");
        view();
    }

    public void edit(int index,String newTask,int newPriority){
        if(index<=0 || index>listOfTask.size()){
            System.out.println("Invalid task number");
            return;
        }
        listOfTask.get(index-1).task=newTask;
        listOfTask.get(index-1).priority=newPriority;
        System.out.println("Task Edited Successfully");
        view();
    }
}
