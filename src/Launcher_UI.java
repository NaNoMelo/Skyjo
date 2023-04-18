package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Launcher_UI extends JFrame {
    boolean gameStatus = true;
    int numberOfPlayers;


    public void launcher() {
        //set a frame full screen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        //add a background png
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\axela\\IdeaProjects\\Skyjo\\powered2.jpg"));
        background.setBounds(0, 0, 1920, 1080);
        this.add(background);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //create button to start the game
        JButton start = new JButton("Start");
        start.setBounds(606, 650, 300, 100);
        this.add(start);

        //create button to quit the game
        JButton quit = new JButton("Quit");
        quit.setBounds(606, 750, 300, 100);
        this.add(quit);

        //if start is clicked gameStatus is true and close the launcher
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStatus = true;
                dispose();
            }
        });
        //if quit is clicked gameStatus is false and close the launcher
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStatus = false;
                dispose();
            }
        });


    }

    //create a menu frame att full screen
    public void menu() {
        //set a frame full screen
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        //add a background png
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\axela\\IdeaProjects\\Skyjo\\powered2.jpg"));
        background.setBounds(0, 0, 1920, 1080);
        this.add(background);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //create a entry field for the number of players
        JTextField numberOfPlayersField = new JTextField();
        numberOfPlayersField.setBounds(606, 650, 300, 100);
        this.add(numberOfPlayersField);
        //create a button to confirm the number of players
        JButton confirm = new JButton("Confirm");
        confirm.setBounds(606, 450, 300, 100);
        this.add(confirm);
        //if confirm is clicked get the number of players and close the menu
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               numberOfPlayers = Integer.parseInt(numberOfPlayersField.getText());
                gameStatus = true;
                dispose();
            }
        });

    }

}

