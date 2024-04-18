import edu.macalester.graphics.*;
import java.awt.Color;

public class Tile extends GraphicsGroup{
    private int xPos;
    private int yPos;
    private int size;
    // private boolean hasFood;
  
    


    public Rectangle tileShape;

    public Tile(int xPos, int yPos, int size, Color color) {
        this.tileShape = new Rectangle(xPos, yPos, size, size);
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


}
