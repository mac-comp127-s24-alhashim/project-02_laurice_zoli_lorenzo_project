import edu.macalester.graphics.*;
import edu.macalester.graphics.events.*;
import edu.macalester.graphics.ui.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.Color;


public class SnakeGame {

    Snake snakeHead = new Snake(5 * TILE_SIZE, 5 * TILE_SIZE, "r");
    public ArrayList<Snake> snakeList = new ArrayList<Snake>(Arrays.asList(snakeHead));
    

    
    private static int boardWidth = 600;
    private static int boardHeight = 600;

    CanvasWindow canvas;
    private static final double TILE_SIZE = 25;
    public Food food = new Food(10 * TILE_SIZE, 10 * TILE_SIZE);
    final Random random = new Random();
    String direction;
    boolean moving;

    public SnakeGame(CanvasWindow canvas){

        this.canvas = canvas;
        moving = false;


        direction = "r";

        canvas.setBackground(Color.BLACK);

        GraphicsText score = new GraphicsText("0");
        score.setCenter(boardWidth - 20, boardHeight - 20);
        score.setFontSize(40);
        score.setFillColor(Color.WHITE);

        GraphicsText youLose = new GraphicsText("You Lose!");
        youLose.setCenter(boardWidth / 5, boardWidth / 2);
        youLose.setFontSize(100);
        youLose.setFillColor(Color.RED);

        GraphicsText snakeText = new GraphicsText("SNAKE");
        snakeText.setCenter(boardWidth / 4, boardWidth / 2);
        snakeText.setFontSize(100);
        snakeText.setFillColor(Color.WHITE);
        
        Button startButton = new Button("START GAME!");
        startButton.setCenter(boardWidth / 2, boardHeight * 3 / 4);
        startButton.onClick(()-> {
            canvas.remove(startButton);
            canvas.remove(snakeText);
            moving = true;
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            canvas.add(score);
        });

        GraphicsText finalScore = new GraphicsText();
        finalScore.setCenter(boardWidth / 4, boardHeight * 5.5 / 6);
        finalScore.setFillColor(Color.GREEN);
        finalScore.setFontSize(30);
        
        Button playAgainButton = new Button("PLAY AGAIN?");
        playAgainButton.setCenter(boardWidth / 2, boardHeight * 3 / 4);
        playAgainButton.onClick(() -> {
            canvas.removeAll();
            SnakeGame newGame = new SnakeGame(canvas);
        });
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
        snakeHead.addToCanvas(canvas);

        // creates red tile for food and adds to canvas in a random location
        food.addToCanvas(canvas);
    

        canvas.draw();
        

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

        canvas.add(snakeText);
        canvas.add(startButton);

        canvas.animate(() -> {
            if(moving){
                if(eatFood()) {
                    food.tileShape.setPosition(random.nextInt((int)boardWidth / (int)TILE_SIZE) * TILE_SIZE, random.nextInt(((int)boardHeight / (int)TILE_SIZE)) * TILE_SIZE);
                    Snake snakePart = new Snake(snakeList.get(snakeList.size() - 1).getPreviousPoses()[0], snakeList.get(snakeList.size() - 1).getPreviousPoses()[1], snakeList.get(snakeList.size() - 1).getDirection());
                    snakePart.addToCanvas(canvas);
                    snakeList.add(snakePart);
                }
                snakeHead.updatePosition(direction);
                if(snakeList.size() > 1){
                    for (int i = 1; i < snakeList.size(); i++){
                        snakeList.get(i).updatePosition(snakeList.get(i - 1));
                    }
            }

            score.setText(Integer.toString(snakeList.size() - 1));
            
            // TO DO: //
            // MAKE FOOD METHOD ONLY BE ABLE TO SPAWN FOOD WHERE THERE IS NOT A PART OF A SNAKE //
            // IMPLEMENT STARTING / DEATH SCREENS AND BUTTONS //

            moving = isAlive();
            if(!isAlive()) {
                finalScore.setText("Your final score was " + Integer.toString(snakeList.size() - 1));
                canvas.add(finalScore);
                for(Snake snake : snakeList) {
                    snake.snakeShape.setFillColor(Color.RED);
                    canvas.add(playAgainButton);
                }
                canvas.remove(score);
                canvas.add(youLose);
                
            }
            
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            

        }
    });
        
    }
    public static void main(String[] args) {
        
        
        CanvasWindow canvas = new CanvasWindow("Snake", 600, 600);
        SnakeGame game = new SnakeGame(canvas);

        

    }


    



    public boolean eatFood() {
        if(snakeHead.getXPos() == food.getXPos() && snakeHead.getYPos() == food.getYPos()) {
            return true;

        }
        return false;
    }

    public boolean isAlive(){
        if(snakeHead.getXPos() >= boardWidth || snakeHead.getXPos() <= -1 * TILE_SIZE || snakeHead.getYPos() >= boardHeight || snakeHead.getYPos() <= -1 * TILE_SIZE ){
            return false;
        }

        for(int i = 1; i < snakeList.size(); i++){
            if(snakeHead.getXPos() == snakeList.get(i).getXPos() && (snakeHead.getYPos() == snakeList.get(i).getYPos())){
                return false;
            }
        }
        return true;
    }
    

    


}
