import javax.swing.*;

public class Tester {
    public static void main(String[] args) {

        //Programming Portion Criteria: (Spaceship)Programming Portion Criteria: (Spaceship)

        //THINGS THAT ARE DONE/OBVIOUS:
            //Classes in separate files.  Do class divisions make sense?
            //Interface for MoveableObject, implemented by Rocket
            //Anonymous class for Keyboard Listeners
            //A Panel that extends JPanel
            //Does spaceship move with keyboard commands?
            //CREATE ASTEROID CLASS AND IMPLEMENT MovableObject AND THE AsteroidSize ENUM
            //MouseListener as an Inner class, to shoot the laser.
            //Does Laser "fire"?



            //Timer that takes in a Lambda Function.
            //MAKE ASTEROIDS SPAWN on a timer
            // MAKE ASTEROID MOVE AUTOMATICALLY (via another timer probably)
            //Do asteroids disappear after getting shot with the laser?

            //Extra:  Does the spaceship blow up if an asteroid hits it.  (Optional)




        //Create Frame
        JFrame frame = new JFrame("Asteroid Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new GamePanel());

        frame.pack();
        frame.setVisible(true);


        //UNCOMMENT WHEN COMPLETED TESTING
        //frame.setResizable(false);





        

    }
}
