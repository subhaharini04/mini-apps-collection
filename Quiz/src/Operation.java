import java.util.*;

public class Operation {
    List<Question> quest=new ArrayList<>();
    HashMap<String,Integer> scoreBoard=new HashMap<>();
    Scanner obj=new Scanner(System.in);
    Question q;
    int score=0;
    public void loadQuest(){
        quest.add(new Question(
                "Which language is used for Android app development?",
                new String[]{"1. Python", "2. Java", "3. C++", "4. Ruby"},
                2
        ));

        quest.add(new Question(
                "What does CPU stand for?",
                new String[]{"1. Central Processing Unit", "2. Computer Primary Unit", "3. Control Program Unit", "4. Central Program Unit"},
                1
        ));

        quest.add(new Question(
                "Which data structure uses FIFO order?",
                new String[]{"1. Stack", "2. Queue", "3. Tree", "4. Graph"},
                2
        ));
    }
    public void startQuiz(String name){
        score=0;
       for (Question question:quest){
           question.display();
           System.out.print("Enter the correct option(1-4): ");
           int ans=obj.nextInt();
           while(ans>4){
               System.out.print("Enter the correct option in between 1 to 4:");
               ans= obj.nextInt();
           }
           if(ans==question.index){
               score++;
               System.out.println("Correct Answer");
           }else {
               System.out.println("Wrong Answer");
           }
       }
        System.out.println("Final Score: "+ score);
       scoreBoard.put(name,score);
    }
    public void highScore(){
        List<Map.Entry<String,Integer>> list=new ArrayList<>(scoreBoard.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        System.out.printf("%-5s | %-15s | %s%n", "Rank","UserName", "Score");
        System.out.println("---------------------------");
        int rank=1;
        for (Map.Entry<String,Integer> entry : list) {
            System.out.printf("%-5s | %-15s | %d%n", rank,entry.getKey(), entry.getValue());
            rank++;
    }
    }
}
