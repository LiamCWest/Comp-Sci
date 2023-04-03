package Checkpoint;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SpeedLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<Integer, Integer> speedMap = new TreeMap<Integer, Integer>();
        speedMap.put(1, 100);
        speedMap.put(20, null);
        speedMap.put(21, 270);
        speedMap.put(30, null);
        speedMap.put(31, 500);
        speedMap.put(2147483647, null);

        char run = 'y';
        
        while(run == 'y'){
            int limit = Integer.parseInt(Input(sc, "Enter the speed limit: "));
            int speed = Integer.parseInt(Input(sc, "Enter the recorded speed of the car: "));

            if(speed<=limit){
                System.out.println("Congratualtions, you are within the speed limit!");
            }
            else{
                System.out.printf("You are speeding and your fine is $%d\n", mappedValue(speedMap, speed-limit));
            }

            run = Input(sc, "Continue? (y/n) ").charAt(0);

        }
        
    }

    //Function to ask a question and return an answerEnter the speed limit
    static String Input(Scanner sc, String q){
        //ask question
        System.out.print(q);
        //accept and return answer
        return sc.next();
    }

    private static <K, V> V mappedValue(TreeMap<K, V> map, K key) {
        Entry<K, V> e = map.floorEntry(key);
        if (e != null && e.getValue() == null) {
            e = map.lowerEntry(key);
        }
        return e == null ? null : e.getValue();
    }    
}
