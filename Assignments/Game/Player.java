package Assignments.Game;

import java.awt.*;

public class Player extends GameObject{
    private int jumpHeight = 150;
    private int currentJumpHeight = 0;
    private boolean isJumping = false;
    private boolean isFalling = false;
    private int jumpVelocity = -3;

    Player(int x, int y, Color[] colors, Polygon[] shapes, boolean shapeQ, Image image, Boolean hasGravity, GameManager gameManager) {
        super(x, y, colors, shapes, shapeQ, image, hasGravity, gameManager);
    }

    @Override
    public void move() {
        if (super.isGrounded()) {
            currentJumpHeight = 0;
            isFalling = false;
        }

        if (isJumping) {
            if (currentJumpHeight < jumpHeight) {
                setVelocity(getVelocity()[0], jumpVelocity);
                currentJumpHeight++;
            } else {
                isJumping = false;
                isFalling = true;
            }
        } else if (isFalling) {
            setVelocity(getVelocity()[0], 1);
        }

        super.move();
    }

    public void jump() {
        if (super.isGrounded()) {
            isJumping = true;
            isFalling = false;
        }
    }
}
