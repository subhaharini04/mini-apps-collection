import java.security.SecureRandom;

public class Operation {
    public void generate(int length,boolean upper,boolean lower,boolean num,boolean special){
        SecureRandom secure=new SecureRandom();
        String lower1 = "abcdefghijklmnopqrstuvwxyz";
        String upper1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()-_=+";
        StringBuilder combined=new StringBuilder();
        if(upper){
           combined.append(upper1);
        }
        if(lower){
            combined.append(lower1);
        }
        if (num){
            combined.append(numbers);
        }
        if (special){
            combined.append(symbols);
        }
StringBuilder password=new StringBuilder();
        for (int i=0;i<length;i++){
            int index= secure.nextInt(combined.length());
            char c=combined.charAt(index);
            password.append(c);
        }
        System.out.println(password.toString());
    }
}
