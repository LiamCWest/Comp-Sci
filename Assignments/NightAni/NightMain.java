package Assignments.NightAni;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class NightMain extends JFrame{
    private ArrayList<ArrayList<Building>> buildings;
    private Building mainBuilding;
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
    }

    public void paint(Graphics g){
        // super.paint(g);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int t = 0;
        while(buildings.get(1).get(0).GetPos()[0] > -10){
            g.setColor(new Color(0,0,0,255));
            g.fillRect(0, 0, this.getSize().width+100, this.getSize().height+100);

            drawRoad(g, (this.getSize().width/200)*t);
            
            
            for (int i = 2; i > 0; i--){
                for (Building building : this.buildings.get(i-1)) {
                    int [] pos = building.GetPos();
                    if((pos[0] <= this.getSize().width) && (pos[0] >= 0-building.GetWidth())) building.DrawBuilding(g);
                    pos = building.GetPos();
                    building.MoveBuilding(new int[]{pos[0] - (this.getSize().width/200)+((i-1)*1), pos[1]});
                }
            }
            drawMainBuilding(g, (this.getSize().width/200)*t);
            t++;
            try {
                Thread.sleep(30);
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
                int[] size = new int[]{sizeWidth, sizeHeight};

                int R = (int)(Math.random()*20)+61;
                int G = (int)(Math.random()*20)+61;
                int B = (int)(Math.random()*40)+115;
                Color color = new Color(R, G, B, 255);

                buildings.get(i).add(new Building(new int[]{offset+this.getSize().width,height-size[1]-(int)(0.2*this.getSize().height)}, size, color));
                offset += sizeWidth;
            }
            if(i == 0){                
                int mainHeight = 250;
                int mainWidth = 100;

                int mainX = offset + 200 + mainWidth;
                int mainY = this.getSize().height-mainHeight-(int)(0.2*this.getSize().height);

                this.mainBuilding = new Building(new int[]{mainX, mainY}, new int[]{mainWidth, mainHeight}, new Color(255, 255, 255, 255));
            }
        }

        return buildings;
    }

    public void drawRoad(Graphics g, int move){
        g.setColor(new Color(0, 0,0 ,255));
        g.fillRect(0, this.getSize().height-((int)(0.2*this.getSize().height)), this.getSize().width, (int)(0.2*this.getSize().height));

        //road lines
        g.setColor(new Color(255,255,0,255));
        for(int i = 0; i < 7; i++){
            int pos = PositiveMod(((i*(50+20))-move+50), 490);
            g.fillRect(pos-50, this.getSize().height-((int)(0.2*this.getSize().height))+((int)(0.2*this.getSize().height)/2), 50, 5);
        }
    }

    public void drawMainBuilding(Graphics g, int move){
        int[] pos = this.mainBuilding.GetPos();
        /*if((pos[0] <= this.getSize().width) && (pos[0] >= 0-this.mainBuilding.GetWidth()))*/ this.mainBuilding.DrawBuilding(g);
        pos = this.mainBuilding.GetPos();
        System.out.println(pos[0] + " " + pos[1]);
        this.mainBuilding.MoveBuilding(new int[]{pos[0] - (this.getSize().width/200), pos[1]});
    }

    public static int PositiveMod(int value, int mod){
        return ((value % mod + mod) % mod);
    }
}

class Building {
    private int[] pos;
    private int[] size;
    private Color color;

    public Building(int[] pos, int[] size, Color color){
        this.pos = pos;
        this.size = size;
        this.color = color;
    }

    public void DrawBuilding(Graphics g){
        /* 
         * TODO:
         * doors
         * move stuff from NightMain.java
         */
        g.setColor(color);
        g.fillRect(pos[0], pos[1], size[0], size[1]);
        g.setColor(Color.BLACK);
        g.drawRect(pos[0], pos[1], size[0], size[1]);
    }

    public void MoveBuilding(int[] newPos){
        this.pos = newPos;
    }

    public int[] GetPos(){
        return this.pos;
    }

    public int GetWidth(){
        return this.size[0];
    }
}