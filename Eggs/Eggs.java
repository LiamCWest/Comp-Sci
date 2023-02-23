package Eggs;

import java.util.Scanner;
import java.lang.Math;

public class Eggs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many eggs?");
        int eggs = sc.nextInt();
        System.out.printf("That is %d crate(s), %d carton(s), and %d egg(s) leftover.\n", (int) Math.floor(eggs/180), (int) Math.floor((eggs%180)/12), (int) Math.floor((eggs%180)%12));
        sc.close();
    }
}
