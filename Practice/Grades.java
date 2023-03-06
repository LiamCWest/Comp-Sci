package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitlePrint("Average");
        
        int students = Integer.parseInt(Input(sc, "How many students are there? "));
        System.out.printf("Enter the grades for the %d students.\n\n", students);

        double[] marks = new double[students];
        for(int i = 0; i < students; i++){
            marks[i] = Double.parseDouble(Input(sc, "What is student #" + (i+1) + "'s mark? "));
        }

        System.out.printf("\nThere are %d student in the class\nThe average mark was %3.2f%%\n", students, Average(marks));
    }

    public static double Average(double[] array) {
        return Arrays.stream(array).average().orElse(Double.NaN);
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
}
