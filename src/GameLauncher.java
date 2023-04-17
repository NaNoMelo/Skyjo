package src;
import javax.swing.*;
import java.awt.event.*;

public class GameLauncher extends JFrame {
    //initialize a start menu
    public static void start_up_menu(String[] args) {
    //create a frame
    JFrame frame = new JFrame("Skyjo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    //set a background from a picture

    //write welcome message
    JLabel welcome = new JLabel("Welcome to Skyjo!");
    //create a button to start the game
        JButton bouton1 = new JButton("Start the game");
        bouton1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    //add the button to the frame
    frame.getContentPane().add(bouton1);

    }
}

