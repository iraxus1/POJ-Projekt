package pl.edu.pja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static pl.edu.pja.Snake.*;

public class Board extends JPanel implements ActionListener{

    private static final int boardWidth = 800;
    private static final int boardHeight = 600;

    private static Image head;
    private static Image body;

    private static Timer timer;
    private Logic logic = new Logic();
    private Food food = new Food();
    private KeyboardListener keyboardListener = new KeyboardListener();

    public Board(int diff){

        //Background
        requestFocusInWindow();
        addKeyListener(keyboardListener);
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(boardWidth, boardHeight));

        //Textures
        ImageIcon bodyIcon = new ImageIcon("B.png");
        ImageIcon headIcon = new ImageIcon("H.png");

        body = bodyIcon.getImage();
        head = headIcon.getImage();

        //Start game
        logic.setSpeed(diff);
        startGame();
    }

    private void startGame() {
        //Spawn edible
        logic.foodPlace();

        //Start position
        logic.setSnakeOnStart();

        //Speed
        timer = new Timer(logic.getSpeed(), this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g){
        //Draw game over after failure
        if(logic.isGameOver() == true){
            gameOver(g);
        }

        //Draw victory after reach score
        else if(logic.isVictory() == true)
        {
            victory(g);
        }

        else{
            if (Logic.getScore() == 0) {
                food.setFood(food.getR().getImage());
            }
            if((Snake.getSnakeX()[0] == food.getFoodX()) && getSnakeY()[0] == food.getFoodY()){
                logic.foodColor();
            }
            //draw food
            g.drawImage(food.getFood(), food.getFoodX(), food.getFoodY(), this);

            //Draw score
            g.setColor(Color.WHITE);
            g.setFont( new Font("Lucida Sans",Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+ logic.getScore(), (boardWidth - metrics.stringWidth("Score: " + logic.getScore()))/2, g.getFont().getSize());

            g.setColor(Color.WHITE);
            g.setFont( new Font("Lucida Sans",Font.BOLD, 10));
            g.drawString("Lenght: "+ logic.getSnakeLength(), (boardWidth - metrics.stringWidth("Lenght: " + logic.getSnakeLength()))/5, g.getFont().getSize());

            g.setColor(Color.WHITE);
            g.setFont( new Font("Lucida Sans",Font.BOLD, 10));
            g.drawString("Speed: "+ logic.getSpeed(), (boardWidth - metrics.stringWidth("Speed: " + logic.getSpeed()))/10, g.getFont().getSize());

            for(int i = 0; i < logic.getSnakeLength(); i++){
                //snake head
                if(i == 0){
                    g.drawImage(head, getSnakeX()[i], getSnakeY()[i], this);
                }
                //snake body
                else{
                    g.drawImage(body, getSnakeX()[i], getSnakeY()[i], this);
                }
            }
        }
    }

    //Called when key is pressed
    public void actionPerformed(ActionEvent e){
        if(logic.isGameOver() == false){
            logic.hitFood();
            logic.moveSnake();
            if(logic.checkHits(boardHeight, boardWidth))
            {
                timer.stop();
            }
        }
        repaint();
    }

    private void gameOver(Graphics g){
        String family = "Lucida Sans";
        int size = 60;
        int style = Font.BOLD;
        Font font = new Font(family, style, size);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("Game Over", (Board.boardWidth/2) - 165, (Board.boardHeight/2) );
        g.drawString("Score: " + logic.getScore(), (Board.boardWidth/2) - 120, (Board.boardHeight/2) + 100);
        exitButton();
    }

    //Print victory after reach required score
    private void victory(Graphics g){
        String family = "Lucida Sans";
        int size = 60;
        int style = Font.BOLD;
        Font font = new Font(family, style, size);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("Victory", (Board.boardWidth/2) - 120, (Board.boardHeight/2) );
        g.drawString("Score: " + logic.getScore(), (Board.boardWidth/2) - 120, (Board.boardHeight/2) + 100);
        exitButton();
    }

    //Display exit button after victory or game over
    private void exitButton(){
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton exit = new JButton("Exit");
        exit.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(exit);
        add(buttonPanel, BorderLayout.SOUTH);
        exit.setVisible(true);
        this.revalidate();
    }
}
