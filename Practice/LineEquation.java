package Practice;

import java.util.Scanner;

public class LineEquation {
    public static void main(String[] args) {
        Double[] pointOne = new Double[]{1d,2d};
        Double[] pointTwo = new Double[]{9d,5d};

        System.out.println(DistTwoPoints(pointOne, pointTwo));
        System.out.println(Yint(pointOne, pointTwo));
        System.out.println(Slope(pointOne, pointTwo));
    }

    static Double DistTwoPoints(Double[] pointOne, Double[] pointTwo){
        return Math.sqrt(Math.pow(pointOne[0]-pointTwo[0], 2)+Math.pow(pointOne[1]-pointTwo[1], 2));
    }

    static Double Yint(Double[] pointOne, Double[] pointTwo){
        return pointOne[0]-(Slope(pointOne, pointTwo)*pointOne[0]);
    }

    static Double Slope(Double[] pointOne, Double[] pointTwo){
        return (pointOne[1]-pointTwo[1])/(pointOne[0]-pointTwo[0]);
    }

    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q){
        //ask question
        System.out.print(q);
        //accept and return answer
        return sc.next();
    }
}