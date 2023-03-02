package Checkpoint;

import java.util.Scanner;

public class Quadrants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your points coordinates seperated by a comma");
        String coords = sc.nextLine();
        double x = Double.parseDouble(coords.substring(0, coords.indexOf(",")));
        double y = Double.parseDouble(coords.substring(coords.indexOf(",")+1));
        if(x*y > 0){
            if(y > 0){
                System.out.println("Your point is in the top right quadrant!");
            }
            else{
                System.out.println("Your point is in the bottom left quadrant!");
            }
        }
        else{
            if(y > 0){
                System.out.println("Your point is in the top left quadrant!");
            }
            else{
                System.out.println("Your point is in the bottom right quadrant!");
            }
        }
        sc.close();
    }
}
