package Assignments.NightAni;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class NightMain extends JFrame{
    private ArrayList<ArrayList<Building>> buildings;
    private Building mainBuilding;
    private Car car;
    public static void main(String[] args) {
        new NightMain();
    }

    public NightMain(){
        //Set the title
        setTitle("Welcome to Java");
        //Set the size of the window
        setSize(400, 400);
        this.buildings = GenBuildings();
        this.car = new Car(new int[]{25, 300}, new int[]{1, 1}, new Color(255, 0, 0, 255));
        //Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the visibility
        setVisible(true);
    }


    public void paint(Graphics g){
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
            drawMainBuilding(g, true);
            drawCar(g, false);
            t++;
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int n = 0; n < 60; n++){
            g.setColor(new Color(0,0,0,255));
            g.fillRect(0, 0, this.getSize().width+100, this.getSize().height+100);

            drawRoad(g, (this.getSize().width/200)*t);
            
            for (int i = 2; i > 0; i--){
                for (Building building : this.buildings.get(i-1)) {
                    int [] pos = building.GetPos();
                    if((pos[0] <= this.getSize().width) && (pos[0] >= 0-building.GetWidth())) building.DrawBuilding(g);
                }
            }
            drawMainBuilding(g, false);
            drawCar(g, true);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
        car door = true
        draw car with door
        human walk out
        car door = false
        draw car without door
        main building doors open
        human walk in to main building
        main building doors close
        */
    }

    public ArrayList<ArrayList<Building>> GenBuildings(){
        ArrayList<ArrayList<Building>> buildings = new ArrayList<ArrayList<Building>>(Arrays.asList(new ArrayList<Building>(),new ArrayList<Building>(),new ArrayList<Building>()));

        int height = this.getSize().height;
        int width = this.getSize().width;

        // random buildings
        for(int i = 0; i < 2; i++){
            int offset = 0;
            width -= i*(width*0.05);
            height -= i*(height*0.05);

            Double buildingMultiplier = 1.0;
            Double WMulti = 1.6;
        
            while(offset < (width+(0.075*width))*2-(i*width+(0.075*width))){
                int sizeWidth = (int)Math.round((Math.random()*(0.075*width*buildingMultiplier*WMulti))+(0.05*width*buildingMultiplier*WMulti)+15);
                int sizeHeight = (int)Math.round((Math.random()*(0.1*height*buildingMultiplier))+(0.3*height*buildingMultiplier)+(i*height*0.05));
                int[] size = new int[]{sizeWidth, sizeHeight};

                int R = (int)(Math.random()*20)+61;
                int G = (int)(Math.random()*20)+61;
                int B = (int)(Math.random()*40)+115;
                Color color = new Color(R, G, B, 255);
                buildings.get(i).add(new Building(new int[]{offset+this.getSize().width,height-size[1]-(int)(0.2*this.getSize().height)}, size, color, false, new int[]{0,0}, 0, new Color(0,0,0,0), 0, new Color(0,0,0,0)));
                offset += sizeWidth;
            }
            if(i == 0){                
                int mainHeight = 250;
                int mainWidth = 100;
                int mainX = 1110;
                int mainY = this.getSize().height-mainHeight-(int)(0.2*this.getSize().height);

                this.mainBuilding = new Building(new int[]{mainX, mainY}, new int[]{mainWidth, mainHeight}, new Color(255, 0, 255, 255), true, new int[]{25,25}, 5, new Color(255,255,255,255), 2, new Color(0,0,255,255));
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

    public void drawMainBuilding(Graphics g, Boolean move){
        int[] pos = this.mainBuilding.GetPos();
        if((pos[0] <= this.getSize().width) && (pos[0] >= 0-this.mainBuilding.GetWidth())) this.mainBuilding.DrawBuilding(g);
        if(move){
            pos = this.mainBuilding.GetPos();
            this.mainBuilding.MoveBuilding(new int[]{pos[0] - (this.getSize().width/200), pos[1]});
        }
    }

    public void drawCar(Graphics g, Boolean move){
        int[] pos = this.car.GetPos();
        this.car.DrawCar(g);
        if(move){
            pos = this.car.GetPos();
            this.car.MoveCar(new int[]{pos[0]+1, pos[1]});
        }
    }

    public static int PositiveMod(int value, int mod){
        return ((value % mod + mod) % mod);
    }
}

class Building {
    private int[] pos;
    private int[] size;
    private int[] windowSize;
    private int gap;
    private Color color;
    private Color windowColor;
    private Boolean windowsQ;
    private int doors;
    private Color doorColor;

    private int[] windows;
    private int wallGap;
    private int doorGap;

    public Building(int[] pos, int[] size, Color color, Boolean windowsQ, int[] windowSize, int gap, Color windowColor, int doors, Color doorColor){
        this.pos = pos;
        this.size = size;
        this.windowSize = windowSize;
        this.gap = gap;
        this.color = color;
        this.windowColor = windowColor;
        this.windowsQ = windowsQ;
        this.doors = doors;
        this.doorColor = doorColor;
        if(windowsQ){
            this.windows = new int[]{(size[0]-gap)/(windowSize[0]+gap), (size[1]-gap)/(windowSize[1]+gap)};
            this.wallGap = ((size[0])-(((windowSize[0]+gap)*windows[0])))/2;
        }
        if(doors > 0){
            this.windows[1] -= 2;
            this.doorGap = ((size[0])-(((windowSize[0]+gap)*doors)))/2;
        }
    }

    public void DrawBuilding(Graphics g){
        g.setColor(color);
        g.fillRect(pos[0], pos[1], size[0], size[1]);
        g.setColor(Color.BLACK);
        g.drawRect(pos[0], pos[1], size[0], size[1]);
        
        if(windowsQ){
            g.setColor(windowColor);
            for(int i = 0; i < windows[0]; i++){
                for(int j = 0; j < windows[1]; j++){
                    g.fillRect(pos[0]+((windowSize[0]+gap)*i)+wallGap+(int)Math.round(gap/2), pos[1]+((windowSize[1]+gap)*j)+gap+(int)Math.round(gap/2), windowSize[0], windowSize[1]);
                }
            }
        }

        if(doors > 0){
            g.setColor(doorColor);
            for(int i = 0; i < doors; i++){
                int x = pos[0]+doorGap+(i*(windowSize[1]+gap));
                int y = pos[1]+(windowSize[1]+gap)*(windows[1])+wallGap+gap;
                g.fillRect(x, y, windowSize[0], (windowSize[1]*2)+gap);
            }
        }
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

class Car {
    private int[] pos;
    private int[] size;
    private Color carColor;
    public Car(int[] pos, int[] size, Color carColor){
        this.pos = pos;
        this.size = size;
        this.carColor = carColor;
    }

    public void DrawCar(Graphics g){
        g.setColor(this.carColor);
        g.fillRect(pos[0], pos[1]+(10*size[1]), 80*size[0], 40*size[1]);
        g.fillRect(pos[0]+(10*size[0]), pos[1], 100*size[0], 10*size[1]);
        g.fillRect(pos[0]+(80*size[0]), pos[1]+(25*size[1]), 55*size[0], 25*size[1]);
        g.setColor(new Color(0,100,0,255));
        g.fillRect(pos[0]+(80*size[0]), pos[1]+(10*size[1]), 40*size[0], 15*size[1]);

        g.setColor(new Color(50,50,50,255));
        g.fillOval(pos[0]+(10*size[0]), pos[1]+(35*size[1]), 25*size[0], 25*size[1]);
        g.fillOval(pos[0]+(100*size[0]), pos[1]+(35*size[1]), 25*size[0], 25*size[1]);
    }

    public void MoveCar(int[] newPos){
        this.pos = newPos;
    }

    public int[] GetPos(){
        return this.pos;
    }
}