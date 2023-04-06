package Functions;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Functions {
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

    //Function to count occurrences
    static int countOccurrences(int[] carray, int x){
        ArrayList<Integer> clist = new ArrayList<Integer>(Arrays.asList(Arrays.stream(carray).boxed().toArray( Integer[]::new )));;
        return Collections.frequency(clist, x);
    }

    //Function get the nth index of a substring in a string
    static Integer countedIndex(String s, int i, String n, int add){
        if(i == 0){
            return s.indexOf(n, add);
        }
        else{
            return countedIndex(s, i-1, n, s.indexOf(n, add)+1);
        }
    }

    //Function to print a total cost, with taxes if needed
    static void TotalPrint(double total, boolean tax){
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double taxes = 0;
        if(tax){
            taxes = total*0.13;
            System.out.printf("Sub-total: %s\nTax: %s\n", money.format(total), money.format(taxes));
        }
        System.out.printf("Total: %s", money.format(total+taxes));
    }

    static String Line(Character c, int i){
        return new String(new char[i]).replace('\0', c);
    }

    private static <K, V> V mappedValue(TreeMap<K, V> map, K key) {
        Entry<K, V> e = map.floorEntry(key);
        if (e != null && e.getValue() == null) {
            e = map.lowerEntry(key);
        }
        return e == null ? null : e.getValue();
    }

    //Function to get the longest of two strings
    public static String getLongestString(String s1, String s2) {
        if(s1.length() > s2.length())
            return s1;
        else
            return s2;
    }
}
