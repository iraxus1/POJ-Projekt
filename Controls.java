package pl.edu.pja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controls extends JPanel{
    private int SCREEN_WIDTH;
    private int SCREEN_HEIGHT;
    private final JButton wasd;
    private final JButton arrows;

    static boolean wasdChoose = true;
    static boolean arrowsChoose = false;
    final JFrame controls = new JFrame("Controls");

    public Controls()
    {
        resolveScreenSize();

        JPanel homeScreen = new JPanel(new BorderLayout());
        homeScreen.setPreferredSize(new Dimension(150, 100));

        wasd = new JButton("WSAD");
        arrows = new JButton("ARROWS");

        listeners();

        wasd.setForeground(Color.RED);
        wasd.setBackground(Color.BLACK);
        wasd.setFocusPainted(false);

        arrows.setForeground(Color.RED);
        arrows.setBackground(Color.BLACK);
        arrows.setFocusPainted(false);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(Color.GREEN);
        buttonsPanel.add(arrows);
        buttonsPanel.add(wasd);
        buttonsPanel.repaint();
        homeScreen.add(buttonsPanel);
        controls.setLocation((SCREEN_WIDTH )/2, (SCREEN_HEIGHT)/2);
        controls.add(homeScreen);
        controls.pack();
        controls.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        controls.setVisible(true);
    }

    public void listeners()
    {
        wasd.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                wasd.setBackground(Color.WHITE);
                arrows.setBackground(Color.BLACK);
                wasdChoose = true;
                arrowsChoose = false;
                //System.out.println("wsad true");
                controls.setVisible(false);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        arrows.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                arrows.setBackground(Color.WHITE);
                wasd.setBackground(Color.BLACK);
                wasdChoose = false;
                arrowsChoose = true;
                //System.out.println("arrows true");
                controls.setVisible(false);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
    }

    private void  resolveScreenSize(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        SCREEN_HEIGHT = screenSize.height;
        SCREEN_WIDTH = screenSize.width;
    }

    public static boolean isWasdChoose() {
        return wasdChoose;
    }

    public static boolean isArrowsChoose() {
        return arrowsChoose;
    }
}
