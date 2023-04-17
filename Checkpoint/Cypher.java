package Checkpoint;
import java.util.Scanner;

public class Cypher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = Input(sc, "Enter phrase to be shifted: ", true);
        int shift = Integer.parseInt(Input(sc, "Enter shift amount: ", false));

        System.out.println(Caesar(input, shift));
    }

    public static String Caesar(String s, int shift){
        String result = "";
        for(Character c : s.toCharArray()){result += (char)(c + shift);}
        return result;
    }

    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q, Boolean lineOrNext){
        //ask question
        System.out.print(q);
        //accept and return answer
        if(lineOrNext)
            return sc.nextLine();
        else
            return sc.next();
    }
}
