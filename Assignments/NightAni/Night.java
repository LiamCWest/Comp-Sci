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
        for(int t = 0; t < 100; t++){
            g.setColor(new Color(0,0,0,255));
            g.fillRect(0, 0, this.getSize().width+100, this.getSize().height+100);

            drawRoad(g);

            //far background buildings
            Color farBuildingColor = new Color(39,43,89,255);
            drawBuilding(g, t, farBuildingColor, 100, 50, 75, this.getSize().height-this.getSize().height/4);
            drawBuilding(g, t, farBuildingColor, 80, 40, 125, this.getSize().height-this.getSize().height/4);
            
            //close background buildings
            Color closeBuildingColor = new Color(53,62,128,255);
            drawBuilding(g, t, closeBuildingColor, 145, 75, 0, this.getSize().height-this.getSize().height/4);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {}
        }
    }


    public void drawRoad(Graphics g){
        g.setColor(new Color(255,255,255,255));
        g.fillRect(0, this.getSize().height-this.getSize().height/4, this.getSize().width, this.getSize().height/4);
    }

    public void drawBuilding(Graphics g, int frame, Color color, int height, int width, int x, int y){
        g.setColor(color);
        g.fillRect(x-frame, y-height, width, height);
    }
}
