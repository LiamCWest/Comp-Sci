package Checkpoint;
import java.util.Scanner;
public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitlePrint("Welcome to the Square Making Program");

        int dimension = Integer.parseInt(Input(sc, "\nWhat dimension of square? (-1 to quit) "));
        while(dimension != -1){
            for(int i = 0; i < dimension; i++){
                System.out.println(new String(new char[dimension]).replace('\0', '*'));
            }
            dimension = Integer.parseInt(Input(sc, "\nWhat dimension of square? (-1 to quit) "));
        }
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

    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q){
        //ask question
        System.out.print(q);
        //accept and return answer
        return sc.next();
    }

    static String Line(Character c, int i){
        return new String(new char[i]).replace('\0', c);
    }
}
