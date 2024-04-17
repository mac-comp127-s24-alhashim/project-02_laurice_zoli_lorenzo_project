import edu.macalester.graphics.*;


public class Tile extends GraphicsGroup{
    private int xPos;
    private int yPos;
    private int size;
    private boolean hasFood;
    


    public Rectangle tileShape;

    public Tile(int xPos, int yPos, int size) {
        this.tileShape = new Rectangle(xPos, yPos, size, size);
        this.xPos = xPos;
        this.yPos = yPos;  
        this.size = size;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this.tileShape);
    }

    public void populateCanvas(CanvasWindow canvas) {
        int numPerRow = canvas.getWidth() / size;
        int numRows = canvas.getHeight() / size;

        for(int row = 0; row < numRows; row++) {
            for(double b = 0; b < numPerRow; b++) {
                
                
                addToCanvas(canvas);
            }
        }

    }
}
