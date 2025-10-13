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

        quest.add(new Question(
                "Which company developed the Java programming language?",
                new String[]{"1. Microsoft", "2. Sun Microsystems", "3. Google", "4. IBM"},
                2
        ));

        quest.add(new Question(
                "Which of the following is a NoSQL database?",
                new String[]{"1. MySQL", "2. Oracle", "3. MongoDB", "4. PostgreSQL"},
                3
        ));
    }
    public void startQuiz(String name){
       for (Question question:quest){
           question.display();
           System.out.print("Enter the correct option(1-4): ");
           int ans=obj.nextInt();
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
    for (Map.Entry<String,Integer> value:scoreBoard.entrySet()){
        System.out.println(value.getKey()+" "+value.getValue());
    }
    }
}
