package Checkpoint;

public class Pyramids {
    public static void main(String[] args) {
        for(int i = 0; i<5; i++)
            System.out.println("  ".repeat(6-i)+"* ".repeat((i*2)+1));
    }
}
