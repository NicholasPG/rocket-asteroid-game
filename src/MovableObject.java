import java.awt.*;

public interface MovableObject {

    void draw(Graphics2D g2);

    void translate(int dx, int dy);
}
