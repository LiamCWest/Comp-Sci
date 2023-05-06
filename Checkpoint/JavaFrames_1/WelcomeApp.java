package Checkpoint.JavaFrames_1;

import javax.swing.*;
import java.awt.*;

public class WelcomeApp extends JFrame{
    //Constructor
    public WelcomeApp(){
        //Set the title
        setTitle("Welcome to Java");
        //Set the size of the window
        setSize(400, 400);
        //Set the close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the visibility
        setVisible(true);
    }

    public void paint(Graphics g){
        g.drawString("Welcome to Graphics", 100, 100);
    }
}
