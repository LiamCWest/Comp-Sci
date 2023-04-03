package Checkpoint;

import java.lang.Math;

public class Doubles {
    public static void main(String[] args) {
        System.out.println("How many rolls until you get doubles?");

        int[] dice = new int[]{(int)(Math.random()*5)+1, (int)(Math.random()*5)+1};
        int rolls = 1;
        System.out.printf("Roll %d: %d, %d\n", rolls, dice[0], dice[1]);
        while(dice[0] != dice[1]){
            rolls++;
            dice = new int[]{(int)(Math.random()*5)+1, (int)(Math.random()*5)+1};
            System.out.printf("Roll %d: %d, %d\n", rolls, dice[0], dice[1]);
        }
        System.out.printf("You have got doubles in %d roll(s)\n",rolls);

    }
}
