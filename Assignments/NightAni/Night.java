package Assignments.NightAni;

import javax.swing.*;
import java.awt.*;

public class Night extends JFrame{
    public static void main(String[] args) {
        new Night();
    }

    public Night(){
        //Set the title
        setTitle("Night Animation");
        //Set the size of the window
        setSize(400, 400);
        //Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the visibility
        setVisible(true);
    }

    public void paint(Graphics g){
        while(true){
            g.setColor(new Color(0,0,0,255));
            g.fillRect(0, 0, this.getSize().width+100, this.getSize().height+100);

            drawRoad(g);
            drawBuildings(g);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void drawRoad(Graphics g){
        g.setColor(new Color(255,255,255,255));
        g.fillRect(0, this.getSize().height-this.getSize().height/4, this.getSize().width, this.getSize().height/4);
    }

    public void drawBuildings(Graphics g){
        int[] pos = new int[]{};
        int[] size = new int[]{};
        Color color = new Color(255,255,255,255);
        g.setColor(color);
        g.fillRect(pos[0], pos[1], size[0], size[1]);
    }
}
