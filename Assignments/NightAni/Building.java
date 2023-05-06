package Assignments.NightAni;

import java.awt.*;

public class Building {
    private int[] pos;
    private int doors;
    private int[] size;
    private int[] windowSize;
    private int gap;
    private Color color;
    private Color windowColor;

    private int[] windows;
    private int wallGap;

    public Building(int[] pos, int doors, int[] size, int[] windowSize, int gap, Color color, Color windowColor){
        this.pos = pos;
        this.doors = doors;
        this.size = size;
        this.windowSize = windowSize;
        this.gap = gap;
        this.color = color;
        this.windowColor = windowColor;
        this.windows = new int[]{(size[0]-gap)/(windowSize[0]+gap), (size[1]-gap)/(windowSize[1]+gap)};
        this.wallGap = ((size[0])-(((windowSize[0]+gap)*windows[0])))/2;
    }

    public void DrawBuilding(Graphics g){
        /* 
         * TODO:
         * doors
         * move stuff from NightMain.java
         */
        g.setColor(color);
        g.fillRect(pos[0], pos[1], size[0], size[1]);

        g.setColor(windowColor);
        for(int i = 0; i < windows[0]; i++){
            for(int j = 0; j < windows[1]; j++){
                g.fillRect(pos[0]+((windowSize[0]+gap)*i)+wallGap+(int)Math.round(gap/2), pos[1]+((windowSize[1]+gap)*j)+gap+(int)Math.round(gap/2), windowSize[0], windowSize[1]);
            }
        }
    }
}
