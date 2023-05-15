package Assignments.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Game extends JFrame{
    private BufferedImage offScreenBuffer;
    private GameObject[] gameObjects;
    private JPanel panel;
    private Vector<Integer> movementVector;

    public Game() {
        movementVector = new Vector<Integer>(2);
        movementVector.add(0);  // Initialize index 0 with value 0
        movementVector.add(0);  // Initialize index 1 with value 0

        panel = new JPanel();
        setContentPane(panel);

        //Set the title
        setTitle("City Street Animation");
        //Set the size of the window
        setSize(1360, 768);
        //Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the visibility
        setVisible(true);

        // Create the off-screen buffer with the same size as the window
        offScreenBuffer = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_ARGB);
    }

    public void play() {
        start();
        Thread gameUpdate = new Thread(()->{
            while(true){
                update();
                render();
            }
        });
        Thread input = new Thread(()->{
            while(true){
                movementInput();
            }
        });
        gameUpdate.start();
        input.start();
    }

    public void start(){
        gameObjects = new GameObject[1];
        gameObjects[0] = new GameObject(100, 100, new Color[]{Color.BLACK, Color.BLACK}, new Polygon[]{new Polygon(new int[]{0, 50, 50, 0}, new int[]{0, 0, 50, 50}, 4)}, true, null);
    }

    public void update() {
        GameObject gameObject = gameObjects[0];
        gameObject.setVelocity(movementVector.get(0) * gameObject.getSpeed(), movementVector.get(1) * gameObject.getSpeed());
        gameObject.move();
    }

    public void render() {
        Graphics g = getGraphics();
        Graphics bbg = offScreenBuffer.getGraphics();
        bbg.setColor(new Color(255, 255, 255, 255));
        bbg.fillRect(0, 0, this.getSize().width + 100, this.getSize().height + 100);
        for (GameObject gameObject : gameObjects) {
            gameObject.draw(bbg);
        }
        g.drawImage(offScreenBuffer, 0, 0, this);
    }

    public void movementInput(){
        panel.getInputMap().put(KeyStroke.getKeyStroke("W"), "moveUp");
        panel.getActionMap().put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(1, -1);
            }
        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("S"), "moveDown");
        panel.getActionMap().put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(1, 1);
            }
        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("A"), "moveLeft");
        panel.getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(0, -1);
            }
        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("D"), "moveRight");
        panel.getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(0, 1);
            }
        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("released W"), "stopMoveUp");
        panel.getActionMap().put("stopMoveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(1, 0);
            }
        });

        panel.getInputMap().put(KeyStroke.getKeyStroke("released S"), "stopMoveDown");
        panel.getActionMap().put("stopMoveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(1, 0);
            }
        });

        panel.getInputMap().put(KeyStroke.getKeyStroke("released A"), "stopMoveLeft");
        panel.getActionMap().put("stopMoveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(0, 0);
            }
        });

        panel.getInputMap().put(KeyStroke.getKeyStroke("released D"), "stopMoveRight");
        panel.getActionMap().put("stopMoveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movementVector.set(0, 0);
            }
        });
    }
}

class GameObject{
    private int x;
    private int y;
    private int[] velocity;
    private int speed;
    private Polygon[] shapes;
    private Polygon[] movedShapes;
    private Color[] colors;
    private Boolean shapeQ;
    private Image image;

    public GameObject(int x, int y, Color[] colors, Polygon[] shapes, boolean shapeQ, Image image) {
        this.x = x;
        this.y = y;
        this.colors = colors;
        this.shapes = shapes;
        this.movedShapes = new Polygon[shapes.length];
        this.shapeQ = shapeQ;
        this.image = image;
        this.velocity = new int[]{0, 0};
        this.speed = 2;
    }

    public void draw(Graphics g) {
        if (shapeQ) {
            moveShapes(); // Update the movedShapes array before drawing
            for (Polygon shape : movedShapes) {
                g.setColor(colors[0]);
                g.fillPolygon(shape);
            }
        } else {
            g.drawImage(image, x, y, null);
        }
    }

    private void moveShapes() {
        for (int i = 0; i < shapes.length; i++) {
            movedShapes[i] = changePos(this.x, this.y, shapes[i]);
        }
    }

    public void move(){
        this.x += velocity[0];
        this.y += velocity[1];
    }

    public int getSpeed(){
        return speed;
    }

    public void setVelocity(int x, int y){
        this.velocity = new int[]{x, y};
    }

    private Polygon changePos(int dx, int dy, Polygon polygon) {
        Polygon movedPolygon = new Polygon(polygon.xpoints, polygon.ypoints, polygon.npoints);
        for (int i = 0; i < movedPolygon.npoints; i++) {
            movedPolygon.xpoints[i] += dx;
            movedPolygon.ypoints[i] += dy;
        }
        return movedPolygon;
    }
}