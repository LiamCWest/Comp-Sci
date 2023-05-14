package Assignments;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class NightMain extends JFrame {
    private ArrayList<ArrayList<Building>> buildings;
    private Building mainBuilding;
    private Car car;
    private int aniSpeed;
    private int layers;

    private AnimationPanel animationPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NightMain::new);
    }

    public NightMain() {
        this.aniSpeed = 10;
        this.layers = 2;

        // Set the title
        setTitle("Welcome to Java");
        // Set the size of the window
        setSize(800, 600);
        this.buildings = GenBuildings(this.layers);
        this.car = new Car(25, 300, 1, 1, new Color(255, 0, 0, 255));
        // Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the visibility
        setVisible(true);

        animationPanel = new AnimationPanel();
        add(animationPanel);

        startAnimation();
    }

    private void startAnimation() {
        Thread animationThread = new Thread(() -> {
            int t = 0;
            while (buildings.get(1).get(0).getX() > -10) {
                animationPanel.setFrame(t, 0);
                t++;
                try {
                    Thread.sleep(aniSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int n = 0; n < 100; n++) {
                animationPanel.setFrame(t, 1);
                try {
                    Thread.sleep(aniSpeed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        animationThread.start();
    }

    public ArrayList<ArrayList<Building>> GenBuildings(int layers) {
        ArrayList<ArrayList<Building>> buildings = new ArrayList<>();

        int height = getHeight();
        int width = getWidth();

        // Random buildings
        for (int i = 0; i < layers; i++) {
            buildings.add(new ArrayList<>());
            int offset = 0;
            width -= i * (width * 0.05);
            height -= i * (height * 0.05);

            double buildingMultiplier = 1.0;
            double WMulti = 1.6;

            while (offset < (width + (0.075 * width)) * 2 - (i * width + (0.075 * width))) {
                int sizeWidth = (int) Math.round((Math.random() * (0.075 * width * buildingMultiplier * WMulti)) + (0.05 * width * buildingMultiplier * WMulti) + 15);
                int sizeHeight = (int) Math.round((Math.random() * (0.1 * height * buildingMultiplier)) + (0.3 * height * buildingMultiplier) + (i * height * 0.05));
                int[] size = new int[]{sizeWidth, sizeHeight};

                int R = (int) (Math.random() * 20) + 61;
                int G = (int) (Math.random() * 20) + 61;
                int B = (int) (Math.random() * 40) + 115;
                Color color = new Color(R, G, B, 255);
                buildings.get(i).add(new Building(offset + getWidth(), getHeight() - size[1] - (int) (0.2 * getHeight()), size, color, false, new int[]{0, 0}, (int) (0.02 * width)));
                offset += (int) (0.075 * width * buildingMultiplier * WMulti) + (int) (0.05 * width * buildingMultiplier * WMulti);
                buildingMultiplier *= 0.9;
            }
        }

        // Main building
        int mainBuildingHeight = (int) (0.4 * height);
        int mainBuildingWidth = (int) (0.6 * width);
        int mainBuildingX = (getWidth() - mainBuildingWidth) / 2;
        int mainBuildingY = getHeight() - mainBuildingHeight - 10;
        int[] mainBuildingSize = new int[]{mainBuildingWidth, mainBuildingHeight};
        Color mainBuildingColor = new Color(50, 50, 50, 255);
        buildings.add(new ArrayList<>());
        buildings.get(layers).add(new Building(mainBuildingX, mainBuildingY, mainBuildingSize, mainBuildingColor, true, new int[]{0, 0}, (int) (0.02 * width)));

        return buildings;
    }

    private class AnimationPanel extends JPanel {
        private int currentFrame;
        private int animationPhase;

        public AnimationPanel() {
            currentFrame = 0;
            animationPhase = 0;
        }

        public void setFrame(int frame, int phase) {
            currentFrame = frame;
            animationPhase = phase;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw buildings
            ArrayList<Building> currentBuildings = buildings.get(animationPhase);
            for (Building building : currentBuildings) {
                building.draw(g, currentFrame);
            }

            // Draw car
            car.draw(g, currentFrame);
        }
    }

    private class Building {
        private int x;
        private int y;
        private int[] size;
        private Color color;
        private boolean isMainBuilding;
        private int[] offset;
        private int phase;

        public Building(int x, int y, int[] size, Color color, boolean isMainBuilding, int[] offset, int phase) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
            this.isMainBuilding = isMainBuilding;
            this.offset = offset;
            this.phase = phase;
        }

        public void draw(Graphics g, int frame) {
            int posX = x + offset[0] - (size[0] + (int) (0.075 * size[0]));
            int posY = y + offset[1];

            // Draw building
            g.setColor(color);
            g.fillRect(posX, posY, size[0], size[1]);

            // Draw windows
            if (!isMainBuilding && frame % 20 == 0) {
                int windowSize = (int) (0.1 * size[0]);
                int windowSpacing = (int) (0.05 * size[0]);
                int numWindows = (size[0] - windowSpacing) / (windowSize + windowSpacing);
                int windowY = posY + (int) (0.1 * size[1]);

                g.setColor(Color.YELLOW);
                for (int i = 0; i < numWindows; i++) {
                    int windowX = posX + windowSpacing + i * (windowSize + windowSpacing);
                    g.fillRect(windowX, windowY, windowSize, windowSize);
                }
            }
        }

        public int getX() {
            return x;
        }
    }

    private class Car {
        private int x;
        private int y;
        private int speedX;
        private int speedY;
        private Color color;

        public Car(int x, int y, int speedX, int speedY, Color color) {
            this.x = x;
            this.y = y;
            this.speedX = speedX;
            this.speedY = speedY;
            this.color = color;
        }

        public void draw(Graphics g, int frame) {
            int posX = x + frame * speedX;
            int posY = y + frame * speedY;

            // Draw car
            g.setColor(color);
            g.fillRect(posX, posY, 50, 20);
        }
    }
}

