import java.awt.*;
import java.awt.geom.Line2D;

public class Rocket implements MovableObject
{

    private int x, y;
    private GamePanel panel;

    public Rocket(int x, int y, GamePanel panel)
    {
        this.panel = panel;
        this.x = x;
        this.y = y;
    }

    //GETTERS
    public int getX() {return x;}
    public int getY() {return y;}

    @Override
    public void draw(Graphics g) {
        //Draw the rocket as a series of red lines
        Graphics2D g2 = (Graphics2D) g;
        Line2D.Double line1 = new Line2D.Double(x, y, x + 20, y + 10);
        Line2D.Double line2 = new Line2D.Double(x, y, x + 7, y + 10);
        Line2D.Double line3 = new Line2D.Double(x, y + 20, x + 20, y + 10);
        Line2D.Double line4 = new Line2D.Double(x, y + 20, x + 7, y + 10);

        g2.setColor(Color.RED);
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);
        g2.draw(line4);
    }

    @Override
    public void translate(int dx, int dy) {
        //Move the rockets coordinates
        x += dx;
        y += dy;

        //Bind the rocket to the bounds of the panel
        if (x + 20 > panel.getWidth()) {x = panel.getWidth() - 20;}
        if (x < 0) {x = 0;}
        if (y < 0) {y = panel.getHeight() - 20;}
        if (y + 20 > panel.getHeight()) {y = 0;}
    }
}
