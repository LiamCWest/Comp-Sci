package Practice;

import java.util.Scanner;
import java.util.Arrays;

public class LineEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TitlePrint("Equation of a Line Calculator");

        double[] pointOne = Arrays.stream(Input(sc, "Enter the first point: ").split(",")).mapToDouble(Double::valueOf).toArray();
        double[] pointTwo = Arrays.stream(Input(sc, "Enter the second point: ").split(",")).mapToDouble(Double::valueOf).toArray();

        System.out.printf("Distance between the points: %3.2f\n", DistTwoPoints(pointOne, pointTwo));
        System.out.printf("Y intercept of the line: %3.2f\n", Yint(pointOne, pointTwo));
        System.out.printf("Slope of the line: %3.2f\n", Slope(pointOne, pointTwo));
    }

    static double DistTwoPoints(double[] pointOne, double[] pointTwo){
        return Math.sqrt(Math.pow(pointOne[0]-pointTwo[0], 2)+Math.pow(pointOne[1]-pointTwo[1], 2));
    }

    static double Yint(double[] pointOne, double[] pointTwo){
        return pointOne[0]-(Slope(pointOne, pointTwo)*pointOne[0]);
    }

    static double Slope(double[] pointOne, double[] pointTwo){
        return (pointOne[1]-pointTwo[1])/(pointOne[0]-pointTwo[0]);
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