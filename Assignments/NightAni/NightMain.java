package Assignments.NightAni;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class NightMain extends JFrame{
    private ArrayList<ArrayList<Building>> buildings;
    public static void main(String[] args) {
        new NightMain();
    }

    public NightMain(){
        //Set the title
        setTitle("Welcome to Java");
        //Set the size of the window
        setSize(400, 400);
        this.buildings = GenBuildings(1);
        //Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the visibility
        setVisible(true);

        // //timer that runs repaint every 100ms
        // Timer timer = new Timer(100, e -> {
        //     this.repaint();
        // });
        // timer.start();
    }

    public void paint(Graphics g){
        // super.paint(g);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(buildings.get(0).get(0).GetPos()[0] > -10){
            g.setColor(new Color(0,0,0,255));
            g.fillRect(0, 0, this.getSize().width+100, this.getSize().height+100);

            drawRoad(g);

            for (int i = 2; i > 0; i--){
                for (Building building : this.buildings.get(i-1)) {
                    building.DrawBuilding(g);
                    int[] pos = building.GetPos();
                    building.MoveBuilding(new int[]{pos[0] - (this.getSize().width/200)+((i-1)*1), pos[1]});
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ArrayList<Building>> GenBuildings(int numBuildings){

        ArrayList<ArrayList<Building>> buildings = new ArrayList<ArrayList<Building>>(Arrays.asList(new ArrayList<Building>(),new ArrayList<Building>(),new ArrayList<Building>()));

        int height = this.getSize().height;
        int width = this.getSize().width;

        // random buildings
        for(int i = 0; i < 2; i++){
            int offset = 0;
            width -= i*(width*0.05);
            height -= i*(height*0.05);

            Double buildingMultiplier = 1.25;
            Double WMulti = 1.4;

            while(offset < (width+(0.075*width))*2-(i*width+(0.075*width))){
                int sizeWidth = (int)Math.round((Math.random()*(0.075*width*buildingMultiplier*WMulti))+(0.05*width*buildingMultiplier*WMulti)+15);
                int sizeHeight = (int)Math.round((Math.random()*(0.25*height*buildingMultiplier)+(i*height*0.075))+(0.1875*height*buildingMultiplier)+(i*height*0.05));
                int windowWidth = (int)Math.round((Math.random()*(0.0125*width*buildingMultiplier))+((0.00625*width*buildingMultiplier)));
                int windowHeight = (int)Math.round((Math.random()*(0.025*height*buildingMultiplier))+((0.0125*height*buildingMultiplier)));

                int[] size = new int[]{sizeWidth, sizeHeight};
                int[] windowSize = new int[]{windowWidth, windowHeight};

                int R = (int)(Math.random()*20)+61;
                int G = (int)(Math.random()*20)+61;
                int B = (int)(Math.random()*40)+115;
                Color color = new Color(R, G, B, 255);

                buildings.get(i).add(new Building(new int[]{offset+this.getSize().width,height-size[1]-(int)(0.2*this.getSize().height)}, size, windowSize, (int)(0.0125*height), color, new Color(19,19,89,255)));
                offset += sizeWidth;
            }
        }

        return buildings;
    }

    public void drawRoad(Graphics g){
        g.setColor(new Color(255,255,255,255));
        g.fillRect(0, this.getSize().height-((int)(0.2*this.getSize().height)), this.getSize().width, (int)(0.2*this.getSize().height));
    }
}
