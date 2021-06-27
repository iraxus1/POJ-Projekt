package pl.edu.pja;

import java.util.Random;

import static pl.edu.pja.Food.*;

public class Logic{
    private static int speed;
    private static int score = 0;

    private static boolean gameOver = false;
    private static boolean victory = false;

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Logic.speed = speed;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Logic.score = score;
    }

    public static boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean gameOver) {
        Logic.gameOver = gameOver;
    }

    public static boolean isVictory() {
        return victory;
    }

    public static void setVictory(boolean victory) {
        Logic.victory = victory;
    }

    Snake snake = new Snake();
    public boolean checkHits(int boardHeight, int boardWidth){
        //snake collision
        for(int i = snake.getLength(); i > 0; i--){
            //run check after initial length and if head hit anywhere on body
            if( (snake.getSnakeX()[0] == snake.getSnakeX()[i]) && (snake.getSnakeY()[0] == snake.getSnakeY()[i]) && (i > 3)){
                gameOver = true;
            }
        }

        //bottom wall
        if(snake.getSnakeY()[0] > boardHeight - 10){
            gameOver = true;
        }
        //top wall
        if(snake.getSnakeY()[0] < -10){
            gameOver = true;
        }
        //right wall
        if(snake.getSnakeX()[0] > boardWidth - 10){
            gameOver = true;
        }
        //left wall
        if(snake.getSnakeX()[0] < -10){
            gameOver = true;
        }

        if(gameOver == true){
            return true;
        }

        if(victory == true)
        {
            return true;
        }
        return false;
    }

    public void moveSnake(){
        for(int i = snake.getLength(); i > 0; i--){
            snake.setSnakeX(i, snake.getSnakeX()[i-1]);
            snake.setSnakeY(i, snake.getSnakeY()[i-1]);
        }
        if(KeyboardListener.up){
            snake.setSnakeY(0, snake.getSnakeY()[0]-20);
        }
        if(KeyboardListener.down){
            snake.setSnakeY(0, snake.getSnakeY()[0]+20);
        }
        if(KeyboardListener.left){
            snake.setSnakeX(0, snake.getSnakeX()[0]-20);
        }
        if(KeyboardListener.right){
            snake.setSnakeX(0, snake.getSnakeX()[0]+20);
        }
    }

    public void foodColor()
    {
        Random random = new Random();
        switch(random.nextInt(4))
        {
            case 1: {
                setFood(Food.getR().getImage());
                if((snake.getSnakeX()[0] == getFoodX()) && snake.getSnakeY()[0] == getFoodY()){
                    snake.setLength(1);
                }
                break;
            }
            case 2: {
                setFood(Food.getG().getImage());
                if((snake.getSnakeX()[0] == getFoodX()) && snake.getSnakeY()[0] == getFoodY()){
                    Logic.speed -= 2;
                }
                break;
            }
            case 3: {
                setFood(Food.getB().getImage());
                if((snake.getSnakeX()[0] == getFoodX()) && snake.getSnakeY()[0] == getFoodY()){
                    snake.setLength(-1);
                }
                break;
            }
        }
    }

    public void hitFood(){
        if(score == 20)
        {
            victory = true;
        }

        if((snake.getSnakeX()[0] == getFoodX()) && snake.getSnakeY()[0] == getFoodY()){
            snake.setLength(1);
            score ++;
            foodPlace();
        }
    }

    public void foodPlace(){
        int r = (int) (Math.random() * 32);
        setFoodX(r * 20);
        r = (int) (Math.random() * 30);
        setFoodY(r * 20);
    }

    public void setSnakeOnStart()
    {
        for (int i = 0; i < getSnakeLength(); i++) {
            //snake.getSnakeX()[i] = 400;
            //snake.getSnakeY()[i] = 300;
            snake.setSnakeX(i, 400);
            snake.setSnakeY(i, 300);
        }
    }

    public int getSnakeLength()
    {
        return snake.getLength();
    }
}
