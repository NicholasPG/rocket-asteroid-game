import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

public class Asteroid implements MovableObject
{

    private int x, y;
    private final AsteroidSize size;

    public Asteroid(int x, int y, AsteroidSize size)
    {
        this.size = size;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        int width = 0;
        int height = 0;

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


        //ALL EXAMPLE FROM ROCKET CLASS
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double ball1 = new Ellipse2D.Double(x, y, width, height);


        g2.setColor(Color.WHITE);
        g2.draw(ball1);
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
