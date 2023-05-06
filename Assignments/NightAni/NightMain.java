package Assignments.NightAni;

import javax.swing.*;
import java.awt.*;

public class NightMain extends JFrame{
    public static void main(String[] args) {
        new NightMain();
    }

    public NightMain(){
        //Set the title
        setTitle("Welcome to Java");
        //Set the size of the window
        setSize(1360, 765);
        //Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the visibility
        setVisible(true);
    }

    public void paint(Graphics g){
        GenBuildings(g, 1);
    }

    public void GenBuildings(Graphics g, int numBuildings){
        /*TODO: 
        Make it so that the buildings don't overlap
        move to building class
        make multiple buildings and layer them
        change colours
        */

        int height = this.getSize().height;
        int width = this.getSize().width;

        for(int i = 0; i < numBuildings; i++){//0.006
            int sizeWidth = (int)Math.round((Math.random()*(0.09375*width))+(0.05*width));
            int sizeHeight = (int)Math.round((Math.random()*(0.25*height))+((0.1875*height)));
            int windowWidth = (int)Math.round((Math.random()*(0.0125*width))+((0.00625*width)));
            int windowHeight = (int)Math.round((Math.random()*(0.025*height))+((0.0125*height)));

            int[] size = new int[]{sizeWidth, sizeHeight};
            int[] windowSize = new int[]{windowWidth, windowHeight};

            Building b = new Building(new int[]{0,height-size[1]}, 1, size, windowSize, (int)(0.0125*height), Color.BLACK, Color.YELLOW);
            b.DrawBuilding(g);
        }
    }
}
