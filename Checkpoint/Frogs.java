package Checkpoint;
import java.util.Map;
public class Frogs {
    public static void main(String[] args) {
        Map<Integer, String> numMap = Map.of(0, "no", 1, "One", 2, "Two", 3, "Tree", 4, "Four", 5, "Five");
        for(int numFrogs = 5; numFrogs > 0; numFrogs--)
            System.out.printf("\n%s green and speckled frogs sat on a speckled log\nEating some most delicious bugs -- YUM YUM!\nOne jumped into the pool where it was nice and cool\nThen there were %s green and speckled frogs.\n", numMap.get(numFrogs), numMap.get(numFrogs-1).toLowerCase());
    }
}