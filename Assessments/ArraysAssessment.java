package Assessments;

import java.io.*;
import java.util.Arrays;

public class ArraysAssessment {
    public static void main(String[] args) throws Exception {
        //read in the file and display error message if the file is not found
        File rainFile = new File("/home/archiso/Code/Java/Comp Sci/Assessments/Monthly Precipitation.txt");
        if (!rainFile.exists()) {
            System.out.println("File not found");
            System.exit(0);
        }
        BufferedReader br = new BufferedReader(new FileReader(rainFile));

        //store the data in arrays
        Double[] rain = new Double[Integer.parseInt(br.readLine())];
        String[] months = new String[rain.length];
        for (int i = 0; i < rain.length; i++) {
            months[i] = br.readLine();
            rain[i] = Double.parseDouble(br.readLine());
        }
        
        //sort the the months array based on the values in the rain array
        String[] sortedMonths = Arrays.asList(BubbleSort(rain, months)).toArray(new String[months.length]);
        for(int i = 0; i < sortedMonths.length; i++){
            System.out.println(sortedMonths[i] + Line(' ', 12-sortedMonths[i].length()) + rain[Arrays.asList(months).indexOf(sortedMonths[i])]);
        }
        System.out.println("\nTotal" + Line(' ', 7) + sum(rain) + "\nAverage" + Line(' ', 5) + sum(rain)/rain.length);

        //ask for a month and print the corresponding value
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nWhat month would you like to search for?");
        String month = br2.readLine();
        System.out.println(String.valueOf(month.toLowerCase().charAt(0)).toUpperCase() + month.toLowerCase().substring(1) + Line(' ', 12-month.length()) + Search(months, rain, month));
        
        //close the readers
        br.close();
        br2.close();
    }

    public static Object[] BubbleSort(Double[] arr, Object[] months){
        //bubble sort using arr as the index and sorting the corresponding values in the months array and returning the sorted months array
        int n = arr.length;
        Double temp = 0.0;
        String temp2 = "";
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    temp2 = String.valueOf(months[j-1]);
                    arr[j-1] = arr[j];
                    months[j-1] = months[j];
                    arr[j] = temp;
                    months[j] = temp2;
                }
            }
        }
        return months;
    }

    public static Double Search(String[] months, Double[] rain, String month){
        //searches for the month in the months array and returns the corresponding value in the rain array
        for (int i = 0; i < months.length; i++) {
            if (months[i].toLowerCase().equals(month.toLowerCase())) {
                return rain[i];
            }
        }
        return 0.0;
    }

    // Function to print a line of a certain character a certain number of times
    static String Line(Character c, int i){
        return new String(new char[i]).replace('\0', c);
    }

    //Function to sum an array of doubles
    public static Double sum(Double...values) {
        Double result = 0.0;
        for (Double value:values)
        result += value;
        return result;
    }
}
