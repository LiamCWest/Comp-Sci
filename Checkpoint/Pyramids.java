package Checkpoint;

public class Pyramids {
    public static void main(String[] args) {
        for(int i = 1; i<18; i+=2){
            System.out.print(Line(' ', 18-i));
            for(int s = 0; s<i; s++){
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    static String Line(Character c, int i){
        return new String(new char[i]).replace('\0', c);
    }
}
