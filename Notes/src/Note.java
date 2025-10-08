import java.io.*;
import java.util.ArrayList;

class setOfNote {
  String title;
  String content;

    public setOfNote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String toString(){
        return title + " : "+ content;
    }
}

public class Note{
    public void add(String title,String content){
        if(title.isEmpty()|| content.isEmpty()){
            System.out.println("Title or content cannot be empty");
            return;
        }
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("Notes.txt",true))){
            writer.write(title+" | "+content);
            writer.newLine();
        }catch (IOException e){
            System.out.println("Error in adding");
            e.printStackTrace();
        }
        System.out.println("Added");
        view();
    }

    public void view(){
        try(BufferedReader reader=new BufferedReader(new FileReader("Notes.txt"))) {
           String line;
           boolean found=false;
           int count=1;
           while((line=reader.readLine())!=null){
               found=true;
               System.out.println(count+". "+line);
           }
           if(!found) System.out.println("No notes found");
        }catch (IOException e){
            System.out.println("Error in Showing Notes");
        }
    }

    public void delete(int index){
        ArrayList<String> list=new ArrayList<>();
       try(BufferedReader reader=new BufferedReader(new FileReader("Notes.txt"))) {
           String line;
           while ((line=reader.readLine())!=null){
               list.add(line);
           }
       }catch (IOException e){
           e.printStackTrace();
       }
        if (list.isEmpty()) {
            System.out.println("No notes to delete");
            return;
        }
        if(index<=0 || index>list.size()) {
            System.out.println("Index is invalid");
            return;
        }
        list.remove(index-1);
       try(BufferedWriter writer=new BufferedWriter(new FileWriter("Notes.txt",false))) {
         for(int i=0;i< list.size();i++){
             writer.write(list.get(i));
             writer.newLine();
         }
       }catch (IOException e){
           e.printStackTrace();
       }
       view();
    }

    public void edit(int index,String note,String content){
        ArrayList<String> list=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader("Notes.txt"))) {
            String line;
            while ((line=reader.readLine())!=null){
                list.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            System.out.println("No notes to edit");
            return;
        }

        if(index<=0 || index> list.size()) {
            System.out.println("Index is invalid");
            return;
        }
        list.set(index-1,note+" | "+content);
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("Notes.txt",false))) {
            for(int i=0;i< list.size();i++){
                writer.write(list.get(i));
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        view();
    }

}