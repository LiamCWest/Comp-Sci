package Practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Paint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitlePrint("Welcome to the Paint Store!");

        System.out.println("\nYou've got walls!\nWe've got paint!\n");

        double width = Double.parseDouble(Input(sc, "What is width of the wall in m? "));
        double height = Double.parseDouble(Input(sc, "What is height of the wall in m? "));
        double area = width*height;
        double cans = area/4;

        System.out.printf("\nThe surface you wish to paint is %3.2f m^2.\nThat means you need %3.2f cans of paint.\n\n", area, cans);

        TotalPrint(cans*17.5, true);
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

    //Function to print a total cost, with taxes if needed
    static void TotalPrint(double total, boolean tax){
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double taxes = 0;
        if(tax){
            taxes = total*0.13;
            System.out.printf("Sub-total: %s\nTax: %s\n", money.format(total), money.format(taxes));
        }
        System.out.printf("Total: %s\n", money.format(total+taxes));
    }
}
