import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PrivateKey;
import java.time.Year;
import java.util.ArrayList;
import javax.swing.*;


public class GamePanel extends JPanel{
    private final int PANEL_HEIGHT = 500, PANEL_WIDTH = 1000;
    private Rocket rocket;
    private ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
    private int rocketStartX, rocketStartY;
    public boolean mousePressed = false;


    public GamePanel() {
        //Create the Rocket
        rocketStartX = 100;
        rocketStartY = 100;
        rocket = new Rocket(rocketStartX, rocketStartY);

        //Set up size and format of Panel
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);

        //Anonymous KeyListener to Move Rocket
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            //Moves the rocket when arrow keys are pressed
            public void keyPressed(KeyEvent e){
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        rocket.translate(0, -10);
                        break;
                    case KeyEvent.VK_DOWN:
                        rocket.translate(0, 10);
                        break;
                    case KeyEvent.VK_RIGHT:
                        rocket.translate(10, 0);
                        break;
                    case KeyEvent.VK_LEFT:
                        rocket.translate(-10, 0);
                        break;
                }
                repaint();
            }
            public void keyReleased(KeyEvent e) {}
        });

        //add mouseListener to fire laser
        this.addMouseListener(new LaserListener());



        asteroids.add(new Asteroid(50, 50, AsteroidSize.SMALL));
        asteroids.add(new Asteroid(200, 200, AsteroidSize.MEDIUM));
        asteroids.add(new Asteroid(300, 300, AsteroidSize.LARGE));



        this.setFocusable(true);
    }


    //Inner MouseListener Class to fire laser from Rocket
    private class LaserListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
            repaint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            mousePressed = false;
            repaint();
        }
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rocket.draw(g);

        for(Asteroid roid : asteroids) {
            roid.draw(g);
        }

        if (mousePressed) {
            int startLaserY = rocket.getY() +10, startLaserX = rocket.getX() + 20, endLaserY = rocket.getY() +10, endLaserX = PANEL_WIDTH;
            g.setColor(Color.BLACK);
            g.drawLine(startLaserX, startLaserY - 1, endLaserX, endLaserY - 1);
            g.drawLine(startLaserX, startLaserY + 1, endLaserX, endLaserY + 1);
            g.setColor(Color.orange);
            g.drawLine(startLaserX, startLaserY, endLaserX, endLaserY);
        }
        
    }
}
