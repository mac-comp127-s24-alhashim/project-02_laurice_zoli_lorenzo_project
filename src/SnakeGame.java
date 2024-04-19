import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

import java.util.Random;
import java.awt.Canvas;
import java.awt.Color;


public class SnakeGame {
    private static int boardWidth;
    private static int boardHeight;

    private static final int TILE_SIZE = 25;
    private Tile snakeHead;
    private Tile food;
    Random random;

    String direction;

    boolean moving;

    public SnakeGame(int boardWidth, int boardHeight){

        moving = true;


        direction = "r";
        Snake snakeHead = new Snake(5 * TILE_SIZE, 5 * TILE_SIZE, "r");
        Tile food = new Tile(10 * TILE_SIZE, 10 * TILE_SIZE, TILE_SIZE, Color.RED);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        CanvasWindow canvas = new CanvasWindow("Snake", boardWidth, boardHeight);
        canvas.setBackground(Color.BLACK);

        ///

        Random random = new Random();
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
        // Tile snakeHead = new Tile(5 * TILE_SIZE, 5 * TILE_SIZE, 25, Color.GREEN);
        snakeHead.addToCanvas(canvas);

        // creates red tile for food and adds to canvas in a random location
        // Tile food = new Tile(random.nextInt(boardWidth / TILE_SIZE) *TILE_SIZE, random.nextInt(boardHeight / TILE_SIZE) * TILE_SIZE, TILE_SIZE, Color.RED);
        food.addToCanvas(canvas);
        ///

        canvas.draw();

        random = new Random();
        // placeFood(canvas);

        canvas.onKeyDown(event -> {
            if(direction.equals("l") || direction.equals("r")){
                if(event.getKey().equals(Key.UP_ARROW)) {
                    direction = "u";
                }
                if(event.getKey().equals(Key.DOWN_ARROW)) {
                    direction = "d";
                }
            }
            if(direction.equals("u") || direction.equals("d")){
                if(event.getKey().equals(Key.LEFT_ARROW)) {
                    direction = "l";
                }
                if(event.getKey().equals(Key.RIGHT_ARROW)) {
                    direction = "r";
                }
            }
        });

        canvas.animate(() -> {
            snakeHead.updatePosition(direction);
            System.out.println(direction);
            System.out.println(snakeHead.getXPos() + "   " + snakeHead.getYPos());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(600, 600);

    }


    // public void placeFood(CanvasWindow canvas){
    //     food.setX(random.nextInt(boardWidth / TILE_SIZE));
    //     food.setY(random.nextInt(boardHeight / TILE_SIZE));
    //     food.addToCanvas(canvas);
    // }


    public static void draw(CanvasWindow canvas){
        Random random = new Random();
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

        // creates red tile for food and adds to canvas in a random location
        Tile food = new Tile(random.nextInt(boardWidth / TILE_SIZE) *TILE_SIZE, random.nextInt(boardHeight / TILE_SIZE) * TILE_SIZE, TILE_SIZE, Color.RED);
        food.addToCanvas(canvas);

    }

    


}
