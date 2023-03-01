package Functions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Functions {
    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q){
        //ask question
        System.out.print(q);
        //accept and return answer
        return sc.next();
    }

    //Function to print a heading/title in a fancy way
    static void TitlePrint(String title){
        //define and create a varible for the "*" that will be printed
        String stars = "";
        for(int i = 0; i<title.length()+12; i++){
            stars += "*";
        }
        //print title surounded by stars
        System.out.printf("\n%s\n*     %s     *\n%s\n", stars, title, stars);
    }

    //Function to count occurrences
    static int countOccurrences(int[] carray, int x){
        ArrayList<Integer> clist = new ArrayList<Integer>(Arrays.asList(Arrays.stream(carray).boxed().toArray( Integer[]::new )));;
        return Collections.frequency(clist, x);
    }

    //Function get the nth index of a substring in a string
    static Integer countedIndex(String s, int i, String n, int add){
        if(i == 0){
            return s.indexOf(n, add);
        }
        else{
            return countedIndex(s, i-1, n, s.indexOf(n, add)+1);
        }
    }
}
