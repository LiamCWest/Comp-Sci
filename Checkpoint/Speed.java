package Checkpoint;
public class Speed {
    public static void main(String[] args) {
        System.out.println("KPH     MPH\n------------");
        for(int i = 60; i < 140; i+=10)
            System.out.printf("%d     %3.2f\n", i, i*0.6214);
    }
}
