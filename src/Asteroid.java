import javax.swing.*;
import java.awt.*;

public class Asteroid implements MovableObject{


    private ImageIcon meteor;
    private JPanel canvas;
    private int x, y;

    public Asteroid (JPanel canvas, int x, int y) {
        this.canvas = canvas;

        meteor = new ImageIcon("meteor.png");
        Image image = meteor.getImage();
        Image image2 = image.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        meteor = new ImageIcon(image2);

        this.x = x; //canvas.getWidth()/2;
        this.y = y; //(int)(Math.random() * canvas.getHeight());
    }

    @Override
    public void draw(Graphics2D g2) {
        meteor.paintIcon(canvas, g2, x, y);
    }

    @Override
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getHeight() {
        return meteor.getIconHeight();
    }
}
