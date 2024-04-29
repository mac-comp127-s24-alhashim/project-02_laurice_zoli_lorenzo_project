import java.awt.Color;

public class Food extends Tile {
    private static final int SIZE = 25;

    double xPos;
    double yPos;

    public static Color foodColor = Color.RED;
    
    public Food(double xPos, double yPos) {
        super(xPos,yPos,foodColor);
    }
}
