package Assignments;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Lab2 {
    public static void main(String[] args) {
        //init scanner
        Scanner sc = new Scanner(System.in);

        //Question 1
        TitlePrint("Question 1 - Product of Three Numbers");
        Product(sc);

        //Queston 2
        TitlePrint("Question 2 - Speed Fines");
        Speed(sc);

        //Quetion 3
        TitlePrint("Question 3 - Computer Store");
        Computer(sc);

        //Question 4
        TitlePrint("BONUS - Question 4 - Yahtze");
        Yahtze(sc);
    }

    //Question 1
    static void Product(Scanner sc){
        //Get inputs
        Double x = Double.parseDouble(Input(sc, "x: "));
        Double y = Double.parseDouble(Input(sc, "y: "));
        Double z = Double.parseDouble(Input(sc, "z: "));
        Double product = Double.parseDouble(Input(sc, "Product: "));
        //Check if the user is correct
        if(x*y*z == product){
            System.out.println("You are correct!");
        }
        else{
            System.out.println("You are incorrect");
        }
    }
    
    //Question 2
    static void Speed(Scanner sc){
        //Get input speed
        Double speed = Double.parseDouble(Input(sc, "Speed: "));
        //Check what fine range the speed falls into
        if(speed <= 100d){
            System.out.println("There is no fine");
        }
        else if(speed <= 120){
            System.out.println("Fine is $80.00");
        }
        else if(speed <= 130){
            System.out.println("Fine is $150.00");
        }
        else if(speed <= 140){
            System.out.println("Fine is $300.00");
        }
        else{
            System.out.println("Fine is $500.00");
        }
    }

    //Question 3
    static void Computer(Scanner sc){
        //take ram and hdd size inputs
        int ram = Integer.parseInt(Input(sc, "RAM size: "));
        int hdd = Integer.parseInt(Input(sc, "Hard drive size: "));
        //list of prices
        List<List<Double>> prices = Arrays.asList(Arrays.asList(599.99, 649.99, 999.99), Arrays.asList(799.50, 899.99, 1229.99));
        //list of possible hdd sizes
        List<Integer> hddSizes = Arrays.asList(160, 320);
        //list of possible ram sizes
        List<Integer> ramSizes = Arrays.asList(2, 4, 8);
        //money format
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.printf("Cost: %s\n", money.format(prices.get(hddSizes.indexOf(hdd)).get(ramSizes.indexOf(ram))));
    }

    //Question 4
    static void Yahtze(Scanner sc){
        //dice roll
        int[] dice = new int[5];
        int[] numNums = new int[]{0, 0, 0, 0, 0, 0};
        for (int i = 0; i < dice.length; i++){
            dice[i] = (int)(Math.random()*6)+1;
            numNums[dice[i]-1] += 1;
        }

        System.out.println(Arrays.toString(dice));

        if(IntStream.of(numNums).anyMatch(x -> x == 5)){
            System.out.println("YAHTZE!!");
        }
        else if(IntStream.of(numNums).anyMatch(x -> x == 4)){
            System.out.println("Four Of A Kind!");
        }
        else if(IntStream.of(numNums).anyMatch(x -> x == 3)){
            if(IntStream.of(numNums).anyMatch(x -> x == 2)){
                System.out.println("Full House!");
            }
            else{
                System.out.println("Three of a Kind!");
            }
        }
        else if((countOccurrences(numNums, 1) == 5) && (numNums[0] == 0|| numNums[5] == 0)){
            System.out.println("Large Straight!");
        }
        else if((countOccurrences(numNums, 0) < 3 && ((numNums[0] == 0 && numNums[1] == 0) || (numNums[4] == 0 && numNums[5] == 0)))){
            System.out.println("Small Straight!");
        }
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

    // Function to count occurrences
    static int countOccurrences(int[] carray, int x){
        ArrayList<Integer> clist = new ArrayList<Integer>(Arrays.asList(Arrays.stream(carray).boxed().toArray( Integer[]::new )));;
        return Collections.frequency(clist, x);
    }
}