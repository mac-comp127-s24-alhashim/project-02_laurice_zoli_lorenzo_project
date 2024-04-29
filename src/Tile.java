import edu.macalester.graphics.*;
import java.awt.Color;

public class Tile extends GraphicsGroup{
    private double xPos;
    private double yPos;
    public static final int SIZE = 25;
    // private boolean hasFood;
  
    


    public Rectangle tileShape;

    public Tile(double xPos, double yPos, Color color) {
        this.tileShape = new Rectangle(xPos, yPos, SIZE, SIZE);
        tileShape.setFillColor(color);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void setX(int newX){
        xPos = newX;
    }

    public void setY(int newY){
        yPos = newY;
    }


     public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this.tileShape);
    }

    public double getXPos() {
        return tileShape.getX();
    }

    public double getYPos() {
        return tileShape.getY();
    }


}
