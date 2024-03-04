import javax.swing.*;

public class Tester {
    public static void main(String[] args) {
        //Create Frame
        JFrame frame = new JFrame("Asteroid Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new GamePanel());

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);





        

    }
}
