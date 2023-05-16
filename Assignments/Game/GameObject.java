package Assignments.Game;

import java.awt.*;

public class GameObject{
    private int x;
    private int y;
    private int[] velocity;
    private int speed;
    private Polygon[] shapes;
    private Polygon[] movedShapes;
    private Color[] colors;
    private Boolean shapeQ;
    private Image image;
    private boolean hasGravity;
    private GameManager gameManager;

    private Rectangle hitboxShape;
    private Rectangle hitbox;

    public GameObject(int x, int y, Color[] colors, Polygon[] shapes, boolean shapeQ, Image image, boolean hasGravity, GameManager gameManager) {
        this.x = x;
        this.y = y;
        this.colors = colors;
        this.shapes = shapes;
        this.movedShapes = new Polygon[shapes.length];
        this.shapeQ = shapeQ;
        this.image = image;
        this.hasGravity = hasGravity;
        this.gameManager = gameManager;
        this.velocity = new int[]{0, 0};
        this.speed = 2;
        if(shapeQ){
            this.hitboxShape = new Rectangle();
            calculateBoundingBox();
            this.hitbox = moveHitbox(x, y);
        }
        else this.hitbox = new Rectangle(x, y, image != null ? image.getWidth(null) : 0, image != null ? image.getHeight(null) : 0);
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
        if(!(isColliding())){
            if(hasGravity){
                if(!(isGrounded())){
                    velocity[1] += 1;
                }
                else if (velocity[1] > 0){
                    velocity[1] = 0;
                }
            }
            this.x += velocity[0];
            this.y += velocity[1];
            this.hitbox = moveHitbox(this.x, this.y);
        }
    }

    public int getSpeed(){
        return speed;
    }

    public void setVelocity(int x, int y){
        this.velocity = new int[]{x, y};
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    private Polygon changePos(int dx, int dy, Polygon polygon) {
        Polygon movedPolygon = new Polygon(polygon.xpoints, polygon.ypoints, polygon.npoints);
        for (int i = 0; i < movedPolygon.npoints; i++) {
            movedPolygon.xpoints[i] += dx;
            movedPolygon.ypoints[i] += dy;
        }
        return movedPolygon;
    }

    private void calculateBoundingBox() {
        if (shapes.length == 0) {
            hitboxShape = new Rectangle(x, y, 0, 0);
            return;
        }
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
    
        for (Polygon shape : shapes) {
            for (int i = 0; i < shape.npoints; i++) {
                int x = shape.xpoints[i];
                int y = shape.ypoints[i];
    
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }
    
        int width = maxX - minX;
        int height = maxY - minY;
    
        hitboxShape.setBounds(minX, minY, width, height);
    }

    private Rectangle moveHitbox(int dx, int dy) {
        return new Rectangle(hitboxShape.x + dx, hitboxShape.y + dy, hitboxShape.width, hitboxShape.height);
    }

    private Boolean isGrounded(){
        Rectangle checkBox = new Rectangle(hitbox.x + 1, hitbox.y + 1, hitbox.width - 2, hitbox.height - 1);
        for(GameObject gameObject : gameManager.getGameObjects()){
            if(gameObject != this){
                if(gameObject.getHitbox().intersects(checkBox)){
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isColliding(){
        Rectangle checkBox = new Rectangle(hitbox.x + velocity[0] + 1, hitbox.y + velocity[1], hitbox.width-1, hitbox.height-1);
        for(GameObject gameObject : gameManager.getGameObjects()){
            if(gameObject != this){
                if(gameObject.getHitbox().intersects(checkBox)){
                    return true;
                }
            }
        }
        return false;
    }
}