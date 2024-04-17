import edu.macalester.graphics.*;

import java.awt.Color;


public class SnakeGame {
    private static int boardWidth;
    private static int boardHeight;

    private static final int TILE_SIZE = 25;

    public SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        CanvasWindow canvas = new CanvasWindow("Snake", boardWidth, boardHeight);
        canvas.setBackground(Color.BLACK);
        canvas.draw();
        addSnakeHead(canvas);
        addFood(canvas);
        addGrid(canvas);
    }
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(600, 600);

    }


    public static void draw(CanvasWindow canvas){
        //creates grid lines to help visualize game and adds to canvas
        for(int i = 0; i < boardWidth/TILE_SIZE; i++){
            Line vertical = new Line(i * TILE_SIZE, 0, i * TILE_SIZE, boardHeight);
            Line horizontal = new Line(0, i * TILE_SIZE, boardWidth, i * TILE_SIZE);
            vertical.setStrokeColor(Color.GRAY);
            horizontal.setStrokeColor(Color.GRAY);
            canvas.add(vertical);
            canvas.add(horizontal);
        }
        //creates green tile for snake head and adds to canvas
        Tile snakeHead = new Tile(5 * TILE_SIZE, 5 * TILE_SIZE, 25, Color.GREEN);
        snakeHead.addToCanvas(canvas);

        //creates red tile for food and adds to canvas
        Tile food = new Tile(10 * TILE_SIZE, 10 * TILE_SIZE, TILE_SIZE, Color.RED);
        food.addToCanvas(canvas);

    }

    public static void addGrid(CanvasWindow canvas){
        for(int i = 0; i < boardWidth/TILE_SIZE; i++){
            Line vertical = new Line(i * TILE_SIZE, 0, i * TILE_SIZE, boardHeight);
            Line horizontal = new Line(0, i * TILE_SIZE, boardWidth, i * TILE_SIZE);
            vertical.setStrokeColor(Color.GRAY);
            horizontal.setStrokeColor(Color.GRAY);
            canvas.add(vertical);
            canvas.add(horizontal);
        }
    }


    public static void addSnakeHead(CanvasWindow canvas){
        Tile snakeHead = new Tile(5 * TILE_SIZE, 5 * TILE_SIZE, 25, Color.GREEN);
        snakeHead.addToCanvas(canvas);
    }

    public static void addFood(CanvasWindow canvas){
        Tile food = new Tile(10 * TILE_SIZE, 10 * TILE_SIZE, TILE_SIZE, Color.RED);
        food.addToCanvas(canvas);
    }


}
