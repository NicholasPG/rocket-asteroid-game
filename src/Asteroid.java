import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Asteroid implements MovableObject
{

    private int x, y, height, width;
    private final AsteroidSize size;

    public Asteroid(int x, int y, AsteroidSize size)
    {
        this.size = size;
        this.x = x;
        this.y = y;

        height = 0;
        width = 0;
    }

    //GETTERS
    public int getY() {return y;}
    public int getX() {return x;}
    public int getHeight() {return height;}
    public int getWidth() {return width;}
    public AsteroidSize getSize() {return size;}


    @Override
    public void draw(Graphics g) {
        //switch to create the asteroid the proper size
        switch(size) {
            case SMALL : {
                width = 10;
                height = 10;
                break;
            }
            case MEDIUM : {
                width = 25;
                height = 25;
                break;
            }
            case LARGE : {
                width = 50;
                height = 50;
                break;
            }
        }

        //Draw the Asteroid as a white ball
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double ball1 = new Ellipse2D.Double(x, y, width, height);
        g2.setColor(Color.WHITE);
        g2.draw(ball1);
    }

    @Override
    public void translate(int dx, int dy) {
        //switch to make smaller asteroids move faster than larger ones
        switch(size) {
            case SMALL : {
                x += (dx * 4);
                break;
            }
            case MEDIUM : {
                x += (dx * 2);
                break;
            }
            case LARGE : {
                x += dx;
                break;
            }
        }

        y += dy;
    }
}
