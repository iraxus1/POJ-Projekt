package pl.edu.pja;


import java.awt.*;

public class Snake {
    private static int maxSnakeLength = 3000;
    private int length = 3;
    private static int[] snakeX = new int[maxSnakeLength];
    private static int[] snakeY = new int[maxSnakeLength];

    public Snake() {}

    public int getLength() {
        return length;
    }

    public static int[] getSnakeX() {
        return snakeX;
    }

    public static int[] getSnakeY() {
        return snakeY;
    }

    public void setSnakeX(int index, int value) {
        this.snakeX[index] = value;
    }

    public void setSnakeY(int index, int value) {
        this.snakeY[index] = value;
    }

    public void setLength(int length) {
        this.length = this.length + length;
    }
}
