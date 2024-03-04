import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class GamePanel extends JPanel{
    //Size of the game Panel
    private final int PANEL_HEIGHT = 500, PANEL_WIDTH = 1000;
    //Location for the Rocket to start
    private final int rocketStartX = 100, rocketStartY = 100;
    //Delay for asteroids to move across the screen
    private final int MOVE_DELAY = 10;
    //Delay for new asteroids to spawn
    private final int SPAWN_DELAY = 100;
    //Delay to move the rocket
    private final int ROCKET_SPEED = 3;

    private boolean moveLeft = false, moveRight = false, moveUp = false, moveDown = false;
    private boolean gameOver = false;
    private final Rocket rocket;
    private ArrayList<Asteroid> asteroids = new ArrayList<>();
    public boolean mousePressed = false;
    private final GamePanel here = this;


    public GamePanel() {
        //Create the Rocket
        rocket = new Rocket(rocketStartX, rocketStartY, this);

        //Set up size and format of Panel
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);

        //Anonymous KeyListener to Move Rocket
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            //Moves the rocket when arrow keys are pressed
            public void keyPressed(KeyEvent e){
                if (gameOver) {
                    return;
                }
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        moveUp = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        moveDown = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        moveLeft = true;
                        break;
                    case KeyEvent.VK_W:
                        moveUp = true;
                        break;
                    case KeyEvent.VK_S:
                        moveDown = true;
                        break;
                    case KeyEvent.VK_D:
                        moveRight = true;
                        break;
                    case KeyEvent.VK_A:
                        moveLeft = true;
                        break;
                }
                repaint();
            }
            public void keyReleased(KeyEvent e) {
                if (gameOver) {
                    return;
                }
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        moveUp = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        moveDown = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        moveLeft = false;
                        break;
                    case KeyEvent.VK_W:
                        moveUp = false;
                        break;
                    case KeyEvent.VK_S:
                        moveDown = false;
                        break;
                    case KeyEvent.VK_D:
                        moveRight = false;
                        break;
                    case KeyEvent.VK_A:
                        moveLeft = false;
                        break;
                }
                repaint();
            }
        });

        //add mouseListener to fire laser
        this.addMouseListener(new LaserListener());

        //Timer that takes in a lambda expression to move asteroids toward left
        Timer moveTimer = new Timer(MOVE_DELAY, (e) -> {
            for (Asteroid asteroid : asteroids) {
                asteroid.translate(-1, 0);
                if ((rocket.getX() + 20 >= asteroid.getX()
                        && rocket.getX() + 20 <= asteroid.getX() + asteroid.getWidth()
                        && rocket.getY() + 10 >= asteroid.getY()
                        && rocket.getY() + 10 <= asteroid.getY() + asteroid.getHeight())) {
                    gameOver = true;
                    break;
                };
                if (rocket.getX() >= asteroid.getX()
                        && rocket.getX() <= asteroid.getX() + asteroid.getWidth()
                        && rocket.getY() >= asteroid.getY()
                        && rocket.getY() <= asteroid.getY() + asteroid.getHeight()) {
                    gameOver = true;
                    break;
                }
                if (rocket.getX() >= asteroid.getX()
                        && rocket.getX() <= asteroid.getX() + asteroid.getWidth()
                        && rocket.getY() + 20 >= asteroid.getY()
                        && rocket.getY() + 20 <= asteroid.getY() + asteroid.getHeight()) {
                    gameOver = true;
                    break;
                }

                /*if (asteroid.getX() + asteroid.getWidth() < 0) {
                    asteroids.remove(asteroid);
                    break;
                }*/
            }
            here.repaint();
        });

        Timer spawnTimer = new Timer(SPAWN_DELAY, (e) -> {
            int s = (int)(Math.random() * 3);
            if (s == 0) {
                asteroids.add(new Asteroid(PANEL_WIDTH, (int)(Math.random() * (PANEL_HEIGHT - 10)), AsteroidSize.SMALL));
            }else if (s == 1) {
                asteroids.add(new Asteroid(PANEL_WIDTH, (int)(Math.random() * (PANEL_HEIGHT - 25)), AsteroidSize.MEDIUM));
            } else {
                asteroids.add(new Asteroid(PANEL_WIDTH, (int)(Math.random() * (PANEL_HEIGHT - 50)), AsteroidSize.LARGE));
            }
            here.repaint();
        });

        Timer gameOverTimer = new Timer(50, (e) -> {
            if(gameOver) {
                spawnTimer.stop();
                moveTimer.stop();
            }
        });

        Timer rocketTimer = new Timer(10, (e) -> {
            if(moveUp) {
                rocket.translate(0, -ROCKET_SPEED);
            }
            if (moveDown) {
                rocket.translate(0, ROCKET_SPEED);
            }
            if (moveLeft) {
                rocket.translate(-ROCKET_SPEED, 0);
            }
            if (moveRight ){
                rocket.translate(ROCKET_SPEED, 0);
            }

        });


        gameOverTimer.start();
        rocketTimer.start();
        //Start Both timers
        moveTimer.start();
        spawnTimer.start();

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

        //paint the rocket
        rocket.draw(g);
        //paint all the asteroids
        for(Asteroid asteroid : asteroids) {
            asteroid.draw(g);
        }
        //Paint the laser and remove asteroids that have been shot
        if (mousePressed) {
            //paint the laser
            int startLaserY = rocket.getY() +10, startLaserX = rocket.getX() + 20, endLaserY = rocket.getY() +10, endLaserX = PANEL_WIDTH;
            g.setColor(Color.BLACK);
            g.drawLine(startLaserX, startLaserY - 1, endLaserX, endLaserY - 1);
            g.drawLine(startLaserX, startLaserY + 1, endLaserX, endLaserY + 1);
            g.setColor(Color.orange);
            g.drawLine(startLaserX, startLaserY, endLaserX, endLaserY);

            //Remove asteroids that get shot by the laser
            int laserPointY = rocket.getY() + 10;
            int laserPointX = rocket.getX() + 20;
            for (Asteroid asteroid : asteroids) {
                if (laserPointY >= asteroid.getY() && laserPointY <= asteroid.getY() + asteroid.getHeight() && laserPointX <= asteroid.getX()) {
                    asteroids.remove(asteroid);
                    break;
                };
            }
        }

    }
}
