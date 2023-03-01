package Checkpoint;
import java.text.NumberFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
class Input{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Question 1
        System.out.println("Question 1:");
        Madlibs("There once was a person named __NAME__ who lived in __CITY__. At the age of __AGE__, __NAME__ went to college at __COLLEGE__. __NAME__ graduated and went to work as a __PROFESSION__. Then, __NAME__ adopted a(n) __ANIMAL__ named __PETNAME__. They both lived happily ever after!");
        
        //Question 2
        System.out.println("\nQuestion 2:");
        Salary(sc);
        
        //Question 3
        System.out.println("\nQuestion 3:");
        Items(sc);
        
        //Question 4
        System.out.println("\nQuestion 4:");
        Stocks(600, 21.77, 2);
        
        //Question 5
        System.out.println("\nQuestion 5:");
        Issue();

        sc.close();
    }

    //Question 1
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

    //Question 2
    static void Salary(Scanner sc){
        System.out.println("Minimum Wage:");
        double wage = sc.nextDouble();
        System.out.println("Hours Worked");
        double hours = sc.nextDouble();
        NumberFormat money = NumberFormat.getCurrencyInstance();

        System.out.printf("The salary is %s\n", money.format(hours*wage));
    }

    //Question 3
    static void Items(Scanner sc){
        System.out.println("Enter the number of items purchased\nfollowed by the cost of one item.");
        int numItems = Integer.parseInt(sc.next());
        double itemCost = Double.parseDouble(sc.next());
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.printf("%1d items at %s each.\n", numItems, money.format(itemCost));
        System.out.printf("Total amount due %s.\nPlease take your merchandise.\n", money.format(itemCost*numItems));
        System.out.printf("Place %s in an envelope\nand slide it under the office door.\nThank you for using the self-service line.\n", money.format(itemCost*numItems));
    }
    
    //Question 4
    static void Stocks(int shares, double price, int commission){
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double totalCost = shares*price;
        double commissionFee = totalCost*((double) commission/100);
        System.out.printf("Amount paid for stock alone: %s\nCommission fee: %s\nTotal amount paid: %s\n", money.format(totalCost), money.format(commissionFee), money.format(commissionFee+totalCost));
    }
    
    //Question 5
    static void Issue(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your age.");
        int age = keyboard.nextInt();
        System.out.println("Enter your name.");
        // keyboard.nextLine() does not work, keyboard.next() is much better
        String name = keyboard.next();
        System.out.println(name + ",you are " + age + " years old.");
        keyboard.close();
    }
}