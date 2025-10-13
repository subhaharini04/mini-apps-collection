public class Question {
    String question;
    String[] option;
    int index;

    public Question(String question, String[] option, int index) {
        this.question = question;
        this.option = option;
        this.index = index;
    }

    public void display(){
        System.out.println(question);
        for (String op:option){
            System.out.println(op);
        }
    }
}
