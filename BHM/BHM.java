package BHM;

import javax.swing.JOptionPane;

public class BHM {
    public static void main(String[] args) {
        Madlibs("Fifteen year old Harry Gairey Jr. and his friend Donny Jubas went __ANSWER__. Harry could not get a __ANSWER__ because of the colour of his skin. Harry’s father worked as a __ANSWER__. The __ANSWER__ was an all-Black labour union. Students from the __ANSWER__ protested in front of the ice rink in support of Gairey Jr. In __ANSWER__, Toronto passed a law against __ANSWER__. The Harry Ralph Gairey Rink was named in __ANSWER__ of __ANSWER__.");
    }

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
}
