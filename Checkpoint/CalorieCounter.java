package Checkpoint;

import java.text.NumberFormat;
import java.util.Map;
import java.util.Scanner;

public class CalorieCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();

        Map<String, Map<String, Map<String, Double>>> menu = Map.of(
            "Burger", Map.of(
                "Cheeseburger", Map.of(
                    "Cost", 15.00,
                    "Cals", 461.00
                ),
                "Fish Burger", Map.of(
                    "Cost", 13.00,
                    "Cals", 431.00
                ),
                "Veggie Burger", Map.of(
                    "Cost", 16.50,
                    "Cals", 420.00
                )
            ),
            "Side Order", Map.of(
                "Fries", Map.of(
                    "Cost", 4.00,
                    "Cals", 100.00
                ),
                "Baked Potato", Map.of(
                    "Cost", 3.50,
                    "Cals", 57.00
                ),
                "Chef Salad", Map.of(
                    "Cost", 2.50,
                    "Cals", 70.00
                )
            ),
            "Drink", Map.of(
                "Soft Drink", Map.of(
                    "Cost", 3.50,
                    "Cals", 130.00
                ),
                "Orange Juice", Map.of(
                    "Cost", 3.25,
                    "Cals", 160.00
                ),
                "Milk", Map.of(
                    "Cost", 2.75,
                    "Cals", 118.00
                )
            ),
            "Dessert", Map.of(
                "Apple Pie", Map.of(
                    "Cost", 4.50,
                    "Cals", 167.00
                ),
                "Sundae", Map.of(
                    "Cost", 5.75,
                    "Cals", 266.00
                ),
                "Fruit Cup", Map.of(
                    "Cost", 1.75,
                    "Cals", 75.00
                )
            )
        );
        String[] menuOrder = new String[]{"Burger", "Side Order", "Drink", "Dessert"};

        TitlePrint("Welcome to Chip’s Fast Food Emporium");

        int cals = 0;
        Double cost = 0.0;
        for (String section : menuOrder){
            Object food = MenuListing(sc, menu.get(section), section);
            cals += (food != "no") ? menu.get(section).get(food).get("Cals") : 0;
            cost += (food != "no") ? menu.get(section).get(food).get("Cost") : 0;
            System.out.println(cost);
        }

        System.out.printf("\nYour total calorie count is %d\n", cals);
        System.out.printf("Your total bill is %s\n", money.format(cost));
    }

    static Object MenuListing(Scanner sc, Map<String, Map<String, Double>> menu, String section){
        System.out.printf("\nHere are the three %s choices:\n", section);
        int i = 1;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        for (Map<String, Double> food : menu.values()) {
            System.out.printf("%d - %s (%3.0f Calories) %s\n", i, menu.keySet().toArray()[i-1], food.get("Cals"), money.format(food.get("Cost")));
            i++;
        }
        
        System.out.printf("4 - no %s\n", section);
        int food = Integer.parseInt(Input(sc, "Please enter a " + section + " choise: "));
        return (food != 4) ? menu.keySet().toArray()[food-1] : "no";
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
}
