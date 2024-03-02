import javax.swing.*;

public class Tester {
    public static void main(String[] args) {

        //Programming Portion Criteria: (Spaceship)Programming Portion Criteria: (Spaceship)
            //Classes in separate files.  Do class divisions make sense?
            //Interface for MoveableObject, implemented by Rocket and Asteroid at a minimum
            //Anonymous class for Keyboard Listeners
            //A Panel that extends JPanel
            //MouseListener as an Inner class, to shoot the laser.
            //Timer that takes in a Lambda Function.
            //An Enum of AsteroidSize: Small, Medium, Large.
            //Do asteroids move automatically?
            //Does spaceship move with keyboard commands?
            //Does Laser "fire"?
            //Do asteroids disappear after getting shot with the laser?
            //Do more asteroids appear as the time goes on?
            //Extra:  Does the spaceship blow up if an asteroid hits it.  (Optional)




        //Create Frame
        JFrame frame = new JFrame("Asteroid Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GamePanel gamePanel = new GamePanel();


        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        //Add GamePanel to Frame




        

    }
}
