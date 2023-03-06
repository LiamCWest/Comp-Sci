package Checkpoint;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = Integer.parseInt(Input(sc, "Enter number of seconds "));

        int days = left / 86400;
        left = left % 86400;

        int hours = left / 3600;
        left = left % 3600;

        int minutes = left / 60;
        left = left % 60;

        System.out.printf("\nThat is %d days, %d hours, %d minutes, and %d seconds\n", days, hours, minutes, left);
    }

    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q){
        //ask question
        System.out.print(q);
        //accept and return answer
        return sc.next();
    }
}
