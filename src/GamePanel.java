import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    final int PANEL_WIDTH = 1000, PANEL_HEIGHT = 500;
    final int DELAY = 10;

    ArrayList<Asteroid> roids;
    GamePanel here;



    public GamePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        here = this;


        roids= new ArrayList();
        int tempY = (int)(Math.random() * PANEL_HEIGHT);
        roids.add(new Asteroid(this, PANEL_WIDTH, tempY));


        Timer t = new Timer(DELAY, new
                ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        for (Asteroid roid : roids) {
                            roid.translate(-1, 0);
                            here.repaint();
                        }}});
        t.start();

    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        for (Asteroid roid : roids)
            roid.draw(g2);



    }
}
