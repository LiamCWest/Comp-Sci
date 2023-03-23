package Assessments;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class LabAssessment2Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TitlePrint("JET LAG CALCULATOR");

        TreeMap<Integer, Integer> departMap = new TreeMap<Integer, Integer>();
        departMap.put(9, 0);
        departMap.put(12, null);
        departMap.put(13, 1);
        departMap.put(18, null);
        departMap.put(19, 3);
        departMap.put(22, null);
        departMap.put(23, 4);
        departMap.put(1, null);
        departMap.put(2, 5);
        departMap.put(8, null);

        TreeMap<Integer, Integer> arriveMap = new TreeMap<Integer, Integer>();
        arriveMap.put(9, 4);
        arriveMap.put(12, null);
        arriveMap.put(13, 2);
        arriveMap.put(18, null);
        arriveMap.put(19, 0);
        arriveMap.put(22, null);
        arriveMap.put(23, 1);
        arriveMap.put(1, null);
        arriveMap.put(2, 3);
        arriveMap.put(8, null);


        int departTime[] = GetTime(sc, "depart");
        int arriveTime[] = GetTime(sc, "arive");
        int hours = arriveTime[1] - departTime[1];
        if(hours<0)
            hours+=24;
        int zones = Math.abs(arriveTime[2] - departTime[2]);
        int depart = mappedValue(departMap, departTime[0]);
        int arrive = mappedValue(arriveMap, arriveTime[0]);

        
        double daysOfRecovery = (hours/2 + (zones-3) + depart + arrive)/10;

        System.out.println(daysOfRecovery);
    }

    //Function to ask a question and return an answer
    static String Input(Scanner sc, String q){
        //ask question
        System.out.print(q);
        //accept and return answer
        return sc.next();
    }

    static int[] GetTime(Scanner sc, String side){
        String timeAndZone = Input(sc, "Enter " + side + "time, UTC time zone in brackets (no spaces):\n");
        int time = Integer.parseInt(timeAndZone.substring(0, timeAndZone.indexOf("(")));
        int zone = Integer.parseInt(timeAndZone.substring(timeAndZone.indexOf("(")+1, timeAndZone.indexOf(")")));
        int UTC = time+zone;
        if(UTC<0)
            UTC+=24;

        return new int[]{time, UTC, zone};
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

    private static <K, V> V mappedValue(TreeMap<K, V> map, K key) {
        Entry<K, V> e = map.floorEntry(key);
        if (e != null && e.getValue() == null) {
            e = map.lowerEntry(key);
        }
        return e == null ? null : e.getValue();
    }    
}
