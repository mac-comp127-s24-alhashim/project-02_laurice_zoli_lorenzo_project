# Team Name:  Syntax Serpents 
# Project Name: Snake Rendition

## Project Description

Welcome to our Java-based Snake game project, an innovative reimagining of the classic Snake game that captivated millions on early Nokia phone models. Our version stays true to the beloved original, where the player controls a growing line that becomes a snake, navigating the play area while avoiding walls and its own ever-extending body. The objective is to eat items that randomly appear, each item consumed makes the snake longer and the game increasingly challenging. 

The system will look like below, the green square is the snake and the red square is the food. 

![A screenshot showing the main window of the program. A food unit and snake of length 1 is shown](res/images/MainWindow.png "Main Window Screenshot")

## Requirements

Java 22 and any IDE (we recommend VS Code) installed on your machine is required to run this program.

## How To Run

To run the program, simply clone this repository to your machine, preferably with GitHub Desktop, open the repo in VS Code, navigate to src/SnakeGame.java, and run the program. To play the game, click the start button and use the arrow keys to navigate your snake to the red food objects while avoiding running into the walls or yourself. The goal of the game is to get the highest score possible!

## Limitations

The only bug that we have encountered is that, if the snake is traveling in one direction, then if you quickly press a key to change direction and then press the key that goes in the opposite of the original direction, then the snake seemingly 'turns back on itself' without changing direction in the first place. This is caused by the implementation of the canvas.animate method, so it was very difficult to attempt to fix.

## References

We referenced previous activities and labs in order to see the best ways to work with the kilt graphics library to implement our game.

## DEMO VIDEO
https://youtu.be/gvlLUbsnJ5A




