import javax.swing.*;

public class Tester {
    public static void main(String[] args) {
        //Create Frame
        JFrame frame = new JFrame("Asteroid Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add the Game Panel to the frame
        frame.add(new GamePanel());

        //edit the properties of the frame
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
