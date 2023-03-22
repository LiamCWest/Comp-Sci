package Assessments;

import java.util.Scanner;

public class LabAssessment2Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitlePrint("TIRE PRESSURE CALCULATOR");

        String[] FB = new String[]{"front", "rear"};
        String[] LR = new String[]{"right", "left"};
        int[] pressure = new int[4];
        boolean goodPressure = true;

        for(int i = 0; i < 2; i++){
            for(int n = 0; n < 2; n++){
                int index = Integer.parseInt(Integer.toString(i)+Integer.toString(n), 2);
                pressure[index] = Integer.parseInt(Input(sc, "Input " + LR[n] + " " + FB[i] + " pressure\n"));
                if(pressure[index] > 45 || pressure[index] < 35){
                    System.out.println("Warning: pressure is out of range");
                    goodPressure = false;
                }
            }
        }

        if(pressure[0] == pressure[1] && pressure[2] == pressure[3] && goodPressure){
            System.out.println("Inflation is OK");
        }
        else{
            System.out.println("Inflation is BAD");
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
}