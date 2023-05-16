package Assignments.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Game extends JFrame{
    private BufferedImage offScreenBuffer;
    private JPanel panel;
    private Vector<Integer> movementVector;
    private GameManager gameManager;

    public Game() {
        gameManager = new GameManager(this);
        
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
        gameManager.start();
        Thread gameUpdate = new Thread(()->{
            while(true){
                gameManager.update();
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

    public void render() {
        Graphics g = getGraphics();
        Graphics bbg = offScreenBuffer.getGraphics();
        bbg.setColor(new Color(255, 255, 255, 255));
        bbg.fillRect(0, 0, this.getSize().width + 100, this.getSize().height + 100);
        for (GameObject gameObject : gameManager.getGameObjects()) {
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

    public Vector<Integer> getMovementVector() {
        return movementVector;
    }
}