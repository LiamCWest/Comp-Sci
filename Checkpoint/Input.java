package Checkpoint;

import java.text.NumberFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

class Input{
    public static void main(String[] args) {
        //Question 1
        Madlibs("There once was a person named __NAME__ who lived in __CITY__. At the age of __AGE__, __NAME__ went to college at __COLLEGE__. __NAME__ graduated and went to work as a __PROFESSION__. Then, __NAME__ adopted a(n) __ANIMAL__ named __PETNAME__. They both lived happily ever after!");

        //Question 2

        //Question 3
        // Items();
    }

    static void Madlibs(String story){
        for(int i = 0; i<story.length(); i++){
            Character c = story.charAt(i);
            if(c == '_'){
                String s = story.substring(i);
                int secondIndex = countedIndex(s, 1, "__", 0);
                String answer = JOptionPane.showInputDialog(s.substring(countedIndex(s, 0, "__", 0)+2, secondIndex), JOptionPane.QUESTION_MESSAGE);
                System.out.print(answer);
                i += secondIndex+1;
            }
            else{
                System.out.print(c);
            }
        }
        System.out.print("\n");
    }

    static Integer countedIndex(String s, int i, String n, int add){
        if(i == 0){
            return s.indexOf(n, add);
        }
        else{
            return countedIndex(s, i-1, n, s.indexOf(n, add)+1);
        }
    }

    //Question 3
    static void Items(){
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