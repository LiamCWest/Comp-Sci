package Checkpoint;
import java.util.Scanner;

public class Builtin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Question 1
        System.out.println("Question 1");
        System.out.println(getLongestString(Input(sc, "Enter first word: "), Input(sc, "Enter second word: ")));
    }

    //Function to get the longest of two strings
    public static String getLongestString(String s1, String s2) {
        if(s1.length() > s2.length())
            return s1;
        else
            return s2;
    }

    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q){
        //ask question
        System.out.print(q);
        //accept and return answer
        return sc.next();
    }
}
