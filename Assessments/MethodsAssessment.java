package Assessments;

import java.util.Arrays;
import java.util.Scanner;

public class MethodsAssessment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int uPoint = 0, cPoint = 0;
        String playAgain = "y";
        while (playAgain.charAt(0) == 'y'){
            char user = userChoice(sc);
            System.out.println ("You have selected " + user);
            char comp = compChoice();
            System.out.println("The computer has selected " + comp);
            char win = winner(new String[]{Character.toString(user), Character.toString(comp)});
            if (win == 'c'){
                cPoint++;
                System.out.println ("\nThe computer wins!");
            }
            else if (win == 'u'){
                uPoint++;
                System.out.println ("\nYou win!");
            }
            else{
                System.out.println ("\nThere is a tie!");
            }
            System.out.println("Points: You: " + uPoint + " Computer: " +cPoint);
            if(win != 'b'){
                System.out.println("\nPlay again? (y/n) ");
                playAgain = Character.toString(sc.next().charAt(0));
            }
            else
                playAgain = "y";
            System.out.println("");
        }
        System.out.println("Goodbye!");
    }

    public static boolean isValid (String c){
        /* TO DO: Finish the if. it needs to check P and S too.
        return true if valid, false otherwise
        */
        if(c.equalsIgnoreCase("Rock")|| c.equalsIgnoreCase("R") || c.equalsIgnoreCase("Scissors") || c.equalsIgnoreCase("S") || c.equalsIgnoreCase("Paper") || c.equalsIgnoreCase("P"))
            return true;
        else
            return false;
    }

    public static char userChoice(Scanner sc){ 
        System.out.println("Rock Paper or Scissors");
        System.out.println("Choice? (r/p/s)");
        String pick = sc.next();
        while(!isValid(pick)){
            System.out.println("Choice? (r/p/s)");
            pick = sc.next();
        }
        return pick.toLowerCase().charAt(0);
    }

    public static char compChoice (){
        String choices = "rps";
        int index = (int)(Math.random()*3);
        return choices.charAt(index);
    }

    public static char winner (String[] choices){ 
        //Parameter info: comp and user both hold one of r, s, p
        //returns c for computer, u for user and b for both
        if(Arrays.stream(choices).anyMatch("s"::equals) && Arrays.stream(choices).anyMatch("r"::equals)){
            return (choices[1].equals("r")) ? 'c' : 'u';
        } else if(Arrays.stream(choices).anyMatch("s"::equals) && Arrays.stream(choices).anyMatch("p"::equals)){
            return (choices[1].equals("s")) ? 'c' : 'u';
        }else if(Arrays.stream(choices).anyMatch("r"::equals) && Arrays.stream(choices).anyMatch("p"::equals)){
            return (choices[1].equals("p")) ? 'c' : 'u';
        }else
            return 'b';
    }
}