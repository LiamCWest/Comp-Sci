package Checkpoint;
import java.util.Scanner;

public class Builtin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Question 1
        System.out.println("Question 1");
        System.out.println(getLongestString(Input(sc, "Enter first word: ", false), Input(sc, "Enter second word: ", false)));

        //Question 2
        System.out.println("Question 2");
        String wordOne = Input(sc, "Enter first word: ", false);
        String wordTwo = Input(sc, "Enter second word: ", false);

        if(wordOne.compareTo(wordTwo) < 0)
            System.out.println(wordOne + " comes before " + wordTwo);
        else if(wordOne.compareTo(wordTwo) > 0)
            System.out.println(wordTwo + " comes before " + wordOne);
        else
            System.out.println("The words are the same");

        //Question 3 and 4
        System.out.println("Question 3 and 4");
        String name = Input(sc, "Enter your name: ", false);
        System.out.println("Your name in reverse is: " + reverseString(name));
        if(isPalindrome(name))
            System.out.println("Your name is a palindrome");
        else
            System.out.println("Your name is not a palindrome");

        //Question 5
        System.out.println("\nQuestion 5");
        String sentence = Input(sc, "Enter a sentence: ", true);
        int spaces = sentence.replaceAll("[^ ]", "").length();
        System.out.println("There are " + (spaces + 1) + " words in the sentence");

        //a
        System.out.println("\na");
        String word = Input(sc, "Enter a word: ", false);
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                System.out.println("The first vowel is " + word.charAt(i) + " and it is in position " + (i+1));
                break;
            }
        }

        //Question 6
        System.out.println("\nQuestion 6");
        String phrase = Input(sc, "Enter a phrase: ", true);
        phrase = phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("The phrase in reverse is: " + reverseString(phrase));
        if(isPalindrome(phrase))
            System.out.println("The phrase is a palindrome");
        else
            System.out.println("The phrase is not a palindrome");
    }

    private static String reverseString(String name) {
        //Reverse the string
        String reversed = "";
        for(int i = name.length() - 1; i >= 0; i--)
            reversed += name.charAt(i);
        return reversed;
    }

    private static boolean isPalindrome(String name) {
        //Check if string is a palindrome
        if(name.equals(reverseString(name)))
            return true;
        else
            return false;
    }

    //Function to get the longest of two strings
    public static String getLongestString(String s1, String s2) {
        if(s1.length() > s2.length())
            return s1;
        else
            return s2;
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
