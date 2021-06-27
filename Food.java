package pl.edu.pja;

import javax.swing.*;
import java.awt.*;

public class Food {

    private static int foodX;
    private static int foodY;
    private static Image food;

    private static ImageIcon R = new ImageIcon("R.png");
    private static ImageIcon G = new ImageIcon("G.png");
    private static ImageIcon B = new ImageIcon("n.png");

    public Food() {
    }

    public static int getFoodX() {
        return foodX;
    }

    public static int getFoodY() {
        return foodY;
    }

    public static Image getFood() {
        return food;
    }

    public static void setFood(Image food) {
        Food.food = food;
    }

    public static void setFoodX(int foodX) {
        Food.foodX = foodX;
    }

    public static void setFoodY(int foodY) {
        Food.foodY = foodY;
    }

    public static ImageIcon getR() {
        return R;
    }

    public static ImageIcon getG() {
        return G;
    }

    public static ImageIcon getB() {
        return B;
    }
}
