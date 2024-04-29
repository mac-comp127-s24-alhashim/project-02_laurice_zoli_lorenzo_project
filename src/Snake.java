import java.awt.Color;

import edu.macalester.graphics.*;


public class Snake extends GraphicsGroup {

    public static final int SIZE = 25;
    private double xPos;
    private double yPos;

    private double previousXPos;
    private double previousYPos;

    public Rectangle snakeShape;

    public String directionString;

    public Snake(double xPos, double yPos, String directionString) {
        
        this.xPos = xPos;
        this.yPos = yPos;
        this.directionString = directionString;

        this.snakeShape = new Rectangle(xPos, yPos, SIZE, SIZE);

        snakeShape.setFillColor(Color.GREEN);
    }

    public void updatePosition(String directionString) {

        this.previousXPos = this.snakeShape.getX();
        this.previousYPos = this.snakeShape.getY();

        if(directionString.equals("u")) {
            snakeShape.setPosition(snakeShape.getX(), snakeShape.getY() - SIZE);
        }
        if(directionString.equals("d")) {
            snakeShape.setPosition(snakeShape.getX(), snakeShape.getY() + SIZE);
        }
        if(directionString.equals("l")) {
            snakeShape.setPosition(snakeShape.getX() - SIZE, snakeShape.getY());
        }
        if(directionString.equals("r")) {
            snakeShape.setPosition(snakeShape.getX() + SIZE, snakeShape.getY());
        }
    }

    public void updatePosition(Snake nextSnake) {
        this.previousXPos = this.snakeShape.getX();
        this.previousYPos = this.snakeShape.getY();
        snakeShape.setPosition(nextSnake.getPreviousPoses()[0],nextSnake.getPreviousPoses()[1]);
    }



    public double getXPos() {
        return this.snakeShape.getX();
    }
    public double getYPos() {
        return this.snakeShape.getY();
    }

    public String getDirection(){
        return this.directionString;
    }

    public void setDirection(String directionString) {
        this.directionString = directionString;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this.snakeShape);
    }

    public double[] getPreviousPoses() {
        return new double[]{this.previousXPos, this.previousYPos};
    }

    


}
