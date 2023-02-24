//Lab Assessment 1
//Liam West
//2023-02-24

package Assessments;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LabAssessment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<String>> items = Arrays.asList(Arrays.asList("strawbarry", "5"), Arrays.asList("eggplant", "2"), Arrays.asList("flowers", "1"), Arrays.asList("pumpkin", "2"), Arrays.asList("saybean", "3"));

        List<List<String>> amounts = ListItems(items, sc);
        Bill(amounts, items, sc);
    }

    static List<List<String>> ListItems(List<List<String>> items, Scanner sc){
        List<List<String>> amounts = new ArrayList<>();

        TitlePrint("Welcome to My Farm Stall");
        System.out.println("\nEnter the amount of each thing you would like to buy.");

        for(int i = 0; i<items.size(); i++){
            String item = items.get(i).get(0);
            String itemP = item.charAt(item.length()-1) == 'y' ? item.substring(0, item.length()-1) + "ies" : item + "s";
            String amount = Input(sc, Integer.toString(i + 1)+". How many " + itemP + " would you like? ");
            amounts.add(Arrays.asList(item, amount));
        }

        return amounts;
    }

    static void Bill(List<List<String>> amounts, List<List<String>> items, Scanner sc){
        TitlePrint("Food Bill");
        int total = 0;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        for(int i = 0; i<amounts.size(); i++){
            List<String> item = amounts.get(i);
            int cost = Integer.valueOf(item.get(1)) * Integer.valueOf(items.get(i).get(1));
            total += cost;
            System.out.println(item.get(1) + " " + item.get(0) + " @ $" +items.get(i).get(1) + " = " + money.format(cost));
        }
        Double tax = total * 0.13;
        System.out.printf("\nSubtotal: %s\nTax: %s\nTotal: %s\n", money.format(total), money.format(tax), money.format(tax+total));
        int paid = Integer.valueOf(Input(sc, "Enter the amount of money paid: $"));
        System.out.printf("Your change is %s\n", money.format(paid-(total+tax)));
    }

    static String Input(Scanner sc, String q){
        System.out.print(q);
        return sc.next();
    }

    static void TitlePrint(String title){
        String stars = "";
        for(int i = 0; i<title.length()+12; i++){
            stars += "*";
        }
        System.out.printf("\n%s\n*     %s     *\n%s\n", stars, title, stars);
    }
}
