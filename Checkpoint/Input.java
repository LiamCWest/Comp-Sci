package Checkpoint;

import java.text.NumberFormat;
import java.util.Scanner;

class Input{
    public static void main(String[] args) {
        //Question 3
        System.out.println("Enter the number of items purchased\nfollowed by the cost of one item.");
        Scanner sc = new Scanner(System.in);
        String items = sc.nextLine();
        int numItems = Integer.parseInt(items.substring(0, items.indexOf(" ")));
        double itemCost = Double.parseDouble(items.substring(items.indexOf(" ")));
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.printf("%1d items at %s each.\n", numItems, money.format(itemCost));
        System.out.printf("Total amount due %s.\nPlease take your merchandise.\n", money.format(itemCost*numItems));
        System.out.printf("Place %s in an envelope\nand slide it under the office door.\nThank you for using the self-service line.\n", money.format(itemCost*numItems));
        sc.close();
    }
}