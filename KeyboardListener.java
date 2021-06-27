package pl.edu.pja;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    static boolean up = false;
    static boolean down = false;
    static boolean left = false;
    static boolean right = false;
    Controls controls = new Controls();
        public void keyTyped(KeyEvent e){}
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (controls.isArrowsChoose() == true) {
                if ((key == KeyEvent.VK_UP) && (!down)) {
                    up = true;
                    right = false;
                    left = false;
                }
                if ((key == KeyEvent.VK_DOWN) && (!up)) {
                    down = true;
                    right = false;
                    left = false;
                }
                if ((key == KeyEvent.VK_LEFT) && (!right)) {
                    left = true;
                    up = false;
                    down = false;
                }
                if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                    right = true;
                    up = false;
                    down = false;
                }
            }
            else if (controls.isWasdChoose() == true) {
                if ((key == KeyEvent.VK_W) && (!down)) {
                    up = true;
                    right = false;
                    left = false;
                }
                if ((key == KeyEvent.VK_S) && (!up)) {
                    down = true;
                    right = false;
                    left = false;
                }
                if ((key == KeyEvent.VK_A) && (!right)) {
                    left = true;
                    up = false;
                    down = false;
                }
                if ((key == KeyEvent.VK_D) && (!left)) {
                    right = true;
                    up = false;
                    down = false;
                }
            }
        }
        public void keyReleased(KeyEvent e){}
    }

