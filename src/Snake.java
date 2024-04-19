import java.awt.Color;

import edu.macalester.graphics.*;


public class Snake extends GraphicsGroup {

    public static final int SIZE = 25;
    private double xPos;
    private double yPos;

    public Rectangle snakeHead;

    public String directionString;

    public Snake(double xPos, double yPos, String directionString) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.directionString = directionString;

        this.snakeHead = new Rectangle(xPos, yPos, SIZE, SIZE);

        snakeHead.setFillColor(Color.GREEN);
    }

    public void updatePosition(String directionString) {
        if(directionString.equals("u")) {
            snakeHead.setPosition(snakeHead.getX(), snakeHead.getY() - SIZE);
        }
        if(directionString.equals("d")) {
            snakeHead.setPosition(snakeHead.getX(), snakeHead.getY() + SIZE);
        }
        if(directionString.equals("l")) {
            snakeHead.setPosition(snakeHead.getX() - SIZE, snakeHead.getY());
        }
        if(directionString.equals("r")) {
            snakeHead.setPosition(snakeHead.getX() + SIZE, snakeHead.getY());
        }
    }

    public double getXPos() {
        return this.snakeHead.getX();
    }
    public double getYPos() {
        return this.snakeHead.getY();
    }

    public void setDirection(String directionString) {
        this.directionString = directionString;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this.snakeHead);
    }


}
