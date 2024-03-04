import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Rocket implements MovableObject
{

    private int x, y;

    public Rocket(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw(Graphics g) {
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
        x += dx;
        y += dy;
    }
}
