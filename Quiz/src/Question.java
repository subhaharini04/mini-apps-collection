public class Question {
    String question;
    String[] option;
    int index;

    public Question(String question, String[] option, int index) {
        this.question = question;
        this.option = option;
        this.index = index;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOption() {
        return option;
    }

    public void setOption(String[] option) {
        this.option = option;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void display(){
        System.out.println(question);
        for (String op:option){
            System.out.println(op);
        }
    }
}
