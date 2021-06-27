package pl.edu.pja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu {
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private JFrame snake;
    private JPanel homeScreen;
    private JButton easy;
    private JButton medium;
    private JButton hard;
    private JButton impossible;
    //private JButton controller;
    private JButton play;
    private int difficulty;

    private void  resolveScreenSize(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        SCREEN_HEIGHT = screenSize.height;
        SCREEN_WIDTH = screenSize.width;
    }

    public void setUpHomeScreen(){
        difficulty = 150 ;  // default medium speed
        snake = new JFrame();
        snake.setLayout(new BorderLayout());

        //home screen panel
        resolveScreenSize();
        snake.setLocation((SCREEN_WIDTH )/4, (SCREEN_HEIGHT)/4);
        homeScreen = new JPanel(new BorderLayout());
        homeScreen.setPreferredSize(new Dimension(800, 600));

        JLabel bg = new JLabel();
        bg.setPreferredSize(new Dimension(800, 600));
        ImageIcon icon = new ImageIcon("Snake.png");
        icon.getImage().flush();
        bg.setIcon(icon);
        homeScreen.add(bg);

        easy = new JButton("Easy");
        medium = new JButton("Medium");
        hard = new JButton("Hard");
        impossible = new JButton("Impossible");
        play = new JButton("Play");
        //controller = new JButton("Controls");

        play.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                snake.remove(play);
                snake.remove(easy);
                snake.remove(medium);
                snake.remove(hard);
                snake.remove(impossible);
                snake.getContentPane().remove(homeScreen);
                //game panel
                Board board = new Board(difficulty);
                snake.add(board);
                board.requestFocusInWindow();
                snake.getContentPane().validate();
                snake.getContentPane().repaint();
            }
            public void mousePressed(MouseEvent e) {

            }
        });

        /*controller.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                Controls controls = new Controls();
                controls.requestFocusInWindow();
                snake.getContentPane().validate();
                snake.getContentPane().repaint();
            }
            public void mousePressed(MouseEvent e) {}
        });*/

        easy.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                difficulty = 200;
                easy.setBackground(Color.WHITE);
                medium.setBackground(Color.BLACK);
                hard.setBackground(Color.BLACK);
                impossible.setBackground(Color.BLACK);
            }
            public void mousePressed(MouseEvent e) {
            }
        });

        medium.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                difficulty = 150;
                medium.setBackground(Color.WHITE);
                easy.setBackground(Color.BLACK);
                hard.setBackground(Color.BLACK);
                impossible.setBackground(Color.BLACK);
            }
            public void mousePressed(MouseEvent e){}
        });

        hard.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                difficulty = 125;
                hard.setBackground(Color.WHITE);
                easy.setBackground(Color.BLACK);
                medium.setBackground(Color.BLACK);
                impossible.setBackground(Color.BLACK);
            }
            public void mousePressed(MouseEvent e){}
        });

        impossible.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                difficulty = 45;
                impossible.setBackground(Color.WHITE);
                hard.setBackground(Color.BLACK);
                easy.setBackground(Color.BLACK);
                medium.setBackground(Color.BLACK);
            }
            public void mousePressed(MouseEvent e){}
        });

        easy.setForeground(Color.RED);
        easy.setBackground(Color.BLACK);
        easy.setFocusPainted(false);

        medium.setForeground(Color.RED);
        medium.setBackground(Color.BLACK);
        medium.setFocusPainted(false);

        hard.setForeground(Color.RED);
        hard.setBackground(Color.BLACK);
        hard.setFocusPainted(false);

        impossible.setForeground(Color.RED);
        impossible.setBackground(Color.BLACK);
        impossible.setFocusPainted(false);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(Color.GREEN);
        buttonsPanel.add(easy);
        buttonsPanel.add(medium);
        buttonsPanel.add(hard);
        buttonsPanel.add(impossible);
        //buttonsPanel.add(controller);
        buttonsPanel.add(play);
        buttonsPanel.repaint();

        homeScreen.add(buttonsPanel, BorderLayout.SOUTH);
        snake.add(homeScreen, BorderLayout.CENTER);
        snake.setTitle("SNAKE");
        snake.setResizable(false);
        snake.pack();
        snake.setVisible(true);
        snake.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
