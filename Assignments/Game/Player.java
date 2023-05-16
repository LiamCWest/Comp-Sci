package Assignments.Game;

import java.awt.*;

public class Player extends GameObject{
    Player(int x, int y, Color[] colors, Polygon[] shapes, boolean shapeQ, Image image, Boolean hasGravity, GameManager gameManager) {
        super(x, y, colors, shapes, shapeQ, image, hasGravity, gameManager);
    }
}
