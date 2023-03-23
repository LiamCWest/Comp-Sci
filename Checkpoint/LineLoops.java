package Checkpoint;
import java.util.Scanner;

public class LineLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitlePrint("Welcome to Lines!");

        for(int i = 1; i < 6; i++){
            System.out.println(Line(Input(sc, "\nWhat character would you like for line #" + i + "? ").charAt(0), Integer.parseInt(Input(sc, "How many would you like? "))));
        }
    }

    static String Line(Character c, int i){
        return new String(new char[i]).replace('\0', c);
    }

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
}