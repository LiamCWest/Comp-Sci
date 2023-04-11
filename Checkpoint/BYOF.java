package Checkpoint;
import java.util.Scanner;

public class BYOF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String choice = "";
        while(!(choice.equals("0"))){
            choice = Input(sc, "Which question do you want to run? (0 to exit) ", false);
            switch (choice) {
                case "0":
                    System.out.println("Goodbye");
                    break;
                case "1":
                    Question1(sc);
                    break;
                case "2":
                    Question2(sc);
                    break;
                case "3":
                    Question3(sc);
                    break;
                case "4":
                    Question4(sc);
                    break;
                case "5":
                    Question5(sc);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    //Question 1
    public static void Question1(Scanner sc){
        String name = Input(sc, "What is your name? ", true);
        for (int i = 0; i < 2; i++) {
            Line1();
        }
        Line2(name);
        Line1();
    }

    public static void Line1() {
        System.out.println("Happy Birthday to you!");
    }

    public static void Line2(String name) {
        System.out.printf("Happy Birthday dear %s!%n", name);
    }

    //Question 2
    public static void Question2(Scanner sc){
        //Calculate tax
        double price = Double.parseDouble(Input(sc, "Enter the price of the item: ", false));
        double tax = Double.parseDouble(Input(sc, "Enter the tax rate: ", false));
        double total = price + (price * tax);
        System.out.printf("The total price is $%.2f%n", total);
    }

    //Question 3
    public static void Question3(Scanner sc){
        //Mark conversion
        //Chose to go from levels to percentage or the other way around
        String choice = Input(sc, "Do you want to convert from levels to percentage or the other way around? ", false);
        if(choice.equalsIgnoreCase("levels")){
            //Convert from levels to percentage
            String level = Input(sc, "Enter the level: ", false);
            int percentage = 0;
            switch (level) {
                case "R":
                    percentage = 0;
                    break;
                case "1-":
                    percentage = 50;
                    break;
                case "1+":
                    percentage = 55;
                    break;
                case "2-":
                    percentage = 60;
                    break;
                case "2+":
                    percentage = 65;
                    break;
                case "3-": 
                    percentage = 70;
                    break;
                case "3+":
                    percentage = 75;
                    break;
                case "4-":
                    percentage = 80;
                    break;
                case "4+":
                    percentage = 90;
                    break;
                default:
                    System.out.println("Invalid level");
                    break;
            }
            System.out.printf("The percentage is %d%n", percentage);
        } else if(choice.equalsIgnoreCase("percentage")){
            //Convert from percentage to levels
            int percentage = Integer.parseInt(Input(sc, "Enter the percentage: ", false));
            String level = "";
            if(percentage < 50)
                level = "R";
            else if(percentage < 55)
                level = "1-";
            else if(percentage < 60)
                level = "1+";
            else if(percentage < 65)
                level = "2-";
            else if(percentage < 70)
                level = "2+";
            else if(percentage < 75)
                level = "3-";
            else if(percentage < 80)
                level = "3+";
            else if(percentage < 90)
                level = "4-";
            else
                level = "4+";
            System.out.printf("The level is %s%n", level);
        } else {
            System.out.println("Invalid choice");
        }
    }
    
    //Question 4
    public static void Question4(Scanner sc){
        //Phone list
        String name = PhoneList(sc);
        System.out.println(name);
    }

    //Phone list
    public static String PhoneList(Scanner sc){
        String firstName = Input(sc, "Enter the name: ", false);
        String lastName = sc.next();
        return lastName + ", " + firstName;
    }

    //Question 5
    public static void Question5(Scanner sc){
        int num = Integer.parseInt(Input(sc, "Enter a number: ", false));
        if(checkPrime(num))
            System.out.println("The number is prime");
        else
            System.out.println("The number is not prime");
    }

    //Check if number is prime
    public static Boolean checkPrime(int num){
        if (num > 1){
            for (int i = 2; i < num; i++) {
                if(num % i == 0)
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q, Boolean lineOrNext){
        //ask question
        System.out.print(q);
        //accept and return answer
        if(lineOrNext)
            return sc.nextLine();
        else
            return sc.next();
    }
}
